package com.dkt.controller.trendcurvemanagement;
import com.alibaba.fastjson.JSON;
import com.dkt.controller.base.BaseController;
import com.dkt.service.trendcurvemanagement.DcPanelManager;
import com.dkt.service.trendcurvemanagement.TransformerManager;
import com.dkt.util.PageData;
import com.dkt.util.echarts.SingleLineChart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.dkt.entity.Page;
/**
 * 类名称：监控管理管理
 * @author：shr
 * 修改时间：2018年01月08日
 * @version
 */
@Controller
@RequestMapping(value="/dcpanel")
public class DcPanelController extends BaseController {
    @Resource(name="dcpanelService")
    private DcPanelManager dcpanelService;
    /**列表
     * @param page
     * @throws Exception
     */
    @RequestMapping(value="/list")
    @ResponseBody
    public List list(Page page) throws Exception{
        List objlist =new ArrayList();
        PageData pd = new PageData();
        pd = this.getPageData();
        page.setPd(pd);
        List<PageData>	varList = dcpanelService.list(page);
        if(varList.size()>0){
            for (int i=0;i<varList.size();i++){
                objlist.add(varList.get(i));
            }
        }
        return objlist;
    }

    /**去直流屏曲线页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/goToDePanel")
    @ResponseBody
    public ModelAndView EchartsList() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        List<PageData>	list = dcpanelService.selEquDcSreenNewId(pd);
        int newid=0;
        String equipmentName="";
        if(list.size()>0){
            newid=(Integer) list.get(0).get("id");
            equipmentName=list.get(0).get("equipment_name").toString();
        }
        mv.setViewName("trendcurvemanagement/de_panel");
        mv.addObject("newid",newid);
        mv.addObject("equipmentName",equipmentName);
        return mv;
    }
    /**微机保护装置数据查询
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/findEchartsList")
    @ResponseBody
    public List<Object> findDcPanelList(int id,String DataTime,int dataType,String graphicsType){
        Map<String,String> map = new HashMap<String,String>();
        PageData pd = new PageData();
        List<Object>objList = new ArrayList<Object>();
        Object obj=null;
        Object obj2=null;
        Object obj3=null;
        boolean ifhaveequlow=true;
        DecimalFormat df   = new DecimalFormat("######0.00");
        StringBuffer option=new StringBuffer();
        StringBuffer option2=new StringBuffer();
        StringBuffer option3=new StringBuffer();
        try{
            pd = this.getPageData();
            if(dataType==1 ||dataType==2){
                pd.put("DataTime",DataTime);
            }else if (dataType==3){
                String DataTime2=DataTime.substring(0,8);
                DataTime2=DataTime2+"01";
                pd.put("DataTime",DataTime2);
            }
            pd.put("id",id);
            SingleLineChart echarts=new SingleLineChart();
            List<String> titleName=new ArrayList<String>();
            List<String> titleName2=new ArrayList<String>();
            List<String> titleName3=new ArrayList<String>();
            List a=new ArrayList();
            List b=new ArrayList();
            List c=new ArrayList();
            List<String> xData=new ArrayList<String>();
            List<List> data=new ArrayList<List>();
            List<List> data2=new ArrayList<List>();
            List<List> data3=new ArrayList<List>();
            String xName="日期";
            List<PageData>	threepc = dcpanelService.findDcPanelList(pd);
//            if(threepc.size()>0){
            if(false){
                for(int i=0;i<threepc.size();i++){
                    PageData tpc=threepc.get(i);
                    a.add(df.format(tpc.get("mother_accused_undervoltage")));
                    b.add(df.format(tpc.get("mother_or_undervoltage")));
                    c.add(df.format(tpc.get("rechargeable_battery_current")));
                    xData.add((String) tpc.get("collect_time"));
                }
                data.add(a);
                data2.add(b);
                data3.add(c);
                String text="控母欠压曲线图";
                titleName.add("控母欠压");
                String yName="V";
                obj=echarts.getManyLineOrBarChart(text,graphicsType,titleName, yName, xName,xData,data);
                //合母欠压图
                titleName2.add("合母欠压");
                String text2="合母欠压曲线图";
                String yName2="V";
                obj2=echarts.getManyLineOrBarChart(text2,graphicsType,titleName2, yName2, xName,xData,data2);
                //充电电池电流
                titleName3.add("充电电池电流");
                String text3="充电电池电流曲线图";
                String yName3="A";
                obj3=echarts.getManyLineOrBarChart(text3,graphicsType,titleName3, yName3, xName,xData,data3);
            }else{
                option.append("{title: { text: '控母欠压曲线图'},tooltip: {trigger: 'axis',position: ['50%', '10%'],axisPointer: {type: 'shadow'}},legend: {data: ['A相温度','B相温度','C相温度']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj = JSON.parse(option.toString().replaceAll(" +",""));
                option2.append("{title: { text: '合母欠压曲线图'},tooltip: {trigger: 'axis',position: ['50%', '10%'],axisPointer: {type: 'shadow'}},legend: {data: ['A相温度','B相温度','C相温度']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj2 = JSON.parse(option2.toString().replaceAll(" +",""));
                option3.append("{title: { text: '充电电池电流曲线图'},tooltip: {trigger: 'axis',position: ['50%', '10%'],axisPointer: {type: 'shadow'}},legend: {data: ['A相温度','B相温度','C相温度']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj3 = JSON.parse(option3.toString().replaceAll(" +",""));
            }
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        objList.add(obj);
        objList.add(obj2);
        objList.add(obj3);
        return objList;
    }
}
