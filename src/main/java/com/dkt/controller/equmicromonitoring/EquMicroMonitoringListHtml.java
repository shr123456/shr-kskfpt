package com.dkt.controller.equmicromonitoring;


import com.dkt.entity.equmicromonitoring.EquMicroMonitoring;

import java.util.List;

/**
 * Created by Tom Sun on 2018/1/18.
 */
public class EquMicroMonitoringListHtml {


    public String EquMicroMonitorAssemble(EquMicroMonitoring info) {
        String html=EquMicroMonitorContentHtml();
        if(info!=null)
        {
            String content="";

            html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/weiji.png' onclick='show("+info.getID()+")' title='电房：" + info.getELECTRICAL_ROOM_NAME() + "'>");//图片

            content+="<div class='til'><B>"+info.getEQUIPMENT_NAME()+"</B></div>";
           // content+="<div class='til'>AI/BI/CI:"+Math.round(info.getA_ELECTRICITY())+"/"+Math.round(info.getB_ELECTRICITY()) + "/" + Math.round(info.getC_ELECTRICITY()) + "</div>";
            content+="<div class='til'>AV/BV/CV:"+Math.round(info.getA_VOLTAGE())+"/"+Math.round(info.getB_VOLTAGE()) + "/" + Math.round(info.getC_VOLTAGE()) + "</div>";
           // content+="<div class='til'>AL/BL/CL:"+Math.round(info.getA_LOAD())+"/"+Math.round(info.getB_LOAD()) + "/" + Math.round(info.getC_LOAD()) + "</div>";
            content+="<div class='til'>AB V/AC V/BC V:"+Math.round(info.getUAB_LINE_VOLTAGE())+"/"+Math.round(info.getUBC_LINE_VOLTAGE()) + "/" + Math.round(info.getUAC_LINE_VOLTAGE()) + "</div>";
            content+="<div class='til'>零序电流："+info.getZ_E_P_THRESHOLD()+"</div>";
            content+="<div class='til'>失压保护："+info.getLOSS_PRESSURE_PROTECTION()+"</div>";
            content+="<div class='til'>过电压保护："+info.getOVERVOLTAGE_PROTECTION()+"</div>";
            content+="<div class='til'>过负荷保护："+info.getOVERLOAD_PROTECTION()+"</div>";
            content+="<div class='til'>三段过流保护："+info.getTHREE_OVERCURRENT_PROTECTION()+"</div>";

            html = html.replace("<div class='til'>content</div>",content);
        }

        return html;
    }

    private String EquMicroMonitorContentHtml()
    {
        String html="<div class=\"lump\">\n" +
                "<div class=\"lump_cont\">\n" +
                "<div class=\"img_bx\"><img src='images/211.png' title=''></div>\n" +
                "<div class='til'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }

}
