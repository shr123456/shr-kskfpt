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
					
					<form action="equdcscreen/${msg }.do" name="Form" id="Form" method="post">
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
								<td style="width:75px;text-align: right;padding-top: 13px;">设备名称:</td>
								<td><input type="text" name="EQUIPMENT_NAME" id="EQUIPMENT_NAME" value="${pd.EQUIPMENT_NAME}" maxlength="150" placeholder="这里输入设备名称" title="设备名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">安装位置:</td>
								<td><input type="text" name="INSTALLATION_POSITION" id="INSTALLATION_POSITION" value="${pd.INSTALLATION_POSITION}" maxlength="150" placeholder="这里输入安装位置" title="安装位置" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">设备型号:</td>
								<td><input type="text" name="EQUIPMENT_VERSION" id="EQUIPMENT_VERSION" value="${pd.EQUIPMENT_VERSION}" maxlength="100" placeholder="这里输入设备型号" title="设备型号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电池容量:</td>
								<td><input type="number" name="BATTERY_CAPACITY" id="BATTERY_CAPACITY" value="${pd.BATTERY_CAPACITY}" maxlength="32" placeholder="这里输入电池容量" title="电池容量" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">输入电压:</td>
								<td><input type="number" name="INPUT_VOLTAGE" id="INPUT_VOLTAGE" value="${pd.INPUT_VOLTAGE}" maxlength="32" placeholder="这里输入输入电压" title="输入电压" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">输出电压:</td>
								<td><input type="number" name="OUTPUT_VOLTAGE" id="OUTPUT_VOLTAGE" value="${pd.OUTPUT_VOLTAGE}" maxlength="32" placeholder="这里输入输出电压" title="输出电压" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">生产日期:</td>
								<td><input class="span10 date-picker" name="MAKE_TIME" id="MAKE_TIME" value="${pd.MAKE_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="生产日期" title="生产日期" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">品牌:</td>
								<td><input type="text" name="BRAND" id="BRAND" value="${pd.BRAND}" maxlength="50" placeholder="这里输入品牌" title="品牌" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">生产厂家:</td>
								<td><input type="text" name="MANUFACTURER" id="MANUFACTURER" value="${pd.MANUFACTURER}" maxlength="50" placeholder="这里输入生产厂家" title="生产厂家" style="width:98%;"/></td>
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
			if($("#EQUIPMENT_NAME").val()==""){
				$("#EQUIPMENT_NAME").tips({
					side:3,
		            msg:'请输入设备名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EQUIPMENT_NAME").focus();
			return false;
			}
			if($("#INSTALLATION_POSITION").val()==""){
				$("#INSTALLATION_POSITION").tips({
					side:3,
		            msg:'请输入安装位置',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INSTALLATION_POSITION").focus();
			return false;
			}
			if($("#EQUIPMENT_VERSION").val()==""){
				$("#EQUIPMENT_VERSION").tips({
					side:3,
		            msg:'请输入设备型号',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#EQUIPMENT_VERSION").focus();
			return false;
			}
			if($("#BATTERY_CAPACITY").val()==""){
				$("#BATTERY_CAPACITY").tips({
					side:3,
		            msg:'请输入电池容量',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BATTERY_CAPACITY").focus();
			return false;
			}
			if($("#INPUT_VOLTAGE").val()==""){
				$("#INPUT_VOLTAGE").tips({
					side:3,
		            msg:'请输入输入电压',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#INPUT_VOLTAGE").focus();
			return false;
			}
			if($("#OUTPUT_VOLTAGE").val()==""){
				$("#OUTPUT_VOLTAGE").tips({
					side:3,
		            msg:'请输入输出电压',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#OUTPUT_VOLTAGE").focus();
			return false;
			}
			if($("#MAKE_TIME").val()==""){
				$("#MAKE_TIME").tips({
					side:3,
		            msg:'请输入生产日期',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MAKE_TIME").focus();
			return false;
			}
			if($("#BRAND").val()==""){
				$("#BRAND").tips({
					side:3,
		            msg:'请输入品牌',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BRAND").focus();
			return false;
			}
			if($("#MANUFACTURER").val()==""){
				$("#MANUFACTURER").tips({
					side:3,
		            msg:'请输入生产厂家',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MANUFACTURER").focus();
			return false;
			}
			if($("#UPDATE_TIME").val()==""){
				$("#UPDATE_TIME").tips({
					side:3,
		            msg:'请输入修改时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#UPDATE_TIME").focus();
			return false;
			}
			if($("#DELETED").val()==""){
				$("#DELETED").tips({
					side:3,
		            msg:'请输入业务删除',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DELETED").focus();
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