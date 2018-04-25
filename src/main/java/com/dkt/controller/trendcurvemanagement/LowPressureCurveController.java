package com.dkt.controller.trendcurvemanagement;
import com.alibaba.fastjson.JSON;
import com.dkt.controller.base.BaseController;
import com.dkt.service.system.fhbutton.FhbuttonManager;
import com.dkt.service.trendcurvemanagement.LowPressureCurveManager;
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
import com.dkt.util.Jurisdiction;
/**
 * 类名称：监控管理管理
 * @author：shr
 * 修改时间：2018年01月08日
 * @version
 */
@Controller
@RequestMapping(value="/lowpressurecurve")
public class LowPressureCurveController extends BaseController {
    @Resource(name="lowpressurecurveService")
    private LowPressureCurveManager lowpressurecurveService;
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
        List<PageData>	varList = lowpressurecurveService.list(page);
        if(varList.size()>0){
            for (int i=0;i<varList.size();i++){
                objlist.add(varList.get(i));
            }
        }
        return objlist;
    }
    /**去低压页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/goToLowPressureCurve")
    @ResponseBody
    public ModelAndView EchartsList() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        List<PageData>	list = lowpressurecurveService.selectEqulowbNewId(pd);
        int newid=0;
        String equipmentName="";
        if(list.size()>0){
             newid=(Integer) list.get(0).get("id");
             equipmentName=list.get(0).get("equipment_name").toString();
        }

        mv.setViewName("trendcurvemanagement/low_pressure_curve");
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
    public List<Object> findThreePhaseCurrent(int id,String DataTime,int dataType,String graphicsType){
        Map<String,String> map = new HashMap<String,String>();
        PageData pd = new PageData();
        List<Object>objList = new ArrayList<Object>();
        Object obj=null;
        Object obj2=null;
        Object obj3=null;
        Object obj4=null;
        Object obj5=null;
        Object obj6=null;
        DecimalFormat df   = new DecimalFormat("######0.00");
        Boolean ifintoline=false;
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
            List<PageData>	list = lowpressurecurveService.selectEqulowbList(pd);
            if (list.size()>0){
                ifintoline=Boolean.parseBoolean(list.get(0).get("if_into_line").toString());
            }
            List<PageData>	threepc = lowpressurecurveService.findThreePhaseCurrent(pd);
            if(threepc.size()>0){
                //图1
                SingleLineChart echarts=new SingleLineChart();
                List<String> titleName=new ArrayList<String>();
                titleName.add("A相电流");
                titleName.add("B相电流");
                titleName.add("C相电流");
                String yName="(A)";
                String xName="日期";
                List a=new ArrayList();
                List b=new ArrayList();
                List c=new ArrayList();
                List a2=new ArrayList();
                List b2=new ArrayList();
                List c2=new ArrayList();
                List a3=new ArrayList();
                List a4=new ArrayList();
                List a5=new ArrayList();
                List a6=new ArrayList();
                List<String> xData=new ArrayList<String>();
                List<List> data=new ArrayList<List>();
                List<List> data2=new ArrayList<List>();
                List<List> data3=new ArrayList<List>();
                List<List> data4=new ArrayList<List>();
                List<List> data5=new ArrayList<List>();
                List<List> data6=new ArrayList<List>();
                for(int i=0;i<threepc.size();i++){
                    PageData tpc=threepc.get(i);
                    a.add(df.format(tpc.get("a_electricity")));
                    b.add(df.format(tpc.get("b_electricity")));
                    c.add(df.format(tpc.get("c_electricity")));
                    a2.add(df.format(tpc.get("A_VOLTAGE")));
                    b2.add(df.format(tpc.get("B_VOLTAGE")));
                    c2.add(df.format(tpc.get("C_VOLTAGE")));
                    a3.add(df.format(tpc.get("total_p_at_ee")));
                    a4.add(df.format(tpc.get("total_power_factor")));
                    a5.add(df.format(tpc.get("total_active_power")));
                    a6.add(df.format(tpc.get("total_reactive_power")));
                    xData.add((String) tpc.get("collect_time"));
                }
                data.add(a);
                data.add(b);
                data.add(c);
                data2.add(a2);
                data2.add(b2);
                data2.add(c2);
                data3.add(a3);
                data4.add(a4);
                data5.add(a5);
                data6.add(a6);
                String text="三相电流曲线图";
                obj=echarts.getManyLineOrBarChart(text,graphicsType,titleName, yName, xName,xData,data);
                //图2
                List<String> titleName2=new ArrayList<String>();
                titleName2.add("A相电压");
                titleName2.add("B相电压");
                titleName2.add("C相电压");
                String yName2="V";
                String text2="三相电压曲线图";
                obj2=echarts.getManyLineOrBarChart(text2,graphicsType,titleName2, yName2, xName,xData,data2);
                //图3
                List<String> titleName3=new ArrayList<String>();
                titleName3.add("电量");
                String text3="电量曲线图";
                obj3=echarts.getManyLineOrBarChart(text3,graphicsType,titleName3, yName2, xName,xData,data3);
                //图4
                List<String> titleName4=new ArrayList<String>();
                String yName3="P";
                titleName4.add("功率因数");
                String text4="功率因数曲线图";
                obj4=echarts.getManyLineOrBarChart(text4,graphicsType,titleName4, yName3, xName,xData,data4);
                if(ifintoline){
                //图5
                List<String> titleName5=new ArrayList<String>();
                titleName5.add("总有功功率");
                String yName5="KW";
                 String text5="总有功功率曲线图";
                obj5=echarts.getManyLineOrBarChart(text5,graphicsType,titleName5, yName5, xName,xData,data5);
                //图6
                List<String> titleName6=new ArrayList<String>();
                titleName6.add("总无功功率");
                String text6="总无功功率曲线图";
                obj6=echarts.getManyLineOrBarChart(text6,graphicsType,titleName6, yName5, xName,xData,data6);
                }
            }else{
                StringBuffer option=new StringBuffer();
                option.append("{title: { text: '三相电流曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj = JSON.parse(option.toString().replaceAll(" +",""));
                StringBuffer option2=new StringBuffer();
                option2.append("{title: { text: '三相电压曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj2 = JSON.parse(option2.toString().replaceAll(" +",""));
                StringBuffer option3=new StringBuffer();
                option3.append("{title: { text: '线电流曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj3 = JSON.parse(option3.toString().replaceAll(" +",""));
                StringBuffer option4=new StringBuffer();
                option4.append("{title: { text: '相电流曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj4 = JSON.parse(option4.toString().replaceAll(" +",""));
                if(ifintoline) {
                    StringBuffer option5=new StringBuffer();
                    option5.append("{title: { text: '总有功功率曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                    obj5 = JSON.parse(option5.toString().replaceAll(" +",""));
                    StringBuffer option6=new StringBuffer();
                    option6.append("{title: { text: '总无功功率曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: []},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                    obj6 = JSON.parse(option6.toString().replaceAll(" +",""));
                }
            }
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        objList.add(obj);
        objList.add(obj2);
        objList.add(obj3);
        objList.add(obj4);
        if(ifintoline) {
            objList.add(obj5);
            objList.add(obj6);
        }
        return objList;
    }
}
