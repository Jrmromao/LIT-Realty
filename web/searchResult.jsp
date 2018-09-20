<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="resources/template/head.jsp"/>
<div class="about_top">
    <div class="container">



        <div class="row">
            <div class="col-sm-4">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h3 class=" h3">Refine Search</h3>
                <form action="AdvanceSerach" method="post">
                    <div class="col-md-10 dropdown-buttons">   

                        <div class="section_room">
                            <select id="country" onchange="change_country(this.value)" class="frm-field required" name="price">
                                <option>Price</option>


                                <c:forEach items="${list}" var="p">
                                    <option value="${p.getPrice()}">&euro;${p.getPrice()}</option>
                                </c:forEach>    
                            </select>
                        </div>
                        <div class="section_room">
                            <select id="country" onchange="change_country(this.value)" class="frm-field required" name="location">
                                <option value="${list[0].getCity()}">${list[0].getCity()}</option>

                            </select>
                        </div>
                        <select id="country" onchange="change_country(this.value)" class="frm-field required" name="type">
                            <option value=" "> All Types</option>
                            <c:forEach items="${tList}" var="p">
                                <option value="${p.getTypeId()}">${p.getPType()}</option>
                            </c:forEach>     
                        </select>
                        <select id="country" onchange="change_country(this.value)" class="frm-field required" name="nBedrooms">
                            <option value=" ">Num Bedrooms</option>
                            <c:forEach items="${list}" var="p">
                                <option value="${p.getBedrooms()}">${p.getBedrooms()}</option>
                            </c:forEach>     
                        </select>
                        <div class="section_room">
                            <select id="country" onchange="change_country(this.value)" class="frm-field required" name="squarefeet">
                                <option value=" "> Square Feet</option>
                                <c:forEach items="${list}" var="p">
                                    <option value="${p.getSquarefeet()}">${p.getSquarefeet()}</option>
                                </c:forEach>     
                            </select>
                        </div>
                    </div> 
                    <button type="submit" class="btn btn-success">Serach</button>
                </form>
            </div>
            <div class="col-lg">
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
                    <br>
                    <br>
                    <br>
                    <h2>We Found: ${list.size()} Properties in ${list[0].getCity()}</h2>
                    <br>
                    <br>
                    <c:forEach items="${list}" var="s">
                        <tr>
                            <td>${s.getListingNum()}</td>
                            <td>${s.getStreet()}</td>
                            <td>${s.getCity()}</td>
                            <td>${s.getLotsize()}</td>
                            <td><a href="PropDetailServlet?id=${s.getId()}"><img src="resources/images/properties/thumbs/${s.getListingNum()}.JPG" alt=""/></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <hr>
            </div>   
        </div>
    </div>
</div>

<jsp:include page="resources/template/footer.jsp"/> 