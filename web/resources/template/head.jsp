<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
    <head>
        <title>LIT Realty| ${page}</title>
        <link href="../../css/myStyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Realist Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <!-- Custom Theme files -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link href='http://fonts.googleapis.com/css?family=Grand+Hotel:400' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet:100,300,400,500,600,700,800,900' type='text/css'>
        <!-- Menu -->
        <script src="js/responsiveslides.min.js"></script>
        <script src="../../js/scripts.js" type="text/javascript"></script>
        <script>
            $(function () {
                $("#slider").responsiveSlides({
                    auto: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });

            $(document).ready(function () {
                $('#myCarousel').carousel({
                    interval: 10000
                })
            });
        </script>
        <!----font-Awesome----->
        <link rel="stylesheet" href="fonts/css/font-awesome.min.css">
        <!----font-Awesome----->
        <script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#horizontalTab').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion           
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                });
            });
        </script>	
    </head>
    <body>
        <div class="header">
            <div class="col-xs-4">
                <div class="logo">
                    <a href="Index"><img src="images/logo.png" alt=""/></a>
                </div>
            </div>
            <div class="col-xs-8 header_right">
                <span class="menu"></span>
                <div class="top-menu">
                    <ul>
                        <li><a class="active scroll" href="Index"><i class="fa fa-home"> </i>Home</a></li>
                        <li><a href="about.jsp"><i class="fa fa-star"> </i> About</a></li>
                        <li><a href="Agents"><i class="fa fa-user"> </i>Agents</a></li>
                        <li><a href="services.jsp"><i class="fa fa-thumbs-up"> </i>Services</a></li>
                            <shiro:guest>
                            <li><a href="login.jsp" ><i class="fa fa-sign-in"> </i>Login</a></li>
                            </shiro:guest>
                            <shiro:user>
                            <li><a href="logout" ><i class="fa fa-sign-out"> </i>Logout</a></li>

                            <li><a href="AgentProfile" ><i class="fa fa-user"> </i>Profile</a></li>
                
                        </shiro:user>






                        <li><a href="Favorites"><i class="fa fa-star"> </i>Favorites</a></li>
                        <li><a href="contact.jsp"><i class="fa fa-envelope-o"> </i>Contact</a></li>

                    </ul>
                </div>
                <!-- script for menu -->
                <script>
                    $("span.menu").click(function () {
                        $(".top-menu").slideToggle("slow", function () {
                            // Animation complete.
                        });
                    });
                </script>
                <!-- script for menu -->
            </div>
            <div class="clearfix"> </div>
        </div>





