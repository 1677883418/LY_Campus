<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: goodsir
  Date: 2021/8/30
  Time: 下午12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>书籍展示</title>
    <%--BootStrap 美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small>书籍列表 ——————显示所有书籍</small>

            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <%--toAddBook--%>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示所有书籍</a>
        </div>
        <div class="col-md-4"></div>
        <div class="col-md-4 column">
            <%--查询书籍--%>
            <form action="${pageContext.request.contextPath}/book/queryBook" method="post"
                  style="float: right"
                  class="form-inline">
                <span style="color: red;font-weight: bold">${error}</span>
                <input type="text" name="bookName" class="form-control" placeholder="请输入要查询的书籍名称">
                <input type="submit" value="查询" class="btn btn-primary ">
            </form>
        </div>
    </div>

</div>

<div class="row clearfix">
    <div class="col-md-12 column">
        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th>书籍编号</th>
                <th>书籍名称</th>
                <th>书籍数量</th>
                <th>书籍详情</th>
                <th>操作</th>
            </tr>
            </thead>
            <%--书籍从数据库中查询出来,从books中遍历出来--%>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.bookCounts}</td>
                    <td>${book.detail}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/toUpdate?id=${book.bookID}"
                           class="btn btn-primary">修改</a>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}"
                           class="btn btn-default">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
