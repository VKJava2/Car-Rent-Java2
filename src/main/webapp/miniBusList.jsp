<%@ page import="lv.javaguru.java2.domain.MiniBus" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: XidenT
  Date: 10/08/2015
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mini bus list for rent:</title>
</head>
<body>

<%
  List<MiniBus> miniBuses = (List<MiniBus>)request.getAttribute("model");
  if(miniBuses != null) {
%>

<h1>Please find below list of mini buses currently available for rent:</h1>

<table border="3">
  <%for(MiniBus miniBus : miniBuses) { %>
  <tr>
    <td><%=miniBus.getMake()%></td>
    <td><%=miniBus.getModel()%></td>
    <td><%=miniBus.getProductionYear()%></td>
    <td><%=miniBus.getEngineCapacity()%></td>
    <td><%=miniBus.getFuelType()%></td>
    <td><%=miniBus.getFuelConsumption()%></td>
    <td><%=miniBus.getRentPrice()%></td>
    <td><%=miniBus.isAvailable()%></td>
    <td><%=miniBus.getSeatNumber()%></td>
    <td><%=miniBus.getCargoVolume()%></td>
    <td><%=miniBus.getMiniBusColor()%></td>
  </tr>
  <%}%>
</table>
<%}
else
{%>
<h2>No available mini buses found, sorry. Please try again later.</h2><%
  }
%>
</body>
</html>
