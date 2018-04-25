package com.dkt.controller.alarm.poweroutages;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.dkt.controller.base.BaseController;
import com.dkt.entity.Page;
import com.dkt.util.PageData;
import com.dkt.util.Jurisdiction;
import com.dkt.service.alarm.poweroutages.PowerOutagesManager;

/** 
 * 说明：断电告警
 * @author：shr
 * @date：2018-01-18
 */
@Controller
@RequestMapping(value="/poweroutages")
public class PowerOutagesController extends BaseController {
	
	String menuUrl = "poweroutages/list.do"; //菜单地址(权限用)
	@Resource(name="poweroutagesService")
	private PowerOutagesManager poweroutagesService;

	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表PowerOutages");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords1 = pd.getString("keywords1");				//关键词检索条件
		if(null != keywords1 && !"".equals(keywords1)){
			pd.put("keywords1", keywords1.trim());
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
		List<PageData>	varList = poweroutagesService.list(page);	//列出PowerOutages列表
		mv.setViewName("alarm/poweroutages/poweroutages_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	/**修改状态
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editTag")
	@ResponseBody
	public int editTag() throws Exception{
		int start=0;
		try {
			PageData pd = this.getPageData();
			poweroutagesService.editTag(pd);
		}catch (Exception e){
			e.printStackTrace();
			start=1;
		}
		return start;
	}
}
