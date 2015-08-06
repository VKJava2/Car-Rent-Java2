<%@ page import="lv.javaguru.java2.domain.Motorcycle" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Motorcycles list</title>
</head>
<body>
		<h1>Congratz, some bikes are still available for rent</h1>
        <%
            List<Motorcycle> motorcycles = (List<Motorcycle>)request.getAttribute("model");
            if(motorcycles != null) {
        %>
        <h2>Available bikes</h2>
        <table border="1">
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
