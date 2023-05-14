<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Register Page</title>
    <meta name="viewport"  content="width=device-width,minimum-scale=1.0, maximum-scale=2.0; charset=UTF-8">
    <!--width:可视区域的宽度，值可为数字或关键词device-width(设备的宽度)
      maximum-scale=2.0, minimum-scale=1.0;可视区域的缩放级别
      实现了适应手机页面，主要是设置了width为device-width，device-width为使用设备的宽度。  -->
<%--    <link href="<c:url value="${pageContext.request.contextPath}/jsp/back-end/css/reg.css"/>" rel="stylesheet"  type="text/css" />--%>
    <link href="${pageContext.request.contextPath}/jsp/back-end/css/reg.css" rel="stylesheet"  type="text/css" />
    <script src="${pageContext.request.contextPath}/jsp/back-end/js/reg.js"></script>
</head>
<body>
    <button onclick="window.location.href='userlogin'" class="return"></button>			<!-- 注册页面左上角的返回按钮，点击时返回登录页面 -->
    <div class="box">
        <div class="box-head">学 生 信 息 注 册</div>														<!-- 用户注册的标题 -->
        <br>
        <div class="box-body">
            <form action="${pageContext.request.contextPath}/student/saveStudent" method="post" name="form">
                <table>
                    <tr>
                        <th>学生学号：</th>																	<!-- 输入用户名称 -->
                        <td><input type="text" name="studentId" id="user" placeholder="长度为9位的数字，要求未注册过" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <th>密　　码：</th>																	<!-- 输入密码 -->
                        <td><input type="password" name="password" placeholder="长度6~20，大小写字母、数字或下划线" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <th>确认密码：</th>																	<!-- 重复密码 -->
                        <td><input type="password" name="repwd" placeholder="请再次输入密码进行确认" autocomplete="off"></td>
                    </tr>
                    <tr>
                        <th>真实姓名：</th>																	<!-- 输入用户真实姓名 -->
                        <td><input type="text" name="name" placeholder="输入您的真实姓名" autocomplete="off"></td>
                    </tr>

                    <tr>
                        <th>学   院：</th>																	<!-- 输入手机号码 -->
                        <td>
                            <select name="college" id="grade" style="height: 38px; margin-bottom: 15px;">
                                <option value="信工">信息工程学院</option>
                                <option value="物电">物理与电子电气工程学院</option>
                                <option value="人文">人文学院</option>
                                <option value="数统">数学统计学院</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>电话号码：</th>
                        <td><input type="text" name="phone" placeholder="13、14、15、17、18开头的11位手机号" autocomplete="off"></td>
                    </tr>
                </table>
                <br>
<%--                <input type="button" onclick="checkData()" value="注册">		<!-- 注册按钮 -->--%>
                <input type="submit"  value="注册">		<!-- 注册按钮 -->
            </form>

        </div>
    </div>
   
</body>
</html>