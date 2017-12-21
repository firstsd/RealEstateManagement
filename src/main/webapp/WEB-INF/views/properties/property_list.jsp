<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="<c:url value="/resources/assets/imageAjax.js"/>"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>


<script type="text/javascript">
	function submitPropertyListModel() {
	    document.getElementById("propertyListModelList").submit();
	}
	function changePage(itemValue) {
		document.getElementById("currentPageId").value = itemValue;
		submitPropertyListModel();
	}
</script>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	
	<!-- banner -->
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="<c:url value="/index"/>">Home</a> / Buy, Sell &amp; Rent</span>
			<h2>Buy, Sell &amp; Rent</h2>
		</div>
	</div>
	<!-- banner -->
	<div class="container">
		<div class="properties-listing spacer">
			<form:form modelAttribute="searchDto"  role="form" 
								action="search" method="POST"
								id="propertyListModelList" name="propertyListModel">
				<div class="row">
					<div class="col-lg-3 col-sm-4 ">

						<div class="search-form">
							<h4>
								<span class="glyphicon glyphicon-search"></span> Search for
							</h4>
							<input type="text" name="textSearch" class="form-control" placeholder="Search of Properties">
							<div class="row">
								<div class="col-lg-6">
									<select name="purpose" class="form-control">
										<option value="rent,sell">-- Purpose type --</option>
										<option value="rent">Rent</option>
										<option value="sell">Sell</option>
									</select>
								</div>
								<%--
								<div class="col-lg-7">
									<select class="form-control">
										<option>Price</option>
										<option>$150,000 - $200,000</option>
										<option>$200,000 - $250,000</option>
										<option>$250,000 - $300,000</option>
										<option>$300,000 - above</option>
									</select>
								</div>
								--%>
								<div class="col-lg-6">
									<select name="type" class="form-control">
										<option value="house,apartment">-- Property type --</option>
										<option value="house">House</option>
										<option value="apartment">Apartment</option>
									</select>
								</div>
							</div>
						<button type="button" id="searchBtnHomeList" class="btn btn-primary col-lg-4 col-sm-5">Find by Ajax</button>
						</div>
						<!-- start of MOST VIEWED PROPERTY -->
						<div class="hot-properties hidden-xs">
							<h4>Hot Properties</h4>
							<c:forEach var="property" items="${propertyListModel.hotPropertyList}">
								<div class="row">
									<div class="col-lg-4 col-sm-5">
										<img src="<c:url value="/uploadimage/${property.mainPicturePath}"/>" class="img-responsive img-circle"
											alt="properties">
									</div>
									<div class="col-lg-8 col-sm-7">
										<h5>
											<a href="<c:url value="/property?id=${property.id}"/>">${property.name}</a>
										</h5>
										<p class="price">
											Price:
											<fmt:formatNumber value="${property.purposeType.calculatePrice()}" type="currency" />
										</p>
									</div>
								</div>
							</c:forEach>
						</div>
						<!-- end of MOST VIEWED PROPERTY -->
					</div>

					<div class="col-lg-9 col-sm-8">
						<div class="sortby clearfix">
							<c:set var="pagerCount" value="12" />
							<c:set var="startPageNum" value="${(propertyListModel.currentPage - 1)*(pagerCount + 1)}" />
							<c:set var="currentPage"
								value="${(propertyListModel.currentPage - 1)* pagerCount + propertyListModel.propertyList.size()}" />

							<c:if test="${salary > propertyListModel.totalItemCount}">
								<c:set var="currentPage" value="${propertyListModel.totalItemCount}" />
							</c:if>
							<div class="pull-left result">
								Showing:
								<c:out value="${startPageNum} - ${currentPage}" />
								of
								<c:out value="${propertyListModel.totalItemCount}" />
							</div>
							<div class="pull-right">
								<select class="form-control" name="order" onchange="submitPropertyListModel()">
									<option value="0">Sort by</option>
									<option value="0">Register: New to Old</option>
									<option value="1">Register: Old to New</option>
								</select>
							</div>
						</div>
						<div class="row" id="searchResult">


							<!-- start of MAIN PROPERTY -->
							<c:forEach var="property" items="${propertyListModel.propertyList}">
								<!-- properties -->
								<div class="col-lg-4 col-sm-6">
									<div class="properties">
										<div class="image-holder">
											<img src="<c:url value="/uploadimage/${property.mainPicturePath}"/>" class="img-responsive" alt="properties">
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
							<%-- 				<fmt:formatNumber value="0" type="currency" /> --%>
											<fmt:formatNumber value="${property.purposeType.calculatePrice()}" type="currency" />
										</p>
										<div class="listing-detail">
											<span data-toggle="tooltip" data-placement="bottom" data-original-title="Bed Room">${property.bedroom}</span>
											<span data-toggle="tooltip" data-placement="bottom" data-original-title="Living Room">${property.livingroom}</span>
											<span data-toggle="tooltip" data-placement="bottom" data-original-title="Parking">${property.parking}</span>
											<span data-toggle="tooltip" data-placement="bottom" data-original-title="Kitchen">${property.kitchen}</span>
										</div>
										<a class="btn btn-primary" href="<c:url value="/property/propertyList?id=${property.id}"/>">View Details</a>
									</div>
								</div>
								<!-- properties -->
							</c:forEach>
							<!-- end of MAIN PROPERTY -->

						</div>

						<div class="row">

							<!-- start of PAGER -->
							<div class="center">
								<input type="hidden" name="currentPage" id="currentPageId" value="${propertyListModel.currentPage}">
								<ul class="pagination">
									<li><a href="#" onclick="changePage(${propertyListModel.currentPage - 1})">«</a></li>
									<c:choose>
										<c:when test="${propertyListModel.totalItemCount % pagerCount == 0}">
											<c:set var="totalPageCount" value="${propertyListModel.totalItemCount/pagerCount}" />
										</c:when>
										<c:otherwise>
											<c:set var="totalPageCount" value="${propertyListModel.totalItemCount/pagerCount+1}" />
										</c:otherwise>
									</c:choose>
									<c:forEach var="pageNum" begin="1" end="${totalPageCount}">
										<c:choose>
											<c:when test="${pageNum == propertyListModel.currentPage}">
												<li class="active"><a href="#" onclick="changePage(${pageNum})">${pageNum}</a></li>
											</c:when>
											<c:otherwise>
												<li><a href="#" onclick="changePage(${pageNum})">$pageNum</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<li><a href="#" onclick="changePage(${propertyListModel.currentPage + 1})">»</a></li>
								</ul>
							</div>
							<!-- end of PAGER -->
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>