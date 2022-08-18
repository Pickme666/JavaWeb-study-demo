<%--
  Created by IntelliJ IDEA.
  User: Fzd
  Date: 2022/7/8
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello jsp</title>
</head>
<body>

<%--JSP（全称：Java Server Pages）：Java 服务端页面。
    是一种动态的网页技术，其中既可以定义 HTML、JS、CSS等静态内容，还可以定义 Java代码的动态内容，也就是 JSP = HTML + Java
    JSP 原理：
        1. 浏览器第一次访问 hello.jsp 页面
        2. tomcat 会将 hello.jsp 转换为名为 hello_jsp.java 的一个 Servlet
        3. tomcat 再将转换的 servlet 编译成字节码文件 hello_jsp.class
        4. tomcat 会执行该字节码文件，向外提供服务
        可以说 JSP 本质上就是一个 Servlet。
    JSP 脚本有如下三个分类：
        <%...%>：内容会直接放到_jspService()方法之中
        <%=…%>：内容会放到out.print()中，作为out.print()的参数
        <%!…%>：内容会放到_jspService()方法之外，被类直接包含
--%>

    <h1>Hello JSP</h1>

    <%
        System.out.println("hello jsp");
        String s = "南华";
    %>

    <%="垃圾"%>
    <%=s%>

    <%!
        void go(){}
        int sum = 1;
    %>

</body>
</html>
