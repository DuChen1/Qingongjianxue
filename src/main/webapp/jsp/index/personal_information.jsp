<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="utf-8" isELIgnored="false" %>
<%--isELIgnored="false"允许页面使用EL表达式--%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/jsp/index/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人信息</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 标签页图标 -->
    <link rel="shortcut icon" href="<%=basePath%>img/favicon.ico">

    <link rel="stylesheet" href="<%=basePath%>css/resume.css">
    <link rel="stylesheet" href="<%=basePath%>css/nav-footer.css">

</head>

<body>
<!-- 导航栏 -->
<nav class="navbar navbar-expand-sm   bg-light  shadow fixed-top">
    <div class="container-fluid">
        <div class="nav">
            <!-- logo -->
            <a href="<%=basePath%>index.jsp" class="navbar-brand">
                <img src="<%=basePath%>img/logo1.png" class="rounded" style="width: 200px;" alt="logo">
            </a>
            <!-- 菜单 -->
            <ul class="navbar-nav ">
                <li class="nav-item ">
                    <a href="<%=basePath%>index.jsp" class="nav-link  fs-5  mt-2">首页</a>
                </li>
                <li class="nav-item ">
                    <a href="${pageContext.request.contextPath}/resume/all_resume" class="nav-link  fs-5  mt-2 link">活动记录</a>
                </li>
                <li class="nav-item ">
                    <a href="<%=basePath%>student-notice.jsp" class="nav-link  fs-5  mt-2">通知</a>
                </li>
                <li class="nav-item ">
                    <a href="${pageContext.request.contextPath}/student/student_info" class="nav-link  fs-5  mt-2">个人信息</a>
                </li>
                <li class="nav-item ">
                    <a href="${pageContext.request.contextPath}/message/message_info" class="nav-link  fs-5  mt-2">招聘大厅</a>
                </li>
                <!-- <li class="nav-item ">
                    <a href="#" class="nav-link  fs-5  mt-2">薪资结算</a>
                </li> -->
                <!-- 竖线 -->
                <li class="nav-item ">
                    <div class="line"></div>
                </li>
                <li class="nav-item ">

                </li>
                <!-- 下拉菜单 -->
                <div class="dropdown">
                    <button type="button" class="btn dropdown-toggle border" data-bs-toggle="dropdown">
                        <!-- <img src="<%=basePath%>img/icon/bootstrap-icons-1.10.2/person-circle.svg" class="user-icon" width="30px" alt="用户名"> -->
                        <svg xmlns="http://www.w3.org/2000/svg" width="40px" height="30px"
                             fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                            <path fill-rule="evenodd"
                                  d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                        </svg>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#" class="dropdown-item">账号: <%=session.getAttribute("studentId")%></a></li>
                        <li><a href="#" class="dropdown-item">姓名: <%=session.getAttribute("name")%></a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><button class="btn dropdown-item m-0" type="submit">退出登录</button></li>
                    </ul>
                </div>

            </ul>
        </div>
    </div>

</nav>

