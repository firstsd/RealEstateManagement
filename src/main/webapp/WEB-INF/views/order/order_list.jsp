<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<fmt:setLocale value="en_US" />
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="true" %>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	

	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="<c:url value="/"/>">Home</a> / orders</span>
			<h2><spring:message code="list.header"   text="List of orders" /></h2>
		</div>
	</div>
	<!-- banner -->

	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-12 col-sm-12">

					<div class="table-responsive">
						<table class="table table-hover">
							<tr class="active">
								<th><spring:message code="list.id"   text="ID" /> </th>
								<th><spring:message code="list.Requestor"   text="Requestor" /></th>
								<th><spring:message code="list.Date"   text="Date" /></th>
								<th><spring:message code="list.Name"   text="Name" /></th>
								<th><spring:message code="list.Address"   text="Address" /></th>
								<th><spring:message code="list.Purpose"   text="Purpose" /></th>
								<th><spring:message code="list.Owner"   text="Owner of property" /></th>
								<th><spring:message code="list.Status"   text="Status" /></th>
								<th></th>
								<th></th>
							</tr>

							<c:if test="${not empty orderList}">
								<c:forEach var="order" items="${orderList}">
									<tr class="active">
										<td>${order.getId()}</td>
										<td>${order.getAccount().getFirstName()}</td>
										<td>${order.getRegisterDate()}</td>
										<td>${order.getProperty().getName()}</td>
										<td>${order.getProperty().getAddress()}</td>
										<td>${order.getProperty().getPropertyType()}</td>
										<td>${order.getProperty().getOwner().getFirstName()} - ${order.getProperty().getOwner().getLastName()}</td>
										<td>
											<c:choose>
												<c:when test="${order.getStatus() == 1}">
													PENDING
												</c:when>
												<c:when test="${order.getStatus() == 2}">
													<b>APPROVED</b>
												</c:when>
												<c:when test="${order.getStatus() == 3}">
													BOUGHT
												</c:when>
												<c:when test="${order.getStatus() == 4}">
													RENTED
												</c:when>
												<c:when test="${order.getStatus() == 4}">
													CANCELLED
												</c:when>
												<c:otherwise>
													DELETED
												</c:otherwise>
											</c:choose>
										</td>
										<td><a href="<c:url value="/order?orderId=${order.getId()}"/>">View</a></td>
										<td>
											<c:if test="${not empty sessionScope.currentUser}">
												<c:if test="${sessionScope.currentUser.getRole().getId() == 2}">
													<c:if test="${order.getStatus().getId() == 1}">
														<a href="<c:url value="/order/approve?orderId=${order.getId()}"/>">Approve</a>
													</c:if>
												</c:if>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:if>

						</table>
					</div>

				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>