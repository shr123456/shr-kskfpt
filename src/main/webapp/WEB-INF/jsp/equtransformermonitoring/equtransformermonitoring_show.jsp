<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	request.setAttribute("path", path);
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
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

					<form action="equtransformer/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电房名称:</td>
								<td><input type="text" name="ELECTRICAL_ROOM_NAME" id="ELECTRICAL_ROOM_NAME" value="${pd.ELECTRICAL_ROOM_NAME}" readonly="readonly" maxlength="150" placeholder="这里输入设备名称" title="设备名称" style="width:98%;" readonly="readonly"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">设备名称:</td>
								<td><input type="text" name="EQUIPMENT_NAME" id="EQUIPMENT_NAME" value="${pd.EQUIPMENT_NAME}" maxlength="150" placeholder="这里输入设备名称" title="设备名称" readonly="readonly" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">设备编号:</td>
								<td><input type="text" name="EQUIPMENT_CODE" id="EQUIPMENT_CODE" value="${pd.EQUIPMENT_CODE}" maxlength="50" placeholder="这里输入设备编号" title="设备编号" readonly="readonly" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">安装位置:</td>
								<td><input type="text" name="INSTALLATION_POSITION" id="INSTALLATION_POSITION" value="${pd.INSTALLATION_POSITION}" maxlength="150" placeholder="这里输入安装位置" readonly="readonly" title="安装位置" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">设备型号:</td>
								<td><input type="text" name="EQUIPMENT_VERSION" id="EQUIPMENT_VERSION" value="${pd.EQUIPMENT_VERSION}" maxlength="100" placeholder="这里输入设备型号" title="设备型号" readonly="readonly" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">高压额定电流:</td>
								<td><input type="number" name="HIGH_RATED_CURRENT" id="HIGH_RATED_CURRENT" value="${pd.HIGH_RATED_CURRENT}" maxlength="32" placeholder="这里输入高压额定电流" readonly="readonly" title="高压额定电流" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">低压额定电流:</td>
								<td><input type="number" name="LOW_RATED_CURRENT" id="LOW_RATED_CURRENT" value="${pd.LOW_RATED_CURRENT}" maxlength="32" placeholder="这里输入低压额定电流" readonly="readonly" title="低压额定电流" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">高压额定电压:</td>
								<td><input type="number" name="HIGH_RATED_VOLTAGE" id="HIGH_RATED_VOLTAGE" value="${pd.HIGH_RATED_VOLTAGE}" maxlength="32" placeholder="这里输入高压额定电压" readonly="readonly" title="高压额定电压" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">低压额定电压:</td>
								<td><input type="number" name="LOW_RATED_VOLTAGE" id="LOW_RATED_VOLTAGE" value="${pd.LOW_RATED_VOLTAGE}" maxlength="32" placeholder="这里输入低压额定电压" readonly="readonly" title="低压额定电压" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">生产日期:</td>
								<td><input class="span10 date-picker" name="MAKE_TIME" id="MAKE_TIME" value="${pd.MAKE_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="生产日期" title="生产日期" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">品牌:</td>
								<td><input type="text" name="BRAND" id="BRAND" value="${pd.BRAND}" maxlength="50" placeholder="这里输入品牌" readonly="readonly" title="品牌" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">生产厂家:</td>
								<td><input type="text" name="MANUFACTURER" id="MANUFACTURER" value="${pd.MANUFACTURER}" maxlength="50" placeholder="这里输入生产厂家" title="生产厂家" readonly="readonly" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">容量:</td>
								<td><input type="text" name="CAPACITY" id="CAPACITY" value="${pd.CAPACITY}" maxlength="20" placeholder="这里输入容量" readonly="readonly" title="容量" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">${EQU_TITLE}:</td>
								<td>${EQU_NAME}</td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>