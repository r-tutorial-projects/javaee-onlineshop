<%--
  Created by IntelliJ IDEA.
  User: rubeen
  Date: 02.11.17
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TestSite</title>
</head>
<body>
<%
    String mail = request.getParameter("mail");
    String password = request.getParameter("password");
    if(mail != null)
        out.println(mail);
    System.out.println(mail);

    if (application.getAttribute("n") == null)
        application.setAttribute("n", Integer.valueOf(0));

    Integer n = (Integer) application.getAttribute("n");
    int i = n.intValue() + 1;
    application.setAttribute("n", Integer.valueOf(i));
    out.println("Visits since deployment: " + i);
%>

<jsp:forward page="signin.jsp">
    <jsp:param name="email" value="<%= mail%>"/>
    <jsp:param name="password" value="<%= password%>"/>
</jsp:forward>
</body>
</html>
