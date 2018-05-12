<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ooguro
  Date: 2018/05/09
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.html" %>
<%
    int[] array = {0, 1, 2};
    request.setAttribute("array", array);

    List<String> list = new ArrayList<>();
    list.add("zero");
    list.add("one");
    list.add("two");
    request.setAttribute("list", list);

    HashMap<String, String> map = new HashMap<>();
    map.put("zero", "零");
    map.put("one", "壱");
    map.put("two", "弐");
    request.setAttribute("map", map);

%>

${array[1]}<br>
${list[2]}<br>
${map.two}

<%@ include file="../footer.html" %>