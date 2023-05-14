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
    <title>主页</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 标签页图标 -->
    <link rel="shortcut icon" href="<%=basePath%>img/favicon.ico">
    <link rel="stylesheet" href="<%=basePath%>css/nav-footer.css">
    <link href="<%=basePath%>css/index.css" rel="stylesheet">
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
                        <li><a href="${pageContext.request.contextPath}/login/destory" class="dropdown-item">退出登录</a></li>
                    </ul>
                </div>

            </ul>
        </div>
    </div>

</nav>

<div class="container-fluid p-0" style="margin-top: 100px;">
    <!-- 轮播图 -->
    <div id="demo" class="carousel slide" data-bs-ride="carousel">
        <!-- 轮播图指示符 -->
        <div class="carousel-indicators">
            <button class="active" type="button" data-bs-target="#demo" data-bs-slide-to="0"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
            <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
        </div>

        <!-- 轮播/幻灯片 -->
        <div class="carousel-inner">
            <div class="carousel-item active">

                <img src="<%=basePath%>img/index_img1.png" alt="" class="d-block w-100 ">
            </div>
            <div class="carousel-item">
                <img src="<%=basePath%>img/index_img2.jpg" alt="" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="<%=basePath%>img/index_img3.jpeg" alt="" class="d-block w-100">
            </div>
            <div class="carousel-item">
                <img src="<%=basePath%>img/index_img4.png" alt="" class="d-block w-100">
            </div>
        </div>
        <!-- 左右控件 -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
    <!-- 模块 -->
    <div class="container bg-light mt-4">
        <div class="row mt-5">
            <div class="col">
                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                         class="bi bi-cup-hot-fill" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M.5 6a.5.5 0 0 0-.488.608l1.652 7.434A2.5 2.5 0 0 0 4.104 16h5.792a2.5 2.5 0 0 0 2.44-1.958l.131-.59a3 3 0 0 0 1.3-5.854l.221-.99A.5.5 0 0 0 13.5 6H.5ZM13 12.5a2.01 2.01 0 0 1-.316-.025l.867-3.898A2.001 2.001 0 0 1 13 12.5Z" />
                        <path
                                d="m4.4.8-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 3.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 3.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 3 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 4.4.8Zm3 0-.003.004-.014.019a4.167 4.167 0 0 0-.204.31 2.327 2.327 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.31 3.31 0 0 1-.202.388 5.444 5.444 0 0 1-.253.382l-.018.025-.005.008-.002.002A.5.5 0 0 1 6.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 6.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 6 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 7.4.8Zm3 0-.003.004-.014.019a4.077 4.077 0 0 0-.204.31 2.337 2.337 0 0 0-.141.267c-.026.06-.034.092-.037.103v.004a.593.593 0 0 0 .091.248c.075.133.178.272.308.445l.01.012c.118.158.26.347.37.543.112.2.22.455.22.745 0 .188-.065.368-.119.494a3.198 3.198 0 0 1-.202.388 5.385 5.385 0 0 1-.252.382l-.019.025-.005.008-.002.002A.5.5 0 0 1 9.6 4.2l.003-.004.014-.019a4.149 4.149 0 0 0 .204-.31 2.06 2.06 0 0 0 .141-.267c.026-.06.034-.092.037-.103a.593.593 0 0 0-.09-.252A4.334 4.334 0 0 0 9.6 2.8l-.01-.012a5.099 5.099 0 0 1-.37-.543A1.53 1.53 0 0 1 9 1.5c0-.188.065-.368.119-.494.059-.138.134-.274.202-.388a5.446 5.446 0 0 1 .253-.382l.025-.035A.5.5 0 0 1 10.4.8Z" />
                    </svg>
                </div>
                <p class="fs-4 mt-1 title">
                    找兼职
                <p class="fs-5  content">你我的邂逅，注定是一场美妙的旅行，我将安全的把你带到兼职的旅行地！</p>
                </p>
            </div>
            <div class=" card text-white  col ">
                <img src="<%=basePath%>img/user-index2.jpg" alt="" class="card-img-top img">
                <div class="card-body card-img-overlay text-center  mt-5">
                    <h2 class="card-title">招聘大厅</h2>
                    <p class="card-text">各种兼职，样样都给力！</p>
                    <a href="<%=basePath%>recruitment-hall.jsp" class="btn btn-light">查看详情</a>
                </div>
            </div>
        </div>
        <div class="row mt-5">
            <div class=" card text-white  col ">
                <img src="<%=basePath%>img/user-index3.jpg" alt="" class="card-img-top img">
                <div class="card-body card-img-overlay text-center  mt-5">
                    <h2 class="card-title">个人简历</h2>
                    <p class="card-text">勤者自助，达者自强！</p>
                    <a href="#" class="btn btn-light">查看详情</a>
                </div>
            </div>
            <div class="col">
                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                         class="bi bi-vector-pen" viewBox="0 0 16 16">
                        <path fill-rule="evenodd"
                              d="M10.646.646a.5.5 0 0 1 .708 0l4 4a.5.5 0 0 1 0 .708l-1.902 1.902-.829 3.313a1.5 1.5 0 0 1-1.024 1.073L1.254 14.746 4.358 4.4A1.5 1.5 0 0 1 5.43 3.377l3.313-.828L10.646.646zm-1.8 2.908-3.173.793a.5.5 0 0 0-.358.342l-2.57 8.565 8.567-2.57a.5.5 0 0 0 .34-.357l.794-3.174-3.6-3.6z" />
                        <path fill-rule="evenodd"
                              d="M2.832 13.228 8 9a1 1 0 1 0-1-1l-4.228 5.168-.026.086.086-.026z" />
                    </svg>
                </div>
                <p class="fs-4 mt-1 title">
                    写简历
                <p class="fs-5  content">你的个人说明书，求职的 “敲门砖” !</p>
                </p>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col">
                <div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor"
                         class="bi bi-journal-text" viewBox="0 0 16 16">
                        <path
                                d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z" />
                        <path
                                d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z" />
                        <path
                                d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z" />
                    </svg>
                </div>
                <p class="fs-4 mt-1 title">
                    查结果
                <p class="fs-5  content">每一条消息及时送达，让你的焦急不再等待！</p>
                </p>
            </div>
            <div class=" card text-white  col ">
                <img src="<%=basePath%>img/user-index6.jpg" alt="" class="card-img-top img">
                <div class="card-body card-img-overlay text-center  mt-5">
                    <h2 class="card-title">通知中心</h2>
                    <p class="card-text">求职更轻松，每天好薪情！</p>
                    <a href="#" class="btn btn-light">查看详情</a>
                </div>
            </div>
        </div>
        <!--
                    <div class="row mt-5">
                        <div class=" card text-white  col ">
                            <img src="<%=basePath%>img/user-index8.jpg" alt="" class="card-img-top img">
                            <div class="card-body card-img-overlay text-center  mt-5">
                                <h2 class="card-title">薪资结算</h2>
                                <p class="card-text">勤俭自强，励炼成长！</p>
                                <a href="#" class="btn btn-light">查看详情</a>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <svg xmlns="http://www.w3.org/2000/svg" width="40px" height="40px" fill="currentColor"
                                    class="bi bi-currency-exchange" viewBox="0 0 16 16">
                                    <path
                                        d="M0 5a5.002 5.002 0 0 0 4.027 4.905 6.46 6.46 0 0 1 .544-2.073C3.695 7.536 3.132 6.864 3 5.91h-.5v-.426h.466V5.05c0-.046 0-.093.004-.135H2.5v-.427h.511C3.236 3.24 4.213 2.5 5.681 2.5c.316 0 .59.031.819.085v.733a3.46 3.46 0 0 0-.815-.082c-.919 0-1.538.466-1.734 1.252h1.917v.427h-1.98c-.003.046-.003.097-.003.147v.422h1.983v.427H3.93c.118.602.468 1.03 1.005 1.229a6.5 6.5 0 0 1 4.97-3.113A5.002 5.002 0 0 0 0 5zm16 5.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0zm-7.75 1.322c.069.835.746 1.485 1.964 1.562V14h.54v-.62c1.259-.086 1.996-.74 1.996-1.69 0-.865-.563-1.31-1.57-1.54l-.426-.1V8.374c.54.06.884.347.966.745h.948c-.07-.804-.779-1.433-1.914-1.502V7h-.54v.629c-1.076.103-1.808.732-1.808 1.622 0 .787.544 1.288 1.45 1.493l.358.085v1.78c-.554-.08-.92-.376-1.003-.787H8.25zm1.96-1.895c-.532-.12-.82-.364-.82-.732 0-.41.311-.719.824-.809v1.54h-.005zm.622 1.044c.645.145.943.38.943.796 0 .474-.37.8-1.02.86v-1.674l.077.018z" />
                                </svg>
                            </div>
                            <p class="fs-4 mt-1 title">
                                发工资
                            <p class="fs-5  content">精打细算，不漏一分 !</p>
                            </p>
                        </div>
                    </div> -->

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