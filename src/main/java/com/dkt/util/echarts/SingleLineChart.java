package com.dkt.util.echarts;

import com.alibaba.fastjson.JSON;

import java.util.List;

import static com.dkt.util.Tools.isEmpty;

public class SingleLineChart {
    /**
     * 单折线或单柱状图
     * @param type   决定单是饼状图（bar）还是单折线图(line)  不传类型默认为单折线图
     * @param titleName 标题名称
     * @param yName   Y轴名称
     * @param xName   x轴名称
     * @param xData   x轴值
     * @param data    Y轴值
     * @return
     */
    public Object getSingleLineOrBarChart(String type,String titleName,String yName,String xName,List<String> xData,List<String> data){
        StringBuffer option=new StringBuffer();
        if(isEmpty(type)){
            type="line";
        }
        option.append("{tooltip: {trigger: 'axis'},legend: {data:['"+titleName+"'],},");
        option.append("xAxis : [{name:'"+xName+"',type : 'category',data : [");
        for(int i=0;i<xData.size();i++){
            if (xData.size()==1){
                option.append("'"+xData.get(i)+"'");
            }else {
                if(i<xData.size()-1){
                    option.append("'"+xData.get(i)+ "',");
                }else{
                    option.append("'"+xData.get(i)+"'");
                }
            }
        }
        option.append("]}],yAxis : [{name: '"+yName+"',type : 'value'}],series : [");
        option.append("{'name':'"+titleName+"', 'type':'"+type+"','data':[");
        for(int i=0;i<data.size();i++){
            if (data.size()==1){
                option.append("'"+data.get(i)+"'");
            }else {
                if(i<data.size()-1){
                    option.append("'"+data.get(i)+ "',");
                }else{
                    option.append("'"+data.get(i)+"'");
                }
            }
        }
        option.append("]} ] }");
        String  optionList = option.toString().replaceAll(" +","").trim();
        return JSON.parse(optionList);
    }
    /**
     * 多折线或多柱状图
     * @param type   决定单是饼状图（bar）还是折线图(line)  不传类型默认为折线图
     * @param titleName 每条展示数据的标题名称集合
     * @param yName   Y轴名称
     * @param xName   x轴名称
     * @param xData   x轴值集合
     * @param data    每条数据Y轴值集合
     * 注意标题名称titleName集合和data集合的长度要一致
     * @return
     */
    public Object getManyLineOrBarChart(String text,String type,List<String> titleName,String yName,String xName,List<String> xData,List<List> data){
        StringBuffer option=new StringBuffer();
        if(isEmpty(type)){
            type="line";
        }
        if(data.size()>0){
            if(type.equals("line")){
                option.append("{title: { text: '"+text+"'},tooltip : {trigger: 'axis',position: ['50%', '10%'],axisPointer : {type : 'line'}},legend: {data: [");
            }else {
                option.append("{title: { text: '"+text+"'},tooltip : {trigger: 'axis',axisPointer : {type : 'shadow'}},legend: {data: [");
            }
            for(int i=0;i<titleName.size();i++){
                if (titleName.size()==1){
                    option.append("'"+titleName.get(i)+"'");
                }else {
                    if(i<titleName.size()-1){
                        option.append("'"+titleName.get(i)+ "',");
                    }else{
                        option.append("'"+titleName.get(i)+"'");
                    }
                }
            }
            option.append("]},grid: {left: '3%',right: '7%',bottom: '3%',containLabel: true},yAxis: {name:'"+yName+"',type: 'value'},xAxis: {type: 'category',name:'"+xName+"',data: [");
            for(int i=0;i<xData.size();i++){
                if (xData.size()==1){
                    option.append("'"+xData.get(i)+"'");
                }else {
                    if(i<xData.size()-1){
                        option.append("'"+xData.get(i)+ "',");
                    }else{
                        option.append("'"+xData.get(i)+"'");
                    }
                }
            }
            option.append("]},series: [");
            for(int i=0;i<titleName.size();i++){
                if (titleName.size()==1){
                    option.append("{name: '"+titleName.get(i)+"',type: '"+type+"',label: {normal: {position: 'insideRight'}},data: [");
                    for(int j=0;j<data.get(i).size();j++){
                        if (data.get(i).size()==1){
                            option.append("'"+data.get(i).get(j)+"'");
                        }else {
                            if(j<data.get(i).size()-1){
                                option.append("'"+data.get(i).get(j)+ "',");
                            }else{
                                option.append("'"+data.get(i).get(j)+"'");
                            }
                        }
                    }
                    option.append("]}");
                }else {
                    if(i<titleName.size()-1){
                        option.append("{name: '"+titleName.get(i)+"',type: '"+type+"',label: {normal: {position: 'insideRight'}},data: [");
                        for(int j=0;j<data.get(i).size();j++){
                            if (data.get(i).size()==1){
                                option.append("'"+data.get(i).get(j)+"'");
                            }else {
                                if(j<data.get(i).size()-1){
                                    option.append("'"+data.get(i).get(j)+ "',");
                                }else{
                                    option.append("'"+data.get(i).get(j)+"'");
                                }
                            }
                        }
                        option.append("]},");
                    }else{
                        option.append("{name: '"+titleName.get(i)+"',type: '"+type+"',label: {normal: {position: 'insideRight'}},data: [");
                        for(int j=0;j<data.get(i).size();j++){
                            if (data.get(i).size()==1){
                                option.append("'"+data.get(i).get(j)+"'");
                            }else {
                                if(j<data.get(i).size()-1){
                                    option.append("'"+data.get(i).get(j)+ "',");
                                }else{
                                    option.append("'"+data.get(i).get(j)+"'");
                                }
                            }
                        }
                        option.append("]}");
                    }
                }
            }
            option.append("]}");
        }else{
            option.append("{tooltip: {trigger: 'axis',axisPointer: {type: 'shadow'}},legend: {data: ['']},grid: {left: '3%',right: '7%',bottom: '3%',containLabel: true},yAxis: {type: 'value'},xAxis: {type: 'category',data: []},series: []}");
        }
        String  optionList = option.toString().replaceAll(" +","");
        return JSON.parse(optionList);
    }
    /**
     * 雷达图
     * @param text    图名称
     * @param titleName 每条展示数据的标题名称集合
     * @param max   最大边缘值
     * @param calibration   每个刻度展示的值
     * @param data   每个刻度里面的值是多少轴值集合
     * 注意刻度calibration集合和data集合的长度要一致
     * @return
     */
    public Object getRadarMap(String text,List<String> titleName,int max,List<String> calibration,List<List> data){
        StringBuffer option=new StringBuffer();
        option.append("{title: {text: '"+text+"'},tooltip: {trigger: 'axis'}, legend: {data: [");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("'"+titleName.get(i)+"'");
            }else {
                if(i<titleName.size()-1){
                    option.append("'"+titleName.get(i)+ "',");
                }else{
                    option.append("'"+titleName.get(i)+"'");
                }
            }
        }
        option.append("]}, polar: [{indicator: [");
        for(int i=0;i<calibration.size();i++){
            if (calibration.size()==1){
                option.append("{ text: '"+calibration.get(i)+"', max: "+max+"}");
            }else {
                if(i<calibration.size()-1){
                    option.append("{ text: '"+calibration.get(i)+"', max: "+max+"},");
                }else{
                    option.append("{ text: '"+calibration.get(i)+"', max: "+max+"}");
                }
            }
        }
        option.append("],}],series: [{type: 'radar',data: [");

        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("{value: [");
                for(int j=0;j<data.get(i).size();j++){
                    if (data.get(i).size()==1){
                        option.append("'"+data.get(i).get(j)+"'");
                    }else {
                        if(j<data.get(i).size()-1){
                            option.append("'"+data.get(i).get(j)+ "',");
                        }else{
                            option.append("'"+data.get(i).get(j)+"'");
                        }
                    }
                }
                option.append("],name: '"+titleName.get(i)+"'}");
            }else {
                if(i<titleName.size()-1){
                    option.append("{value: [");
                    for(int j=0;j<data.get(i).size();j++){
                        if (data.get(i).size()==1){
                            option.append("'"+data.get(i).get(j)+"'");
                        }else {
                            if(j<data.get(i).size()-1){
                                option.append("'"+data.get(i).get(j)+ "',");
                            }else{
                                option.append("'"+data.get(i).get(j)+"'");
                            }
                        }
                    }
                    option.append("],name: '"+titleName.get(i)+"'},");
                }else{
                    option.append("{value: [");
                    for(int j=0;j<data.get(i).size();j++){
                        if (data.get(i).size()==1){
                            option.append("'"+data.get(i).get(j)+"'");
                        }else {
                            if(j<data.get(i).size()-1){
                                option.append("'"+data.get(i).get(j)+ "',");
                            }else{
                                option.append("'"+data.get(i).get(j)+"'");
                            }
                        }
                    }
                    option.append("],name: '"+titleName.get(i)+"'}");
                }
            }
        }

        option.append("]}]}");
        String  optionList = option.toString().replaceAll(" +","");
        return JSON.parse(optionList);
    }

    /**
     * 环形图
     * @param titleDesc    标题描述
     * @param titleName    标题集合
     * @param data         每个标题所占的值
     * 注意刻度titleName集合和data集合的长度要一致
     * @return
     */
    public Object getCircularDiagram(String titleDesc,List<String> titleName,List<String> data){
        StringBuffer option=new StringBuffer();
        String format="{a}<br/>{b}:{c}({d}%)";
        option.append("{tooltip: {trigger: 'item',formatter:'"+format+"'},legend: {orient: 'vertical',x: 'left',data:[");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("'"+titleName.get(i)+"'");
            }else {
                if(i<titleName.size()-1){
                    option.append("'"+titleName.get(i)+ "',");
                }else{
                    option.append("'"+titleName.get(i)+"'");
                }
            }
        }
        option.append(" ]},series: [{name:'"+titleDesc+"',type:'pie',radius: ['50%', '70%'],avoidLabelOverlap: false,");
        option.append("label: {normal: {show: false,position: 'center'},emphasis: {show: true,");
        option.append("textStyle: {fontSize: '30',fontWeight: 'bold'}}},labelLine: {normal: {show: false}},data:[");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
            }else {
                if(i<titleName.size()-1){
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'},");
                }else{
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
                }
            }
        }
        option.append("]}]}");
        String  optionList = option.toString().replaceAll(" +","");
        return JSON.parse(optionList);
    }
    /**
     * 饼状图
     * @param text         图名称
     * @param subtext      图名称描述
     * @param titleDesc    标题描述
     * @param titleName    标题集合
     * @param data         每个标题所占的值
     * 注意刻度titleName集合和data集合的长度要一致
     * @return
     */
    public Object getPieChart(String text,String subtext,String titleDesc,List<String> titleName,List<String> data){
        StringBuffer option =new StringBuffer();
        option.append("{title :{ text: '"+text+"',subtext: '"+subtext+"',x:'center'},");
        option.append("tooltip : {trigger: 'item',formatter: '{a} <br/>{b} : {c} ({d}%)'},");
        option.append(" legend: {orient: 'vertical',left: 'left',data: [");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("'"+titleName.get(i)+"'");
            }else {
                if(i<titleName.size()-1){
                    option.append("'"+titleName.get(i)+ "',");
                }else{
                    option.append("'"+titleName.get(i)+"'");
                }
            }
        }
        option.append("]},series : [{name: '"+titleDesc+"',type: 'pie',radius : '55%',center: ['50%', '60%'],data:[");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
            }else {
                if(i<titleName.size()-1){
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'},");
                }else{
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
                }
            }
        }
        option.append("],itemStyle: {emphasis: {shadowBlur: 10,shadowOffsetX: 0,shadowColor: 'rgba(0, 0, 0, 0.5)'");
        option.append("}}}]}");
        String  optionList = option.toString().replaceAll(" +","");
        return JSON.parse(optionList);

    }

    /**
     * 蛋糕饼状图
     * @param titleDesc    标题描述
     * @param titleName    标题集合
     * @param data         每个标题所占的值
     * 注意刻度titleName集合和data集合的长度要一致
     * @return
     */
    public Object getCustomizedPie(int max,int min,String titleDesc,List<String> titleName,List<String> data){
        StringBuffer option =new StringBuffer();
        option.append("{backgroundColor: '#2c343c',title: {text: 'Customized Pie',left: 'center',top: 20,");
        option.append("textStyle: {color: '#ccc'}},tooltip : {trigger: 'item', formatter: '{a}<br/>{b}:{c}({d}%)'},");
        option.append("visualMap: {show: false,min: "+min+",max: "+max+",inRange: {colorLightness: [0, 1]}},");
        option.append("series : [{name:'"+titleDesc+"',type:'pie',radius : '55%',center: ['50%', '50%'],data:[");
        for(int i=0;i<titleName.size();i++){
            if (titleName.size()==1){
                option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
            }else {
                if(i<titleName.size()-1){
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'},");
                }else{
                    option.append("{value:"+data.get(i)+", name:'"+titleName.get(i)+"'}");
                }
            }
        }
        option.append("],roseType: 'radius',");
        option.append("  label: {normal: {textStyle: {color: 'rgba(255, 255, 255, 0.3)'}}},labelLine: {normal: {");
        option.append("lineStyle: {color: 'rgba(255, 255, 255, 0.3)'},smooth: 0.2,length: 10,length2: 20}},");
        option.append("itemStyle: {normal: {color: '#c23531',shadowBlur: 200,shadowColor: 'rgba(0, 0, 0, 0.5)'}},");
        option.append("}]}");
        String  optionList = option.toString().replaceAll(" +","");
        return JSON.parse(optionList);

    }
    /**
     * 折线饼状图集合
     * @param yName1       Y轴左名称
     * @param yName1       Y轴右名称
     * @param titleName    标题集合
     * @param titleName    前几个为柱状图
     * @param data         每个标题所占的值集合
     * 注意刻度titleName集合和data集合的长度要一致
     * @return
     */
    public Object getLineAndbarList(String yName1,String yName2,List<String> titleName,int num,List<String> xData,List<List> data) {
        StringBuffer option = new StringBuffer();
        String optionList = null;
        if (data.size() > 0) {
            option.append("{tooltip: {trigger: 'axis',axisPointer: {type: 'cross',crossStyle: {color: '#999'}}},toolbox: {feature: {dataView: {show: true, readOnly: false},magicType: {show: true, type: ['line', 'bar']},restore: {show: true},\n" +
                    " saveAsImage: {show: true}}},legend: {data:[");
            if (titleName.size() > 0) {
                for (int i = 0; i < titleName.size(); i++) {
                    if (titleName.size() == 1) {
                        option.append("'" + titleName.get(i) + "'");
                    } else {
                        if (i < titleName.size() - 1) {
                            option.append("'" + titleName.get(i) + "',");
                        } else {
                            option.append("'" + titleName.get(i) + "'");
                        }
                    }
                }
                option.append("]},xAxis: [{type: 'category',data: [");

                for (int i = 0; i < xData.size(); i++) {
                    if (xData.size() == 1) {
                        option.append("'" + xData.get(i) + "'");
                    } else {
                        if (i < xData.size() - 1) {
                            option.append("'" + xData.get(i) + "',");
                        } else {
                            option.append("'" + xData.get(i) + "'");
                        }
                    }
                }
                option.append("],axisPointer: {type: 'shadow'}\n" +
                        "  }],yAxis: [{type: 'value',name: '" + yName1 + "',axisLabel: {formatter: '{value}'}},\n" +
                        " {type: 'value',name: '" + yName2 + "',axisLabel: {formatter: '{value}'}}],\n" +
                        "    series: [");
                for (int i = 0; i < titleName.size(); i++) {
                    if (i < num) {
                        option.append("{name:'" + titleName.get(i) + "',type:'bar',data:[");
                    } else {
                        option.append("{name:'" + titleName.get(i) + "',type:'line',yAxisIndex: 1,data:[");
                    }

                    for (int j = 0; j < data.get(i).size(); j++) {
                        if (data.get(i).size() == 1) {
                            option.append("'" + data.get(i).get(j) + "'");
                        } else {
                            if (j < data.get(i).size() - 1) {
                                option.append("'" + data.get(i).get(j) + "',");
                            } else {
                                option.append("'" + data.get(i).get(j) + "'");
                            }
                        }
                    }
                    if (data.size() == 1) {
                        option.append("]}");
                    } else {
                        if (i < data.size() - 1) {
                            option.append("]},");
                        } else {
                            option.append("]}");
                        }
                    }

                }
            }
            option.append("]}");
            optionList = option.toString().replaceAll(" +", "");
        }
        return JSON.parse(optionList);

    }


}
