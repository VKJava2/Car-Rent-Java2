<%@ page import="lv.javaguru.java2.domain.MiniBus" %>
<%--
  Created by IntelliJ IDEA.
  User: XidenT
  Date: 10/08/2015
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicle ID</title>
</head>
<body>
<%
  MiniBus miniBus = (MiniBus)request.getAttribute("VehicleID");
  if(miniBus != null) {
%>
<h1>Vehicle your were looking for is found:</h1>
<ul>
  <li><%=miniBus.getVehicleType()%></li>
  <li><%=miniBus.getMake()%></li>
  <li><%=miniBus.getModel()%></li>
  <li><%=miniBus.getProductionYear()%></li>
  <li><%=miniBus.getEngineCapacity()%></li>
  <li><%=miniBus.getFuelConsumption()%></li>
  <li><%=miniBus.getFuelType()%></li>
  <li><%=miniBus.getRentPrice()%></li>
</ul>
<%}
else
{%>
<h1>Vehicle stored by entered ID is not found!</h1><%
  }
%>
</body>
</html>
