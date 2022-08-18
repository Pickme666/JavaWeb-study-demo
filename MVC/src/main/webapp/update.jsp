<%--
  Created by IntelliJ IDEA.
  User: Fzd
  Date: 2022/7/9
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改品牌</title>
</head>
<body>
    
    <%-- 数据回显 --%>
    
    <div style="margin: 30px 0 0 40px">
        <h3>修改品牌</h3>
        <form action="/MVC/update" method="post">
            
            <%--隐藏域，提交id--%>
            <input type="hidden" name="id" value="${brand.id}">
            
            品牌名称：
            <input name="brandName" value="${brand.brandName}"><br><br>
            企业名称：
            <input name="companyName" value="${brand.companyName}"><br><br>
            排序：
            <input name="ordered" style="margin-left: 32px" value="${brand.ordered}"><br><br>
            描述信息：
            <textarea rows="5" cols="20" name="description">${brand.description}</textarea><br><br>
            
            状态：
            <c:if test="${brand.status == 0}">
                <input type="radio" name="status" value="0" style="margin-left: 30px" checked>禁用
                <input type="radio" name="status" value="1" style="margin-left: 20px">启用<br><br>
            </c:if>
            <c:if test="${brand.status == 1}">
                <input type="radio" name="status" value="0" style="margin-left: 30px">禁用
                <input type="radio" name="status" value="1" style="margin-left: 20px" checked>启用<br><br>
            </c:if>
            
            <input type="submit" value="提交" style="width: 100px; height: 30px">
        </form>
    </div>
</body>
</html>
