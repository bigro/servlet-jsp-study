<%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>

<p>検索キーワードを入力してください</p>
<form action="/chapter15/search" method="post">
    <input type="text" name="keyword">
    <input type="submit" value="検索">
</form>

<%@ include file="../footer.html" %>