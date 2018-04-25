package com.dkt.controller.equdcscreenmonitoring;


import com.dkt.entity.equdcscreenmonitoring.EquDCScreenMonitoring;

/**
 * Created by Tom Sun on 2018/1/18.
 */
public class EquDCScreenMonitorListHtml {

    public String EquDCScreenMonitorAssemble(EquDCScreenMonitoring info)
    {
        String html=EquMeterMonitorHtml();
        if(info!=null)
        {
            String content="";

            html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/zhiliuping.png' onclick='show("+info.getID()+")' title='电房：" + info.getELECTRICAL_ROOM_NAME() + "'>");//图片

            content+="<div class='til'><B>"+info.getEQUIPMENT_NAME()+"</B></div>";
//            content+="<div class='til'>控母欠压：(最大)"+info.getMAX_MCUcontent+="<div class='til'><B>"+info.getEQUIPMENT_NAME()+"</B></div>";()+"(最小)"+info.getMIN_MCU()+"</div>";
//            content+="<div class='til'>合母欠压：(最大)"+info.getMAX_MOU()+"(最小)"+info.getMIN_MOU()+"</div>";
//            content+="<div class='til'>充电电池电流：(最大)"+info.getMAX_RNC()+"(最小)"+info.getMIN_RNC()+"</div>";

            if(info.getUPS_WORK()==0)
            {
                content+="<div class='til'>UPS工作:正常</div>";
            }
            else
            {
                content+="<div class='til'>UPS工作:不正常</div>";
            }

            if(info.getFAILURE_STATE()==0)
            {
                content+="<div class='til'>状态:正常</div>";
            }
            else
            {
                content+="<div class='til'>状态:有故障</div>";
            }
            content+="<div class='til'>电压等级: "+info.getVOLTAGE_LEVEL()+"</div>";
            content+="<div class='til'>合母电压: "+info.getMOTHER_CLOSING_VOLTAGE()+"</div>";
            content+="<div class='til'>合母电流: "+info.getMOTHER_CLOSING_ELECTRICITY()+"</div>";
            content+="<div class='til'>合母欠压: "+info.getMOTHER_CLOSING_UNDERVOLTAGE()+"</div>";
            content+="<div class='til'>合母过压: "+info.getMOTHER_CLOSING_ELECTRICITY()+"</div>";

            content+="<div class='til'>控母电压: "+info.getMOTHER_CONTROL_VOLTAGE()+"</div>";
            content+="<div class='til'>控母电流: "+info.getMOTHER_CONTROL_ELECTRICITY()+"</div>";
            content+="<div class='til'>控母欠压: "+info.getMOTHER_CONTROL_UNDERVOLTAGE()+"</div>";
            content+="<div class='til'>控母过压: "+info.getMOTHER_CONTROL_ELECTRICITY()+"</div>";

            content+="<div class='til'>电池组电压:(1#)"+info.getBATTERY_VOLTAGE_ONE()+"/ (2#)"+info.getBATTERY_VOLTAGE_TWO()+"</div>";
            content+="<div class='til'>电池组温度:(1#)"+info.getBATTERY_TEMPERATURE_ONE()+"/ (2#)"+info.getBATTERY_TEMPERATURE_TWO()+"</div>";

            html = html.replace("<div class='til'>content</div>",content);
        }



        return html;
    }

    private String EquMeterMonitorHtml()
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
