<%@ page import="lv.javaguru.java2.domain.Motorcycle" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Motorcycles list</title>
</head>
<body>
    <%
        List<Motorcycle> motorcycles = (List<Motorcycle>)request.getAttribute("model");
        if(!motorcycles.isEmpty()) {
    %>
    <h2>Available bikes</h2>
    <table border="1">
        <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Production year</th>
            <th>Engine capacity</th>
            <th>Fuel type</th>
            <th>Fuel consumption</th>
            <th>Rent price</th>
            <th>Availability</th>
            <th>Engine by strokes</th>
            <th>Drive type</th>
            <th>Motorcycle type</th>
            <th>Proceed with order</th>
        </tr>

        <%for(Motorcycle motorcycle : motorcycles) { %>
            <tr>
                <td><%=motorcycle.getMake()%></td>
                <td><%=motorcycle.getModel()%></td>
                <td><%=motorcycle.getProductionYear()%></td>
                <td><%=motorcycle.getEngineCapacity()%></td>
                <td><%=motorcycle.getFuelType()%></td>
                <td><%=motorcycle.getFuelConsumption()%></td>
                <td><%=motorcycle.getRentPrice()%></td>
                <td><%=motorcycle.isAvailable()%></td>
                <td><%=motorcycle.getEngineTypeByStrokes()%></td>
                <td><%=motorcycle.getDriveType()%></td>
                <td><%=motorcycle.getMotorcycleType()%></td>
                <%if(motorcycle.isAvailable()){%>
                    <td align="center"><a href="/java2/preOrder?id=<%=motorcycle.getCarId()%>">Proceed</a></td>
                <%}else{%>
                    <td></td>
                <%}%>
            </tr>
        <%}%>
    </table>
    <%}
    else
    {%>
    <h2>Error occured</h2><%
        }
    %>

</body>
</html>
