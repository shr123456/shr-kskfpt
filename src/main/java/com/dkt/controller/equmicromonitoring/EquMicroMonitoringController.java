package com.dkt.controller.equmicromonitoring;

import com.dkt.controller.base.BaseController;
import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.entity.equmicromonitoring.EquMicroMonitoring;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.service.equmicromonitoring.EquMicroMonitoringManager;
import com.dkt.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/** 
 * 说明equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 */
@Controller
@RequestMapping(value="/equmicromonitoring")
public class EquMicroMonitoringController extends BaseController {

	String menuUrl = "equmicromonitoring/list.do";

	@Resource(name="equmicromonitoringService")
	private EquMicroMonitoringManager equMicroMonitoringService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房

	@RequestMapping(value="/list")
	public ModelAndView list() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"监控页面EquMeterMonitoringController");

		ModelAndView mv = this.getModelAndView();

		PageData pd_micro = new PageData();
		pd_micro = this.getPageData();

		List<EquMicroMonitoring> getMicroMonitoringList=equMicroMonitoringService.getMicroMonitoringList(pd_micro);

		String html="";
		if(getMicroMonitoringList.size()>0)
		{
			for(int i=0;i<getMicroMonitoringList.size();i++) {
				EquMicroMonitoringListHtml equMicroMonitoringListHtml = new EquMicroMonitoringListHtml();
				html += equMicroMonitoringListHtml.EquMicroMonitorAssemble(getMicroMonitoringList.get(i));
			}
		}
		else
		{
			html="暂无数据，请重新搜索";
		}

		PageData pd = new PageData();
		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);

		mv.setViewName("equmicromonitoring/equmicromonitoring_list");
		mv.addObject("ContentHtml", html);
		mv.addObject("roomList", roomList);
		//mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());
		return mv;
	}

	/**去展示页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goShow")
	public ModelAndView goShow() throws Exception {

		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = equMicroMonitoringService.findById(pd);	//根据ID读取
		mv.setViewName("equmicromonitoring/equmicro_show");
		mv.addObject("msg", "show");
		mv.addObject("pd", pd);
		return mv;

	}







}
