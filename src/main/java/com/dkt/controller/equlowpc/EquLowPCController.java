package com.dkt.controller.equlowpc;

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
import com.dkt.entity.equtransformer.EquTransformer;
import com.dkt.entity.system.User;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.service.equlowpc.EquLowPCManager;
import com.dkt.service.equtransformer.EquTransformerManager;
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

/** 
 * 说明：equlowpc
 * @author：shr
 * @date：2018-01-12
 */
@Controller
@RequestMapping(value="/equlowpc")
public class EquLowPCController extends BaseController {
	
	String menuUrl = "equlowpc/list.do"; //菜单地址(权限用)
	@Resource(name="equlowpcService")
	private EquLowPCManager equlowpcService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房
	@Resource(name="equtransformerService")
	private EquTransformerManager equTransformerService;//变压器


	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增EquLowPC");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);

		pd.put("CREATOR", user.getUSER_ID());	//创建人
		pd.put("CREATE_TIME", Tools.date2Str(new Date()));	//创建时间
		pd.put("UPDATER", user.getUSER_ID());	//修改人
		pd.put("UPDATE_TIME", Tools.date2Str(new Date()));	//修改时间
		pd.put("DELETED", "0");	//业务删除

		String type=pd.get("IF_INTO_LINE").toString();
		if("0".equals(type))
		{
			pd.put("TRANSFORMER_ID", 0);
		}
		Integer line=Integer.parseInt(type);
		pd.put("IF_INTO_LINE", line);

		equlowpcService.save(pd);

		//如果是进线，修改变压器类型

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
		logBefore(logger, Jurisdiction.getUsername()+"删除EquLowPC");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		equlowpcService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改EquLowPC");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		String type=pd.get("IF_INTO_LINE").toString();
		if("0".equals(type))
		{
			pd.put("TRANSFORMER_ID", 0);
		}
		Integer line=Integer.parseInt(type);
		pd.put("IF_INTO_LINE", line);

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);
		pd.put("UPDATER", user.getUSER_ID());	//修改人
		pd.put("UPDATE_TIME", Tools.date2Str(new Date()));	//修改时间

		equlowpcService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表EquLowPC");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = equlowpcService.list(page);	//列出EquLowPC列表
		mv.setViewName("equlowpc/equlowpc_list");
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
		mv.setViewName("equlowpc/equlowpc_edit");

//		Session session = Jurisdiction.getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);//当前用户
		//获取电房列表数据
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);
		mv.addObject("roomList", roomList);

		//获取变压器列表
		List<EquTransformer> transformerList= equTransformerService.findByTypeOne(pd);
		mv.addObject("transformerList", transformerList);

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
		pd = equlowpcService.findById(pd);	//根据ID读取
		mv.setViewName("equlowpc/equlowpc_edit");

		//获取电房列表数据
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);
		mv.addObject("roomList", roomList);

		//获取变压器列表
		List<EquTransformer> transformerList= equTransformerService.findByTypeOne(pd);
		mv.addObject("transformerList", transformerList);

		String type=pd.get("IF_INTO_LINE").toString();
		if(type=="true") {
			pd.put("IF_INTO_LINE", 1);
		}
		else {
			pd.put("IF_INTO_LINE", 0);
		}

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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除EquLowPC");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			equlowpcService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出EquLowPC到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("主键");	//1
		titles.add("电房 ID");	//2
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
		titles.add("所属变压器ID");	//13
		titles.add("是否进线");	//14
		titles.add("创建人");	//15
		titles.add("创建时间");	//16
		titles.add("修改人");	//17
		titles.add("修改时间");	//18
		titles.add("业务删除");	//19
		dataMap.put("titles", titles);
		List<PageData> varOList = equlowpcService.listAll(pd);
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
			vpd.put("var13", varOList.get(i).get("TRANSFORMER_ID").toString());	//13
			vpd.put("var14", varOList.get(i).get("IF_INTO_LINE").toString());	//14
			vpd.put("var15", varOList.get(i).getString("CREATOR"));	    //15
			vpd.put("var16", varOList.get(i).getString("CREATE_TIME"));	    //16
			vpd.put("var17", varOList.get(i).getString("UPDATER"));	    //17
			vpd.put("var18", varOList.get(i).getString("UPDATE_TIME"));	    //18
			vpd.put("var19", varOList.get(i).get("DELETED").toString());	//19
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
