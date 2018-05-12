<%@ page import="book.bean.Product" %><%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html" %>

<% Product product = (Product)request.getAttribute("product"); %>

<%=product.getId()%> : <%=product.getName()%> : <%=product.getPrice()%><br>

<%@ include file="footer.html" %>