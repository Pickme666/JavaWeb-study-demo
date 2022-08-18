<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--引入JSTL标签库--%>

<html>
<head>
    <title>品牌企业</title>
</head>
<body>
    <h2>欢迎 ${username}</h2><br>
    <input type="button" value="新增" id="add"><br>
    <hr>

    <table border="1" cellspacing="0" width="1000">
        <tr style="height: 40px">
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach var="b" items="${brands}" varStatus="sort">
            <tr align="center" style="height: 30px">
                <td>${sort.count}</td>
                <td>${b.brandName}</td> <%-- 根据属性名称自动解析成对应方法 b.getBrandName --%>
                <td>${b.companyName}</td>
                <td>${b.ordered}</td>
                <td style="width: 400px">${b.description}</td>
                <td>
                    <c:if test="${b.status == 1}">
                        启用
                    </c:if>
                    <c:if test="${b.status == 0}">
                        禁用
                    </c:if>
                </td>
                <td><a href="selectById?id=${b.id}">修改</a>&nbsp;&nbsp;<a href="delete?id=${b.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <script>
        document.getElementById("add").onclick = function () {
            location.href = "add_brand.html";
        }
    </script>
</body>
</html>
