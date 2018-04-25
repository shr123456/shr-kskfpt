package com.dkt.controller.alarm.statistics;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.util.AppUtil;
import com.dkt.util.ObjectExcelView;
import com.dkt.util.PageData;
import com.dkt.util.Jurisdiction;
import com.dkt.util.Tools;
import com.dkt.service.alarm.statistics.StatisticsManager;

/** 
 * 说明：告警统计
 * @author：xyx
 * @date：2018-01-18
 */
@Controller
@RequestMapping(value="/statistics")
public class StatisticsController extends BaseController {
	
	String menuUrl = "statistics/list.do"; //菜单地址(权限用)
	@Resource(name="statisticsService")
	private StatisticsManager statisticsService;

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Statistics");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		String keywords2 = pd.getString("keywords2");				//关键词检索条件
		if(null != keywords2 && !"".equals(keywords2)){
			pd.put("keywords2", keywords2.trim());
		}
		String keywords3 = pd.getString("keywords3");				//关键词检索条件
		if(null != keywords3 && !"".equals(keywords3)){
			pd.put("keywords3", keywords3.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = statisticsService.list(page);	//列出Statistics列表
		mv.setViewName("alarm/statistics/statistics_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
}
