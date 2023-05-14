
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>勤工俭学管理系统</title>

  <style>
    .demo-carousel {
      height: 200px;
      line-height: 200px;
      text-align: center;
    }
  </style>
  <link href="${pageContext.request.contextPath}/statics/css/layui.css"  rel="stylesheet"
        type="text/css" />
  <link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css"  rel="stylesheet"
        type="text/css" />
  <link href="${pageContext.request.contextPath}/statics/css/style.min.css" rel="stylesheet"
        type="text/css" />
  <link href="${pageContext.request.contextPath}/statics/css/materialdesignicons.min.css"
        rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/statics/css/bootstrap.css" rel="stylesheet"
        type="text/css" />


  <script src="${pageContext.request.contextPath}/statics/js/layui.js"></script>
  <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.min.js"></script>
</head>
<body class="layui-layout-body">
<form action="${pageContext.request.contextPath}/login/studentLogin">
  <!-- <div class="layui-body">
内容主体区域
<iframe  name="content" height="100%" width="100%" frameborder="0" scrolling="no"></iframe>
<iframe href="/mvc/list" name="content" height="100%" width="100%" frameborder="0" scrolling="no"></iframe>
</div> -->
  <%-- <div class="layui-layout layui-layout-admin">
<jsp:include page="index.jsp"></jsp:include>
</div> --%>
  <!-- 内容主体区域 -->
  <div>
    <table id="tb-bookReader" lay-filter="tb-bookReader"></table>
  </div>

  <div class="layui-layout layui-layout-admin">
    <%-- <jsp:include page="index.jsp"></jsp:include> --%>
    <%-- <jsp:include page="../jsp/index.jsp" flush="true"/> --%>
    <!-- 搜索条件表单 -->
    <div class="layui-header">
      <div class="layui-logo">系统管理员</div>
      <!-- 头部区域（可配合layui已有的水平导航） -->
      <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="">首页</a></li>
        <%--					<li class="layui-nav-item"><a href="javascript:;">其它系统</a>--%>
        <dl class="layui-nav-child">
          <dd>
            <a href="../reader/04readerFrame.jsp">系统首页</a>
          </dd>
          <dd>
            <%--								<a href="../loginManager.html">图书管理员</a>--%>
          </dd>
        </dl></li>
      </ul>
      <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item"><a href="javascript:;"> <img
                src="http://t.cn/RCzsdCq" class="layui-nav-img"> 系统管理员
        </a>
          <dl class="layui-nav-child">
            <dd id="updatePassword">
              <a href="javascript:;">修改密码</a>
            </dd>
          </dl></li>
        <li class="layui-nav-item"><a
                href="/librarysystem/mvc/relogin">退出</a></li>
      </ul>
    </div>

    <%--左侧导航栏区域（可配合layui已有的垂直导航）--%>
    <div class="layui-side layui-bg-black">
      <div class="layui-side-scroll">
        <ul class="layui-nav layui-nav-tree" lay-filter="test">
          <li class="layui-nav-item layui-nav-itemed"><a class=""
                                                         href="${pageContext.request.contextPath}/student/allStudent" target="content"><i
                  class="layui-icon layui-icon-read"
                  style="font-size: 16px; color: #1E9FFF;"></i>校园学生管理</a></li>


          <li class="layui-nav-item layui-nav-itemed"><a class=""
                                                         href="${pageContext.request.contextPath}/message/allMessage" target="content"><i
                  class="layui-icon layui-icon-read"
                  style="font-size: 16px; color: #1E9FFF;"></i>招聘信息管理</a></li>
          <li class="layui-nav-item layui-nav-itemed"><a class=""
                                                         href="./sortlist.jsp" target="content"><i
                  class="layui-icon layui-icon-tabs"
                  style="font-size: 16px; color: #1E9FFF;"></i>勤工俭学信息审批</a></li>

        </ul>
      </div>
    </div>
    <%--				主体内容--%>
    <div class="layui-body" style="overflow-x: hidden">
      <div class="demoTable layui-form">
        <form action="/book/showBookByNameAndAuthor" method="post">
          <div class="layui-inline">
            <input class="layui-input" name="bname" id="bname"
                   autocomplete="off" placeholder="请输入学生学号">
          </div>
          <%--						<div class="layui-inline">--%>
          <%--							<input class="layui-input" name="author" id="author"--%>
          <%--								autocomplete="off" placeholder="请输入作者">--%>
          <%--						</div>--%>
          <input type="submit" class="layui-btn" value="搜索">
          <%--        <button class="layui-btn" data-type="reload">搜索</button>--%>
          <a class="layui-btn layui-btn-normal"
             href="${pageContext.request.contextPath}/message/toAddMessage">添加招聘信息</a> <a
                class="layui-btn layui-btn-normal" href="/book/listBook">返回首页</a>
        </form>
        <%--        <a style="margin-left: 70px" class="layui-btn layui-btn-normal" onclick="add();">添加图书</a>--%>
      </div>


      <!-- <table class="layui-hide" id="demo" lay-filter="test"></table> -->
      <!--页面主要内容-->
      <main>

        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <!--   <div class="card-header">
      <h4>图书信息</h4>
  </div> -->
              <div class="card-body">
                <div class="table-responsive">
                  <c:if test="${!empty requestScope.list }">
                    <table class="table table-hover">

                      <thead>
                      <tr>
                        <th>序号</th>
                        <th>招聘信息编号</th>
                        <th>职位</th>
                        <th>要求</th>
                        <th>地址</th>
                        <th>电话</th>
                        <th>招聘部门Id</th>
                        <th>招聘部门名称</th>
                        <th>薪资</th>
                        <th>时间</th>
                        <th>是否通过审批</th>
                        <th>通过</th>
