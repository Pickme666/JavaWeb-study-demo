<%--
  Created by IntelliJ IDEA.
  User: Fzd
  Date: 2022/7/8
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--引入JSTL标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>TitleTitle</title>
</head>
<body>

    <%--
        JSP标准标签库 JSPL (Jsp Standarded Tag Library) ，使用标签取代JSP页面上的Java代码。
    --%>

    <%-- c:if 标签用来完成逻辑判断，可以结合EL表示式使用 --%>
    <c:if test="${status == 1}">
        <h3>启用</h3>
    </c:if>
    <%-- c:if 标签没有else --%>
    <c:if test="${status == 0}">
        <h3>禁用</h3>
    </c:if>

    <table border="1" cellspacing="0" width="800">
        <tr>
            <th>序号</th>
            <th>品牌名称</th>
            <th>企业名称</th>
            <th>排序</th>
            <th>品牌介绍</th>
            <th>状态</th>
            <th>操作</th>
        </tr>

    <%-- c:forEach 类似于Java中的增强for循环
            items：被遍历的容器
            var：遍历产生的临时变量
            varStatus：遍历状态对象
                * index 从0开始
                * count 从1开始
    --%>
    <c:forEach var="b" items="${brands}" varStatus="sort">
        <tr align="center">
            <td>${sort.index}</td>
            <td>${b.brandName}</td> <%-- 根据属性名称自动解析成对应方法 b.getBrandName --%>
            <td>${b.companyName}</td>
            <td>${b.ordered}</td>
            <td>${b.description}</td>
            <td>
                <c:if test="${b.status == 1}">
                    启用
                </c:if>
                <c:if test="${b.status == 0}">
                    禁用
                </c:if>
            </td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
    </c:forEach>
    </table>
    <br>

    <%-- c:forEach 也可以按Java中的普通for循环使用, 属性如下
            begin：开始数
            end：结束数
            step：步长
    --%>
    <%--从0循环到10，变量名是 i ，每次自增1--%>
    <c:forEach begin="0" end="10" step="1" var="i">
        <a href="">${i}</a>
    </c:forEach>
</body>
</html>
