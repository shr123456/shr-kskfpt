<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
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
    <script type="text/javascript">
        $(top.hangge());//关闭加载状态
        function  getEchartsList(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList2(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts2.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList3(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts3.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList4(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts4.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList5(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts5.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList6(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts6.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
        function  getEchartsList7(){
            $.ajax({
                url:"/dkt-blyz/echarts/getLineEcharts7.do",
                type:"post",
                dataType:"json",
                success: function (result){
                    var echartsRight = echarts.init(document.getElementById('echarts'));
                    echartsRight.clear();
                    echartsRight.setOption(result)
                }
            })
        }
    </script>
</head>
<body class="no-skin">
<div><button type="submit" onclick="getEchartsList()">获取折线、柱状图</button></div><%--单折线、柱状图--%>
<div><button type="submit" onclick="getEchartsList2()">获取折线、柱状图</button></div><%--多折线、柱状图--%>
<div><button type="submit" onclick="getEchartsList3()">获取雷达图</button></div><%--雷达图--%>
<div><button type="submit" onclick="getEchartsList4()">获取环形图</button></div><%--环形图--%>
<div><button type="submit" onclick="getEchartsList5()">获取饼状图</button></div><%--饼状图--%>
<div><button type="submit" onclick="getEchartsList6()">获取蛋糕饼状图</button></div><%--蛋糕饼状图--%>
<div><button type="submit" onclick="getEchartsList7()">获取折线饼状切换图</button></div><%--折线饼状切换图--%>
<div id="echarts" style="width: 600px; height: 400px">
</div>

</body>
</html>