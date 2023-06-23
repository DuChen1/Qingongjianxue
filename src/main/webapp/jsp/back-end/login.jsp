<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/library/";
%>
<%=basePath%>css/ --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Login Page</title>
    <script src="${pageContext.request.contextPath}/jsp/back-end/js/login.js"></script>                                        <%--标题名称--%>
    <link href="${pageContext.request.contextPath}/jsp/back-end/css/login.css" rel="stylesheet"  type="text/css" />
    <%--导入登录界面的css样式--%>
    </style>
</head>
<%--<body style="background-image: url(././/jsp/back-end/img/background.jpg)" >--%>
<body style="background-image: url(../back-end/img/background.jpg)" >
<div class="htmleaf-container">
    <div class="login-wrap">                            <%-- 登录界面的div块--%>
        <div class="login-html">
            <h2>勤工俭学加油站</h2>                          <%--二级标题, 登录信息--%>

            <%--分为两种登录方式, 学生登录和管理员身份登录--%>
            <input id="tab-1" type="radio" name="tab" class="sign-in" >
            <label for="tab-1" class="tab">用户</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up" >     <%--若获取的请求信息为checked时，下次以管理员登录为默认--%>
            <label for="tab-2" class="tab">管理员</label>
            <div class="login-form">
                <div class="sign-in-htm">
                    <form action="${pageContext.request.contextPath}/login/studentLogin" method="post" name="form_user">            <%--学生学号登录的表单，提交给userLoginServlet进行处理--%>
                        <div class="group">
                            <label class="label">用户名</label>
                            <input name="username" type="text" class="input" >
                        </div>
                        <div class="group">
                            <label class="label">密码</label>
                            <input name="pwd" type="password" class="input" >
                        </div>
                        <div class="group">
                            <input id="check" type="checkbox" class="check" name="check">
                            <%--                            <label for="check"><span class="icon"></span>记住密码</label>--%>
                            <a href="${pageContext.request.contextPath}/login/toAddStudent" class="reg">没有账号?立即注册</a>
                            <p class="error">&nbsp;${message}</p>              <%--若用户登录失败，将在此显示用户登录失败的信息--%>
                        </div>
                        <%--                    <div class="group">--%>
                        <div class="group">
                            <%--以button方式进行javascript点击函数处理，验证登录格式，并提交--%>
                            <input type="submit" class="button" value="登录">
                        </div>
                    </form>
                </div>
                <div class="sign-up-htm">
                    <%--                    <form action="${pageContext.request.contextPath}/admin/adminLogin" method="post" name="form_admin">   &lt;%&ndash;管理员登录的表单，提交给AdminLoginServlet进行处理&ndash;%&gt;--%>
                    <form action="${pageContext.request.contextPath}/admin/adminLogin" method="post">   <%--管理员登录的表单，提交给AdminLoginServlet进行处理--%>
                        <div class="group">
                            <label class="label">管理员账号</label>
                            <input name="adminUsername" id="adminUsername" type="text" class="input" >
                        </div>
                        <div class="group">
                            <label class="label">管理员密码</label>
                            <input name="pwd" type="password" class="input" >
                        </div>
                        <div class="group">
                            <%--                            <p>暂不支持记住密码及注册</p>--%>
                            <p class="error">&nbsp;${message}</p>            <%--若管理员登录失败，将在此显示管理员登录失败的信息--%>
                        </div>
                        <div class="group">
                            <%--以button方式进行javascript点击函数处理，验证管理员登录格式，并提交--%>
                            <input type="submit" class="button" onclick="checkusername()" value="登录">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function checkusername(){
        var d=document.getElementById('adminUsername').value;
        if(d.length>15){
            alert("最大只可以输入15个字符");
            event.preventDefault();
        }

    }
</script>
</body>
</html>
