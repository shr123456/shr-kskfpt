<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    request.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">

    <script type="text/javascript" src="static/weixin/jquery.min.js"></script>

    <style>
        body{ margin:0; padding:0;}
        body,html{ width:100%; min-width:1138px;}
        ul,li,p,form,h1,h2,h3,h4,h5,dl,dt,dd{ margin:0; padding:0; list-style:none}
        i{ font-style:normal}
        img { border:0;}
        .clr { clear:both;}
        .dis { display:none;}
        .wx-main {width:950px; height:580px; margin:20px auto; background-color:#fff;float:left;margin-left: 30px;}
        .wx-left { width:317px; height:580px; position:relative; display:inline-block; float:left; border:1px solid #cdcdcd; }
        .l-top {width:317px; text-align:center;}
        .l-fot {width:100%; height:50px; position: absolute; bottom:0px; border-top:1px solid #cdcdcd; background-color:#f5f5f9;}
        .l-fot ul { display:inline-block; width:270px; height:50px;}
        .ulli { display:inline-block; width:33%; height:50px; line-height:50px; text-align:center; float:left; box-sizing:border-box; border-left:1px solid #cdcdcd;}
        .ulli:last-of-type {width:34%;}
        .lastulli{ display:inline-block; height:50px; line-height:50px; text-align:center; float:left; box-sizing:border-box; border-left:1px solid #cdcdcd;}
        .l-fot ul li:hover { background-color:#fff; cursor:pointer; border:1px solid #44b548;}
        .l-fot-first {background-color:f5f5f9; display:inline-block; width:47px; height:50px; float:left; vertical-align:middle; text-align:center;}
        .l-fot-first img { margin:10px;}
        .add-lw {width:88px; height: auto; bottom:65px; left:47px; }
        .add-l {cursor:pointer; width:89px; height:45px; line-height:45px; border:1px solid #cdcdcd; position:absolute; bottom:65px; left:47px; font-size:30px; text-align:center; font-weight:bold; color:#cdcdcd; background-color:#f5f5f9;}
        .add-l img { position:absolute; left:20px; bottom:-10px;}
        .add-m {cursor:pointer; width:89px; height:45px; line-height:45px; border:1px solid #cdcdcd; position:absolute; bottom:65px; left:135px; font-size:30px; text-align:center; font-weight:bold; color:#cdcdcd; background-color:#f5f5f9;}
        add-mw {width:88px; height: auto; bottom:65px; left:135px; }
        .add-m img { position:absolute; left:20px; bottom:-10px;}
        .add-r {cursor:pointer; width:89px; height:45px; line-height:45px; border:1px solid #cdcdcd; position:absolute; bottom:65px; left:224px; font-size:30px; text-align:center; font-weight:bold; color:#cdcdcd; background-color:#f5f5f9;}
        add-rw {width:88px; height: auto; bottom:65px; left:224px; }
        .add-r img { position:absolute; left:20px; bottom:-10px;}
        .wx-right { width:620px; height:580px; display:inline-block; float:right; background-color:#f5f5f9;}
        .r-top {width:90%; margin:10px auto;}
        .r-top p { width:100%; height:40px; border-bottom:1px solid #cdcdcd;}
        .r-topl {display:inline-block; width:100px; height:40px; line-height:40px; float:left;}
        .r-topr {display:inline-block; width:70px; height:40px; line-height:40px; float:right; color:#01aff0; text-align:right; cursor:pointer;}
        .r-name { width:90%; margin:20px auto; height:30px;padding-bottom: 236px;}
        .r-name form label { display:inline-block; width:85px; height:30px; line-height:30px;}
        .r-name form input { width:300px; height:30px; border:1px solid #cdcdcd;}
        .twome { display:inline-block; width:85px; height:30px; line-height:30px;}
        .twotitle { width:300px; height:30px; border:1px solid #cdcdcd;}
        .r-name p {color:#7c7d82; font-size:12px; margin-left:95px; margin-top:5px;}
        .twomep {color:#7c7d82; font-size:12px; margin-left:95px; margin-top:5px;}
        .r-cont {width:90%; margin:15px 50px 50px 50px; height:auto;}
        .r-cont p { display:inline-block; width:85px; height:30px; line-height:30px; }
        .r-cont .messe { width:100%; height:auto; margin:20px auto;}
        .messe p { display:inline-block; width:85px; height:30px; line-height:30px; float:left;}
        .messe textarea { width:300px; height:100px; margin-top:8px; margin-left:10px;}
        .r-bottom {width:90%; margin:200px auto;}
        .r-bottom p { width:100%; height:40px; border-bottom:1px solid #cdcdcd;}
        .add-menu{cursor: pointer;width: 89px;height: 45px;line-height: 45px;border-left: 1px solid #cdcdcd;position: absolute;font-size: 16px;text-align: center;font-weight: bold;color: #cdcdcd;}
    </style>
    <!--提示框-->
    <script type="text/javascript" src="static/js/jquery.tips.js"></script>
    <script type="text/javascript">
        $(function(){
            //控制一级菜单加号宽度
            var length=${varList.size()};
            //判断一级菜单个数而控制菜单展示内容宽度
            if(length==0){
                $(".lastulli").css({"width":"100%"});
            }
            if(length==1){
                $(".lastulli").css({"width":"66%"});

            }
            if(length==2){
                $(".lastulli").css({"width":"33%"});
            }
            //点击一级菜单展示右边内容
            $(".one-b").click(function(){
                $("#titlexx").show();
                $("#otherxx").hide();
                $("#mtitle").html('一级菜单');
            });
            //控制二级菜单右边单选框
            $("#mes-f").click(function(){
                $("#mes-fx").removeClass("dis");
                $("#mes-lx").addClass("dis");
                $("#TYPE2").val("click");
                $("#content2").val("");
            });
            $("#mes-l").click(function(){
                $("#mes-lx").removeClass("dis");
                $("#mes-fx").addClass("dis");
                $("#TYPE2").val("view");
                $("#content1").val("");
            });

        });
        //点击一级菜单展示菜单内容
        function showOneMenu(title,id,rownumber,clicknum) {
            $("#TITLE").val(title);
            $("#ROWNUMBER").val(rownumber);
            $("#MYMENU_ID").val(id);
            $("#PARENT_ID").val(id);
            $("#titlexx").show();
            $("#otherxx").hide();
            $("#mtitle").html('一级菜单');
            if(clicknum==0){
                $(".add-lw").removeClass("dis");
                $(".add-l").removeClass("dis");
                $("#table-l").removeClass("dis");
                $(".add-mw, .add-rw").addClass("dis");

            }else if(clicknum==1){
                $(".add-mw").removeClass("dis");
                $(".add-m").removeClass("dis");
                $("#table-m").removeClass("dis");
                $(".add-lw, .add-rw").addClass("dis");
            }else if(clicknum==2){
                $(".add-rw").removeClass("dis");
                $(".add-r").removeClass("dis");
                $("#table-r").removeClass("dis");
                $(".add-mw, .add-lw").addClass("dis");
            }else{
                $(".add-l, .add-lw").addClass("dis");
                $(".add-m, .add-mw").addClass("dis");
                $(".add-r, .add-rw").addClass("dis");
            }
        }
        //保存一级菜单内容
        function saveOneMenu() {
            var TITLE= $("#TITLE").val();
            var ROWNUMBER=$("#ROWNUMBER").val();
            if(TITLE==""){
                alert("请填写菜单名称！");
                return
            }
            if(ROWNUMBER==""){
                alert("请填写排序号！");
                return
            }
            $.ajax({
                url:"${path}/mymenu/SetOnemenu.do",
                type:"post",
                dataType:"json",
                data:$("#onemenu").serialize(),
                success: function (result){
                    window.location.reload();
                }
            })
        }
        //删除菜单内容
        function deleteM() {
            if (!confirm("确定要删除吗?")) return;
            var title= $("#mtitle").text();
            if(title=="一级菜单"){
                $.ajax({
                    url:"${path}/mymenu/delete.do",
                    type:"post",
                    dataType:"json",
                    data:$("#onemenu").serialize(),
                    success: function (result){
                        window.location.reload();
                    }
                })
            }else if(title=="二级菜单"){
                $.ajax({
                    url:"${path}/mymenu/delete.do",
                    type:"post",
                    dataType:"json",
                    data:$("#twomenu").serialize(),
                    success: function (result){
                        window.location.reload();
                    }
                })
            }else {
                alert("请先选择菜单！");
            }

        }
        //点击一级菜单加号显示菜单内容
        function showTwoMenu(menuId) {
            $("#MYMENU_ID2").val("");
            $("#TITLE2").val("");
            $("#ROWNUMBER2").val("");
            $("#titlexx").hide();
            $("#mtitle").html('二级菜单');
            $("#PARENT_ID2").val(menuId);
            $("#mes-f").click();
            $("#mes-fx").removeClass("dis");
            $("#mes-lx").addClass("dis");
            $("#content1").val("");
            $("#otherxx").show();
        }
        //点击子菜单显示菜单内容
        function showTwoMenu2(MYMENUID,KEYID,PARENTID,TITLE,ROWNUMBER,TYPE,CONTENT) {
            $("#TITLE2").val(TITLE);
            $("#ROWNUMBER2").val(ROWNUMBER);
            $("#MYMENU_ID2").val(MYMENUID);
            $("#PARENT_ID2").val(PARENTID);
            $("#KEY_ID").val(KEYID);
            $("#TYPE2").val(TYPE);
            $("#mes-f").attr("checked",false);
            $("#mes-l").attr("checked",false);
            if(TYPE=="click"){
                $("#mes-f").click();
                $("#mes-fx").removeClass("dis");
                $("#mes-lx").addClass("dis");
                $("#content1").val(CONTENT);
                $("#content2").val("");
            }
            if(TYPE=="view"){
                $("#mes-l").click();
                $("#mes-lx").removeClass("dis");
                $("#mes-fx").addClass("dis");
                $("#content2").val(CONTENT);
                $("#content1").val("");
            }
            $("#titlexx").hide();
            $("#mtitle").html('二级菜单');
            $("#otherxx").show();
        }
       // 保存二级菜单内容
        function saveTwoMenu() {
            var TITLE= $("#TITLE2").val();
            var ROWNUMBER=$("#ROWNUMBER2").val();
            var content1= $("#content1").val();
            var content2=$("#content2").val();
            if(TITLE==""){
                alert("请填写菜单名称！");
                return
            }
            if(ROWNUMBER==""){
                alert("请填写排序号！");
                return
            }
            if(content1=="" && content2==""){
                alert("请填写菜单内容！");
                return
            }
            if(content2!=""){
                var cont = content2.indexOf("http://");
                if(cont == 0){

                }else if(cont == -1){
                    alert("链接请以http://开头！！！");
                  return
                }
            }
            if(content1!=""){
                $("#CONTENT").val(content1);
            }
            if(content2!=""){
                $("#CONTENT").val(content2);
            }
            $.ajax({
                url:"${path}/mymenu/saveTwoMenu.do",
                type:"post",
                dataType:"json",
                data:$("#twomenu").serialize(),
                success: function (result){
                    window.location.reload();
                }
            })
        }
        //生成菜单
        function createM(keyId) {
            var param={};
            param.KEY_ID=keyId;
            $.ajax({
                url:"${path}/mymenu/createmenu.do",
                type:"post",
                dataType:"json",
                data:param,
                success: function (result){
                   if(result==0){
                       alert("生成成功！");
                   }else if(result==1){
                       alert("获取token失败，请联系管理员！");
                   }else if(result==3){
                       alert("菜单内容有误，请联系管理员！");
                   }
                }
            })
            
        }
    </script>

</head>
<body>
<input type="hidden" name="oneme" id="oneme">
<table>
    <tr>
        <td>
            <div class="wx-main">
                <!--左部分-->
                <div class="wx-left">
                    <div class="l-top">
                        <img src="static/weixin/wx-top.jpg" alt=""/>
                    </div>
                    <div class="l-mid">

                    </div>
                    <div class="l-fot">
                        <div class="l-fot-first">
                            <img src="static/weixin/keyboard.png" width="60%" alt="" id="tsMsg"/>
                        </div>
                        <ul class="add-menu">
                            <c:forEach items="${varList}" var="var" varStatus="vs" begin="0" end="2">
                                <li  class="one-a ulli" onclick="showOneMenu('${var.TITLE}',${var.MYMENU_ID},${var.ROWNUMBER},${vs.index})">${var.TITLE}</li>
                            </c:forEach>
                            <c:if test="${varList.size()<3}">
                                <li class="one-b lastulli"  onclick="showOneMenu()"> +</li>
                            </c:if>
                        </ul>
                    </div>
                    <c:forEach items="${varList}" var="var" varStatus="vs" begin="0" end="2">
                        <c:if test="${vs.index==0}">
                            <div class="add-lw">
                                <div id="add-l-but" class="add-l dis" onclick="showTwoMenu(${var.MYMENU_ID})">+
                                    <img src="static/weixin/wx-arrow.png" alt="">
                                </div>
                                <div class="dis" style="width:89px; line-height:45px; border:1px solid #cdcdcd;border-top:0px; position:absolute; bottom:110px; left:47px; font-size:16px; text-align:center; font-weight:bold; color:#353637; background-color:#f5f5f9;" id="table-l">
                                    <c:forEach items="${varListsub}" var="var2" varStatus="vs2">
                                        <c:if test="${var2.PARENT_ID==var.MYMENU_ID}">
                                            <div id="1" class="sub1" style="border-top:1px solid #cdcdcd;cursor:pointer;" onclick="showTwoMenu2(${var2.MYMENU_ID},'${var2.KEY_ID}',${var2.PARENT_ID},'${var2.TITLE}',${var2.ROWNUMBER},'${var2.TYPE}','${var2.CONTENT}')">${var2.TITLE}</div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${vs.index==1}">
                            <div class="add-mw">
                                <div id="add-m-but" class="add-m dis" onclick="showTwoMenu(${var.MYMENU_ID})">+
                                    <img src="static/weixin/wx-arrow.png" alt="">
                                </div>
                                <div class="dis" style="width:89px; line-height:45px; border:1px solid #cdcdcd;border-top:0px; position:absolute; bottom:110px; left:135px; font-size:16px; text-align:center; font-weight:bold; color:#353637; background-color:#f5f5f9;" id="table-m">
                                    <c:forEach items="${varListsub}" var="var2" varStatus="vs2">
                                        <c:if test="${var2.PARENT_ID==var.MYMENU_ID}">
                                            <div id="1" style="border-top:1px solid #cdcdcd;cursor:pointer;" onclick="showTwoMenu2(${var2.MYMENU_ID},'${var2.KEY_ID}',${var2.PARENT_ID},'${var2.TITLE}',${var2.ROWNUMBER},'${var2.TYPE}','${var2.CONTENT}')">${var2.TITLE}</div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${vs.index==2}">
                            <div class="add-rw">
                                <div id="add-r-but"  class="add-r dis" onclick="showTwoMenu(${var.MYMENU_ID})">+
                                    <img src="static/weixin/wx-arrow.png" alt=""/>
                                </div>
                                <div class="dis" style="width:89px;  line-height:45px; border:1px solid #cdcdcd;border-top:0px; position:absolute; bottom:110px; left:224px; font-size:16px; text-align:center; font-weight:bold; color:#353637; background-color:#f5f5f9;" id="table-r">
                                    <c:forEach items="${varListsub}" var="var2" varStatus="vs2">
                                        <c:if test="${var2.PARENT_ID==var.MYMENU_ID}">
                                            <div id="1" style="border-top:1px solid #cdcdcd;cursor:pointer;" onclick="showTwoMenu2(${var2.MYMENU_ID},'${var2.KEY_ID}',${var2.PARENT_ID},'${var2.TITLE}',${var2.ROWNUMBER},'${var2.TYPE}','${var2.CONTENT}')">${var2.TITLE}</div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <!--右部分-->
                <div class="wx-right">
                    <div class="r-top">
                        <p><span class="r-topl" id="mtitle"></span><span class="r-topr" onclick="deleteM();">删除菜单</span></p>
                        <div class="clr"></div>
                    </div>
                    <div class="r-name" style="display: none;" id="titlexx">
                        <form id="onemenu">
                            <input type="hidden" id="MYMENU_ID" name="MYMENU_ID">
                            <input type="hidden" id="KEY_ID" name="KEY_ID" value="${pd.KEY_ID}">
                            <input type="hidden" value="click" id="TYPE" name="TYPE">
                            <label>菜单名称</label>
                            <input type="input" placeholder="输入菜单名称" id="TITLE" name="TITLE">
                            <P>字数不超过4个汉字或8个字母</P>
                            <label>排序</label>
                            <input type="input" placeholder="排序号" id="ROWNUMBER" name="ROWNUMBER" >
                            <div style="margin: 10px 10px">
                                <button type="button" class="button" style="float: right;" onclick="saveOneMenu()"> 确定</button>
                            </div>
                        </form>
                    </div>
                    <div class="r-cont" id="otherxx" style="display: none;">
                        <form id="twomenu">
                            <input type="hidden" id="MYMENU_ID2" name="MYMENU_ID">
                            <input type="hidden" id="PARENT_ID2" name="PARENT_ID">
                            <input type="hidden" id="KEY_ID2" name="KEY_ID" value="${pd.KEY_ID}">
                            <input type="hidden" value="click" id="TYPE2" name="TYPE">
                            <input type="hidden" value="" id="CONTENT" name="CONTENT">
                            <label class="twome">菜单名称</label>
                            <input type="input" class="twotitle" placeholder="输入菜单名称" id="TITLE2" name="TITLE"></br>
                            <p class="twomep" style="width: 170px;">字数不超过4个汉字或8个字母</p></br>
                            <label class="twome">排序</label>
                            <input type="input" class="twotitle"  placeholder="排序号" id="ROWNUMBER2" name="ROWNUMBER" ></br>
                            <p>菜单内容</p>
                            <input id="mes-f" type="radio" name="mes">
                            <label>发送消息&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input id="mes-l" type="radio" name="mes">
                            <label>跳转网页</label>
                            <div id="mes-fx" class="messe">
                                <p>发送消息</p>
                                <textarea placeholder="请输入消息" id="content1" onkeyup="setContent(this.value);"></textarea>
                            </div>
                            <div id="mes-lx" class="messe dis">
                                <p>发送链接</p>
                                <textarea placeholder="请输入链接" id="content2" onkeyup="setContent(this.value);"></textarea>
                            </div>
                            <div style="margin: 10px 10px">
                                <button type="button" class="button" style="float: right;" onclick="saveTwoMenu()"> 确定</button>
                            </div>
                        </form>
                    </div>
                    <div class="r-bottom">
                        <div class="clr"></div>
                        <p><span class="r-topl"></span><span class="r-topr" onclick="createM('${pd.KEY_ID}');">生成菜单</span></p>
                    </div>
                </div>
            </div>

        </td>
    </tr>
    <tr>
        <td>错误代码说明：<a href="https://wenku.baidu.com/view/5edee974f78a6529647d53a1.html" target="_bank">https://wenku.baidu.com/view/5edee974f78a6529647d53a1.html</a>(返回错误代码说明功能正常，只是参数配置问题，具体根据错误代码看说明)</td>
    </tr>
</table>
</body>
</html>