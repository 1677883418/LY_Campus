<%--
  Created by IntelliJ IDEA.
  User: goodsir
  Date: 2021/8/31
  Time: 下午3:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍信息</title>
    <%--BootStrap 美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small>修改书籍</small>
            </h1>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <%--出现的问题,我们提交了sql请求,但是修改失败,考虑方向:1.事务提交 2.SQL执行失败,修改不成功--%>
        <%--前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${QBooks.bookID}">
        <div class="form-group">
            <label for="bkName">书籍名称:</label>
            <input type="text" name="bookName" class="form-control" id=
                    "bkName" value="${QBooks.bookName}" required>
        </div>

        <div class="form-group">
            <label for="bkCounts">书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" id="bkCounts" value="${QBooks.bookCounts}"
                   required>
        </div>

        <div class="form-group">
            <label for="bkDetail">书籍描述:</label>
            <input type="text" name="detail" class="form-control" id="bkDetail" value="${QBooks.detail}" required>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">修改</button>
        </div>
    </form>
</div>

</body>
</html>
