<%@ page import="lv.javaguru.java2.domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: XidenT
  Date: 09/09/2015
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Name</title>
</head>
<body>
<%
  User user = (User)request.getAttribute("UserName");
  if(user != null) {
%>
<h1>User your were looking for is found:</h1>
<ul>
  <li><%=user.getUserId()%></li>
  <li><%=user.getFirstName()%></li>
  <li><%=user.getLastName()%></li>
  <li><%=user.getUserName()%></li>
  <li><%=user.getPhoneNr()%></li>
  <li><%=user.getEmail()%></li>
  <li><%=user.getBankAccNr()%></li>
</ul>
<%}
else
{%>
<h1>User stored by entered user name is not found!</h1><%
  }
%>
</body>
</html>
