package com.dkt.controller.electricalroom;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.dkt.entity.system.User;
import com.dkt.util.*;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.apache.shiro.session.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.service.electricalroom.ElectricalRoomManager;

/** 
 * 说明：electricalroom
 * @author：shr
 * @date：2018-01-08
 */
@Controller
@RequestMapping(value="/electricalroom")
public class ElectricalRoomController extends BaseController {
	
	String menuUrl = "electricalroom/list.do"; //菜单地址(权限用)
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalroomService;

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表ElectricalRoom");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = electricalroomService.list(page);	//列出ElectricalRoom列表
		mv.setViewName("electricalroom/electricalroom_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}

	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增ElectricalRoom");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//pd.put("ELECTRICALROOM_ID", this.get32UUID());	//主键

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);

		pd.put("CUSTOMER_ID", user.getUSER_ID());	//当前用户

		pd.put("CREATOR", user.getUSER_ID());	//新增用户
		pd.put("CREATE_TIME", new Date());	//新增时间
		pd.put("UPDATER", user.getUSER_ID());	//修改用户
		pd.put("UPDATE_TIME", new Date());	//修改时间
		pd.put("DELETED", 0);	//逻辑删除

		electricalroomService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除ElectricalRoom");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		electricalroomService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改ElectricalRoom");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		electricalroomService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("electricalroom/electricalroom_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = electricalroomService.findById(pd);	//根据ID读取
		mv.setViewName("electricalroom/electricalroom_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除ElectricalRoom");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			electricalroomService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出ElectricalRoom到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("主键");	//1
		titles.add("客户ID");	//2
		titles.add("电房编号");	//3
		titles.add("电房名称");	//4
		titles.add("创建人");	//5
		titles.add("创建时间");	//6
		titles.add("电房温度");	//7
		titles.add("电房湿度");	//8
		titles.add("负责人");	//9
		titles.add("负责人联系电话电话");	//10
		titles.add("备注");	//11
		titles.add("相关照片");	//12
		titles.add("修改人");	//13
		titles.add("修改时间");	//14
		titles.add("是否删除");	//15
		dataMap.put("titles", titles);
		List<PageData> varOList = electricalroomService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).getString("CUSTOMER_ID"));	    //2
			vpd.put("var3", varOList.get(i).getString("ELECTRICAL_ROOM_CODE"));	    //3
			vpd.put("var4", varOList.get(i).getString("ELECTRICAL_ROOM_NAME"));	    //4
			vpd.put("var5", varOList.get(i).getString("CREATOR"));	    //5
			vpd.put("var6", varOList.get(i).getString("CREATE_TIME"));	    //6
			vpd.put("var7", varOList.get(i).getString("TEMPERATURE"));	    //7
			vpd.put("var8", varOList.get(i).getString("DAMPNESS"));	    //8
			vpd.put("var9", varOList.get(i).getString("CHARGER"));	    //9
			vpd.put("var10", varOList.get(i).getString("CHARGE_TEL"));	    //10
			vpd.put("var11", varOList.get(i).getString("REMARK"));	    //11
			vpd.put("var12", varOList.get(i).getString("PHOTO_URL"));	    //12
			vpd.put("var13", varOList.get(i).getString("UPDATER"));	    //13
			vpd.put("var14", varOList.get(i).getString("UPDATE_TIME"));	    //14
			vpd.put("var15", varOList.get(i).get("DELETED").toString());	//15
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
