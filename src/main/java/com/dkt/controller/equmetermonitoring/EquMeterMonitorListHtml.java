package com.dkt.controller.equmetermonitoring;

import com.dkt.entity.equmetermonitoring.EquMeterMonitoring;

import java.util.List;

/**
 * Created by Tom Sun on 2018/1/18.
 */
public class EquMeterMonitorListHtml {


    public String EquMeterMonitorAssemble(List<EquMeterMonitoring> EquMeter_Lsit) {

        String allHtml="";
        if(EquMeter_Lsit.size()>0)
        {
            String contentHtml="";
            int typeSave=-1;
            for(int i=0;i<EquMeter_Lsit.size();i++)
            {
                EquMeterMonitoring info=EquMeter_Lsit.get(i);
                int type=info.getEQU_TYPE();
                if(typeSave==-1)
                {
                    typeSave=type;
                }

                if(typeSave!=type)
                {
                    String topHtml= EquMeterMonitorTopAssemble(typeSave,contentHtml);
                    allHtml+=topHtml;

                    typeSave=type;//重新赋值
                    contentHtml="";//清空

                    if(EquMeter_Lsit.size()==i+1)//如果是最后一条
                    {
                        contentHtml+=EquMeterMonitorContentAssemble(info);
                        String topHtml_last= EquMeterMonitorTopAssemble(type,contentHtml);
                        allHtml+=topHtml_last;
                        break;//结束循环
                    }
                }

                if(typeSave==type)
                {
                    contentHtml+=EquMeterMonitorContentAssemble(info);

                    if(EquMeter_Lsit.size()==i+1)//如果是最后一条
                    {
                        String topHtml_last= EquMeterMonitorTopAssemble(type,contentHtml);
                        allHtml+=topHtml_last;
                        break;//结束循环
                    }
                }
            }
        }

        return allHtml;
    }



    private String EquMeterMonitorTopAssemble(int type,String equMeterMonitorContentHtml)
    {
        String html=EquMeterMonitorTopHtml();
        if(type==1)
        {
            html = html.replace("<div class='title'>title</div>","<div class='title'>高压</div>");
        }
        else if(type==2)
        {
            html = html.replace("<div class='title'>title</div>","<div class='title'>低压</div>");
        }
        else if(type==0)
        {
            html = html.replace("<div class='title'>title</div>","<div class='title'>回路</div>");
        }
        html = html.replace("<div class='lump_bx'>content</div>","<div class='lump_bx'>"+equMeterMonitorContentHtml+"</div>");

        return html;
    }

