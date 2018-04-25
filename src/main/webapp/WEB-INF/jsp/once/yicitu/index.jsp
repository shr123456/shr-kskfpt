<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("path", path);
%>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<title>鱼珠配电一次图低压</title>
	<link rel="stylesheet" href="../static/once/yicitu/css/main.css">
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
	<style>
		body,html {
			background-color: #000;
			color: #fff;
		}
		.yct_yzdy .cri_main {
			height: unset;
		}
		.yct_yzdy .cri_main table:before {
			content: "";
			pointer-events: none;
			box-sizing: border-box;
			position: absolute;
			width: 100%;
			height: 100%;
			left: 0;
			top: 0;
			border: 1px solid #fff;
			border-right: none;
			border-bottom: none;
			z-index: 2;
		}
		.yct_yzdy .cri_main table td:before {
			content: "";
			pointer-events: none;
			box-sizing: border-box;
			position: absolute;
			width: 100%;
			height: 100%;
			left: 0;
			top: 0;
			border-right: 1px solid #fff;
			border-bottom: 1px solid #fff;
			z-index: 2;
		}
	</style>
</head>
<body>
	<div class="yct_yzdy">
		<div class="cri_main">
<!--			<img class="img_tp" src="images/yzdyyct_bg.png">-->
			<div class="img_tp bg"></div>
			<div class="img_tp p01 open"></div>
			<div class="img_tp p02 open"></div>
			<div class="img_tp p03 open"></div>
			<div class="img_tp p04 open"></div>
			<div class="img_tp p05 open"></div>
			<div class="img_pad" style="padding-top:80px;">
			<table cellspacing="0" cellpadding="0" border="0">
				<tr class="img_x">
					<td colspan="2"></td>
<!--					<td>123</td>-->
					<td colspan="2"></td>
<!--					<td></td>-->
					<td></td>
					<td></td>
					<td colspan="6"></td>
<!--
					<td></td>
					<td></td>
					<td></td>
					<td></td>
-->
				</tr>
				<tr>
					<td class="w14" colspan="2">低压开关柜编号及名称</td>
<!--					<td>123</td>-->
					<td class="w21" colspan="2">2P01 进线柜</td>
<!--					<td>123</td>-->
					<td class="w10">2P02 电容补偿柜</td>
					<td class="w10">2P03 电容补偿柜</td>
					<td colspan="6">2P04 出线柜</td>
<!--
					<td>123</td>
					<td>123</td>
					<td>123</td>
					<td>123</td>
-->
				</tr>
				<tr>
					<td colspan="2">回路名称</td>
<!--					<td>123</td>-->
					<td>1#与2#专变联络</td>
					<td>1#专变低压电源进线</td>
					<td></td>
					<td></td>
					<td class="w9">A2办公23~33层办公区正常用电</td>
					<td class="w9">A2办公23~33层办公区正常用电</td>
					<td class="w9">预留A2办公23~33层办公区照明发展用电</td>
					<td class="w9">A2办公1~2层商业区正常用电</td>
					<td class="w9">备用</td>
				</tr>
				<tr>
					<td colspan="2">电流互感器</td>
<!--					<td>123</td>-->
					<td>&Phi;100II 3000/5</td>
					<td>&Phi;100II 3000/5</td>
					<td>&Phi;40I 500/5</td>
					<td>&Phi;40I 500/5</td>
					<td>&Phi;100II 3500/5</td>
					<td>&Phi;30I 250/5</td>
					<td>&Phi;30I 200/5</td>
					<td>&Phi;30I 40/5</td>
					<td>&Phi;30I 40/5</td>
				</tr>
				<!-------------------------------------------------------------------------------------->
				<tr>
					<td rowspan="11" class="min" width="3%">
						主<br><br><br>要<br><br><br>参<br><br><br>数<br>
					</td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
				<tr>
<!--					<td class="min" width="3%"></td>-->
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="11%"></td>
					<td width="10%"></td>
					<td width="10%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
					<td width="9%"></td>
				</tr>
			</table>
			</div>
		</div>
	</div>
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>

	<script src="static/once/yicitu/js/main.js"></script>
	<script type="text/javascript">
        $(top.hangge());
	</script>
</body>
</html>