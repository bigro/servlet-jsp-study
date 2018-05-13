<%@ page import="book.bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>購入数を選択してください</p>
<form action="select" method="post">
    <select name="count">
        <c:forEach var="i" begin="1" end="9">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>

    <p><input type="submit" value="確定"></p>
</form>

<%@ include file="../footer.html" %>