<!-- 主体 -->
<div class="container-fluid p-0 " style="margin-top: 100px">
    <div class="container border bg-light  ">
        <div class="row justify-content-center ">
            <h2 class="fw-bold title p-3 mt-5 mb-3 col-4 offset-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                     class="bi bi-person-workspace" viewBox="0 0 16 16">
                    <path
                            d="M4 16s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H4Zm4-5.95a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
                    <path
                            d="M2 1a2 2 0 0 0-2 2v9.5A1.5 1.5 0 0 0 1.5 14h.653a5.373 5.373 0 0 1 1.066-2H1V3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v9h-2.219c.554.654.89 1.373 1.066 2h.653a1.5 1.5 0 0 0 1.5-1.5V3a2 2 0 0 0-2-2H2Z" />
                </svg>

                个人信息
            </h2>
        </div>
        <!-- form表单 -->
        <form action="${pageContext.request.contextPath}/student/updateStudent_index" method="post">
            <div class="   row justify-content-center">

                <div class="col-8 form-back ">
                    <div class="row justify-content-center ">
                        <div class="  p-3 fs-5 col-10 content-back rounded-3 mt-4 mb-3">
                            <hr>
                            <label for="studentId" class="form-label">学号</label>
                            <input readonly id="studentId" type="text" class="form-control border rounded-3 mb-2 "
                                   name="studentId" value="${requestScope.get('studentId')}">


                            <label for="name" class="form-label">姓名</label>
                            <input id="name" type="text" class="form-control border rounded-3 mb-2" name="name" value="${requestScope.get("name")}">



                            <label for="sex" class="form-label">性别</label>
                            <input id="sex" type="text" class="form-control border rounded-3 mb-2" name="sex" value="${requestScope.get("sex")}">

                            <label for="age" class="form-label">年龄</label>
                            <input id="age" type="text" class="form-control border rounded-3 mb-2" name="age" value="${requestScope.get("age")}">

                            <label for="college" class="form-label">学院</label>
                            <input id="college" type="text" class="form-control border rounded-3 mb-2"
                                   name="college" value="${requestScope.get("college")}">
                            <label for="phone" class="form-label">联系方式</label>
                            <input id="phone" type="text" class="form-control border rounded-3 mb-2" name="phone" value="${requestScope.get("phone")}">

                            <label for="address" class="form-label">住址</label>
                            <input id="address" type="text" class="form-control border rounded-3 mb-2"
                                   name="address" value="${requestScope.get("address")}">



                            <label for="speciality" class="form-label">特长</label>
                            <!-- textarea结束标签换行会有较大的缩进 -->
                            <textarea name="speciality" id="speciality" cols="30" rows="6"
                                      class="form-control ">${requestScope.get("speciality")}</textarea>
                            <!-- <input class="form-control" type="text" placeholder="只读文本..." aria-label="readonly input example" readonly> -->
                            <!-- 按钮 -->
                            <div class="justify-content-center row mt-3">
                                <button class="btn col-4 fs-5 btn-back" type="submit">确认修改</button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </form>

    </div>


    <!-- 页脚 -->
    <div class="footer  bg-dark text-white">
        <div class="container-sm">
            <div class="row footer-title">
                <div class="col-4 ">
                    <h5 class="fs-5">勤工俭学加油站</h5>
                    <!-- <p class="p-3">一切为了学生，为了学生的一切</p> -->
                </div>
                <div class="col footer-title2">

                    <h5 class="fs-5">友情链接</h5>
                </div>


            </div>
            <div class="row ">
                <div class="col-3  lh-lg">勤工俭学加油站，大学生兼职的摇篮，大学生梦想的舞台。以梦为马，不负韶华，为你的青春加油打气！</div>
                <div class="col-9 fs-6 mt-4">
                    <div class="row row-cols-4 ">
                        <div class="col"></div>

                        <div class="col "><a href="https://www.nxu.edu.cn/"
                                             class="text-light text-decoration-none ">宁夏大学官网</a></div>
                        <div class="col"><a href="https://graduate.nxu.edu.cn/"
                                            class="text-light text-decoration-none ">研究生院</a></div>
                        <div class="col"><a href="https://kjc.nxu.edu.cn/"
                                            class="text-light text-decoration-none ">科研管理</a></div>
                        <div class="col"></div>
                        <div class="col mt-4"><a href="https://kjc.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">教务系统</a></div>
                        <div class="col mt-4"><a href="https://lib.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">图书馆</a></div>
                        <div class="col mt-4"><a href="https://zs.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">本科生招生</a></div>
                        <div class="col"></div>

                        <div class="col mt-4"><a href="https://kjc.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">人事处</a></div>
                        <div class="col mt-4"><a href="https://jcc.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">宁大财务</a></div>
                        <div class="col mt-4"><a href="https://xxgc.nxu.edu.cn/"
                                                 class="text-light text-decoration-none ">信息工程学院</a></div>
                        <div class="col"></div>
                        <div class="col mt-4"><a href="https://learning.niit.com.cn/"
                                                 class="text-light text-decoration-none ">NIIT</a></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 页脚下划线 -->
        <div class="footer-line"></div>
        <p class="p-3 text-center">@copyright</p>
    </div>
</div>



</body>

</html>
