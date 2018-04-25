package com.dkt.controller.equmetermonitoring;

import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.entity.equmetermonitoring.ElectricalRoomMeter;
import com.dkt.entity.equmetermonitoring.EquMeterMonitoring;
import com.dkt.entity.system.User;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.service.equmetermonitoring.EquMeterMonitoringManager;
import com.dkt.util.*;
import org.apache.shiro.session.Session;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/** 
 * 说明equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 */
@Controller
@RequestMapping(value="/equmetermonitoring")
public class EquMeterMonitoringController extends BaseController {

	String menuUrl = "equmetermonitoring/list.do";

	@Resource(name="equmetermonitoringService")
	private EquMeterMonitoringManager equmetermonitoringService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房

	@RequestMapping(value="/list")
	public ModelAndView list() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表EquMeterMonitoringController");

		ModelAndView mv = this.getModelAndView();

//		Session session = Jurisdiction.getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);

		//所有电表数据
		List<EquMeterMonitoring> allList = new ArrayList<EquMeterMonitoring>();
		//低压
		PageData pd_dy = new PageData();
		pd_dy = this.getPageData();
        pd_dy.put("equ_type","2");

		//pd_dy.put("CUSTOMER_ID",user.getUSER_ID());
		List<EquMeterMonitoring> diyaList = equmetermonitoringService.getMeterListMonitoringByCustomerId(pd_dy);
		if(diyaList.size()>0)
		{
			allList.addAll(diyaList);
		}

		//高压
		PageData pd_gy = new PageData();
		pd_gy = this.getPageData();
		pd_gy.put("equ_type","1");

		//pd_gy.put("CUSTOMER_ID",user.getUSER_ID());
		List<EquMeterMonitoring> gaoyaList = equmetermonitoringService.getMeterListMonitoringByCustomerId(pd_gy);
		if(gaoyaList.size()>0)
		{
			allList.addAll(gaoyaList);
		}

		//回路
		PageData pd_hl = new PageData();
		pd_hl = this.getPageData();
		pd_hl.put("equ_type","0");

		List<EquMeterMonitoring> huiluList = equmetermonitoringService.getMeterListMonitoringOwn(pd_hl);
		if(huiluList.size()>0)
		{
			allList.addAll(huiluList);
		}

		String html="";
		if(allList.size()>0)
		{
			EquMeterMonitorListHtml equMeterMonitorListHtml=new EquMeterMonitorListHtml();
			html=equMeterMonitorListHtml.EquMeterMonitorAssemble(allList);
		}
		else
		{
			html="暂无数据，请重新搜索";
		}

		PageData pd = new PageData();
		//		pd = this.getPageData();
//		String keywords = pd.getString("keywords");
//		if(null != keywords && !"".equals(keywords)){
//			pd.put("keywords", keywords.trim());
//		}
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);

		mv.setViewName("equmetermonitoring/equmetermonitoring_list");
		mv.addObject("ContentHtml", html);
		mv.addObject("roomList", roomList);
		//mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());
		return mv;
	}


	//	**去展示页面
	//	* @param
	//	* @throws Exception
	//	*/
	@RequestMapping(value="/goShow")
	public ModelAndView goShow(String ID,String name) throws Exception {

		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		//pd = this.getPageData();
        pd.put("ID",ID);
		pd = equmetermonitoringService.findById(pd);	//根据ID读取
		mv.setViewName("equmetermonitoring/equsmartmeter_show");

		if(name==null || name=="")
		{
			mv.addObject("EQU_NAME", "暂无关联设备");
		}
		else
		{
			mv.addObject("EQU_NAME",name);
		}

		mv.addObject("msg", "show");
		mv.addObject("pd", pd);
		return mv;

	}

}
