<%@ page import="lv.javaguru.java2.domain.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Car found</title>
</head>
<body>

    <%
        Car car = (Car)request.getAttribute("model");
        if(car != null) {
			%>
		<h1>Car found!!!</h1>
		<ul>
		<li><%=car.getMake()%></li>
		<li><%=car.getModel()%></li>
		<li><%=car.getProductionYear()%></li>
		</ul>
		<%}
		else
		{%>
			<h1>Error occured</h1><%
		}
    %>

</body>
</html>
