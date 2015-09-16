<%@ page import="lv.javaguru.java2.domain.Motorcycle" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Accessory" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.domain.Vehicle" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Map<String, Object> preOrderData = (Map<String, Object>)request.getAttribute("model");
    Vehicle currentVehicle = (Vehicle) preOrderData.get("vehicle");
    List<Accessory> accessories = (List<Accessory>)preOrderData.get("accessories");
    Map<String,String> vehicleSpecials = (HashMap<String,String>)preOrderData.get("specials");
    if(currentVehicle != null) {
%>
<div style="width:250px; float:left; height:100px; border:1px solid #000; vertical-align: middle;text-align: center">
    <h2><%=currentVehicle.getMake()%></h2>
    <h3><%=currentVehicle.getModel()%></h3>
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
        <input type="hidden" name="VehicleId" value="<%=currentVehicle.getCarId()%>">
        <input type="hidden" name="VehicleType" value="<%=currentVehicle.getVehicleType()%>">
        <br><br>
        <input type="submit" value="Order">
    </form>

</div>

<div style="height:15px; clear: left">

</div>

<div style="clear: left">
    <ul>
        <li><b>Production year:</b> <%=currentVehicle.getProductionYear()%></li>
        <li><b>Engine capacity:</b> <%=currentVehicle.getEngineCapacity()%></li>
        <li><b>Fuel type:</b> <%=currentVehicle.getFuelType()%></li>
        <li><b>Fuel consumption:</b> <%=currentVehicle.getFuelConsumption()%></li>
        <li><b>Rent price:</b> <%=String.format("%.2f", currentVehicle.getRentPrice())%></li>
        <%
			for (Map.Entry<String, String> entry : vehicleSpecials.entrySet()) {
		%>
					<li><b><%= entry.getKey() %>:</b> <%= entry.getValue() %></li>
		<%
			}
    	%>
    </ul>
</div>

<%}%>
</body>
</html>
