<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">
       
   
        
        
   

                <form action="EditDetailsServlet" method="post">
                    <div class="form-group">
                        <label>Agent ID</label>
                        <input type="text" class="form-control" readonly value="${agent.getUserId()}" name="agentID">
                    </div>

                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" class="form-control" readonly value="${agent.getUsername()}" name="username">
                    </div>

                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" class="form-control" readonly value="${agent.getPassword()}" name="password">
                    </div>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" value="${agent.getName()}" name="name">
                    </div>
                    <div class="form-group">
                        <label>Phone</label>
                        <input type="text" class="form-control" value="${agent.getPhone()}" name="phone">
                    </div>
                    <div class="form-group">
                        <label>Fax</label>
                        <input type="text" class="form-control" value="${agent.getFax()}" name="fax">
                    </div>
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="email" class="form-control" value="${agent.getEmail()}" name="email">
                    </div>
                    <input type="submit" class="btn btn-info" value="Update">
                </form>
  
        <hr>
    </div>       

    <jsp:include page="resources/template/footer.jsp"/> 