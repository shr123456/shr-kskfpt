<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <!-- 下拉框 -->
    <link rel="stylesheet" href="static/ace/css/chosen.css" />
    <!-- jsp文件头和头部 -->
    <%@ include file="../system/index/top.jsp"%>
    <!-- 日期框 -->
    <link rel="stylesheet" href="static/ace/css/datepicker.css" />
    <!-- /.main-container -->

    <!-- basic scripts -->
    <!-- 页面底部js¨ -->
    <%@ include file="../system/index/foot.jsp"%>
    <!-- 删除时确认窗口 -->
    <script src="static/ace/js/bootbox.js"></script>
    <!-- ace scripts -->
    <script src="static/ace/js/ace/ace.js"></script>
    <!-- 下拉框 -->
    <script src="static/ace/js/chosen.jquery.js"></script>
    <!-- 日期框 -->
    <script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
    <!--提示框-->
    <script type="text/javascript" src="static/js/jquery.tips.js"></script>
    <script type="text/javascript" src="plugins/echarts/echarts3.js"></script>
    <%--<script type="text/javascript" src="plugins/echarts/echarts2.js"></script>--%>
    <style type="text/css">
        html,body{background-color: white;}
        .head{width: 100%;height: 50px;border: 1px solid;}
        .head>.head_up{float: left}
        .head>.head_dw{float: left;margin-top: 10px;}
        .head_dw_zq{width: 150px;float: left;margin-top: 10px;}
        .cont{margin-top: 5px;}
        .cont_up,.cont_dw{width: 49.8%;height: 340px;border: 1px solid;margin: 1px;overflow: hidden}
        .cont_up,.cont_dw{float: left;}
        .datetime,.sbxz{margin-top: 10px;}
        .span10{height: 25px;width: 100px;}
        .dtime{width: 160px}
        .sel{width: 50px;padding: 0px;height: 27px;}
        .col-sm-3{width: 77px;margin-top: 2px;}
        #mainFrame{height: 700px;}
        .offerRe{width: 100%;height: 100%; background:rgba(0,0,0,0.3); position:fixed; left:0; top:0;}
        .offerRe .alarmCon{width:600px;height:450px;position: absolute;left: 50%;top:60%;margin-left: -250px;margin-top: -275px;}
        .offerRe .searchEve{display: block;}
        .panelHeader{
            padding:10px 10px 10px 2px;
            border-bottom: 1px solid #eeeeee;
            font-weight: bold;
            font-size: 16px;
            margin-left: 10px;
            background: #78acdd;
            color: white;
        }
        .panelCon{padding: 20px;}
        .fr{float: right;}
        .csp{cursor: pointer;}
        .fz18{font-size: 18px;}
        .col-sm-3{margin-top: 0px;width: 26px;}
        select.form-control {padding: 0px 6px;}
        .foot{width: 100%;height: 50px;background: #F9F9F9;text-align: center}
        .foot_cz{margin: 10px 10px}
    </style>
    <script type="text/javascript">
        $(function () {
            $('.offerRe').hide();
            $('.offerRe .panelHeader .csp').click(function () {
                $('.offerRe').hide();
            });
            $('.date-picker').datepicker({autoclose: true,todayHighlight: true});
            //默让时间是今天
            var datatime=getNowFormatDate();
            $("#DataTime").val(datatime);
            //默让图形为折线图
            $("#graphics").val("line");
            getEchartsList7();
        })
        $(top.hangge());//关闭加载状态
        /**
         * 搜索按钮
         */
       function  searchs() {
           getEchartsList7();
       }
       //加载图形数据
        function  getEchartsList7(){
            var param={};
            param.id=$("#id").val();
            param.graphicsType=$("#graphics").val();
            param.DataTime=$("#DataTime").val();
            param.dataType=$("select[name=select]").val();
            $.ajax({
                url:"${path}/monitmanage/findThreePhaseCurrent.do",
                type:"post",
                dataType:"json",
                data:param,
                success: function (result){
                    if(result.length>0){
                        for(var i=0;i<result.length;i++){
                            var echartsRight = echarts.init(document.getElementById("echarts"+(i+1)+""));
                            echartsRight.clear();
                            echartsRight.setOption(result[i])
                        }
                    }
                }
            })
        }
        //切换图形形式
        function switchGraphics() {
           var graphics= $("#graphics").val();
           if(graphics=="line"){
               $("#graphics").val("bar");
           }else if(graphics=="bar"){
               $("#graphics").val("line");
           }
            getEchartsList7();
        }
        //获取当前日期
        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
            return currentdate;
        }
        /**
         *显示选择界面
         */
        function showCustomerView() {
            $('#customer_div').show();
            //$("#Form").submit();
            var newid=$("#id").val();
            $.ajax({
                url:"${path}/monitmanage/list.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var html="";
                    if(result.length>0){
                        html+="<table style='width: 100%; text-align: center;' id='loop_table'>";
                        html+="<tbody>";
                        for(var i=0;i<result.length;i++){
                            if(i%3==0){
                                html+="<tr style='text-align: left;'>";
                            }
                            if(result[i].ID==newid){
                                html+="<td style='margin-bottom: 5px;padding-left: 5px;width: 31%;height: 21px;display: inline-block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;'><label for='male"+i+"'><input custonname='"+ result[i].equipment_name +"' type='checkbox' name='equ' class='loop_view ace' data-text='G1进线' onclick='loopClick(this)' style='margin-left: 5px;float: left;-webkit-appearance: checkbox;' checked='checked' value='"+result[i].ID+"' checked id='male"+i+"'><span class='lbl'>"+result[i].equipment_name+"</span></label>";
                            }else {
                                html+="<td style='margin-bottom: 5px;padding-left: 5px;width: 31%;height: 21px;display: inline-block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;'><label for='male"+i+"'><input custonname='"+ result[i].equipment_name +"' type='checkbox' name='equ' class='loop_view ace' data-text='G1进线' onclick='loopClick(this)' style='margin-left: 5px;float: left;-webkit-appearance: checkbox;'  value='"+result[i].ID+"' id='male"+i+"'><span class='lbl'>"+result[i].equipment_name+"</span></label>";
                            }
                            html+="</td>";
                            if(i%3==2){
                                html+="</tr>";
                            }
                        }
                        html+="</tbody>";
                        html+="</table>";
                    }else {
                        html+="<p>暂无设备！！！</p>";
                    }
                    $("#panelHeader").html(html)
                }
            })

        }
        //控制复选框为单选
        function loopClick(obj) {
            var boxArray = document.getElementsByName('equ');
            for(var i=0;i<=boxArray.length-1;i++){
                if(boxArray[i]==obj && obj.checked){
                    boxArray[i].checked = true;
                }else{
                    boxArray[i].checked = false;
                }
            }
        }
        //选择设备保存
        function save() {
            for(var i = 0; i < $("input[name='equ']").length; i++){
                //console.log($("input[name='equ']")[i].checked == true)
                if($("input[name='equ']")[i].checked == true) {
                    $("#id").val($("input[name='equ']")[i].value);
                    $("#sbxz").val($("input[name='equ']")[i].attributes['custonname'].value);
                }
            }
            $('#customer_div').hide();
        }
        function cancel() {
            $('.offerRe').hide();
        }
    </script>

