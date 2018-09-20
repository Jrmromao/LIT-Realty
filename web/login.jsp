<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">
        <div class="about">

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Login via site</h3>
                        </div>
                        <div class="panel-body"><!-- action="LoginServlet"--->
                            <form accept-charset="UTF-8" role="form" method="post" name="loginform" action="LoginServlet">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Username" name="username" type="text" id="username">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Password" name="password" type="password" id="password">
                                    </div>
                                    <p class="danger">${message}</p>

                                    <div class="checkbox">
                                        <label>
                                            Remember Me
                                            <input type="checkbox" id="rememberMe" name="rememberMe" value="true" />
                                        </label>
                                    </div>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                                    <br>
                                    <p>New Here? <a href="LoadRegister">Register Here</a></p>
                                </fieldset>
                            </form>
                            <hr/>
                            <center><h4>OR</h4></center>
                            <input class="btn btn-lg btn-facebook btn-block" type="submit" value="Login via facebook">
                        </div>
                    </div>
                </div>
            </div>
        </div>     
    </div>   
        <jsp:include page="resources/template/footer.jsp"/> 