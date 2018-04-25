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
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<!-- 下拉框 -->
<link rel="stylesheet" href="static/ace/css/chosen.css" />
<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>
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
							
						<!-- 检索  -->
						<form action="statistics/list.do" method="post" name="Form" id="Form">
						<input type="hidden" name="keywords2"  id="keywords2" value=""/>
						<input type="hidden" name="keywords3"  id="keywords3" value=""/>
						<table style="margin-top:5px;">
							<tr>
								<td>
									<div class="nav-search">
										<span class="input-icon">
											<input type="text" placeholder="这里输入电表名称" class="nav-search-input" id="nav-search-input" autocomplete="off" name="keywords" value="${pd.keywords }" placeholder="这里输入电表名称"/>
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
									</div>
								</td>
								<td style="vertical-align:top;padding-left:2px"><a class="btn btn-light btn-xs" onclick="tosearch();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
							</tr>

						</table>
						<!-- 检索  -->
					
						<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">	
							<thead>
								<tr>
									<th class="" style="width:70px;">序号</th>
									<th class="" onclick="onclick1(1);"><a href="javascript:;">电表名称</a>
										<c:if test="${(pd.keywords3 == '' || pd.keywords3 == null) or pd.keywords2!=1}">
											<span id="meterName" style="display: none" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 1 and pd.keywords2==1}">
										<span id="meterName" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 2  and pd.keywords2==1}">
											<span id="meterName"  class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
										</c:if>
									</th>
									<th class="" onclick="onclick1(2);"><a href="javascript:;">越限告警数量</a>
										<c:if test="${(pd.keywords3 == '' || pd.keywords3 == null)or pd.keywords2!=2 }">
											<span id="limitcount" style="display: none" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 1  and pd.keywords2==2}">
											<span id="limitcount" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 2  and pd.keywords2==2}">
											<span id="limitcount"  class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
										</c:if>
									</th>
									<th class="" onclick="onclick1(3);"><a href="javascript:;">断电告警数量</a>
										<c:if test="${(pd.keywords3 == '' || pd.keywords3 == null )or pd.keywords2!=3}">
											<span id="stacount" style="display: none" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 1 and pd.keywords2==3}">
											<span id="stacount" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 2 and pd.keywords2==3}">
											<span id="stacount"  class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
										</c:if>
									</th>
									<th class="" onclick="onclick1(4);"><a href="javascript:;">合计</a>
										<c:if test="${(pd.keywords3 == '' || pd.keywords3 == null) or pd.keywords2!=4}">
											<span id="heji" style="display: none" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 1 and pd.keywords2==4}">
											<span id="heji" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
										</c:if>
										<c:if test="${pd.keywords3 == 2 and pd.keywords2==4}">
											<span id="heji"  class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
										</c:if>
									</th>
								</tr>
							</thead>
													
							<tbody>
							<!-- 开始循环 -->	
							<c:choose>
								<c:when test="${not empty varList}">
									<c:if test="${QX.cha == 1 }">
									<c:forEach items="${varList}" var="var" varStatus="vs">
										<tr>
											<td class='' style="width: 30px;">${vs.index+1}</td>
											<td class=''>${var.meter_name}</td>
											<td class=''>${var.limitcount}</td>
											<td class=''>${var.stacount}</td>
											<td class=''>${var.heji}</td>
										</tr>
									</c:forEach>
									</c:if>
									<c:if test="${QX.cha == 0 }">
										<tr>
											<td colspan="100" class="">您无权查看</td>
										</tr>
									</c:if>
								</c:when>
								<c:otherwise>
									<tr class="main_info">
										<td colspan="100" class="" >没有相关数据</td>
									</tr>
								</c:otherwise>
							</c:choose>
							</tbody>
						</table>
						<div class="page-header position-relative">
						<table style="width:100%;">
							<tr>
								<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
							</tr>
						</table>
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
		<!-- /.main-content -->

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
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
	<script type="text/javascript">
		$(top.hangge());//关闭加载状态
		//检索
		function tosearch(){
			top.jzts();
			$("#Form").submit();
		}
		$(function() {

			//日期框
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
			});
			
			//下拉框
			if(!ace.vars['touch']) {
				$('.chosen-select').chosen({allow_single_deselect:true}); 
				$(window)
				.off('resize.chosen')
				.on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				}).trigger('resize.chosen');
				$(document).on('settings.ace.chosen', function(e, event_name, event_val) {
					if(event_name != 'sidebar_collapsed') return;
					$('.chosen-select').each(function() {
						 var $this = $(this);
						 $this.next().css({'width': $this.parent().width()});
					});
				});
				$('#chosen-multiple-style .btn').on('click', function(e){
					var target = $(this).find('input[type=radio]');
					var which = parseInt(target.val());
					if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
					 else $('#form-field-select-4').removeClass('tag-input-style');
				});
			}
			
			
			//复选框全选控制
			var active_class = 'active';
			$('#simple-table > thead > tr > th input[type=checkbox]').eq(0).on('click', function(){
				var th_checked = this.checked;//checkbox inside "TH" table header
				$(this).closest('table').find('tbody > tr').each(function(){
					var row = this;
					if(th_checked) $(row).addClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', true);
					else $(row).removeClass(active_class).find('input[type=checkbox]').eq(0).prop('checked', false);
				});
			});
		});
		function onclick1(num) {
            $('#meterName').hide();
            $('#limitcount').hide();
            $('#stacount').hide();
            $('#heji').hide();
           if(num==1){
            var className=document.getElementById("meterName").className;
            if(className =="glyphicon glyphicon-chevron-up"){
                $('#meterName').removeClass('glyphicon-chevron-up');
                $('#meterName').addClass('glyphicon-chevron-down');
                $("#keywords3").val(1);
			} else {
                $('#meterName').addClass('glyphicon-chevron-up');
                $('#meterName').removeClass('glyphicon-chevron-down');

                $("#keywords3").val(2);
			}
            $("#keywords2").val(1);
            $('#meterName').show();
             }
           if(num==2){
               var className=document.getElementById("limitcount").className;
               if(className =="glyphicon glyphicon-chevron-up"){
                   $('#limitcount').removeClass('glyphicon-chevron-up');
                   $('#limitcount').addClass('glyphicon-chevron-down');
                   $("#keywords3").val(1);
               } else {
                   $('#limitcount').addClass('glyphicon-chevron-up');
                   $('#limitcount').removeClass('glyphicon-chevron-down');
                   $("#keywords3").val(2);
               }
               $("#keywords2").val(2);
               $('#limitcount').show();
		     }
            if(num==3){
                var className=document.getElementById("stacount").className;
                if(className =="glyphicon glyphicon-chevron-up"){
                    $('#stacount').removeClass('glyphicon-chevron-up');
                    $('#stacount').addClass('glyphicon-chevron-down');
                    $("#keywords3").val(1);
                } else {
                    $('#stacount').addClass('glyphicon-chevron-up');
                    $('#stacount').removeClass('glyphicon-chevron-down');
                    $("#keywords3").val(2);
                }
                $("#keywords2").val(3);
                $('#stacount').show();
              }
            if(num==4){
                var className=document.getElementById("heji").className;
                if(className =="glyphicon glyphicon-chevron-up"){
                    $('#heji').removeClass('glyphicon-chevron-up');
                    $('#heji').addClass('glyphicon-chevron-down');
                    $("#keywords3").val(1);
                } else {
                    $('#heji').addClass('glyphicon-chevron-up');
                    $('#heji').removeClass('glyphicon-chevron-down');
                    $("#keywords3").val(2);
                }
                $("#keywords2").val(4);
                $('#heji').show();
              }
            tosearch();
        }

	</script>


</body>
</html>