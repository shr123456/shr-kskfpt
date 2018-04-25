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
					
					<form action="equsmartmeter/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">选择电房:</td>
								<td>
									<select class="chosen-select form-control" name="ELECTRICAL_ROOM_ID" id="ELECTRICAL_ROOM_ID" data-placeholder="请选择电房" style="vertical-align:top;"  title="所属电房" style="width:98%;" >
										<option value=""></option>
										<c:forEach items="${roomList}" var="room">
											<option value="${room.ROOM_ID}" <c:if test="${room.ROOM_ID == pd.ELECTRICAL_ROOM_ID}">selected</c:if>>${room.ELECTRICAL_ROOM_NAME}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电表名称:</td>
								<td><input type="text" name="METER_NAME" id="METER_NAME" value="${pd.METER_NAME}" maxlength="50" placeholder="这里输入电表名称" title="电表名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电表地址:</td>
								<td><input type="text" name="METER_ADDRESS" id="METER_ADDRESS" value="${pd.METER_ADDRESS}" maxlength="50" placeholder="这里输入电表地址" title="电表地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">网关编号:</td>
								<td><input type="text" name="GATEWAY_NO" id="GATEWAY_NO" value="${pd.GATEWAY_NO}" maxlength="50" placeholder="这里输入网关编号" title="网关编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">网关型号:</td>
								<td><input type="text" name="GATEWAY_MODEL" id="GATEWAY_MODEL" value="${pd.GATEWAY_MODEL}" maxlength="50" placeholder="这里输入网关型号" title="网关型号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">厂家网关:</td>
								<td><input type="text" name="GATEWAY_FACTORY" id="GATEWAY_FACTORY" value="${pd.GATEWAY_FACTORY}" maxlength="50" placeholder="这里输入厂家网关" title="厂家网关" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">CT变比:</td>
								<td><input type="text" name="C_T_RATIO" id="C_T_RATIO" value="${pd.C_T_RATIO}" maxlength="50" placeholder="请输入电流互感器变比" title="电流互感器变比" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">关联设备:</td>
								<td><input type="number" name="EQU_ID" id="EQU_ID" value="${pd.EQU_ID}" maxlength="32" placeholder="这里输入关联设备" title="关联设备" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">关联设备类型:</td>
								<td>
									<select class="chosen-select form-control" name="EQU_TYPE" id="EQU_TYPE" data-placeholder="请选择" style="vertical-align:top;width: 120px;">
										<option value=""></option>
										<option value="2" <c:if test="${pd.EQU_TYPE==1}">selected</c:if>>低压</option>
										<option value="1" <c:if test="${pd.EQU_TYPE==2}">selected</c:if>>高压</option>
										<option value="0" <c:if test="${pd.EQU_TYPE==0}">selected</c:if>>回路</option>
									</select>
								</td>
							</tr>

							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
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
		//保存
		function save(){
			if($("#ELECTRICAL_ROOM_ID").val()==""){
				$("#ELECTRICAL_ROOM_ID").tips({
					side:3,
					msg:'请选择电房',
					bg:'#AE81FF',
					time:2
				});
				$("#ELECTRICAL_ROOM_ID").focus();
				return false;
			}
			if($("#METER_NAME").val()==""){
				$("#METER_NAME").tips({
					side:3,
		            msg:'请输入电表名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#METER_NAME").focus();
			return false;
			}
			if($("#METER_ADDRESS").val()==""){
				$("#METER_ADDRESS").tips({
					side:3,
		            msg:'请输入电表地址',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#METER_ADDRESS").focus();
			return false;
			}
			if($("#GATEWAY_NO").val()==""){
				$("#GATEWAY_NO").tips({
					side:3,
		            msg:'请输入网关编号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GATEWAY_NO").focus();
			return false;
			}
			if($("#GATEWAY_MODEL").val()==""){
				$("#GATEWAY_MODEL").tips({
					side:3,
		            msg:'请输入网关型号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GATEWAY_MODEL").focus();
			return false;
			}
			if($("#GATEWAY_FACTORY").val()==""){
				$("#GATEWAY_FACTORY").tips({
					side:3,
		            msg:'请输入厂家网关',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#GATEWAY_FACTORY").focus();
			return false;
			}
			if($("#EQU_ID").val()==""){
				$("#EQU_ID").tips({
					side:3,
		            msg:'请输入关联设备',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EQU_ID").focus();
			return false;
			}

			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>