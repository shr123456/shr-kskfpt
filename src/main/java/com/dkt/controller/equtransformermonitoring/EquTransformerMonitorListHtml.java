package com.dkt.controller.equtransformermonitoring;

import com.dkt.entity.equtransformermonitoring.EquTtransformerMonitoring;

import java.util.List;

/**
 * Created by Tom Sun on 2018/1/18.
 */
public class EquTransformerMonitorListHtml {

    private String transformerOnHtml="";
    private String transformerOffHtml="";

    public String EquTransformerMonitorAssemble(List<EquTtransformerMonitoring> transformerLowList,List<EquTtransformerMonitoring> transformerHighList)
    {
        String html="";
        //低压数据
        for(int j=0;j<transformerLowList.size();j++)
        {
            EquTransformerMonitorAssemble(transformerLowList.get(j),1);
        }
        //高压数据
        for(int k=0;k<transformerHighList.size();k++)
        {
            EquTransformerMonitorAssemble(transformerHighList.get(k),2);
        }

        if(transformerOnHtml!="")
        {
           String onHtml= EquTransformerMonitorTopOnHtml();
            onHtml = onHtml.replace("<div class='lump_bx'>content</div>","<div class='lump_bx'>"+transformerOnHtml+"</div>");
            html+=onHtml;
        }
        if(transformerOffHtml!="")
        {
            String offHtml= EquTransformerMonitorTopOffHtml();
            offHtml = offHtml.replace("<div class='lump_bx'>content</div>","<div class='lump_bx'>"+transformerOffHtml+"</div>");
            html+=offHtml;
        }

        return html;
    }

    public void  EquTransformerMonitorAssemble(EquTtransformerMonitoring info,int type)
    {
        String html=EquTransformerMonitorHtml();
        if(info!=null)
        {
            String content="";

            content+="<div class='til'><B>"+info.getEQUIPMENT_NAME()+"</b></div>";
            content+="<div class='til'>容量:"+info.getCAPACITY()+"</div>";
            if(info.getLOW_ID() != null && !"".equals(info.getLOW_ID().trim())) {

                if(type==1) {
                    html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/bianyaqi.png' onclick=show("+info.getID()+",'"+info.getLOW_EQUIPMENT_NAME()+"',1) title='电房："+info.getELECTRICAL_ROOM_NAME()+" / 关联低压柜:" + info.getLOW_EQUIPMENT_NAME() +"'>");
                    //content += "<div class='til'>关联低压柜:" + info.getLOW_EQUIPMENT_NAME() + "</div>";
                }
                else  if(type==2) {
                    html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/bianyaqi.png' onclick=show("+info.getID()+",'"+info.getLOW_EQUIPMENT_NAME()+"',2) title='电房："+info.getELECTRICAL_ROOM_NAME()+" / 关联高压柜:" + info.getLOW_EQUIPMENT_NAME() +"'>");
                    // content += "<div class='til'>关联高压柜:" + info.getLOW_EQUIPMENT_NAME() + "</div>";
                }

                //content += "<div class='til'>总电量:" + info.getTOTAL_P_AT_EE() + "</div>";
                if(info.getLOAD_RATE()==null) {
                    content += "<div class='til'>负载率: - </div>";
                }
                else
                {
                    content += "<div class='til'>负载率:" + Math.round(info.getLOAD_RATE()) + "%</div>";
                }
            }
            else
            {
                html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/bianyaqiwei.png' onclick=show("+info.getID()+",'暂没有关联设备',0)>");
            }
//
//            if(info.getMAX_A()==null) {
//                content += "<div class='til'>绕组温度:<img src=\"static/images/monitor/up.png\" title=\"最高\" style=\"wihth:15px;height:15px;\"> - <img src=\"static/images/monitor/down.png\" title=\"最低\" style=\"wihth:15px;height:15px;\"> - </div>";
//            }
//            else
//            {
//                content += "<div class='til'>绕组温度:<img src=\"static/images/monitor/up.png\" title=\"最高\" style=\"wihth:15px;height:15px;\"> " + info.getMAX_A() + " <img src=\"static/images/monitor/down.png\" title=\"最低\" style=\"wihth:15px;height:15px;\"> " + info.getMIN_A() + "</div>";
//            }
//
//            if(info.getMAX_B()==null) {
//                content+="<div class='til'>铁芯温度:<img src=\"static/images/monitor/up.png\" title=\"最高\" style=\"wihth:15px;height:15px;\"> - <img src=\"static/images/monitor/down.png\" title=\"最低\" style=\"wihth:15px;height:15px;\"> - </div>";
//            }
//            else
//            {
//                content+="<div class='til'>铁芯温度:<img src=\"static/images/monitor/up.png\" title=\"最高\" style=\"wihth:15px;height:15px;\"> "+info.getMAX_B()+" <img src=\"static/images/monitor/down.png\" title=\"最低\" style=\"wihth:15px;height:15px;\"> "+info.getMIN_B()+"</div>";
//            }

            content += "<div class='til'>绕组温度:(A相)"+info.getA_WINDING_TEMPERATURE()+"(B相)"+info.getB_WINDING_TEMPERATURE()+"(C相)"+info.getC_WINDING_TEMPERATURE()+"</div>";
            content += "<div class='til'>铁芯温度:(A相)"+info.getA_CORE_TEMPERATURE()+ "(B相)"+info.getB_CORE_TEMPERATURE()+"(C相)"+info.getC_CORE_TEMPERATURE()+"</div>";

            html = html.replace("<div class='til'>content</div>",content);

            if(info.getLOW_ID() != null && !"".equals(info.getLOW_ID().trim())) {
                transformerOnHtml+=html;
            }
            else {
                transformerOffHtml+=html;
            }
        }
    }

    private String EquTransformerMonitorHtml()
    {
        String html="<div class=\"lump\">\n" +
                "<div class=\"lump_cont\">\n" +
                "<div class=\"img_bx\"><img src='images/211.png' title=''></div>\n" +
                "<div class='til'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }

    private String EquTransformerMonitorTopOnHtml()
    {
        String html="<div class=\"part_1\">\n" +
                "<div class=\"part_cont\">" +
                "<div class='lump_bx'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }

    private String EquTransformerMonitorTopOffHtml()
    {
        String html="<div class=\"part_1\">\n" +
                "<div class='title'>未启用</div>\n" +
                "<div class=\"line_bx\"><div class=\"line\"></div></div>\n" +
                "<div class=\"part_cont\">" +
                "<div class='lump_bx'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }


}
