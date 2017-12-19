<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="true" %>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="<c:url value="/"/>">Home</a> / orders</span>
			<h2>List of orders</h2>
		</div>
	</div>
	<!-- banner -->

	<div class="container">
		<div class="spacer">
			<div class="row">

				<c:if test="${msg}">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						${msg}
					</div>
				</c:if>

				<c:if test="${errorMsg}">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						${errorMsg}
					</div>
				</c:if>

				<div
					class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
					<c:choose>
						<c:when test="${empty order}">
							<h1 style="color: black;">Not found item!</h1>
						</c:when>

						<c:otherwise>
							<form method="POST" action="/order/approve">
								<input type="hidden" name="orderId" value="$order.id">
								<h2>Order information</h2>
								<table class="table table-hover table-bordered ">
									<tr>
										<td>Created by</td>
										<td>${order.getAccount().getFirstName()}
											${order.getAccount().getLastName()}</td>
									</tr>
									<tr>
										<td>Registered</td>
										<td>${order.getRegisterDate()}</td>
									</tr>
									<tr>
										<td>Property</td>
										<td>${order.getProperty().getName()}- <a
											href="<c:url value="/property?id=${order.getProperty().getId()}"/>"
											target="_blank">View</a></td>
									</tr>
<%-- 									<tr> --%>
<%-- 										<td>Status</td> --%>
<%-- 										<td>${order.}</td> --%>
<%-- 									</tr> --%>
									<tr>
										<td>Seller</td>
										<td>${order.getProperty().getOwner().getFirstName()} - ${order.getProperty().getOwner().getLastName()}</td>
									</tr>
									<tr>
										<td>Comment</td>
										<td>${order.getComment()}</td>
									</tr>

									<c:choose>
										<c:when test="${orderType == 'Buy'}">
											<tr>
												<td>Buy</td>
												<td>${order.getBuyPrice()}</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>Rent months</td>
												<td>${order.getRentMonth()}</td>
											</tr>
											<tr>
												<td>Rent price (per month)</td>
												<td>${order.getPerMonthPrice()}</td>
											</tr>
											<tr>
												<td>Desposit</td>
												<td>${order.getDeposit()}</td>
											</tr>
											<tr>
												<td>To extend</td>
												<td>${order.isExtendable()}</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</table>
								
								<c:if test="${not empty sessionScope.currentUser}">
									<c:choose>
										<c:when test="${sessionScope.currentUser.getRole().getId() == 2 && statusName == 'PENDING'}">
											<div class="col-lg-3 col-sm-3 col-xs-12 ">
												<a class="btn btn-success" href="<c:url value="/order/approve/$order.id"/>">Approve</a>
											</div>
											<div class="col-lg-3 col-sm-3 col-xs-12 ">
												<a class="btn btn-danger" href="<c:url value="/order/cancel/$order.id"/>">Cancel</a>
											</div>
										</c:when>
										<c:when test="${sessionScope.currentUser.getRole().getId() == 1 && statusName == 'APPROVED'}">
											<div class="col-lg-3 col-sm-3 col-xs-12 ">
												<button class="btn btn-success" data-toggle="modal"
													data-target="#paymentpop">Payment</button>
											</div>
										</c:when>
									</c:choose>

								</c:if>
								<div class="col-lg-3 col-sm-3 col-xs-12 ">
									<a class="btn btn-success" href="<c:url value="/order/list"/>">Back</a>
								</div>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 -->

			</div>
			<!-- row -->
		</div>
		<!-- spacer -->
	</div>
	<!-- container -->


	</tiles:putAttribute>
</tiles:insertDefinition>
</html>