<%@page import="lv.javaguru.*" %>
<%@ page import="lv.javaguru.java2.domain.PersonalCar" %>
<%@ page import="java.util.List" %>
<%@ page import="lv.javaguru.java2.domain.Vehicle" %>
<%@ page import="java.util.Map" %>
<%@ page import="lv.javaguru.java2.domain.Accessory" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="lv.javaguru.java2.domain.Order" %>
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

            <div class="thumbnail">
                <h3><i>ORDER DETAILS</i></h3>
                <hr>
                <br>
                <br>
                <br>
                <br>
                <%
                    Order order = (Order)request.getAttribute("model");
                    if(order != null) {
                %>
                <table border="1" style="background-color:#FFFFCC;border-collapse:collapse;border:1px solid #FFCC00;color:#000000;width:100%" cellpadding="3" cellspacing="0">
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Make</td>
                        <td>&nbsp;&nbsp;<%=order.getMake()%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Model</td>
                        <td>&nbsp;&nbsp;<%=order.getModel()%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Rent untill</td>
                        <td>&nbsp;&nbsp;<%=order.getRentUntill()%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Rent price</td>
                        <td>&nbsp;&nbsp;<%=String.format("%.2f", order.getRentPrice())%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Vehicle rent total</td>
                        <td>&nbsp;&nbsp;<%=String.format("%.2f", order.getRentAmount())%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 600; text-align: left;">&nbsp;&nbsp;Accessories Total</td>
                        <td>&nbsp;&nbsp;<%=String.format("%.2f", order.getAccessoriesTotal())%></td>
                    </tr>
                    <tr>
                        <td style="font-weight: 800; text-align: right;">Grand Total&nbsp;&nbsp;</td>
                        <td style="font-weight: 800; text-align: left;">&nbsp;&nbsp;<%=String.format("%.2f", order.getGrandTotal())+ " EUR"%></td>
                    </tr>
                </table>
                <br>
                <p class="pull-right"><a href="./" class="btn btn-success btn-responsive" role="button" name="booking">  BACK  </a></p>

                <br>
                <br>
                <br>
                <br>
                <br>
                <hr>


                <%}
                    else
                    {%>
                <h2>Error occured</h2><%
                }
            %>
            </div>
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