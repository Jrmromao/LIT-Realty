<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">

        <div class="col-sm-12">
            <div class="blog_list2">
                <h3>Our Agents</h3> 
                <c:forEach items="${list}" var="a">
                    <div class="row">
                        <div class="col-sm">
                            <a href="ViewAgentPropertiesServlet?agentID=${a.getUserId()}"> <img src="resources/images/agents/${a.getUserId()}.jpg"  width="150" height="170" alt=""/></a>
                        </div>
                        <div class="col-md-6">
                            <h3>${a.getName()}</h3> 
                            <p>Collaboratively administrate empowered markets via plug-and-play networks. Dynamically 
                                procrastinate B2C users after installed base benefits. Dramatically 
                                visualize customer directed convergence without revolutionary ROI.</p>
                        </div>
                        <div class="col-sm">
                            <ul class="admin_desc">
                                <li><br><br><br></li>
                                <li class="list_top"><i class="fa fa-phone-square ph"> </i><p class="m_2">${a.getPhone()}</p></li>
                                <li><div class="clearfix"> </div></li>
                                <li class="list_top"><i class="fa fa-envelope ph"> </i>
                                    <p class="m_2"><a href="malito:${a.getEmail()}}">${a.getEmail()}</a></p></li>
                            </ul>
                        </div>

                    </div>
                    <br>
                    <br>
                </c:forEach>   
                <br>
            </div>
        </div>
    </div> 







    <jsp:include page="resources/template/footer.jsp"/> 