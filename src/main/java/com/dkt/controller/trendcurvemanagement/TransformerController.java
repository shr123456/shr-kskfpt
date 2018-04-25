package com.dkt.controller.trendcurvemanagement;
import com.alibaba.fastjson.JSON;
import com.dkt.controller.base.BaseController;
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
@RequestMapping(value="/transformer")
public class TransformerController extends BaseController {
    @Resource(name="transformerService")
    private TransformerManager transformerService;
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
        List<PageData>	varList = transformerService.list(page);
        if(varList.size()>0){
            for (int i=0;i<varList.size();i++){
                objlist.add(varList.get(i));
            }
        }
        return objlist;
    }

    /**去变压器页面
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/goToTransformerCurve")
    @ResponseBody
    public ModelAndView EchartsList() throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        List<PageData>	list = transformerService.selEquTransNewId(pd);
        int newid=0;
        String equipmentName="";
        if(list.size()>0){
            newid=(Integer) list.get(0).get("id");
            equipmentName=list.get(0).get("equipment_name").toString();
        }

        mv.setViewName("trendcurvemanagement/transformer_curve");
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
        boolean ifhaveequlow=true;
        DecimalFormat df   = new DecimalFormat("######0.00");
        DecimalFormat cf   = new DecimalFormat("######0");
        int equlowid=0;//低压柜id
        int capacity=0;//容量
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
            //查询三相温度
            SingleLineChart echarts=new SingleLineChart();
            List<String> titleName=new ArrayList<String>();
            List<String> titleName3=new ArrayList<String>();
            List a=new ArrayList();
            List b=new ArrayList();
            List c=new ArrayList();
            List d=new ArrayList();
            List e=new ArrayList();
            List f=new ArrayList();
            List a2=new ArrayList();
            List<String> xData=new ArrayList<String>();
            List<String> xData2=new ArrayList<String>();
            List<List> data=new ArrayList<List>();
            List<List> data2=new ArrayList<List>();
            List<List> data3=new ArrayList<List>();
            String xName="日期";
            List<PageData>	threepc = transformerService.findThreePhaseTemperature(pd);
            if(threepc.size()>0){
                //图1
                titleName.add("A相绕阻温度");
                titleName.add("B相绕阻温度");
                titleName.add("C相绕阻温度");
                String yName="℃";
                for(int i=0;i<threepc.size();i++){
                    PageData tpc=threepc.get(i);
                    a.add(cf.format(tpc.get("a_winding_temperature")));
                    b.add(cf.format(tpc.get("a_winding_temperature")));
                    c.add(cf.format(tpc.get("c_winding_temperature")));
                    d.add(cf.format(tpc.get("a_core_temperature")));
                    e.add(cf.format(tpc.get("b_core_temperature")));
                    f.add(cf.format(tpc.get("c_core_temperature")));
                    xData.add((String) tpc.get("collect_time"));
                }
                data.add(a);
                data.add(b);
                data.add(c);
                String text="绕组温度曲线图";
                obj=echarts.getManyLineOrBarChart(text,graphicsType,titleName, yName, xName,xData,data);
                data3.add(d);
                data3.add(e);
                data3.add(f);
                String text2="铁芯温度曲线图";
                titleName3.add("A相铁芯温度");
                titleName3.add("B相铁芯温度");
                titleName3.add("C相铁芯温度");
                obj3=echarts.getManyLineOrBarChart(text2,graphicsType,titleName3, yName, xName,xData,data3);
            }else{
                option.append("{title: { text: '绕组温度曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: ['A相绕阻温度','B相绕阻温度','C相绕阻温度']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj = JSON.parse(option.toString().replaceAll(" +",""));
                option3.append("{title: { text: '铁芯温度曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: ['A相铁芯温度','B相铁芯温度','C相铁芯温度']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                obj3 = JSON.parse(option3.toString().replaceAll(" +",""));

            }
                //图2
                //查询低压柜id然后查询采集表电量数据
                List<PageData>	list = transformerService.selectEquLowIdById(pd);
                if (list.size()>0){
                    equlowid=Integer.parseInt(list.get(0).get("id").toString());
                    capacity=Integer.parseInt(list.get(0).get("capacity").toString());
                    pd.put("equlowid",equlowid);
                    //查询电量
                    List<PageData>	electricitylist = transformerService.findElectricity(pd);
                    if(electricitylist.size()>0){
                        for(int i=0;i<electricitylist.size();i++){
                            PageData elelist=electricitylist.get(i);
                            Double totalpatee=Double.parseDouble(elelist.get("total_p_at_ee").toString());
                            a2.add(df.format((totalpatee/capacity)/100));
                           // a2.add(df.format((Integer.parseInt(elelist.get("total_p_at_ee").toString())/capacity)/100));//负载率=电量/容量*100%
                            xData2.add((String) elelist.get("collect_time"));
                        }
                        data2.add(a2);
                        List<String> titleName2=new ArrayList<String>();
                        titleName2.add("负载率");
                        String yName2="(%)";
                        String text="负载率曲线图";
                        obj2=echarts.getManyLineOrBarChart(text,graphicsType,titleName2, yName2, xName,xData2,data2);
                    }else {
                        option2.append("{title: { text: '负载率曲线图'},tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: ['负载率']},grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},yAxis: {name:'',type: 'value'},xAxis: {name:'',type: 'category',data: []},series: []}");
                        obj2 = JSON.parse(option2.toString().replaceAll(" +",""));
                    }
                }else {
                    //是否有低压进线数据
                    ifhaveequlow=false;
                }
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        objList.add(obj);
        objList.add(obj3);
        if(ifhaveequlow){
            objList.add(obj2);
        }
        return objList;
    }
}
