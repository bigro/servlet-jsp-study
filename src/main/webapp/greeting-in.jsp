<%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html" %>

<p>名前を入力してください</p>
<form action="greeting-out.jsp" method="post">
    <input type="text" name="user">
    <input type="submit" value="確定">
</form>

<%@ include file="footer.html" %>