<%@page import="lv.javaguru.*" %>
<%@ page import="lv.javaguru.java2.domain.PersonalCar" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.domain.Vehicle" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Accessory" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>"Cash & Drive" rentals</title>
    <!-- Bootstrap core CSS -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/user_style.css" rel="stylesheet">
    <link href="bootstrap/css/navbar_style.css" rel="stylesheet">
</head>
<body class="new-bg">
<script>
    window.onresize = logoSizeOnWindowResize;
</script>

<!-- ============================== TOP STICKY NAVIGATION BAR START ======================================= -->

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand pull-left" href="./"><img id="logoImage" width="auto" height="40"
                                                             src="images/car_rent_logo.png" alt="Cash & Drive Rentals"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="./">Home</a></li>
                <li><a href="#">Our Cars</a></li>
                <li><a href="#">Conacts</a></li>
                <li><a href="#">About Us</a></li>
                <li><span style="padding-left:30px"></span></li>
            </ul>
        </div>
    </div>
</nav>

<!-- ============================== TOP STICKY NAVIGATION BAR END ======================================= -->

<div class="container-fluid">
    <div class="row row-bottom-margin">
        <!-- ============================== HEADER START ======================================= -->

        <img src="images/header_panorama.jpg" class="img-responsive" height="100%" width="auto">

        <!-- ============================== HEADER END ======================================= -->
    </div>
    <!-- ============================== MAIN CONTENT BOX START ======================================= -->
    <div class="row">
        <div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
            <!-- ============================== ACCORDEON MENU START ======================================= -->

            <div id="mainmenu">
                <div class="panel list-group">
                    <a href="#infoList1" class="list-group-item active" data-toggle="collapse" data-parent="#mainmenu">
                        <span class="glyphicon glyphicon-expand"></span> Bikes
                    </a>

                    <div class="sublinks collapse in" id="infoList1">
                        <a href="#" class="list-group-item small">Street bikes</a>
                        <a href="#" class="list-group-item small">Choppers</a>
                        <a href="#" class="list-group-item small">Cruisers</a>
                    </div>
                    <a href="#infoList2" class="list-group-item active" data-toggle="collapse" data-parent="#mainmenu">
                        <span class="glyphicon glyphicon-expand"></span> Personal auto
                    </a>

                    <div class="sublinks collapse" id="infoList2">
                        <a href="#" class="list-group-item small">Lux cars (sedan)</a>
                        <a href="#" class="list-group-item small">SUV auto</a>
                        <a href="#" class="list-group-item small">Universals</a>
                        <a href="#" class="list-group-item small">Family auto</a>
                    </div>
                    <a href="#infoList3" class="list-group-item active" data-toggle="collapse" data-parent="#mainmenu">
                        <span class="glyphicon glyphicon-expand"></span> Passenger auto
                    </a>

                    <div class="sublinks collapse" id="infoList3">
                        <a href="#" class="list-group-item small">Passenger 1</a>
                        <a href="#" class="list-group-item small">Passenger 2</a>
                        <a href="#" class="list-group-item small">Passenger 3</a>
                    </div>
                </div>
            </div>

            <!-- ============================== ACCORDEON MENU END ======================================= -->

            <div class="panel">
                <h3 class="text-center">Most popular</h3>

                <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor
                    mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna
                    mollis euismod. Donec sed odio dui. </p>

                <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
            </div>
        </div>
        <!-- ============================== MAIN CONTENT BOX START ======================================= -->
        <div class="col-xs-12 col-sm-7 col-md-8 col-lg-8">
            <!-- JSP Injection to output list of chosen vehicle type -->
            <%
                Map<String, Object> preOrderData = (Map<String, Object>)request.getAttribute("model");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String todayDate = dateFormat.format(new Date());
                Vehicle currentVehicle = (Vehicle) preOrderData.get("vehicle");
                List<Accessory> accessories = (List<Accessory>)preOrderData.get("accessories");
                Map<String,String> vehicleSpecials = (HashMap<String,String>)preOrderData.get("specials");
                if(currentVehicle != null) {
                    String image = "car_foto_500x333.png";
                    if(!currentVehicle.getImage().isEmpty() || !currentVehicle.getImage().equals("empty")) {
                        image = currentVehicle.getImage();
                    }
            %>
            <div class="thumbnail">
                    <div class="container-fluid">
                        <div class="col-xs-12 col-sm-12 col-md-5 col-lg-5">
                            <img src="./images/carimages/thumbs/<%= image %>" class="img-responsive" alt="-= Car Name =-">
                        </div>
                        <div class="col-md-1 col-lg-1">
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">

                            <h3>VEHICLE INFORMATION</h3>
                            <h4><%=currentVehicle.getMake() + " " + currentVehicle.getModel()%></h4>
                            <ul>
                                <li><b>Production year:</b> <%=currentVehicle.getProductionYear()%></li>
                                <li><b>Engine capacity:</b> <%=currentVehicle.getEngineCapacity()%> l</li>
                                <li><b>Fuel type:</b> <%=currentVehicle.getFuelType()%></li>
                                <li><b>Fuel consumption:</b> <%=currentVehicle.getFuelConsumption()%> l/100km</li>
                                <li><b>Rent price:</b> <%=String.format("%.2f", currentVehicle.getRentPrice())%> Euro/Day</li>
                                <%
                                    for (Map.Entry<String, String> entry : vehicleSpecials.entrySet()) {
                                %>
                                <li><b><%= entry.getKey() %>:</b> <%= entry.getValue() %></li>
                                <%
                                    }
                                %>
                            </ul>

                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <br />
                            <form  role="form" action="order" method="post">
                                <div class="form-group">

                                        <h3>Available accessories</h3>
                                        <%for(Accessory accessory : accessories) { %>
                                            <div class="checkbox">
                                                <label><input type="checkbox" name="<%=accessory.getAccessory()%>" value="<%=accessory.getAccessoryId()%>"><%=accessory.getAccessory()%><span style="color: firebrick; font-weight: 600;"> extra  fees per day <%=accessory.getRentPrice()%> Euro</span></label>
                                            </div>
                                        <%}%>
                                    </ul>
                                    Rent until date<span style="color: #c12e2a; font-weight: 600">*</span>:<input type="date" name="Untill" class="form-control">
                                    <input type="hidden" class="form-control" name="VehicleId" value="<%=currentVehicle.getCarId()%>">
                                    <input type="hidden" class="form-control" name="VehicleType" value="<%=currentVehicle.getVehicleType()%>">
                                </div>

                                <p class="pull-right"><a href="./" class="btn btn-success btn-responsive" role="button" name="booking">  BACK  </a>
                                    <%
                                        String bookBtnIsActive = "";
                                        if(!currentVehicle.isAvailable()) {
                                            bookBtnIsActive = "disabled";
                                        }
                                    %>
                                    <button type="submit" class="btn btn-danger btn-responsive <%= bookBtnIsActive %>" value="Order">MAKE ORDER</button>
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
            <%
                } else {

                }
            %>
            </div>
            <div class="col-sm-3 col-md-2 col-lg-2">
                <div class="panel">
                    <h3 class="text-center">Most popular</h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div>
            <!-- END OF JSP Injection to output list of choosen vehicle type -->
        </div>
        <!-- ============================== MAIN CONTENT BOX END ======================================= -->
    </div>
</div>
<!-- ============================== MAIN CONTENT BOX END ======================================= -->
<!-- ============================== STICKY FOOTER START ============================== -->

<div class="navbar navbar-default navbar-fixed-bottom">
    <p class="navbar-text pull-left">2015 &copy; All rights reserved</p>
    <a class="navbar-btn btn btn-primary pull-right" href="#">Support</a>
</div>

<!-- ============================== STICKY FOOTER END ================================ -->

<!-- ============================== JS SCRIPT INCLUDES START ============================== -->

<script src="bootstrap/js/jquery-1.11.3.min.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="bootstrap/js/user_functions.js"></script>

<!-- ============================== JS SCRIPT INCLUDES END ============================== -->

</body>
</html>