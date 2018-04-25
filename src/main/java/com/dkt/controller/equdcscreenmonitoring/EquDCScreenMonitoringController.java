package com.dkt.controller.equdcscreenmonitoring;

import com.dkt.controller.base.BaseController;
import com.dkt.entity.electricalroom.ElectricalRoom;
import com.dkt.entity.equdcscreenmonitoring.EquDCScreenMonitoring;
import com.dkt.entity.system.User;
import com.dkt.service.electricalroom.ElectricalRoomManager;
import com.dkt.service.equdcscreenmonitoring.EquDCScreenMonitoringManager;
import com.dkt.util.Const;
import com.dkt.util.Jurisdiction;
import com.dkt.util.PageData;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 说明equdcscreenmonitoring
 * @author:ssm
 * @date:2018-01-17
 */
@Controller
@RequestMapping(value="/equdcscreenmonitoring")
public class EquDCScreenMonitoringController extends BaseController {

    String menuUrl = "equdcscreenmonitoring/list.do";

    @Resource(name="equdcscreenmonitoringService")
    private EquDCScreenMonitoringManager equDCScreenMonitoringService;
    @Resource(name="electricalroomService")
    private ElectricalRoomManager electricalRoomService;//电房

    @RequestMapping(value="/list")
    public ModelAndView list() throws Exception {
        logBefore(logger, Jurisdiction.getUsername() + "列表EquDCScreenMonitoringController");

        ModelAndView mv = this.getModelAndView();
//        Session session = Jurisdiction.getSession();
//        User user = (User)session.getAttribute(Const.SESSION_USER);
        PageData pd = new PageData();
        pd = this.getPageData();

        //        if(!"1".equals(reset)) {
//            //关键词检索条件
//            if (null != dataType && !"".equals(dataType)) {
//                int type = Integer.parseInt(dataType);
//                if (type == 1 || type == 2) {
//                    pd.put("DataTime", DataTime);
//                } else if (type == 3) {
//                    String DataTime2 = DataTime.substring(0, 8);
//                    DataTime2 = DataTime2 + "01";
//                    pd.put("DataTime", DataTime2);
//                }
//                pd.put("dataType", dataType);
//            }
//
//            if (null != keywords && !"".equals(keywords)) {
//                pd.put("keywords", keywords.trim());
//            }
//
//            if (null != roomid && !"".equals(roomid)) {
//                pd.put("roomid", roomid.trim());
//            }
//        }

        //取出用户相关数据
        List<EquDCScreenMonitoring> dc_list=equDCScreenMonitoringService.getDCMonitoringList(pd);

        String html="";
        if(dc_list.size()>0)
        {

            for(int j=0;j<dc_list.size();j++)
            {
                EquDCScreenMonitorListHtml equDCScreenMonitorListHtml=new EquDCScreenMonitorListHtml();
                html+=equDCScreenMonitorListHtml.EquDCScreenMonitorAssemble(dc_list.get(j));
            }
        }
        else
        {
            html="暂无数据，请重新搜索";
        }
        PageData pd_room = new PageData();
        List<ElectricalRoom> roomList=electricalRoomService.listByCustomerId(pd_room);
        mv.setViewName("equdcscreenmonitoring/equdcscreenmonitoring_list");
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
        pd = equDCScreenMonitoringService.findById(pd);	//根据ID读取
        mv.setViewName("equdcscreenmonitoring/equdcscreen_show");
        mv.addObject("msg", "show");
        mv.addObject("pd", pd);
        return mv;

    }



//    @RequestMapping(value="/search")
////    @ResponseBody
//    public String search() throws Exception {
//        logBefore(logger, Jurisdiction.getUsername() + "列表EquDCScreenMonitoringController");
//
//        ModelAndView mv = this.getModelAndView();
////        Session session = Jurisdiction.getSession();
////        User user = (User)session.getAttribute(Const.SESSION_USER);
//        PageData pd = new PageData();
//        //取出用户相关数据
//        List<EquDCScreenMonitoring> dc_list=equDCScreenMonitoringService.getDCMonitoringList(pd);
//
//        String html="<div class='til'><B>规范地方vbdgvfdv</B></div>";
//        if(dc_list.size()>0)
//        {
//            for(int j=0;j<dc_list.size();j++)
//            {
//                EquDCScreenMonitorListHtml equDCScreenMonitorListHtml=new EquDCScreenMonitorListHtml();
//                html+=equDCScreenMonitorListHtml.EquDCScreenMonitorAssemble(dc_list.get(j));
//            }
//        }
//
//        return html;
//    }



}
