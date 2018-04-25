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
	<!-- 页面样式 -->
	<link rel="stylesheet" href="static/ace/css/monitor.css" />

	<!-- 页面底部js¨ -->
	<%@ include file="../system/index/foot.jsp"%>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>

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

						<!-- 检索  -->
						<form action="equmetermonitoring/list.do" method="post" name="Form" id="Form">
							<table style="margin-top:5px;">
								<tr>
									<td>
										<div class="nav-search">
										<span class="input-icon">
											<input type="text" placeholder="这里输入设备名称" class="nav-search-input" id="keywords" autocomplete="off" name="keywords" value="${pd.keywords }" placeholder="这里输入设备名称"/>
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
										</div>
									</td>
									<TD></TD>
									<td>
										<div class="nav-search">
										<span class="input-icon">
											<input type="text" placeholder="这里输入电表网关" class="nav-search-input" id="keyno" autocomplete="off" name="keyno" value="${pd.keyno }" placeholder="这里输入电表网关"/>
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
										</div>
									</td>
                                    <td></td>
									<td style="vertical-align:top;padding-left:2px;">
										<select class="chosen-select form-control" name="ELECTRICAL_ROOM_ID" id="ELECTRICAL_ROOM_ID" data-placeholder="请选择电房" style="vertical-align:top;"  title="所属电房" style="width:98%;" >
											<option value=""></option>
											<c:forEach items="${roomList}" var="room">
												<option value="${room.ROOM_ID}" <c:if test="${room.ROOM_ID == pd.ROOM_ID}">selected</c:if>>${room.ELECTRICAL_ROOM_NAME}</option>
											</c:forEach>
										</select>
									</td>

									<c:if test="${QX.cha == 1 }">
										<td style="vertical-align:top;padding-left:2px"><a class="btn btn-light btn-xs" onclick="tosearch();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
									</c:if>
								</tr>
							</table>
							<!-- 检索  -->

							<div class="presentation">

								<div class="prs_rig">
									<div class="prs_comt">

										${ContentHtml}

									</div>
								</div>
							</div>


						</form>

					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
</div>
<!-- /.main-container -->
<!-- basic scripts -->

	<script type="text/javascript">
		$(top.hangge());//关闭加载状态

		$('.date-picker').datepicker({autoclose: true,todayHighlight: true})
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

		var datatime=getNowFormatDate();
		$("#DataTime").val(datatime);

		function tosearch(){
			top.jzts();
			$("#Form").submit();
		}

		//显示明细
		function show(ID,name){
			top.jzts();
			var url= '<%=basePath%>equmetermonitoring/goShow.do?ID='+ID+'&name='+encodeURI(name);
			//alert(url);
			var diag = new top.Dialog();
			diag.Drag=true;
			diag.Title ="查看设备信息";
			diag.URL = url;
			diag.Width = 500;
			diag.Height = 550;
			diag.Modal = true;				//有无遮罩窗口
			diag. ShowMaxButton = true;	//最大化按钮
			diag.ShowMinButton = true;		//最小化按钮
			diag.CancelEvent = function(){ //关闭事件
				if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					tosearch();
				}
				diag.close();
			};
			diag.show();
		}

	</script>

</body>
</html>