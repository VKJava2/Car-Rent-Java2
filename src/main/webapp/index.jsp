
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
                    <a class="navbar-brand pull-left" href="./"><img id="logoImage"  width="auto" height="40" src="images/car_rent_logo.png" alt="Cash & Drive Rentals"></a>  
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#">Home1</a></li>
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
            <div class="row-full-width row-bottom-margin">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                    <div class="well well-lg text-center">
                        <form role="form" class="form-inline" method="post" action="./booking.php">
                            <div class="form-group">
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                                    <select  class="form-control input-large" name="vehicleType" id="defaultVehicle" onchange="selectChain();">
                                        <option value="empty" selected>Vehicle Type</option>
                                        <option value="volvo">Bike</option>
                                        <option value="saab">Personal</option>
                                        <option value="fiat">Passenger</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
                                    <select  class="form-control input-large" name="vehicleModel" id="defaultModel" disabled>
                                        <option value="empty" selected>Vehicle Model</option>
                                        <option value="volvo">Volvo</option>
                                        <option value="saab">Mercedes</option>
                                        <option value="fiat">BMW</option>
                                        <option value="audi">Audi</option>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary" name="fast_order">BOOK NOW</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row row-bottom-margin">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
                    <!-- ============================== MAIN CONTENT BOX START ======================================= -->

                    <div class="panel">
                        <a href="./motorcycles" target="_self" alt="Rent a Bike"><img src="images/bikes.jpg" class="img-responsive" height="auto" width="auto" alt="Rent a Bike"></a>
                        <div class="caption text-center">
                            <a href="./motorcycles" target="_self" alt="Rent a Bike"><h3>Bikes</h3></a>
                            <p class="text-justify">
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                            </p>
                        </div>
                    </div>

                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
                    <div class="panel">
                        <a href="./personalcars" target="_self" alt="Rent a Personal vehicle"><img src="images/sedan.jpg" class="img-responsive" height="auto" width="auto" alt="Rent a Personal vehicle"></a>
                        <div class="caption text-center">
                            <a href="./personalcars" target="_self" alt="Rent a Personal vehicle"><h3>Personal vehicles</h3></a>
                            <p class="text-justify">
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4">
                    <div class="panel">
                        <a href="./minibuses" target="_self" alt="Rent a Passenger vehicle"><img src="images/passenger.jpg" class="img-responsive" height="auto" width="auto" alt="Rent a Passenger vehicle"></a>
                        <div class="caption text-center">
                            <a href="./minibuses" target="_self" alt="Rent a Passenger vehicle"><h3>Passenger vehicles</h3></a>
                            <p class="text-justify">
                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                            </p>
                        </div>
                    </div>
                    <!-- ============================== MAIN CONTENT BOX END ======================================= -->
                </div>
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