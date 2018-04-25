package com.dkt.controller.equsmartmeter;

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
import com.dkt.service.equsmartmeter.EquSmartMeterManager;

/** 
 * 说明：equsmartmeter
 * @author：shr
 * @date：2018-01-17
 */
@Controller
@RequestMapping(value="/equsmartmeter")
public class EquSmartMeterController extends BaseController {
	
	String menuUrl = "equsmartmeter/list.do"; //菜单地址(权限用)
	@Resource(name="equsmartmeterService")
	private EquSmartMeterManager equsmartmeterService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房

	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增EquSmartMeter");
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

		equsmartmeterService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除EquSmartMeter");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		equsmartmeterService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改EquSmartMeter");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);
		pd.put("UPDATER", user.getUSER_ID());	//修改人
		pd.put("UPDATE_TIME", Tools.date2Str(new Date()));	//修改时间

		equsmartmeterService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表EquSmartMeter");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String keyno = pd.getString("keyno");				//关键词检索条件
		if(null != keyno && !"".equals(keyno)){
			pd.put("keyno", keyno.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = equsmartmeterService.list(page);	//列出EquSmartMeter列表
		mv.setViewName("equsmartmeter/equsmartmeter_list");
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
		mv.setViewName("equsmartmeter/equsmartmeter_edit");

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
		pd = equsmartmeterService.findById(pd);	//根据ID读取
		mv.setViewName("equsmartmeter/equsmartmeter_edit");
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除EquSmartMeter");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			equsmartmeterService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出EquSmartMeter到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("主键");	//1
		titles.add("电房ID");	//2
		titles.add("电表名称");	//3
		titles.add("电表地址");	//4
		titles.add("网关编号");	//5
		titles.add("网关型号");	//6
		titles.add("厂家网关");	//7
		titles.add("关联设备");	//8
		titles.add("创建人");	//9
		titles.add("创建时间");	//10
		titles.add("修改人");	//11
		titles.add("修改时间");	//12
		titles.add("业务删除");	//13
		dataMap.put("titles", titles);
		List<PageData> varOList = equsmartmeterService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).get("ELECTRICAL_ROOM_ID").toString());	//2
			vpd.put("var3", varOList.get(i).getString("METER_NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("METER_ADDRESS"));	    //4
			vpd.put("var5", varOList.get(i).getString("GATEWAY_NO"));	    //5
			vpd.put("var6", varOList.get(i).getString("GATEWAY_MODEL"));	    //6
			vpd.put("var7", varOList.get(i).getString("GATEWAY_FACTORY"));	    //7
			vpd.put("var8", varOList.get(i).get("EQU_ID").toString());	//8
			vpd.put("var9", varOList.get(i).getString("CREATOR"));	    //9
			vpd.put("var10", varOList.get(i).getString("CREATE_TIME"));	    //10
			vpd.put("var11", varOList.get(i).getString("UPDATER"));	    //11
			vpd.put("var12", varOList.get(i).getString("UPDATE_TIME"));	    //12
			vpd.put("var13", varOList.get(i).get("DELETED").toString());	//13
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