<%--                        <th>驳回</th>--%>
                      </tr>
                      </thead>
                      <c:forEach items="${requestScope.get('list')}" var="emp"
                                 varStatus="index">
                        <tbody>
                        <tr>
                          <td>${index.index + 1}</td>
                          <td>${emp.id}</td>
                          <td>${emp.position}</td>
                          <td>${emp.requirement}</td>
                          <td>${emp.address}</td>
                          <td>${emp.phone}</td>
                          <td>${emp.employerId}</td>
                          <td>${emp.employerName}</td>
                          <td>${emp.salary}</td>
                          <td>${emp.time}</td>
                          <td>${emp.pass}</td>
                          <td>
                            <a href="${pageContext.request.contextPath}/message/toUpdateMessage?id=${emp.id}">
<%--                            <a href="${pageContext.request.contextPath}/message/updateMessage">--%>
                              <img src="../../../statics/img/modify_icon.png" width="20px" height="20px"/>
                            </a>
                          </td>
<%--                          <td>--%>
<%--                            <a class="delete"--%>
<%--                               href="${pageContext.request.contextPath}/message/del/${emp.id}"> <img--%>
<%--                                    src='../../../statics/img/delete_icon.png' width='20px'--%>
<%--                                    height='20px' /></a>--%>
<%--                          </td>--%>
                        </tr>

                        </tbody>
                      </c:forEach>
                    </table>
                  </c:if>
                  <form action="" method="POST">
                    <input type="hidden" name="_method" value="DELETE" />
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
</form>


<%--分页--%>
<%-- <div id="page_div"></div>

<div id="pagecount">
   总页数

    <div id="pages"></div>
   总记录数
    <div id="counts"></div>

</div> --%>

</body>
<<!-- script src="./statics/js/layui.js"></script>
<script>
//获取分页记录
    function getPage(){
        $.ajax({
            url: "/System/pagesServlet", //向后端传递参数
            data: {"currentPage": currentPage},
            dataType: "json",
            success: function (data1) {
                var json = eval(data1);
                var pages = json.page;
                var counts = json.count;
                page.innerText = "共" + " " + pages + " " + "页";
                count.innerText = "共" + " " + counts + " " + "条记录";

                //将layui函数放在了ajax函数中
                layui.use('laypage', function () {
                    var laypage = layui.laypage;
                    //alert(datacount);

                    //执行一个laypage实例
                    laypage.render({
                        elem: 'page_div' //注意，这里的 test1 是 ID，不用加 # 号
                        , count: json.count //数据总数，从服务端得到
                        , limit: 8 //每页记录个数
                        , curr: currentPage //现在的页码
                        , hash: true
                        , jump: function (obj, first) {
                            //首次不执行
                            if (!first) {
                                //do something
                                currentPage = obj.curr;//获取点击的页码
                                loadData();
                            }
                        }
                    });
                });
            }
        });
    }
</script>
</script> -->
</html>
