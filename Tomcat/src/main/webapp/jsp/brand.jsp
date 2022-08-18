<%@ page import="JSP.Brand" %><%--导入--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Fzd
  Date: 2022/7/8
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--使用JSP脚本展示java集合中的数据--%>
    <%
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"三只松鼠，好吃不上火",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"优衣库，服适人生",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"为发烧而生",1));
    %>

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

        <%
            for (Brand b : brands) {
        %>
        <tr align="center">
            <%--out.print() 打印到html页面--%>
            <td><%=b.getId()%></td>
            <td><%=b.getBrandName()%></td>
            <td><%=b.getCompanyName()%></td>
            <td><%=b.getOrdered()%></td>
            <td><%=b.getDescription()%></td>
            <td><%=b.getStatus() == 1 ? "启用" : "关闭"%></td>
            <td><a href="#">修改</a> <a href="#">删除</a></td>
        </tr>
        <% //连接for循环
            }
        %>
    </table>
</body>
</html>
