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
						<form action="limit/list.do" method="post" name="Form" id="Form">
							<table style="margin-top:5px;">
								<tr>
									<td>
										<div class="nav-search">
										<span class="input-icon">
											<input type="text" placeholder="这里输入电表名称" class="nav-search-input" id="nav-search-input" autocomplete="off" name="keywords1" value="${pd.keywords1 }" placeholder="这里输入电表名称"/>
											<input type="text" placeholder="这里输入网关编号" class="nav-search-input"  autocomplete="off" name="keywords2" value="${pd.keywords2 }" placeholder="这里输入网关编号"/>
											<input type="text" placeholder="这里输入表地址" class="nav-search-input"  autocomplete="off" name="keywords3" value="${pd.keywords3 }" placeholder="这里输入表地址"/>
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
									<%--<th class="center" style="width:35px;">--%>
										<%--<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>--%>
									<%--</th>--%>
									<th class="center" style="width:50px;">序号</th>
									<th class="center">电表名称</th>
									<th class="center">网关编号</th>
									<th class="center">表地址</th>
									<th class="center">告警内容</th>
									<th class="center">状态</th>
								</tr>
								</thead>
								<tbody>
								<!-- 开始循环 -->
								<c:choose>
									<c:when test="${not empty varList}">
										<c:if test="${QX.cha == 1 }">
											<c:forEach items="${varList}" var="var" varStatus="vs">
												<tr>
													<%--<td class='center'>--%>
														<%--<label class="pos-rel"><input type='checkbox' name='ids' value="${var.LIMIT_ID}" class="ace" /><span class="lbl"></span></label>--%>
													<%--</td>--%>
													<td class='center' style="width: 30px;">${vs.index+1}</td>
													<td class='center'>${var.meter_name}</td>
													<td class='center'>${var.gateway_no}</td>
													<td class='center'>${var.meter_address}</td>
													<td class='center'>${var.CONTENT}</td>
													<c:if test="${var.TAG==0}">
													<td class='center'><a class="btn btn-sm btn-no" onclick="editSave(1,${var.LIMIT_ID});">未确认</a></td>
													</c:if>
													<c:if test="${var.TAG==1}">
													<td class='center'><a class="btn btn-sm btn-warning" onclick="editSave(2,${var.LIMIT_ID});">未解除</a></td>
													</c:if>
													<c:if test="${var.TAG==2}">
													<td class='center'><a class="btn btn-sm btn-success">已解除</a></td>
													</c:if>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${QX.cha == 0 }">
											<tr>
												<td colspan="100" class="center">您无权查看</td>
											</tr>
										</c:if>
									</c:when>
									<c:otherwise>
										<tr class="main_info">
											<td colspan="100" class="center" >没有相关数据</td>
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
    //修改状态
    function editSave(num,id){
        var param={};
        param.num=num;
        param.LIMIT_ID=id;
        if(confirm("是否确定修改状态")) {
        $.ajax({
            url:"${path}/limit/editTag.do",
            type:"post",
            dataType:"json",
            data:param,
            success: function (result){
              if(result==1){
                  alert("修改失败！");
              }else if(result==0){
                  alert("修改成功！");
                  window.location.reload();
              }
            }
		});
		}
    }
</script>


</body>
</html>