<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
					
					<form action="electricalroom/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ROOM_ID" id="ROOM_ID" value="${pd.ROOM_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">

							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电房编号:</td>
								<td><input type="text" name="ELECTRICAL_ROOM_CODE" id="ELECTRICAL_ROOM_CODE" value="${pd.ELECTRICAL_ROOM_CODE}" maxlength="20" placeholder="这里输入电房编号" title="电房编号" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电房名称:</td>
								<td><input type="text" name="ELECTRICAL_ROOM_NAME" id="ELECTRICAL_ROOM_NAME" value="${pd.ELECTRICAL_ROOM_NAME}" maxlength="50" placeholder="这里输入电房名称" title="电房名称" style="width:98%;"/></td>
							</tr>

							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电房温度:</td>
								<td><input type="text" name="TEMPERATURE" id="TEMPERATURE" value="${pd.TEMPERATURE}" maxlength="8" placeholder="这里输入电房温度" title="电房温度" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电房湿度:</td>
								<td><input type="text" name="DAMPNESS" id="DAMPNESS" value="${pd.DAMPNESS}" maxlength="8" placeholder="这里输入电房湿度" title="电房湿度" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">负责人:</td>
								<td><input type="text" name="CHARGER" id="CHARGER" value="${pd.CHARGER}" maxlength="20" placeholder="这里输入负责人" title="负责人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">负责人联系电话电话:</td>
								<td><input type="text" name="CHARGE_TEL" id="CHARGE_TEL" value="${pd.CHARGE_TEL}" maxlength="20" placeholder="这里输入负责人联系电话电话" title="负责人联系电话电话" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注:</td>
								<td><input type="text" name="REMARK" id="REMARK" value="${pd.REMARK}" maxlength="100" placeholder="这里输入备注" title="备注" style="width:98%;"/></td>
							</tr>
							<%--<tr>--%>
								<%--<td style="width:75px;text-align: right;padding-top: 13px;">相关照片:</td>--%>
								<%--<td><input type="text" name="PHOTO_URL" id="PHOTO_URL" value="${pd.PHOTO_URL}" maxlength="500" placeholder="这里输入相关照片" title="相关照片" style="width:98%;"/></td>--%>
							<%--</tr>--%>

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

		function decimalcheck(num)//小数正则校验
		{
			var regExp = /^[+-]?(0|([1-9]\d*))(\.\d+)?$/g;
			var t = regExp.test(num);
			return t;
		}

		function mobilecheck(num)//小数正则校验
		{
			var regExp = /^1[3|4|5|7|8][0-9]{9}$/;;
			var t = regExp.test(num);
			return t;
		}

		//保存
		function save() {

			if ($("#ELECTRICAL_ROOM_CODE").val() == "") {
				$("#ELECTRICAL_ROOM_CODE").tips({
					side: 3,
					msg: '请输入电房编号',
					bg: '#AE81FF',
					time: 2
				});
				$("#ELECTRICAL_ROOM_CODE").focus();
				return false;
			}
			if ($("#ELECTRICAL_ROOM_NAME").val() == "") {
				$("#ELECTRICAL_ROOM_NAME").tips({
					side: 3,
					msg: '请输入电房名称',
					bg: '#AE81FF',
					time: 2
				});
				$("#ELECTRICAL_ROOM_NAME").focus();
				return false;
			}

			var TEMPERATURE= $("#TEMPERATURE").val();
			if (TEMPERATURE == "") {
				$("#TEMPERATURE").tips({
					side: 3,
					msg: '请输入电房温度',
					bg: '#AE81FF',
					time: 2
				});
				$("#TEMPERATURE").focus();
				return false;
			}
			else
			{
				if(decimalcheck(TEMPERATURE)==false)
				{
					$("#TEMPERATURE").tips({
						side:3,
						msg:'电房温度只能输入整数和小数',
						bg:'#AE81FF',
						time:2
					});
					$("#TEMPERATURE").focus();
					return false;
				}
			}

			var DAMPNESS= $("#DAMPNESS").val();
			if(DAMPNESS==""){
				$("#DAMPNESS").tips({
					side:3,
					msg:'请输入电房湿度',
					bg:'#AE81FF',
					time:2
				});
				$("#DAMPNESS").focus();
			    return false;
			}
			else
			{
				if(decimalcheck(DAMPNESS)==false)
				{
					$("#DAMPNESS").tips({
						side:3,
						msg:'电房湿度只能输入整数和小数',
						bg:'#AE81FF',
						time:2
					});
					$("#DAMPNESS").focus();
					return false;
				}
			}

			if($("#CHARGER").val()==""){
				$("#CHARGER").tips({
					side:3,
		            msg:'请输入负责人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CHARGER").focus();
			    return false;
			}

			var CHARGE_TEL=$("#CHARGE_TEL").val();
			if(CHARGE_TEL==""){
				$("#CHARGE_TEL").tips({
					side:3,
		            msg:'请输入负责人联系电话电话',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CHARGE_TEL").focus();
			    return false;
			}
			else
			{
				if(mobilecheck(CHARGE_TEL)==false)
				{
					$("#CHARGE_TEL").tips({
						side:3,
						msg:'手机号码格式不正确',
						bg:'#AE81FF',
						time:2
					});
					$("#CHARGE_TEL").focus();
					return false;
				}
			}

			if($("#REMARK").val()==""){
				$("#REMARK").tips({
					side:3,
		            msg:'请输入备注',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#REMARK").focus();
			return false;
			}
			if($("#PHOTO_URL").val()==""){
				$("#PHOTO_URL").tips({
					side:3,
		            msg:'请输入相关照片',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PHOTO_URL").focus();
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