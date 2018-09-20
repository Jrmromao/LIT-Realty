<jsp:include page="resources/template/head.jsp" />
<div class="about_top">
    <div class="container">


        
        

        <div class="row">
            <div class="col">
                <h2>Hi, ${agent.getName()}</h2>
                <br>
                <br>
                <img src="resources/images/agents/${agent.getUserId()}.jpg" alt="" />
                <br>
                <br>
                <table class="table">
                    <tr>
                        <td>Agent ID:</td>
                        <td>${agent.getUserId()}</td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>${agent.getName()}</td>
                    </tr>
                    <tr>
                        <td>Phone: </td>
                        <td>${agent.getPhone()}</td>
                    </tr>
                    <tr>
                        <td>Fax: </td>
                        <td>${agent.getFax()}</td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td>${agent.getEmail()}</td>
                    </tr>
                </table>
            </div>
            </div>
        </div>           
    </div>



    <jsp:include page="resources/template/footer.jsp" />