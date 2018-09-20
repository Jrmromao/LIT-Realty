<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">


        <title>LIT Realty| ${page}</title>
        ${alert}


        <!-- Bootstrap CSS -->
        <link href="admin/css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="admin/css/bootstrap-theme.css" rel="stylesheet">
        <!--external css-->
        <!-- font icon -->
        <link href="admin/css/elegant-icons-style.css" rel="stylesheet" />
        <link href="admin/css/font-awesome.min.css" rel="stylesheet" />
        <!-- full calendar css-->
        <link href="admin/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />
        <link href="admin/assets/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" />
        <!-- easy pie chart-->
        <link href="admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen" />
        <!-- owl carousel -->
        <link rel="admin/stylesheet" href="css/owl.carousel.css" type="text/css">
        <link href="admin/css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
        <!-- Custom styles -->
        <link rel="admin/stylesheet" href="css/fullcalendar.css">
        <link href="admin/css/widgets.css" rel="stylesheet">
        <link href="admin/css/style.css" rel="stylesheet">
        <link href="admin/css/style-responsive.css" rel="stylesheet" />
        <link href="admin/css/xcharts.min.css" rel=" stylesheet">
        <link href="admin/css/jquery-ui-1.10.4.min.css" rel="stylesheet">
    </head>
    <body>
        <!-- container section start -->
        <section id="container" class="">


            <header class="header dark-bg">
                <div class="toggle-nav">
                    <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
                </div>


                <a href="Index" class="logo"> <img src="images/LIT_LogoNew.png" alt="" width="90"/> </a>

                <!--logo end-->

                <div class="nav search-row" id="top_menu">
                    <!--  search form start -->
                    <ul class="nav top-menu">
                        <li>
                            <form class="navbar-form">
                                <input class="form-control" placeholder="Search" type="text">
                            </form>
                        </li>
                    </ul>
                    <!--  search form end -->
                </div>

                <div class="top-nav notification-row">
                    <!-- notificatoin dropdown start-->
                    <ul class="nav pull-right top-menu">

                        <!-- task notificatoin start -->
                        <li id="task_notificatoin_bar" class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <i class="icon-task-l"></i>
                                <span class="badge bg-important">6</span>
                            </a>
                            <ul class="dropdown-menu extended tasks-bar">

                                <li>
                                    <p class="blue">You have 6 pending letter
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="task-info">
                                            <div class="desc">Design PSD </div>
                                            <div class="percent">90%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">
                                                <span class="sr-only">90% Complete (success)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="task-info">
                                            <div class="desc">
                                                Project 1
                                            </div>
                                            <div class="percent">30%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">
                                                <span class="sr-only">30% Complete (warning)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="task-info">
                                            <div class="desc">Digital Marketing</div>
                                            <div class="percent">80%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                <span class="sr-only">80% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="task-info">
                                            <div class="desc">Logo Designing</div>
                                            <div class="percent">78%</div>
                                        </div>
                                        <div class="progress progress-striped">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" style="width: 78%">
                                                <span class="sr-only">78% Complete (danger)</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <div class="task-info">
                                            <div class="desc">Mobile App</div>
                                            <div class="percent">50%</div>
                                        </div>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">
                                                <span class="sr-only">50% Complete</span>
                                            </div>
                                        </div>

                                    </a>
                                </li>
                                <li class="external">
                                    <a href="#">See All Tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- task notificatoin end -->
                        <!-- inbox notificatoin start-->
                        <li id="mail_notificatoin_bar" class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <i class="icon-envelope-l"></i>
                                <span class="badge bg-important">5</span>
                            </a>
                            <ul class="dropdown-menu extended inbox">
                                <div class="notify-arrow notify-arrow-blue"></div>
                                <li>
                                    <p class="blue">You have 5 new messages</p>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="photo"><img src="resources/images/agents/${agent.getUserId()}.jpg" alt="" /></span>
                                        <span class="subject">
                                            <span class="from">Greg  Martin</span>
                                            <span class="time">1 min</span>
                                        </span>
                                        <span class="message">
                                            I really like this admin panel.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="photo"><img src="resources/images/agents/${agent.getUserId()}.jpg" alt="" /></span>
                                        <span class="subject">
                                            <span class="from">Bob   Mckenzie</span>
                                            <span class="time">5 mins</span>
                                        </span>
                                        <span class="message">
                                            Hi, What is next project plan?
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="photo"><img src="resources/images/agents/${agent.getUserId()}.jpg" alt="" /></span>
                                        <span class="subject">
                                            <span class="from">Phillip   Park</span>
                                            <span class="time">2 hrs</span>
                                        </span>
                                        <span class="message">
                                            I am like to buy this Admin Template.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="photo"><img alt="avatar" src="../img/avatar-mini4.jpg"></span>
                                        <span class="subject">
                                            <span class="from">Ray   Munoz</span>
                                            <span class="time">1 day</span>
                                        </span>
                                        <span class="message">
                                            Icon fonts are great.
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">See all messages</a>
                                </li>
                            </ul>
                        </li>
                        <!-- inbox notificatoin end -->
                        <!-- alert notification start-->
                        <li id="alert_notificatoin_bar" class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                                <i class="icon-bell-l"></i>
                                <span class="badge bg-important">7</span>
                            </a>
                            <ul class="dropdown-menu extended notification">

                                <li>
                                    <p class="blue">You have 4 new notifications</p>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="label label-primary"><i class="icon_profile"></i></span>
                                        Friend Request
                                        <span class="small italic pull-right">5 mins</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="label label-warning"><i class="icon_pin"></i></span>
                                        John location.
                                        <span class="small italic pull-right">50 mins</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="label label-danger"><i class="icon_book_alt"></i></span>
                                        Project 3 Completed.
                                        <span class="small italic pull-right">1 hr</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <span class="label label-success"><i class="icon_like"></i></span>
                                        Mick appreciated your work.
                                        <span class="small italic pull-right"> Today</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">See all notifications</a>
                                </li>
                            </ul>
                        </li>
                        <!-- alert notification end-->
                        <!-- user login dropdown start-->
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="profile-ava">
                                    <img src="resources/images/agents/${agent.getUserId()}.jpg" width="50" alt=""/>
                                </span>
                                <span class="username">${agent.getName()}</span>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu extended logout">
                                <li class="eborder-top">
                                    <a href="AgentProfile"><i class="icon_profile"></i> My Profile</a>
                                </li>
                                <li>
                                    <a href="#"><i class="icon_mail_alt"></i> My Inbox</a>
                                </li>
                                <li>
                                    <a href="#"><i class="icon_clock_alt"></i> Timeline</a>
                                </li>
                                <li>
                                    <a href="#"><i class="icon_chat_alt"></i> Chats</a>
                                </li>
                                <li>
                                    <a href="LogoutServlet"><i class="icon_key_alt"></i> Log Out</a>
                                </li>
                                <li>
                                    <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                                </li>
                                <li>
                                    <a href="documentation.html"><i class="icon_key_alt"></i> Documentation</a>
                                </li>
                            </ul>
                        </li>
                        <!-- user login dropdown end -->
                    </ul>
                    <!-- notificatoin dropdown end-->
                </div>
            </header>
            <!--header end-->

            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a class="" href="adminPage.jsp">
                                <i class="icon_house_alt"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="admin\javascript:;" class="">
                                <i class="icon_document_alt"></i>
                                <span>Forms</span>
                                <span class="menu-arrow arrow_carrot-right"></span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="form_component.html">Form Elements</a></li>
                                <li><a class="" href="form_validation.html">Form Validation</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" class="">
                                <i class="icon_desktop"></i>
                                <span>UI Fitures</span>
                                <span class="menu-arrow arrow_carrot-right"></span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="general.html">Elements</a></li>
                                <li><a class="" href="buttons.html">Buttons</a></li>
                                <li><a class="" href="grids.html">Grids</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="" href="widgets.html">
                                <i class="icon_genius"></i>
                                <span>Widgets</span>
                            </a>
                        </li>
                        <li>
                            <a class="" href="chart-chartjs.html">
                                <i class="icon_piechart"></i>
                                <span>Charts</span>

                            </a>

                        </li>

                        <li class="sub-menu">
                            <a href="admin/javascript:;" class="">
                                <i class="icon_table"></i>
                                <span>Tables</span>
                                <span class="menu-arrow arrow_carrot-right"></span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="basic_table.html">Basic Table</a></li>
                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a href="javascript:;" class="">
                                <i class="icon_documents_alt"></i>
                                <span>Pages</span>
                                <span class="menu-arrow arrow_carrot-right"></span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="profile.html">Profile</a></li>
                                <li><a class="" href="login.html"><span>Login Page</span></a></li>
                                <li><a class="" href="blank.html">Blank Page</a></li>
                                <li><a class="" href="404.html">404 Error</a></li>
                            </ul>
                        </li>

                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="col-lg-9 col-md-12">
                                <div class="panel panel-success">
                                    <div class="panel-heading">
                                        <h2><i class="fa fa-flag-o red"></i><strong> ${agent.getName()}'s properties</strong></h2>
                                    </div>
                                    <div class="panel-body">
                                        <div class="col-lg-10">
                                            <br>
                                            <c:forEach items="${pList}" var="lp">

                                                <div class="row">
                                                    <div class="col-lg-4">
                                                        <h3> <a href="PropDetailServlet?id=${lp.getId()}">${lp.getCity()}</a></h3>
                                                        <a href="PropDetailServlet?id=${lp.getId()}"><img src="resources/images/properties/large/${lp.getListingNum()}/${lp.getListingNum()}.JPG" 
                                                                                                          class="img-responsive"  width="150" height="150" ></a>
                                                    </div>                                       
                                                    <div class="col-lg-6">
                                                        <h3>Owner Details</h3>
                                                      
                                                     
                                                        </div>
                                                    </div>
                                            </c:forEach>
                                            <br> 
                                            <br>
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                    </div>
                                </div>  
                            </div>   
                        </div>  
                        <br>
                    </div>                
                    <!--/col-->
                    <div class="col-md-3">
                        <div class="social-box facebook">
                            <i class="fa fa-facebook"></i>
                            <ul>
                                <li>
                                    <strong>256k</strong>
                                    <span>friends</span>
                                </li>
                                <li>
                                    <strong>359</strong>
                                    <span>feeds</span>
                                </li>
                            </ul>
                        </div>
                        <!--/social-box-->
                    </div>
                    <div class="col-md-3">
                        <div class="social-box google-plus">
                            <i class="fa fa-google-plus"></i>
                            <ul>
                                <li>
                                    <strong>962</strong>
                                    <span>followers</span>
                                </li>
                                <li>
                                    <strong>256</strong>
                                    <span>circles</span>
                                </li>
                            </ul>
                        </div>
                        <!--/social-box-->
                    </div>
                    <!--/col-->
                    <div class="col-md-3">
                        <div class="social-box twitter">
                            <i class="fa fa-twitter"></i>
                            <ul>
                                <li>
                                    <strong>1562k</strong>
                                    <span>followers</span>
                                </li>
                                <li>
                                    <strong>2562</strong>
                                    <span>tweets</span>
                                </li>
                            </ul>
                        </div>
                        <!--/social-box-->
                    </div>
                    <!--/col-->
                    <!-- project team & activity start -->
                    <div class="row">
                    </div>
                </section>
            </section>
            <!--main content end-->
        </section>
        <!-- container section start -->

        <!-- javascripts -->
        <script src="admin/js/jquery.js"></script>
        <script src="admin/js/jquery-ui-1.10.4.min.js"></script>
        <script src="admin/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="admin/js/jquery-ui-1.9.2.custom.min.js"></script>
        <!-- bootstrap -->
        <script src="admin/js/bootstrap.min.js"></script>
        <!-- nice scroll -->
        <script src="admin/js/jquery.scrollTo.min.js"></script>
        <script src="admin/js/jquery.nicescroll.js" type="text/javascript"></script>
        <!-- charts scripts -->
        <script src="admin/assets/jquery-knob/js/jquery.knob.js"></script>
        <script src="admin/js/jquery.sparkline.js" type="text/javascript"></script>
        <script src="admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
        <script src="admin/js/owl.carousel.js"></script>
        <!-- jQuery full calendar -->
        <<script src="admin/js/fullcalendar.min.js"></script>
        <!-- Full Google Calendar - Calendar -->
        <script src="admin/assets/fullcalendar/fullcalendar/fullcalendar.js"></script>
        <!--script for this page only-->
        <script src="admin/js/calendar-custom.js"></script>
        <script src="admin/js/jquery.rateit.min.js"></script>
        <!-- custom select -->
        <script src="admin/js/jquery.customSelect.min.js"></script>
        <script src="admin/assets/chart-master/Chart.js"></script>

        <!--custome script for all page-->
        <script src="js/scripts.js"></script>
        <!-- custom script for this page-->
        <script src="admin/js/sparkline-chart.js"></script>
        <script src="admin/js/easy-pie-chart.js"></script>
        <script src="admin/js/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="admin/js/jquery-jvectormap-world-mill-en.js"></script>
        <script src="admin/js/xcharts.min.js"></script>
        <script src="admin/js/jquery.autosize.min.js"></script>
        <script src="admin/js/jquery.placeholder.min.js"></script>
        <script src="admin/js/gdp-data.js"></script>
        <script src="admin/js/morris.min.js"></script>
        <script src="admin/js/sparklines.js"></script>
        <script src="admin/js/charts.js"></script>
        <script src="admin/js/jquery.slimscroll.min.js"></script>
        <script>
            //knob
            $(function () {
                $(".knob").knob({
                    'draw': function () {
                        $(this.i).val(this.cv + '%')
                    }
                })
            });

            //carousel
            $(document).ready(function () {
                $("#owl-slider").owlCarousel({
                    navigation: true,
                    slideSpeed: 300,
                    paginationSpeed: 400,
                    singleItem: true

                });
            });

            //custom select box

            $(function () {
                $('select.styled').customSelect();
            });

            /* ---------- Map ---------- */
            $(function () {
                $('#map').vectorMap({
                    map: 'world_mill_en',
                    series: {
                        regions: [{
                                values: gdpData,
                                scale: ['#000', '#000'],
                                normalizeFunction: 'polynomial'
                            }]
                    },
                    backgroundColor: '#eef3f7',
                    onLabelShow: function (e, el, code) {
                        el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
                    }
                });
            });
        </script>

    </body>

</html>
