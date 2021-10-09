<%--
  Created by IntelliJ IDEA.
  User: goodsir
  Date: 2021/8/31
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--BootStrap 美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small>新增书籍</small>
            </h1>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bkName">书籍名称:</label>
            <input type="text" name="bookName" class="form-control" id="bkName" required>
        </div>

        <div class="form-group">
            <label for="bkCounts">书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" id="bkCounts" required>
        </div>

        <div class="form-group">
            <label for="bkDetail">书籍描述:</label>
            <input type="text" name="detail" class="form-control" id="bkDetail" required>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">提交</button>
        </div>
    </form>

</div>

</body>
</html>
