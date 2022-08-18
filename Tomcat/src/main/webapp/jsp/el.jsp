<%--
  Created by IntelliJ IDEA.
  User: Fzd
  Date: 2022/7/8
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <%--
        EL（全称Expression Language ）表达式语言，用于简化 JSP 页面内的 Java 代码。
        主要功能从域对象中获取数据，然后将数据展示在页面上。
        语法: ${expression} 。例如：${brands} 就是获取域中存储的 key 为 brands 的数据。
        JavaWeb中有四大域对象，el表达式获取数据会依次从这4个域中寻找，直到找到为止。分别是：
            page：当前页面有效（不常用， 范围太小）
            request：当前请求有效
            session：当前会话有效
            application：当前应用有效（不常用， 范围太大）
        四个域对象的作用范围从小到大 (page -> application)
    --%>

    ${brands}
    <%--获取域中的brands数据--%>

</body>
</html>
