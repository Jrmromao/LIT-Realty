<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="resources/template/head.jsp"/> 

<div id="fb-root"></div>
<script>(function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id))
            return;
        js = d.createElement(s);
        js.id = id;
        js.src = 'https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.11&appId=246253912214299';
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>

${alert}
<div class="slider">
    <div class="callbacks_container">
        <ul class="rslides" id="slider">


            <li><img src="images/banner.jpg" class="img-responsive" alt=""/>
                <div class="banner_desc">
                    <div class="container">
                        <h1>Primeira Image</h1>
                        <h2>Test on the primeira image</h2>
                    </div>

            </li>




            <li><img src="images/banner1.jpg" class="img-responsive" alt=""/>
                <div class="banner_desc">
                    <div class="container">
                        <h1>Segunda image</h1>
                        <h2>Test on seonf image</h2>
                    </div>

                </div>
            </li>



            <li><img src="images/banner2.jpg" class="img-responsive" alt=""/>
                <div class="banner_desc">
                    <div class="container">
                        <h1>Terceira Image</h1>
                        <h2>Test on terceira image</h2>
                    </div>

                </div>
            </li>


        </ul>
    </div>
</div>



<div class="details">
    <div class="container">
        <form action="SearchServlet" method="post">
            <div class="col-md-10 dropdown-buttons">   
                <div class="col-md-4 dropdown-button">           			
                    <div class="section_room">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required" name="price">
                            <option value="0">Price</option>
                            <option value="1">0 - 100,000</option>         
                            <option value="2">100,000 - 200,000</option>
                            <option value="3">200,000 - 300,000</option>
                            <option value="4">300,000 - 400,000</option>         
                            <option value="5">400,000 - 500,000</option>
                            <option value="6">500,000 - 600,000</option>
                            <option value="7">600,000 - 700,000</option>         
                            <option value="8">700,000 - 800,000</option>
                            <option value="9">800,000 - 900,000</option>
                            <option value="10">900,000 - 1,000,000</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-4 dropdown-button">
                    <div class="section_room">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required" name="location">
                            <option value=" ">All Locations</option>
                            <c:forEach items="${cityList}" var="p">
                                <option value="${p}">${p}</option>
                            </c:forEach>    
                        </select>
                    </div>
                </div>
                <div class="col-md-4 dropdown-button">
                    <div class="section_room">
                        <select id="country" onchange="change_country(this.value)" class="frm-field required" name="type">
                            <option value=" "> All Types</option>
                            <c:forEach items="${typeList}" var="p">
                                <option value="${p.getTypeId()}">${p.getPType()}</option>
                            </c:forEach>    
                        </select>
                    </div>
                </div>
            </div> 
            <div class="col-md-2 submit_button"> 
                <input type="submit" value="Search" id="submitSerch">

                <a href="LoadAdvanceSerach">Advanced Search</a>


            </div>
        </form>
    </div>
</div>



















<div class="content_top">
    <div class="container">


        <div class="row">
            <div class="col-sm-4">
                <br>

                <div class="blog_list1">
                    <h3>Our Agents</h3> 
                    <c:forEach items="${list}" var="a">
                        <ul class="blog-list3 list_1"> 
                            <li class="blog-list3-img"> <a href="ViewAgentPropertiesServlet?agentID=${a.getUserId()}"> <img src="resources/images/agents/${a.getUserId()}.jpg" /></a></li>
                            <li class="blog-list3-desc">
                                <h4><a href="#">Adipisicing</a></h4>
                                <ul class="admin_desc">
                                    <li class="list_top"><i class="fa fa-phone-square ph"> </i>
                                        <p class="m_2">${a.getPhone()}</p></li>
                                    <li><div class="clearfix"> </div></li>
                                    <li class="list_top"><i class="fa fa-envelope ph"> </i>
                                        <p class="m_2"><a href="malito:${a.getEmail()}}">${a.getEmail()}</a></p></li>
                                </ul>
                            </li>
                        </ul> 
                    </c:forEach>   
                    <br>

                </div>

                <br>
                <br>
                <br>
                <br>

            </div>
            <div class="col-lg">
                <h4 class="m_3">Latest Properties</h4>
                <div class="col-md">
                    <div class="row">
                        <c:forEach items="${lastestProp}" var="lp" begin="0" end="3">
                            <div class="col-md box_2">
                                <a href="PropDetailServlet?id=${lp.getId()}"><img src="resources/images/properties/large/${lp.getListingNum()}/${lp.getListingNum()}.JPG" class="img-responsive"></a>
                                <div class="box_2">
                                    <div class="special-wrap"><div class="hot_offer"><span class="m_11">Hot Offer</span></div><div class="forclosure"><span class="m_12">Special Offer</span></div></div>
                                </div>
                                <div class="box_3">
                                    <h3> <a href="PropDetailServlet?id=${lp.getId()}">${lp.getCity()}</a></h3>
                                    <div class="boxed_mini_details clearfix">
                                        <span class="area first"><strong>Garage</strong><i class="fa fa-plane icon1"> </i>
                                            ${lp.getGaragesize()}</span>
                                        <span class="status"><strong>Baths</strong><i class="fa fa-retweet icon1"> </i>
                                            ${lp.getBathrooms()}</span>
                                        <span class="bedrooms last"><strong>Beds</strong><i class="fa fa-bed"></i>
                                            ${lp.getBedrooms()}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach> 
                    </div>
                    <div class="row">
                        <c:forEach items="${lastestProp}" var="lp" begin="4" end="8">

                            <div class="col-md-3 box_1">
                                <a href="PropDetailServlet?id=${lp.getId()}"><img src="resources/images/properties/large/${lp.getListingNum()}/${lp.getListingNum()}.JPG" class="img-responsive"  width="595" height="340"></a>
                                <div class="box_2">
                                    <div class="special-wrap"><div class="hot_offer"><span class="m_11">Hot Offer</span></div><div class="forclosure"><span class="m_12">Special Offer</span></div></div>
                                </div>
                                <div class="box_3">
                                    <h3> <a href="PropDetailServlet?id=${lp.getId()}">${lp.getCity()}</a></h3>
                                    <div class="boxed_mini_details clearfix">
                                        <span class="area first"><strong>Garage</strong><i class="fa fa-plane icon1"> </i>
                                            ${lp.getGaragesize()}</span>
                                        <span class="status"><strong>Baths</strong><i class="fa fa-retweet icon1"> </i>
                                            ${lp.getBathrooms()}</span>
                                        <span class="bedrooms last"><strong>Beds</strong><i class="fa fa-bed"></i>
                                            ${lp.getBedrooms()}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>  
                    </div>
                </div>

            </div>   
        </div>
    </div>
    <jsp:include page="resources/template/footer.jsp"/> 

