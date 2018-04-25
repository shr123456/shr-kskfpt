﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
<!-- 百度echarts -->
<script src="plugins/echarts/echarts.min.js"></script>
<script type="text/javascript">
setTimeout("top.hangge()",500);
</script>

	<style>
		.cri_yct_tab {
			padding: 2px 6px;
			margin: 0 2px;
			background-color: #eef0ee;
			cursor: pointer;
		}
		.cri_yct_tab.on {
			color: #fff;
			background-color: #438EB9;
		}
		.cri_yct_tab_hr{
			width: 100%;
			height: 1px;
			background-color: #4F99C6;
			display: block;
		}
	</style>

</head>
<body class="no-skin" style="background-color: #fff;">


		<label class="cri_yct_tab"  onclick="selectTab('once/gy', this)">高压房</label>
		<label class="cri_yct_tab on" onclick="selectTab('once/dy', this)">低压房</label>
		<label class="cri_yct_tab" onclick="selectTab('once/dy', this)">分低压房</label>
		<%--<div class="cri_yct_tab_hr"></div>--%>

		<iframe id="onceFrame" name="onceFrame" style="width: 100%;border: none;" src="once/dy">

		</iframe>
		<%--<!-- /section:basics/navbar.layout -->--%>
		<%--<div class="main-container" id="main-container">--%>
		<%--<!-- /section:basics/sidebar -->--%>
		<%--<div class="main-content">--%>
			<%--<div class="main-content-inner">--%>
				<%--<div class="page-content">--%>
					<%--<div class="hr hr-18 dotted hr-double"></div>--%>
					<%--<div class="row">--%>
						<%--<div class="col-xs-12">--%>

							<%--<div class="alert alert-block alert-success">--%>
								<%--<button type="button" class="close" data-dismiss="alert">--%>
									<%--<i class="ace-icon fa fa-times"></i>--%>
								<%--</button>--%>
								<%--<i class="ace-icon fa fa-check green"></i>--%>
								<%--欢迎使用[电可托快速开发]系统&nbsp;&nbsp;--%>
							<%--</div>--%>
							<%----%>
							<%----%>
							<%--<div id="main" style="width: 600px;height:300px;"></div>--%>
							<%--<script type="text/javascript">--%>
						        <%--// 基于准备好的dom，初始化echarts实例--%>
						        <%--var myChart = echarts.init(document.getElementById('main'));--%>
						<%----%>
						        <%--// 指定图表的配置项和数据--%>
								<%--var option = {--%>
						            <%--title: {--%>
						                <%--text: '电可托快速开发用户统计'--%>
						            <%--},--%>
						            <%--tooltip: {},--%>
						            <%--xAxis: {--%>
						                <%--data: ["系统用户","系统会员"]--%>
						            <%--},--%>
						            <%--yAxis: {},--%>
						            <%--series: [--%>
						               <%--{--%>
						                <%--name: '',--%>
						                <%--type: 'bar',--%>
						                <%--data: [${pd.userCount},${pd.appUserCount}],--%>
						                <%--itemStyle: {--%>
						                    <%--normal: {--%>
						                        <%--color: function(params) {--%>
						                            <%--// build a color map as your need.--%>
						                            <%--var colorList = ['#6FB3E0','#87B87F'];--%>
						                            <%--return colorList[params.dataIndex];--%>
						                        <%--}--%>
						                    <%--}--%>
						                <%--}--%>
						               <%--}--%>
						            <%--]--%>
						        <%--};	        --%>

						        <%--// 使用刚指定的配置项和数据显示图表。--%>
						        <%--myChart.setOption(option);--%>
						    <%--</script>--%>
							<%----%>
						<%--</div>--%>
						<%--<!-- /.col -->--%>
					<%--</div>--%>
					<%--<!-- /.row -->--%>
				<%--</div>--%>
				<%--<!-- /.page-content -->--%>
			<%--</div>--%>
		<%--</div>--%>
		<%--<!-- /.main-content -->--%>


		<%--<!-- 返回顶部 -->--%>
		<%--<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">--%>
			<%--<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>--%>
		<%--</a>--%>

	<%--</div>--%>
	<%--<!-- /.main-container -->--%>

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		$(top.hangge());
        cmainFrameT();
        function cmainFrameT(){
            var bheightT = document.documentElement.clientHeight;
            var height = (bheightT  - 50) + 'px';
			$("#onceFrame").css("height", height);
        }
        $(function() {

        });
        function selectTab(_src, _this){
            $(".cri_yct_tab").removeClass("on");
            $(_this).addClass("on")
            $("#onceFrame").attr("src", _src);
        }

	</script>
<script type="text/javascript" src="static/ace/js/jquery.js"></script>
</body>
</html>