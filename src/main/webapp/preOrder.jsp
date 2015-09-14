<%@ page import="lv.javaguru.java2.domain.Motorcycle" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Accessory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Map<String, Object> preOrderData = (Map<String, Object>)request.getAttribute("model");
    Motorcycle motorcycle = (Motorcycle)preOrderData.get("motorcycle");
    List<Accessory> accessories = (List<Accessory>)preOrderData.get("accessories");
    if(motorcycle != null) {
%>
<div style="width:250px; float:left; height:100px; border:1px solid #000; vertical-align: middle;text-align: center">
    <h2><%=motorcycle.getMake()%></h2>
    <h3><%=motorcycle.getModel()%></h3>
</div>

<div style="width:50px; float:left; height:100px">

</div>

<div style="width:250px; float:left; height:100px">

    <form action="order" method="post">
        <%for(Accessory accessory : accessories) { %>
            <input type="checkbox" name="<%=accessory.getAccessory()%>" value="<%=accessory.getAccessoryId()%>"><%=accessory.getAccessory()%>
            <br>
        <%}%>
        Rent untill:
        <input type="date" name="Untill">
        <input type="hidden" name="VehicleId" value="<%=motorcycle.getCarId()%>">
        <input type="hidden" name="VehicleType" value="Motorcycle">
        <br><br>
        <input type="submit" value="Order">
    </form>

</div>

<div style="height:15px; clear: left">

</div>

<div style="clear: left">
    <ul>
        <li><b>Production year:</b> <%=motorcycle.getProductionYear()%></li>
        <li><b>Engine capacity:</b> <%=motorcycle.getEngineCapacity()%></li>
        <li><b>Fuel type:</b> <%=motorcycle.getFuelType()%></li>
        <li><b>Fuel consumption:</b> <%=motorcycle.getFuelConsumption()%></li>
        <li><b>Rent price:</b> <%=String.format("%.2f", motorcycle.getRentPrice())%></li>
        <li><b>Engine by strokes:</b> <%=motorcycle.getEngineTypeByStrokes()%></li>
        <li><b>Drive type:</b> <%=motorcycle.getDriveType()%></li>
        <li><b>Motorcycle type:</b> <%=motorcycle.getMotorcycleType()%></li>
    </ul>
</div>

<%}%>
</body>
</html>
