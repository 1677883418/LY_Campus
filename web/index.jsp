<%--
  Created by IntelliJ IDEA.
  User: goodsir
  Date: 2021/8/29
  Time: 下午2:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        a {
            text-decoration: none;
            color: black;
            font-size: 18px;
        }

        h3 {
            width: 180px;
            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: mediumpurple;
            border-radius:5px ;
        }
    </style>
</head>
<body>

<h3>
    <a href="${pageContext.request.contextPath}/Student/allStudent">进入学生信息管理页面</a>
</h3>

</body>
</html>
