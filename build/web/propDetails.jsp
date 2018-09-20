<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="resources/template/head.jsp"/>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#call').click(function ()
        {
            $.ajax({
                type: "post",
                url: "AddToFavServlet", //this is my servlet
                data: "input=" + $('#ip').val() + "&output=" + $('#op').val(),
                success: function (msg) {
                    $('#output').append(msg);
                }
            });
        });

    });
</script>

<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/><script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<br>
<br>
<br>
<br>
<div class="about_top">
    <div class="container">
        <div class="row">  
            <div class="col-lg-5 box">
                <br>
                <br>
                <img src="resources/images/properties/large/${prop.getListingNum()}/${prop.getListingNum()}.JPG"
                     alt="Image" id="ShopwImage"  width="450" height="480" />
                <br>
                <c:forEach items="${iList}" var="i"> 
                    <div class="col-lg-5 col-md-5 col-xs-2 thumb w-30 p-3">
                        <a class="thumbnail" href="#" data-image-id="" data-toggle="modal" data-title="Im so nice" data-caption="" data-image="" data-target="#image-gallery">                      
                            <img class="img-responsive" src="resources/images/properties/large/${prop.getListingNum()}/${i}"
                                 onClick="document.getElementById('ShopwImage').src = 'resources/images/properties/large/${prop.getListingNum()}/${i}';"  style="width: 110px; height: 110px;" />
                        </a>
                    </div>
                </c:forEach>
            </div>    
            <div class="col-lg-6 box">
                <h2></h2>
                <br>
                <table class="table">
                    <tr>
                        <td>Views: </td>
                        <td><i class="fa fa-eye" aria-hidden="true"> ${totalView}</i></td>
                    </tr>
                    <tr>
                     
                                     <td>Add To Favorites</td>
                                    <td><a href="Favorites?id=${prop.getId()}"><i class="fa fa-star" aria-hidden="true"></i></a></td>
                    </tr>


                    <tr>
                        <td><strong>Price:</strong></td>
                        <td>&euro;${prop.getPrice()}</td>
                    </tr>
                    <tr>
                        <td><strong>Listing Number:</strong></td>
                        <td>${prop.getListingNum()}</td>
                    </tr>
                    <tr>
                        <td><strong>City:</strong></td>
                        <td>${prop.getCity()}</td>
                    </tr>
                    <tr>
                        <td><strong>Street:</strong> </td>
                        <td>${prop.getStreet()}</td>
                    </tr>
                    <tr>
                        <td><strong>BER Rating:</strong> </td>
                        <td> <img src="resources/images/BER/${prop.getBerRating()}.png" alt=""/></td>
                    </tr>
                    <tr>
                        <td><strong>Lot Size:</strong> </td>
                        <td>${prop.getLotsize()}</td>
                    </tr>
                    <tr>
                        <td><strong>Property Type:</strong> </td>
                        <c:choose>
                            <c:when test="${prop.getTypeId() == 1}">
                                <td>Residential-Single</td>          
                            </c:when>
                            <c:when test="${prop.getTypeId() == 2}">
                                <td>Residential-Multi</td>   
                            </c:when>
                            <c:otherwise>
                                <td>Commercial</td>   
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td><strong>Number of Bedrooms:</strong> </td>
                        <td>${prop.getBedrooms()}</td>
                    </tr>
                    <tr>
                        <td><strong>Number of Bathrooms:</strong> </td>
                        <td>${prop.getBathrooms()}</td>
                    </tr>
                    <tr>
                        <td><strong>Property Style</strong> </td>
                        <c:choose>
                            <c:when test="${prop.getStyleId() == 1}">
                                <td>Bungalow</td>          
                            </c:when>
                            <c:when test="${prop.getStyleId() == 2}">
                                <td>Semi Detached</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 3}">
                                <td>Detached</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 4}">
                                <td>Cottage</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 5}">
                                <td>Terrace</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 8}">
                                <td>Duplex</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 9}">
                                <td>Condo</td>   
                            </c:when>
                            <c:when test="${prop.getStyleId() == 10}">
                                <td>Apartment</td>   
                            </c:when>
                            <c:otherwise>
                                <td>Other</td>   
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td><strong>Garage Style</strong> </td>
                        <c:choose>
                            <c:when test="${prop.getGarageId() == 1}">
                                <td>Attached</td>          
                            </c:when>
                            <c:when test="${prop.getGarageId() == 2}">
                                <td>Detached</td>   
                            </c:when>
                            <c:otherwise>
                                <td>Carport</td>   
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    <tr>
                        <td><strong>Garage Size</strong> </td>
                        <td>${prop.getGaragesize()}</td>
                    </tr>
                    <tr>
                        <td><strong>Square feet</strong> </td>
                        <td>${prop.getSquarefeet()}</td>
                    </tr>
                    <tr>
                        <td><strong>Description</strong> </td>
                        <td>${prop.getDescription()}</td>
                    </tr>

                    <!--|VENDOR DETAILS|-->
                    <c:choose>
                        <c:when test="${prop.getAgentId() == id}">
                            <tr>
                                <td colspan="2" > <h3>Vendor Details</h3></td>
                            </tr>
                            <tr>
                                <td>Vendor Name</td>
                                <td>${vendor.getName()}</td>
                            </tr>
                            <tr>
                                <td>Vendor Phone Num</td>
                                <td>${vendor.getPhoneNum()}</td>
                            </tr>
                            <tr>
                                <td>Vendor Address</td>
                                <td>${vendor.getAddress()}</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <!-- DO NOTHING --->
                        </c:otherwise>
                    </c:choose>
                    <!--||END VENDOR DETAILS-->


                    <tr>
                        <td colspan="2"> <div class="map">
                                <iframe
                                    width="600"
                                    height="450"
                                    frameborder="0" style="border:0"
                                    src="https://www.google.com/maps/embed/v1/place?key=AIzaSyCFhTp-ZCCLf3Vn6Mw6iPFNxHVLS6nqjbQ
                                    &q=${prop.getStreet()}, ${prop.getCity()}" allowfullscreen>
                                </iframe>
                            </div></td>
                    </tr>

                </table>
            </div>
            <hr>
        </div>      
    </div>       
</div>





<jsp:include page="resources/template/footer.jsp"/> 