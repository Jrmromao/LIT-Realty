<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">





        <form class="well form-horizontal" action="SignUpServlet" method="post"  id="contact_form">
            <fieldset>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">Name</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input  name="name" placeholder="Name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>
                    <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">Username</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input  name="username" placeholder="Username" class="form-control"  type="text">
                        </div>
                    </div>
                </div>
                 <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                            <input name="email" placeholder="E-Mail Address" class="form-control"  type="text">
                        </div>
                    </div>
                </div>
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" >Password</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input id="password" name="password" placeholder="Password" class="form-control"   type="password">
                        </div>
                    </div>
                </div>
                
                
                
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" >Confirm Password</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input  id="confirm_password" name="confirm_password"  placeholder="Confirm Password" class="form-control"  type="password">
                            <div class="text-danger">${msg}</div>
                        </div>
                    </div>
                </div>
                        
                        

                        
           <!-- Text input-->
                <div class="form-group"> 
                    <label class="col-md-4 control-label">Category</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="category" class="form-control selectpicker">
                                <option value="">Select your Category</option>
                               
                                    <option value="${list[0].getRoleId()}">Agent</option>
                                    <option value="${list[1].getRoleId()}">User</option>
                            </select>
                        </div>
                    </div>
                </div>
           
           
           
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">Contact No.</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                            <input name="phone" placeholder="Contact No." class="form-control" type="text">
                        </div>
                    </div>
                </div>
                <!--Text input-->
                  <div class="form-group">
                    <label class="col-md-4 control-label">Fax</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                            <input name="fax" placeholder="Fax No." class="form-control" type="text">
                        </div>
                    </div>
                </div>
                  <!--Text input-->
                 <!--- <div class="form-group">
                    <label class="col-md-4 control-label">Profile Photo</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-picture-o"></i></span>
                            <input name="photo" class="form-control" type="file">
                        </div>
                    </div>
                </div>---->


                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4"><br>
                        <button type="submit" class="btn btn-warning" >SUBMIT <span class="fa fa-plus-circle"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
</div><!-- /.container -->




<jsp:include page="resources/template/footer.jsp"/> 
