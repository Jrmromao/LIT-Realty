
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LIT Realty| Agent Login</title>
        <link href="css/adminCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/myStyle.css" rel="stylesheet" type="text/css"/>
        <script src="js/scripts.js" type="text/javascript"></script>
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


        <style>


        </style>



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

        ${alert}
    </head>

    <body>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


        <div class="container">    

            <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3"> 


                <a href="Index"><img src="resources/images/site/logo.gif" alt="" class="center-block"/></a>
                <br>
                <br>

                <br>
                <div class="panel panel-default" >

                    <div class="panel-heading">
                        <div class="panel-title text-center">LIT Realty</div>
                    </div>     

                    <div class="panel-body" >

                        <form name="form" id="form" class="form-horizontal"  method="POST" action="AgentLoginServlet">

                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input id="username" type="text" class="form-control" name="username" placeholder="User">                                        
                            </div>

                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                            </div>                                                                  
                            <p class="danger">${message}</p>
                            <label>
                                Remember Me
                                <input type="checkbox" id="rememberMe" name="rememberMe" value="true" />
                            </label>


                            <div class="form-group">
                               
                                <!-- Button -->
                                <div class="col-sm-12 controls">
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                                </div>
                            </div>

                        </form>     

                    </div>                     
                </div>  
            </div>
        </div>

        <div id="particles"></div>


    </body>




