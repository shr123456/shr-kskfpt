package com.dkt.controller.equcapacitorcabinet;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.entity.system.User;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.util.*;
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
import com.dkt.service.equcapacitorcabinet.EquCapacitorCabinetManager;

/** 
 * 说明：equcapacitorcabinet
 * @author：shr
 * @date：2018-01-12
 */
@Controller
@RequestMapping(value="/equcapacitorcabinet")
public class EquCapacitorCabinetController extends BaseController {
	
	String menuUrl = "equcapacitorcabinet/list.do"; //菜单地址(权限用)
	@Resource(name="equcapacitorcabinetService")
	private EquCapacitorCabinetManager equcapacitorcabinetService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增EquCapacitorCabinet");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		//pd.put("EQUCAPACITORCABINET_ID", this.get32UUID());	//主键
		//pd.put("ID", "0");	//主键

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);

		pd.put("CREATOR", user.getUSER_ID());	//创建人
		pd.put("CREATE_TIME", Tools.date2Str(new Date()));	//创建时间
		pd.put("UPDATER", user.getUSER_ID());	//修改人
		pd.put("UPDATE_TIME", Tools.date2Str(new Date()));	//修改时间
		pd.put("DELETED", "0");	//业务删除
		equcapacitorcabinetService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除EquCapacitorCabinet");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		equcapacitorcabinetService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改EquCapacitorCabinet");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);
		pd.put("UPDATER", user.getUSER_ID());	//修改人
		pd.put("UPDATE_TIME", Tools.date2Str(new Date()));	//修改时间

		equcapacitorcabinetService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表EquCapacitorCabinet");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData> varList = equcapacitorcabinetService.list(page);	//列出EquCapacitorCabinet列表
		mv.setViewName("equcapacitorcabinet/equcapacitorcabinet_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
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
		mv.setViewName("equcapacitorcabinet/equcapacitorcabinet_edit");

//		Session session = Jurisdiction.getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);//当前用户
		//获取电房列表数据
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);
		mv.addObject("roomList", roomList);
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
		pd = equcapacitorcabinetService.findById(pd);	//根据ID读取
		mv.setViewName("equcapacitorcabinet/equcapacitorcabinet_edit");

		//获取电房列表数据
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);
		mv.addObject("roomList", roomList);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除EquCapacitorCabinet");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			equcapacitorcabinetService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出EquCapacitorCabinet到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("主键");	//1
		titles.add("电房ID");	//2
		titles.add("设备名称");	//3
		titles.add("设备编号");	//4
		titles.add("回路名称");	//5
		titles.add("安装位置");	//6
		titles.add("设备型号");	//7
		titles.add("额定电流");	//8
		titles.add("额定电压");	//9
		titles.add("生产日期");	//10
		titles.add("品牌");	//11
		titles.add("生产厂家");	//12
		titles.add("创建人");	//13
		titles.add("创建时间");	//14
		titles.add("修改人");	//15
		titles.add("修改时间");	//16
		titles.add("业务删除");	//17
		dataMap.put("titles", titles);
		List<PageData> varOList = equcapacitorcabinetService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).get("ELECTRICAL_ROOM_ID").toString());	//2
			vpd.put("var3", varOList.get(i).getString("EQUIPMENT_NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("EQUIPMENT_CODE"));	    //4
			vpd.put("var5", varOList.get(i).getString("LOOP_NAME"));	    //5
			vpd.put("var6", varOList.get(i).getString("INSTALLATION_POSITION"));	    //6
			vpd.put("var7", varOList.get(i).getString("EQUIPMENT_VERSION"));	    //7
			vpd.put("var8", varOList.get(i).get("RATED_CURRENT").toString());	//8
			vpd.put("var9", varOList.get(i).get("RATED_VOLTAGE").toString());	//9
			vpd.put("var10", varOList.get(i).getString("MAKE_TIME"));	    //10
			vpd.put("var11", varOList.get(i).getString("BRAND"));	    //11
			vpd.put("var12", varOList.get(i).getString("MANUFACTURER"));	    //12
			vpd.put("var13", varOList.get(i).getString("CREATOR"));	    //13
			vpd.put("var14", varOList.get(i).getString("CREATE_TIME"));	    //14
			vpd.put("var15", varOList.get(i).getString("UPDATER"));	    //15
			vpd.put("var16", varOList.get(i).getString("UPDATE_TIME"));	    //16
			vpd.put("var17", varOList.get(i).get("DELETED").toString());	//17
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
