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

	<link rel="stylesheet" href="plugins/bootstrap-fileinput/css/fileinput.css" />
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
					
					<form action="drawing/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="DRAWING_ID" id="DRAWING_ID" value="${pd.DRAWING_ID}"/>
						<div id="file_url"></div>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">项目名称:</td>
								<td><input type="text" name="PROJECT_NAME" id="FILE_NAME" value="${pd.FILE_NAME}" maxlength="255" placeholder="这里输入项目名称" title="项目名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<%--<input id="input-b3" name="input-b3[]" type="file" class="file" multiple--%>
								<input id="input-b3" name="input-b3[]" type="file" multiple
								   data-show-upload="true" data-show-caption="true" data-msg-placeholder="选择要上传的文件...">

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
	<!-- 上传控件 -->
	<script src="plugins/bootstrap-fileinput/js/fileinput.js"></script>
<script src="plugins/bootstrap-fileinput/js/locales/zh.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#FILE_NAME").val()==""){
				$("#FILE_NAME").tips({
					side:3,
		            msg:'请输入文件名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FILE_NAME").focus();
			return false;
			}
			if($("#FORMERLY_NAME").val()==""){
				$("#FORMERLY_NAME").tips({
					side:3,
		            msg:'请输入文件上传时名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FORMERLY_NAME").focus();
			return false;
			}
			if($("#FILE_URL").val()==""){
				$("#FILE_URL").tips({
					side:3,
		            msg:'请输入文件存放路径',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#FILE_URL").focus();
			return false;
			}
			if($("#SUFFIX").val()==""){
				$("#SUFFIX").tips({
					side:3,
		            msg:'请输入文件格式',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SUFFIX").focus();
			return false;
			}
			if($("#CREATOR").val()==""){
				$("#CREATOR").tips({
					side:3,
		            msg:'请输入创建人',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATOR").focus();
			return false;
			}
			if($("#CREATE_TIME").val()==""){
				$("#CREATE_TIME").tips({
					side:3,
		            msg:'请输入创建时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CREATE_TIME").focus();
			return false;
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
            $("#input-b3").fileinput("upload");
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
            //上传
            $("#input-b3").fileinput({
				showCaption: false,
                uploadAsync: true, //默认异步上传
                uploadUrl:"drawing/fileUpload.do",
                maxFileCount:30, //表示允许同时上传的最大文件个数
                language: 'zh', //设置语言
                maxFileSize:1024*5*30,
                mainClass: "input-group-lg",
                msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
            }).on("fileuploaded", function(event, datas, previewId, index) {
                var html = "";
                $.each(datas.response, function(index, data){

                    html += '<input type="hidden" name="fileName" value="'+data.FILE_NAME+'"/>';
                    html += '<input type="hidden" name="fileUrl" value="'+data.FILE_URL+'"/>';
                    $("#file_url").append(html);
                });
            }).on("filesuccessremove", function(event, datas, previewId) {
                alert("文件已经提交");
                return false;
            });

            $(".fileinput-remove").click(function () {
                $("#file_url").html("");
            });

            $(".fileinput-remove").click(function () {
                $("#file_url").html("");
            });
		});

		</script>
</body>
</html>