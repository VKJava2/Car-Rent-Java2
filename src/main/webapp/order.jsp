<%@ page import="lv.javaguru.java2.domain.Motorcycle" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.domain.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
		<h1>Order details</h1>
        <%
            Order order = (Order)request.getAttribute("model");
            if(order != null) {
        %>

        <table border="1">
            <tr>
                <th>Make</th>
                <th>Model</th>
                <th>Rent untill</th>
                <th>Rent price</th>
                <th>Vehicle rent total</th>
                <th>Accessories Total</th>
            </tr>
            <tr align="center">
                <td><%=order.getMake()%></td>
                <td><%=order.getModel()%></td>
                <td><%=order.getRentUntill()%></td>
                <td><%=String.format("%.2f", order.getRentPrice())%></td>
                <td><%=String.format("%.2f", order.getRentAmount())%></td>
                <td><%=String.format("%.2f", order.getAccessoriesTotal())%></td>
            </tr>
            <tr align="right">
                <th colspan="5">Grand Total</th>
                <td><%=String.format("%.2f", order.getGrandTotal())+ " EUR"%></td>
            </tr>
        </table>

        <br>
        <a href="/java2/index.jsp">Home</a>

        <%}
        else
        {%>
        <h2>Error occured</h2><%
            }
        %>
</body>
</html>
