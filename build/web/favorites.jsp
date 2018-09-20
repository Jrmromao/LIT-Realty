<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">


        <c:choose>
            <c:when test="${pList.size() == 0}">
                <h1 class="h1"> Favorites list is empty! </h1>
            </c:when>

            <c:otherwise> 
                <h1 class="h1">Your List of Favorite Property(s)</h1>
                    <br>
                    <br>
         
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Listing Number</th>
                            <th>Street</th>
                            <th>City</th>
                            <th>Lot Size</th>
                            <th>Photo</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pList}" var="s">
                        <tr>
                            <td>${s.getListingNum()}</td>
                            <td>${s.getStreet()}</td>
                            <td>${s.getCity()}</td>
                            <td>${s.getLotsize()}</td>
                            <td><a href="PropDetailServlet?id=${s.getId()}"><img src="resources/images/properties/thumbs/${s.getListingNum()}.JPG" alt=""/></a></td>
                            <td><a class="btn btn-danger fa fa-trash-o" href="RemoveFavServlet?id=${s.getId()}" role="button"></a> </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <hr>
            </c:otherwise>
        </c:choose>
    </div>   
</div>
<jsp:include page="resources/template/footer.jsp"/> 