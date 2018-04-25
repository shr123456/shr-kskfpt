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
						<div id="zhongxin" style="padding-top: 13px;">
						<!-- 检索  -->
						<form action="drawing/listFile.do" method="post" name="FormFile" id="FormFile">
							<input type="hidden" name="DRAWING_ID" value="${drawingId}">
							<table style="margin-top:5px;">
								<tr>
									<td>
										<div class="nav-search">
										<span class="input-icon">
											<input type="text" placeholder="这里输入关键词" class="nav-search-input" id="nav-search-input" autocomplete="on" name="keywords" value="${pd.keywords }" placeholder="这里输入关键词"/>
											<i class="ace-icon fa fa-search nav-search-icon"></i>
										</span>
										</div>
									</td>
									<%--<td style="padding-left:2px;"><input class="span10 date-picker" name="lastStart" id="lastStart"  value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="开始日期" title="开始日期"/></td>--%>
									<%--<td style="padding-left:2px;"><input class="span10 date-picker" name="lastEnd" name="lastEnd"  value="" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" style="width:88px;" placeholder="结束日期" title="结束日期"/></td>--%>
									<%--<td style="vertical-align:top;padding-left:2px;">--%>
									<%--<select class="chosen-select form-control" name="name" id="id" data-placeholder="请选择" style="vertical-align:top;width: 120px;">--%>
									<%--<option value=""></option>--%>
									<%--<option value="">全部</option>--%>
									<%--<option value="">1</option>--%>
									<%--<option value="">2</option>--%>
									<%--</select>--%>
									<%--</td>--%>
									<td style="vertical-align:top;padding-left:2px"><a class="btn btn-light btn-xs" onclick="toFileSearch();"  title="检索"><i id="nav-search-icon" class="ace-icon fa fa-search bigger-110 nav-search-icon blue"></i></a></td>
									<td>
										<input id="input-b3" name="input-b3[]" type="file" multiple
											   data-show-upload="true" data-show-caption="true" data-msg-placeholder="选择要上传的文件...">
									</td>
									<%--<c:if test="${QX.toExcel == 1 }"><td style="vertical-align:top;padding-left:2px;"><a class="btn btn-light btn-xs" onclick="toExcel();" title="导出到EXCEL"><i id="nav-search-icon" class="ace-icon fa fa-download bigger-110 nav-search-icon blue"></i></a></td></c:if>--%>
								</tr>
							</table>
							<!-- 检索  -->

							<table id="simple-table" class="table table-striped table-bordered table-hover" style="margin-top:5px;">
								<thead>
								<tr>
									<th class="center" style="width:35px;">
										<label class="pos-rel"><input type="checkbox" class="ace" id="zcheckbox" /><span class="lbl"></span></label>
									</th>
									<th class="center" style="width:50px;">序号</th>
									<th class="center">文件名称</th>
									<th class="center">操作</th>
								</tr>
								</thead>

								<tbody>
								<!-- 开始循环 -->
								<c:choose>
									<c:when test="${not empty varList}">
										<c:if test="${QX.cha == 1 }">
											<c:forEach items="${varList}" var="var" varStatus="vs">
												<tr>
													<td class='center'>
														<label class="pos-rel"><input type='checkbox' name='ids' value="${var.file_id}" class="ace" /><span class="lbl"></span></label>
													</td>
													<td class='center' style="width: 30px;">${vs.index+1}</td>
													<td class='center'>${var.file_name}</td>
													<td class="center">
														<a class="btn btn-light btn-xs" href="drawing/downloadFile.do?url=${var.file_url}" title="下载文件" target="_blank">
															<i class="ace-icon fa fa-download bigger-110 nav-search-icon blue"></i>
														</a>
														<a class="btn btn-xs btn-danger" onclick="del('${var.file_id}');">
															<i class="ace-icon fa fa-trash-o bigger-120" title="删除"></i>
														</a>
													</td>
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
									<%--<tr>--%>
										<%--<td style="vertical-align:top;">--%>
											<%--<c:if test="${QX.add == 1 }">--%>
												<%--<a class="btn btn-mini btn-success" onclick="add();">新增</a>--%>
											<%--</c:if>--%>
											<%--<c:if test="${QX.del == 1 }">--%>
												<%--<a class="btn btn-mini btn-danger" onclick="makeAll('确定要删除选中的数据吗?');" title="批量删除" ><i class='ace-icon fa fa-trash-o bigger-120'></i></a>--%>
											<%--</c:if>--%>
										<%--</td>--%>
										<td style="vertical-align:top;"><div class="pagination" style="float: right;padding-top: 0px;margin-top: 0px;">${page.pageStr}</div></td>
									<%--</tr>--%>
								</table>
							</div>
						</form>
						</div>

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

<!-- 删除时确认窗口 -->
<script src="static/ace/js/bootbox.js"></script>
<script type="text/javascript">
    $(top.hangge());
    //检索
    function toFileSearch(){
        top.jzts();
        $("#FormFile").submit();
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

    //删除
    function del(Id){
        bootbox.confirm("确定要删除吗?", function(result) {
            if(result) {
                top.jzts();
                var url = "<%=basePath%>drawing/deleteFile.do?fileId="+Id+"&tm="+new Date().getTime();
                $.get(url,function(data){
                    toFileSearch();
                });
            }
        });
    }

    //删除
    function downloadFile(url){
        var url = "<%=basePath%>drawing/downloadFile.do?url="+url+"&tm="+new Date().getTime();
        $.get(url,function(data){
            toFileSearch();
        });
    }

</script>
</body>
</html>