<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>招聘大厅</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 标签页图标 -->
    <link rel="shortcut icon" href="<%=basePath%>img/favicon.ico">
    <!-- <link href="<%=basePath%>css/index.css" rel="stylesheet"> -->
    <link rel="stylesheet" href="<%=basePath%>css/recruitment-hall.css">
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
<div class="container-fluid p-0" style="margin-top: 100px">
    <div class="container border bg-light  ">
        <div class="row justify-content-start">
            <h2 class="fw-bold title p-3 mt-5 mb-3 col-4 offset-2">
                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-briefcase-fill" viewBox="0 0 16 16">
                    <path d="M6.5 1A1.5 1.5 0 0 0 5 2.5V3H1.5A1.5 1.5 0 0 0 0 4.5v1.384l7.614 2.03a1.5 1.5 0 0 0 .772 0L16 5.884V4.5A1.5 1.5 0 0 0 14.5 3H11v-.5A1.5 1.5 0 0 0 9.5 1h-3zm0 1h3a.5.5 0 0 1 .5.5V3H6v-.5a.5.5 0 0 1 .5-.5z"/>
                    <path d="M0 12.5A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5V6.85L8.129 8.947a.5.5 0 0 1-.258 0L0 6.85v5.65z"/>
                </svg>
                招聘信息一览
            </h2>
        </div>
        <!-- 折叠框组 -->
        <div id="accordion" class="row justify-content-center">


           <c:forEach items="${requestScope.get('messageList')}" var="message" varStatus="index" >
               <div class="card  col-8">
                   <div class="  p-2 title-back rounded border">
                       <a href="#collapse${index.index+1}" class="btn fs-5 a-back " data-bs-toggle="collapse">

                           ${message.position}
                       </a>
                   </div>
                   <div id="collapse${index.index+1}" class="collapse" data-bs-parent="#accordion">
                       <div class="card-body">
<%--                           <input hidden name="messageId" value="${message.messageId}">--%>
                           <p>要求：${message.requirement}</p>
                           <p>薪资：${message.salary} ￥</p>
                           <p>时间：${message.time}</p>
                           <p>地点：${message.address}</p>
                           <p>联系方式：${message.phone}</p>
                           <p>单位：${message.employerName}</p>
                           <div class="row  justify-content-center">
                               <a href="${pageContext.request.contextPath}/resume/stu_info?messageId=${message.messageId}" class="btn btn-back col-3 text-white  fs-5">
                                   申请
                               </a>
                           </div>

                       </div>
                   </div>
               </div>
           </c:forEach>




            <!-- <div class="card">
                <div class="card-header">
                    <a href="#collapseTwo" class="collapsed btn" data-bs-toggle="collapse">
                        可折叠项目2
                    </a>
                </div>
                <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
                    <img src="<%=basePath%>img/wallhaven-d6x77m.jpg" alt="" class="card-img-top">
                    <div class="card-body">
                        拈一缕岁月的风，沐一场时光的雨，让心在平淡中盈满温润，
                        回眸， 有明天可以奔赴，有过往可回头，有温暖可相依，这
                        样的日子，是我想要的岁月静好。
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-header">
                    <a href="#collapseThree" class="collapsed btn" data-bs-toggle="collapse">
                        可折叠项目3
                    </a>
                </div>
                <div id="collapseThree" class="collapse" data-bs-parent="accordion">
                    <img src="<%=basePath%>img/wallhaven-rdvp8m.jpg" alt="" class="card-img-bottom">
                    <div class="card-body">
                        拈一缕岁月的风，沐一场时光的雨，让心在平淡中盈满温润，
                        回眸， 有明天可以奔赴，有过往可回头，有温暖可相依，这
                        样的日子，是我想要的岁月静好。
                    </div>
                </div>
            </div> -->
        </div>

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
