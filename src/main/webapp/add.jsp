<%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.html" %>

<%!
    int add(int a, int b) {
        return a + b;
    }
%>

<p>1+2=<%=add(1, 2)%></p>
<p>3+4=<%=add(3, 4)%></p>

<%@ include file="footer.html" %>