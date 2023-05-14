<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" isELIgnored="false" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java"--%>
<%--         pageEncoding="utf-8" %>--%>
<%--isELIgnored="false"允许页面使用EL表达式--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/jsp/back-end/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>勤工俭学后台管理首页</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 标签页图标 -->
    <link rel="shortcut icon" href="<%=basePath%>img/favicon.ico">
    <link rel="stylesheet" href="<%=basePath%>css/home-page.css">
    <link rel="stylesheet" href="<%=basePath%>css/modify-pwd.css">
</head>

<body>
<div class="container-fluid p-0 m-0 row">
    <!-- 左侧导航栏 -->

    <div class="navbar-box col-3">
        <div class="pt-4 title-hover">
                <span class=" p-3   head-img ">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50px" height="50px" fill="currentColor"
                         class="bi bi-person-gear  rounded-circle  " viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M11 5a3 3 0 1 1-6 0 3 3 0 0 1 6 0ZM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4Z" />
                        <path
                                d="M8.256 14a4.474 4.474 0 0 1-.229-1.004H3c.001-.246.154-.986.832-1.664C4.484 10.68 5.711 10 8 10c.26 0 .507.009.74.025.226-.341.496-.65.804-.918C9.077 9.038 8.564 9 8 9c-5 0-6 3-6 4s1 1 1 1h5.256Z" />
                        <path fill-rule="evenodd"
                              d="M11.886 9.46c.18-.613 1.048-.613 1.229 0l.043.148a.64.64 0 0 0 .921.382l.136-.074c.561-.306 1.175.308.87.869l-.075.136a.64.64 0 0 0 .382.92l.149.045c.612.18.612 1.048 0 1.229l-.15.043a.64.64 0 0 0-.38.921l.074.136c.305.561-.309 1.175-.87.87l-.136-.075a.64.64 0 0 0-.92.382l-.045.149c-.18.612-1.048.612-1.229 0l-.043-.15a.64.64 0 0 0-.921-.38l-.136.074c-.561.305-1.175-.309-.87-.87l.075-.136a.64.64 0 0 0-.382-.92l-.148-.045c-.613-.18-.613-1.048 0-1.229l.148-.043a.64.64 0 0 0 .382-.921l-.074-.136c-.306-.561.308-1.175.869-.87l.136.075a.64.64 0 0 0 .92-.382l.045-.148ZM14 12.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0Z" />
                    </svg>
                </span>

            <span class="text-white-50 fs-6" name="admin">管理员1：${sessionScope.get("admin")}</span>
        </div>
        <!-- 垂直导航 -->
        <ul class="nav  flex-column ">

            <hr class="bg-light">


            <li class="nav-item title-hover">
                <a href="#" class="nav-link text-white-50">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px" fill="currentColor"
                         class="bi bi-houses" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M5.793 1a1 1 0 0 1 1.414 0l.647.646a.5.5 0 1 1-.708.708L6.5 1.707 2 6.207V12.5a.5.5 0 0 0 .5.5.5.5 0 0 1 0 1A1.5 1.5 0 0 1 1 12.5V7.207l-.146.147a.5.5 0 0 1-.708-.708L5.793 1Zm3 1a1 1 0 0 1 1.414 0L12 3.793V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v3.293l1.854 1.853a.5.5 0 0 1-.708.708L15 8.207V13.5a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 4 13.5V8.207l-.146.147a.5.5 0 1 1-.708-.708L8.793 2Zm.707.707 4.5 4.5V13.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5V7.207l4.5-4.5Z" />
                    </svg>
                    <span class="menu-title">首页</span>
                </a>
            </li>
            <li class="nav-item title-hover">
                <div class="">
                    <a href="${pageContext.request.contextPath}/notice/adminAllNotices" class="nav-link text-white-50 ">
                        <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px" fill="currentColor"
                             class="bi bi-info-square" viewBox="0 0 16 16">
                            <path
                                    d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
                            <path
                                    d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z" />
                        </svg>
                        <span class="menu-title">信息审批</span>
                    </a>
                </div>
            </li>

            <li>

                <a href="#user-collapse" class="nav-link text-white-50 title-hover" data-bs-toggle="collapse"
                   aria-expanded="false">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px" fill="currentColor"
                         class="bi bi-people" viewBox="0 0 16 16">
                        <path
                                d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1h8zm-7.978-1A.261.261 0 0 1 7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002a.274.274 0 0 1-.014.002H7.022zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0zM6.936 9.28a5.88 5.88 0 0 0-1.23-.247A7.35 7.35 0 0 0 5 9c-4 0-5 3-5 4 0 .667.333 1 1 1h4.216A2.238 2.238 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816zM4.92 10A5.493 5.493 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275zM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0zm3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4z" />
                    </svg>
                    <span class="menu-title">用户管理</span>
                </a>
                <div class="collapse  show" id="user-collapse">
                    <ul class=" list-unstyled  row ">
                        <li><a href="${pageContext.request.contextPath}/employer/allEmployer"
                               class="sub-title link-light p-2  d-inline-flex text-decoration-none col-9 float-end">信息发布方</a>
                        </li>
                        <li><a  href="${pageContext.request.contextPath}/student/allStudent"
                                class=" sub-title link-light p-2  d-inline-flex text-decoration-none col-9 float-end">学生</a>
                        </li>
                    </ul>
                </div>
            </li>
            <hr class="bg-light">
            <li class="nav-item">
                <a href="#sys-collapse" class="nav-link title-hover text-white-50" data-bs-toggle="collapse">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25px" height="25px" fill="currentColor"
                         class="bi bi-gear" viewBox="0 0 16 16">
                        <path
                                d="M8 4.754a3.246 3.246 0 1 0 0 6.492 3.246 3.246 0 0 0 0-6.492zM5.754 8a2.246 2.246 0 1 1 4.492 0 2.246 2.246 0 0 1-4.492 0z" />
                        <path
                                d="M9.796 1.343c-.527-1.79-3.065-1.79-3.592 0l-.094.319a.873.873 0 0 1-1.255.52l-.292-.16c-1.64-.892-3.433.902-2.54 2.541l.159.292a.873.873 0 0 1-.52 1.255l-.319.094c-1.79.527-1.79 3.065 0 3.592l.319.094a.873.873 0 0 1 .52 1.255l-.16.292c-.892 1.64.901 3.434 2.541 2.54l.292-.159a.873.873 0 0 1 1.255.52l.094.319c.527 1.79 3.065 1.79 3.592 0l.094-.319a.873.873 0 0 1 1.255-.52l.292.16c1.64.893 3.434-.902 2.54-2.541l-.159-.292a.873.873 0 0 1 .52-1.255l.319-.094c1.79-.527 1.79-3.065 0-3.592l-.319-.094a.873.873 0 0 1-.52-1.255l.16-.292c.893-1.64-.902-3.433-2.541-2.54l-.292.159a.873.873 0 0 1-1.255-.52l-.094-.319zm-2.633.283c.246-.835 1.428-.835 1.674 0l.094.319a1.873 1.873 0 0 0 2.693 1.115l.291-.16c.764-.415 1.6.42 1.184 1.185l-.159.292a1.873 1.873 0 0 0 1.116 2.692l.318.094c.835.246.835 1.428 0 1.674l-.319.094a1.873 1.873 0 0 0-1.115 2.693l.16.291c.415.764-.42 1.6-1.185 1.184l-.291-.159a1.873 1.873 0 0 0-2.693 1.116l-.094.318c-.246.835-1.428.835-1.674 0l-.094-.319a1.873 1.873 0 0 0-2.692-1.115l-.292.16c-.764.415-1.6-.42-1.184-1.185l.159-.291A1.873 1.873 0 0 0 1.945 8.93l-.319-.094c-.835-.246-.835-1.428 0-1.674l.319-.094A1.873 1.873 0 0 0 3.06 4.377l-.16-.292c-.415-.764.42-1.6 1.185-1.184l.292.159a1.873 1.873 0 0 0 2.692-1.115l.094-.319z" />
                    </svg>
                    <span class="menu-title">系统管理</span>
                </a>

                <div id="sys-collapse" class="collapse show">
                    <ul class="list-unstyled  row">
                        <li><a href="${pageContext.request.contextPath}/admin/jumpAdminUpdate"
                               class="sub-title link-light p-2  d-inline-flex text-decoration-none col-9 float-end">密码修改</a>
                        </li>

                    </ul>
                </div>
            </li>

        </ul>
    </div>
    <div class="top-back p-0 col-9 shadow">
        <!-- logo -->
        <a href="#" class="navbar-brand float-end">
            <img src="<%=basePath%>img/logo1.png" class="rounded bg-light" style="width: 200px;" alt="logo">
        </a>
        <div class="container mt-5   row justify-content-center ">
            <!-- form表单 -->
            <form action="" method="" class="row justify-content-center">

                <div class="col-7 mt-5 form-back border shadow ">
                    <div class=" row justify-content-center ">
                        <div class="  p-3 fs-5 col-10 content-back rounded-3 mt-4 mb-3">
                            <label for="studentId" class="form-label">账号</label>
                            <input id="studentId" type="text" class="form-control border rounded-3 mb-2 "
                                   name="studentId">
                            <label for="name" class="form-label">旧密码</label>
                            <input id="name" type="text" class="form-control border rounded-3 mb-2" name="name">
                            <label for="sex" class="form-label">新密码</label>
                            <input id="sex" type="text" class="form-control border rounded-3 mb-2" name="sex">

                            <!-- <input class="form-control  " type="text" placeholder="新密码不能与旧密码一致" aria-label="readonly input example" readonly> -->
                            <!-- 按钮 -->
                            <div class="justify-content-center row mt-3">
                                <button class="btn col-4 fs-5 btn-back" type="submit">确认修改</button>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>

    </div>
</body>

</html>
