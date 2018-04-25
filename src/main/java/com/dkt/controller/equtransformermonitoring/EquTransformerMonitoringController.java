package com.dkt.controller.equtransformermonitoring;

import com.dkt.controller.base.BaseController;
import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.entity.equtransformermonitoring.EquTtransformerMonitoring;
import com.dkt.entity.system.User;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.service.equtransformermonitoring.EquTransformerMonitoringManager;
import com.dkt.util.Const;
import com.dkt.util.Jurisdiction;
import com.dkt.util.PageData;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/** 
 * 说明equmetermonitoring
 * @author:ssm
 * @date:2018-01-17
 */
@Controller
@RequestMapping(value="/equtransformermonitoring")
public class EquTransformerMonitoringController extends BaseController {

	String menuUrl = "equtransformermonitoring/list.do";

	@Resource(name="equtransformermonitoringService")
	private EquTransformerMonitoringManager equtransformermonitoringService;
	@Resource(name="electricalroomService")
	private ElectricalRoomManager electricalRoomService;//电房

	@RequestMapping(value="/list")
	public ModelAndView list() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表EquMeterMonitoringController");

		ModelAndView mv = this.getModelAndView();
//		Session session = Jurisdiction.getSession();
//		User user = (User)session.getAttribute(Const.SESSION_USER);
		PageData pd = new PageData();
		pd = this.getPageData();

		//取出所有变压器（低压）
		List<EquTtransformerMonitoring> TransformerLowListCount =equtransformermonitoringService.getTransformerLowListCount(pd);
		//获取变压器所属低压柜电量（低压）
		List<EquTtransformerMonitoring> TransformerLowList =equtransformermonitoringService.getTransformerLowList(pd);
        //组合电量（低压）
		TransformerLowListCount=list_Combination(TransformerLowListCount,TransformerLowList);

		//取出所有变压器（高压）
		List<EquTtransformerMonitoring> TransformerListHighCount =equtransformermonitoringService.getTransformerHighListCount(pd);
		//获取变压器所属低压柜电量（高压）
		List<EquTtransformerMonitoring> TransformerHighList =equtransformermonitoringService.getTransformerHighList(pd);
        //组合电量（高压）
		TransformerListHighCount=list_Combination(TransformerListHighCount,TransformerHighList);

		EquTransformerMonitorListHtml equTransformerMonitorListHtml=new EquTransformerMonitorListHtml();
		String html=equTransformerMonitorListHtml.EquTransformerMonitorAssemble(TransformerLowListCount,TransformerListHighCount);

		if(html=="")
		{
			html="暂无数据，请重新搜索";
		}

		List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd);
		mv.setViewName("equtransformermonitoring/equtransformermonitoring_list");
		mv.addObject("ContentHtml", html);
		mv.addObject("roomList", roomList);
		//mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());
		return mv;
	}

	private List<EquTtransformerMonitoring> list_Combination(List<EquTtransformerMonitoring> TransformerListCount,List<EquTtransformerMonitoring> TransformerList)
	{
		if(TransformerListCount.size()>0) {
			String html = "";
			int id=0;//缓存ID
			Double TOTAL_P_AT_EE=0.0;//缓存电量
			Double TOTAL_P_AT_EE_MIN=0.0;//缓存电量
			String LOW_EQUIPMENT_NAME="";//缓存低压柜名称
			for (int i = 0; i < TransformerList.size(); i++) {

				EquTtransformerMonitoring info=TransformerList.get(i);

				if(i==0)//第一条
				{
					id=info.getID();//缓存数据
					TOTAL_P_AT_EE=info.getTOTAL_P_AT_EE();
					TOTAL_P_AT_EE_MIN=info.getTOTAL_P_AT_EE_MIN();
					LOW_EQUIPMENT_NAME=info.getLOW_EQUIPMENT_NAME();
				}
				else
				{
					if(id==info.getID())//相等表示同一个变压器
					{
						TOTAL_P_AT_EE = TOTAL_P_AT_EE+info.getTOTAL_P_AT_EE();
						TOTAL_P_AT_EE_MIN = TOTAL_P_AT_EE_MIN+info.getTOTAL_P_AT_EE_MIN();
						LOW_EQUIPMENT_NAME=LOW_EQUIPMENT_NAME+","+info.getLOW_EQUIPMENT_NAME();
					}
					else
					{
						//不相等，先保存上一条信息
						TransformerListCount = setTtransformerDate(TransformerListCount,id,TOTAL_P_AT_EE,TOTAL_P_AT_EE_MIN,LOW_EQUIPMENT_NAME);
						//重新赋值
						id=info.getID();//缓存数据
						TOTAL_P_AT_EE=info.getTOTAL_P_AT_EE();
						TOTAL_P_AT_EE_MIN=info.getTOTAL_P_AT_EE_MIN();
						LOW_EQUIPMENT_NAME=info.getLOW_EQUIPMENT_NAME();
					}
				}

				//如果是最后一条数据
				if (i + 1 == TransformerList.size())
				{
					TransformerListCount = setTtransformerDate(TransformerListCount,id,TOTAL_P_AT_EE,TOTAL_P_AT_EE_MIN,LOW_EQUIPMENT_NAME);
				}
			}
		}

		return TransformerListCount;
	}





    //保存电量到List
	private List<EquTtransformerMonitoring> setTtransformerDate(List<EquTtransformerMonitoring> TransformerListCount,int id,Double TOTAL_P_AT_EE,Double TOTAL_P_AT_EE_MIN,String low_name)
	{
		for (int i = 0; i < TransformerListCount.size(); i++) {
			EquTtransformerMonitoring info=TransformerListCount.get(i);
			if(info.getID()==id)
			{
				TransformerListCount.get(i).setLOW_EQUIPMENT_NAME(low_name);
				TransformerListCount.get(i).setTOTAL_P_AT_EE(TOTAL_P_AT_EE);

				//计算负载率
				Double Use_Electricity =TOTAL_P_AT_EE-TOTAL_P_AT_EE_MIN;

				Double LOAD_RATE= Use_Electricity / Double.parseDouble(info.getCAPACITY()) ;
				if(LOAD_RATE==0.00)
				{
					LOAD_RATE=1.00;
				}

				BigDecimal b = new   BigDecimal(LOAD_RATE);
				double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();
				//f1=f1*100;
				TransformerListCount.get(i).setLOAD_RATE(f1);

				break;//结束循环
			}
		}
        return  TransformerListCount;
	}

	//	**去展示页面
	//	* @param
	//	* @throws Exception
	//	*/
	@RequestMapping(value="/goShow")
	public ModelAndView goShow(String ID,String name,int type) throws Exception {

		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		//pd = this.getPageData();
		pd.put("ID",ID);
		pd = equtransformermonitoringService.findById(pd);	//根据ID读取
		mv.setViewName("equtransformermonitoring/equtransformermonitoring_show");

		if(type==1)
		{
			mv.addObject("EQU_TITLE", "关联低压柜");
		}
		else if(type==2)
		{
			mv.addObject("EQU_TITLE", "关联高压柜");
		}
		else
		{
			mv.addObject("EQU_TITLE", "关联设备");
		}

		mv.addObject("EQU_NAME",name);
		mv.addObject("msg", "show");
		mv.addObject("pd", pd);
		return mv;
	}

}