    public String EquMeterMonitorContentAssemble(EquMeterMonitoring info)
    {
        String html=EquMeterMonitorContentHtml();
        if(info!=null)
        {
            String content="";
            content+="<div class='til'><B>"+info.getMETER_NAME()+"</B></div>";

            if(info.getEQU_TYPE()==2) {//低压

                html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/diya.png' onclick=show("+info.getMETER_ID()+",'"+info.getEQUIPMENT_NAME()+"')  title='关联设备:" + info.getEQUIPMENT_NAME() + " / 网关:"+info.getGATEWAY_NO()+" / 电房:" + info.getELECTRICAL_ROOM_NAME() + "'>");//图片

                content+="<div class='til'>电量:"+Math.round(info.getTOTAL_P_AT_EE())+"</div>";
                content+="<div class='til'>无功电量:"+Math.round(info.getTOTAL_AP_REAT_EE())+"</div>";
                content+="<div class='til'>AI/BI/CI:"+Math.round(info.getA_ELECTRICITY())+"/"+Math.round(info.getB_ELECTRICITY()) + "/" + Math.round(info.getC_ELECTRICITY()) + "</div>";
                content+="<div class='til'>AV/BV/CV:"+Math.round(info.getA_VOLTAGE())+"/"+Math.round(info.getB_VOLTAGE()) + "/" + Math.round(info.getC_VOLTAGE()) + "</div>";
                content+="<div class='til'>AB V/AC V/BC V:"+Math.round(info.getUAB_LINE_VOLTAGE())+"/"+Math.round(info.getUBC_LINE_VOLTAGE()) + "/" + Math.round(info.getUAC_LINE_VOLTAGE()) + "</div>";
                content+="<div class='til'>频率："+Math.round(info.getFREQUENCY())+"</div>";

                if(info.getTEMPERATURE_ON_TYPE()==0)
                {
                    content+="<div class='til'>配电开关状态：正常</div>";
                }
                else if(info.getTEMPERATURE_ON_TYPE()==1)
                {
                    content+="<div class='til'>配电开关状态：不正常</div>";
                }
                content+="<div class='til'>总功率因数："+info.getTOTAL_POWER_FACTOR()+"</div>";
                content+="<div class='til'>3相总有功功率："+Math.round(info.getTOTAL_ACTIVE_POWER())+"</div>";
                content+="<div class='til'>3相总无功功率："+Math.round(info.getTOTAL_REACTIVE_POWER())+"</div>";
                content+="<div class='til'>CT变比："+info.getC_T_RATIO()+"</div>";
            }
            else if(info.getEQU_TYPE()==1)//高压
            {
                html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/diya.png' onclick=show("+info.getMETER_ID()+",'"+info.getEQUIPMENT_NAME()+"') title='关联设备:" + info.getEQUIPMENT_NAME() + " / 网关:"+info.getGATEWAY_NO()+" / 电房:" + info.getELECTRICAL_ROOM_NAME() + "'>");//图片

                content+="<div class='til'>总功率因数："+info.getTOTAL_POWER_FACTOR()+"</div>";
                content+="<div class='til'>3相总有功功率："+Math.round(info.getTOTAL_ACTIVE_POWER())+"</div>";
                content+="<div class='til'>3相总无功功率："+Math.round(info.getTOTAL_REACTIVE_POWER())+"</div>";
                content+="<div class='til'>CT变比："+info.getC_T_RATIO()+"</div>";
            }
            else if(info.getEQU_TYPE()==0)//回路
            {
                html = html.replace("<img src='images/211.png' title=''>", "<img src='static/images/monitor/diya.png' onclick='show("+info.getID()+")' title='电房:" + info.getELECTRICAL_ROOM_NAME() + " / 网关:"+info.getGATEWAY_NO()+"'>");//图片

                content+="<div class='til'>电量："+info.getTOTAL_P_AT_EE()+"</div>";
                content+="<div class='til'>无功电量："+info.getTOTAL_AP_REAT_EE()+"</div>";
                content+="<div class='til'>AI/BI/CI:"+Math.round(info.getA_ELECTRICITY())+"/"+Math.round(info.getB_ELECTRICITY()) + "/" + Math.round(info.getC_ELECTRICITY()) + "</div>";
                content+="<div class='til'>AV/BV/CV:"+Math.round(info.getA_VOLTAGE())+"/"+Math.round(info.getB_VOLTAGE()) + "/" + Math.round(info.getC_VOLTAGE()) + "</div>";
                content+="<div class='til'>AB V/AC V/BC V:"+Math.round(info.getUAB_LINE_VOLTAGE())+"/"+Math.round(info.getUBC_LINE_VOLTAGE()) + "/" + Math.round(info.getUAC_LINE_VOLTAGE()) + "</div>";
                content+="<div class='til'>频率："+Math.round(info.getFREQUENCY())+"</div>";
                content+="<div class='til'>总功率因数："+info.getTOTAL_POWER_FACTOR()+"</div>";
                content+="<div class='til'>3相总有功功率："+Math.round(info.getTOTAL_ACTIVE_POWER())+"</div>";
                content+="<div class='til'>3相总无功功率："+Math.round(info.getTOTAL_REACTIVE_POWER())+"</div>";
                content+="<div class='til'>CT变比："+info.getC_T_RATIO()+"</div>";
            }

            html = html.replace("<div class='til'>content</div>",content);
        }

        return html;
    }

    private String EquMeterMonitorContentHtml()
    {
        String html="<div class=\"lump\">\n" +
                "<div class=\"lump_cont\">\n" +
                "<div class=\"img_bx\"><img src='images/211.png' title=''></div>\n" +
                "<div class='til'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }

    private String EquMeterMonitorTopHtml()
    {
        String html="<div class=\"part_1\">\n" +
                "<div class='title'>title</div>\n" +
                "<div class=\"line_bx\"><div class=\"line\"></div></div>\n" +
                "<div class=\"part_cont\">" +
                "<div class='lump_bx'>content</div>\n" +
                "</div>\n" +
                "</div>";

        return  html;
    }
}