</head>
<body class="no-skin">
<input type="hidden" name="graphics" id="graphics">
<input type="hidden" name="id" id="id" value="${newid}">
<div>
    <div class="head">
        <div class="head_up">
            <div class="datetime">
              <label class="col-sm-3 control-label no-padding-right" style="width: 70px">日期：</label>
                <div class="col-sm-9 dtime">
                    <input class="span10 date-picker" name="DataTime" id="DataTime"  value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:150px;" placeholder="日期" title="日期">
                </div>
            </div>
        </div>
        <div class="head_dw_zq">
            <div>
                <div>
                    <label class="col-sm-2 control-label no-padding-right" style="width: 55px;">周期：</label>
                    <div class="col-sm-3">
                        <select class="sel chosen-select form-control" name="select" id="select"  data-placeholder="请选择" style="background-color: #f5f5f5">
                            <option value="1">日</option>
                            <option value="2">周</option>
                            <option value="3">月</option>
                        </select>
                    </div>
                </div>
             </div>
        </div>
        <div class="head_dw sbxz">
            <label class="control-label no-padding-right">设备选择：</label>
            <input name="sbxz" id="sbxz" style="width: 150px" value="${equipmentName}" onclick="showCustomerView()"readonly>
        </div>
        <div class="head_dw" style="margin-left: 10px;margin-top: 7px;">
            <a class="btn btn-light btn-xs" onclick="searchs();" title="搜索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a>
            <a class="btn btn-mini btn-primary" onclick="switchGraphics()" style="margin-left: 20px;height: 28px;">切换图形</a>
        </div>
    </div>
        <div style="clear: both"></div>
    <div class="cont">
        <div class="cont_up" id="echarts1"></div>
        <div class="cont_up" id="echarts2"></div>
        <div class="cont_up" id="echarts3"></div>
        <div class="cont_dw" id="echarts4"></div>
        <div class="cont_dw" id="echarts5"></div>
        <div class="cont_dw" id="echarts6"></div>
    </div>
</div>
<div class="offerRe" id="customer_div">
    <div class="alarmCon"style="background: #FFF;">
        <div class="panelHeader"style="font-size: 14px; margin-left: 0px;padding-left: 10px;">所属设备选择<span class="fr fz18 csp">x</span></div>
        <div id="panelHeader" style="width: 100%;height: 358px;overflow:auto; padding: 10px;">

        </div>
        <div class="foot">
         <a class="btn btn-mini btn-primary foot_cz"  onclick="save();">确定</a>
         <a class="btn btn-mini btn-primary foot_cz" onclick="cancel();">取消</a>
        </div>
    </div>
</div>

</body>
</html>