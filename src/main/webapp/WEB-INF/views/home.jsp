<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>

<link rel="stylesheet"
      href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>

<html>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="body">
        <div class="">
            <div id="slider" class="sl-slider-wrapper">
                <div class="sl-slider">
                    <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25"
                         data-slice2-rotation="-25"
                         data-slice1-scale="2" data-slice2-scale="2">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-1"></div>
                            <h2>
                                <a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a>
                            </h2>
                            <blockquote>
                                <p class="location">
                                    <span class="glyphicon glyphicon-map-marker"></span>
                                </p>
                                <p>Until he extends the circle of his compassion to all living things, man will not
                                    himself find peace.</p>
                                <cite>$ 20,000,000</cite>
                            </blockquote>
                        </div>
                    </div>
                    <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10"
                         data-slice2-rotation="-15"
                         data-slice1-scale="1.5" data-slice2-scale="1.5">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-2"></div>
                            <h2>
                                <a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a>
                            </h2>
                            <blockquote>
                                <p class="location">
                                    <span class="glyphicon glyphicon-map-marker"></span>
                                </p>
                                <p>Until he extends the circle of his compassion to all living things, man will not
                                    himself find peace.</p>
                                <cite>$ 20,000,000</cite>
                            </blockquote>
                        </div>
                    </div>
                    <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3"
                         data-slice2-rotation="3"
                         data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-3"></div>
                            <h2>
                                <a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a>
                            </h2>
                            <blockquote>
                                <p class="location">
                                    <span class="glyphicon glyphicon-map-marker"></span>
                                </p>
                                <p>Until he extends the circle of his compassion to all living things, man will not
                                    himself find peace.</p>
                                <cite>$ 20,000,000</cite>
                            </blockquote>
                        </div>
                    </div>
                    <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="-5"
                         data-slice2-rotation="25"
                         data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-4"></div>
                            <h2>
                                <a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a>
                            </h2>
                            <blockquote>
                                <p class="location">
                                    <span class="glyphicon glyphicon-map-marker"></span>
                                </p>
                                <p>Until he extends the circle of his compassion to all living things, man will not
                                    himself find peace.</p>
                                <cite>$ 20,000,000</cite>
                            </blockquote>
                        </div>
                    </div>
                    <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-5"
                         data-slice2-rotation="10"
                         data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-5"></div>
                            <h2>
                                <a href="#">2 Bed Rooms and 1 Dinning Room Aparment on Sale</a>
                            </h2>
                            <blockquote>
                                <p class="location">
                                    <span class="glyphicon glyphicon-map-marker"></span>
                                </p>
                                <p>Until he extends the circle of his compassion to all living things, man will not
                                    himself find peace.</p>
                                <cite>$ 20,000,000</cite>
                            </blockquote>
                        </div>
                    </div>
                </div>
                <!-- /sl-slider -->
                <nav id="nav-dots" class="nav-dots">
                    <span class="nav-dot-current"></span>
                </nav>
            </div>
            <!-- /slider-wrapper -->
        </div>
        <div class="banner-search">
            <div class="container">
                <!-- banner -->
                <h3>Sell &amp; Rent</h3>
                <div class="searchbar">
                    <div class="row">
                        <div class="col-lg-6 col-sm-6">
                            <form:form modelAttribute="searchDto" role="form"
                                       action="property/search" method="POST"
                                       id="propertyListModelId" name="propertyListModel">
                                <input type="text" class="form-control" name="textSearch"
                                       placeholder="Search of Properties">
                                <div class="row">
                                    <div class="col-lg-4 col-sm-5 ">
                                        <select name="purpose" class="form-control">
                                            <option value="rent,sell">-- Purpose type --</option>
                                            <option value="rent">Rent</option>
                                            <option value="sell">Sell</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-sm-5">
                                        <select name="type" class="form-control">
                                            <option value="house,apartment">-- Property type --</option>
                                            <option value="house">House</option>
                                            <option value="apartment">Apartment</option>
                                        </select>
                                    </div>
                                    <div class="col-lg-4 col-sm-5">
                                        <button type="submit" class="btn btn-primary col-lg-4 col-sm-5">Find Now
                                        </button>
                                    </div>
                                </div>
                                <input type="hidden" name="order" value="0"> <input type="hidden" name="currentPage"
                                                                                    value="1">
                            </form:form>
                            <button type="button" id="searchBtnHome" class="btn btn-primary col-lg-4 col-sm-5">Find by
                                Ajax
                            </button>
                        </div>
                        <c:if test="${empty sessionScope.currentUser}">
                            <div class="col-lg-5 col-lg-offset-1 col-sm-6 ">
                                <p>Join now and get updated with all the properties deals.</p>
                                <button class="btn btn-info" data-toggle="modal" data-target="#loginpop">Login</button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <!-- banner -->
        <div class="container">
            <div class="properties-listing spacer">
                <a href="<c:url value="property/list"/>" class="pull-right viewall"><spring:message code="allView.msg"
                                                                                                    text="View all listing"/></a>
                <h2>Featured Properties</h2>
                <div id="owl-example" class="owl-carousel">

                    <c:forEach var="property" items="${hotProperties}">
                        <!-- properties -->
                        <div class="properties">
                            <div class="image-holder">
                                <img src="<c:url value="/uploadimage/${property.mainPicturePath}"/>"
                                     class="img-responsive" alt="properties-${property.mainPicturePath}">
                                <c:choose>
                                    <c:when test="${property.purposeKey == 'Sell'}">
                                        <div class="status sold">
                                            <b>${property.getPropertyType()}</b> - <i>${property.getPurposeName()}</i>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="status new">
                                            <b>${property.getPropertyType()}</b> - <i>${property.getPurposeName()}</i>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <h4>
                                <a href="<c:url value="/property/propertyList?id=${property.id}"/>">${property.name}</a>
                            </h4>
                            <p class="price">
                                Price:
                                <fmt:setLocale value="en_US"/>
                                    <%-- 									<c:choose> --%>
                                    <%-- 										<c:when test="${property.getUtilitiesCost()} <= 0"> --%>
                                    <%-- 											<fmt:formatNumber value="${property.purposeType.calculatePrice()}" type="currency" /> --%>
                                    <%-- 										</c:when> --%>
                                    <%-- 										<c:otherwise> --%>
                                    <%-- 											<fmt:formatNumber value="${property.getUtilitiesCost()}" type="currency" /> --%>
                                    <%-- 										</c:otherwise> --%>
                                    <%-- 									</c:choose> --%>
                                <fmt:formatNumber value="${property.purposeType.calculatePrice()}" type="currency"/>
                                    <%-- 									<fmt:formatNumber value="1000" type="currency" /> --%>
                            </p>
                            <div class="listing-detail">
                                <span data-toggle="tooltip" data-placement="bottom"
                                      data-original-title="Bed Room">${property.bedroom}</span> <span
                                    data-toggle="tooltip" data-placement="bottom"
                                    data-original-title="Living Room">${property.livingroom}</span> <span
                                    data-toggle="tooltip" data-placement="bottom"
                                    data-original-title="Parking">${property.parking}</span> <span
                                    data-toggle="tooltip" data-placement="bottom"
                                    data-original-title="Kitchen">${property.kitchen}</span>
                            </div>
                            <a class="btn btn-primary" href="property/propertyList?id=${property.id}">View Details</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="spacer">
                <div class="row">
                    <div class="col-lg-6 col-sm-9 recent-view">
                        <h3>About Us</h3>
                        <p>
                            The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those
                            interested. Sections 1.10.32
                            and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their
                            exact original form,
                            accompanied by English versions from the 1914 translation by H. Rackham.
                        </p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-1 col-sm-3 recommended">
                        <h3>Recommended Properties</h3>
                        <div id="myCarousel" class="carousel slide">
                            <ol class="carousel-indicators">
                                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                                <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                            </ol>
                            <!-- Carousel items -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            <img src="<c:url value="/resources/images/properties/1.jpg"/>"
                                                 class="img-responsive" alt="properties"/>
                                        </div>
                                        <div class="col-lg-8">
                                            <h5>
                                                Integer sed porta quam
                                            </h5>
                                            <p class="price">$300,000</p>
                                            <!-- 										<a href="property/1" class="more">More Detail</a> -->
                                        </div>
                                    </div>
                                </div>
                                <!-- 							<div class="item"> -->
                                <!-- 								<div class="row"> -->
                                <!-- 									<div class="col-lg-4"> -->
                                <!-- 										<img src="public/images/properties/2.jpg" class="img-responsive" alt="properties" /> -->
                                <!-- 									</div> -->
                                <!-- 									<div class="col-lg-8"> -->
                                <!-- 										<h5> -->
                                <!-- 											<a href="/property/1">Integer sed porta quam</a> -->
                                <!-- 										</h5> -->
                                <!-- 										<p class="price">$300,000</p> -->
                                <!-- 										<a href="/property/1" class="more">More Detail</a> -->
                                <!-- 									</div> -->
                                <!-- 								</div> -->
                                <!-- 							</div> -->
                                <!-- 							<div class="item"> -->
                                <!-- 								<div class="row"> -->
                                <!-- 									<div class="col-lg-4"> -->
                                <!-- 										<img src="public/images/properties/3.jpg" class="img-responsive" alt="properties" /> -->
                                <!-- 									</div> -->
                                <!-- 									<div class="col-lg-8"> -->
                                <!-- 										<h5> -->
                                <!-- 											<a href="/property/1">Integer sed porta quam</a> -->
                                <!-- 										</h5> -->
                                <!-- 										<p class="price">$300,000</p> -->
                                <!-- 										<a href="/property/1" class="more">More Detail</a> -->
                                <!-- 									</div> -->
                                <!-- 								</div> -->
                                <!-- 							</div> -->
                                <!-- 							<div class="item"> -->
                                <!-- 								<div class="row"> -->
                                <!-- 									<div class="col-lg-4"> -->
                                <!-- 										<img src="public/images/properties/4.jpg" class="img-responsive" alt="properties" /> -->
                                <!-- 									</div> -->
                                <!-- 									<div class="col-lg-8"> -->
                                <!-- 										<h5> -->
                                <!-- 											<a href="/property/1">Integer sed porta quam</a> -->
                                <!-- 										</h5> -->
                                <!-- 										<p class="price">$300,000</p> -->
                                <!-- 										<a href="/property/1" class="more">More Detail</a> -->
                                <!-- 									</div> -->
                                <!-- 								</div> -->
                                <!-- 							</div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
</html>