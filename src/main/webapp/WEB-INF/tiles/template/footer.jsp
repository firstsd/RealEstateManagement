<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="true" %>
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-sm4">
					<h4>Information</h4>
					<ul class="row">
						<c:if test="${not empty sessionScope.currentUser}">
							<c:choose>
								<c:when test="${sessionScope.currentUser.role.id == 4}">
									<li class="col-lg-12 col-sm-12 col-xs-3"><a href="<c:url value="/property/requests"/>">Pending requests</a></li>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.currentUser.role.id != 1}">
									<li class="col-lg-12 col-sm-12 col-xs-3"><a href="<c:url value="/bookappointment/list"/>">Appointments</a></li>
								</c:when>
							</c:choose>
							<li class="col-lg-12 col-sm-12 col-xs-3"><a href="<c:url value="/order/list"/>">Orders</a></li>
						</c:if>
						<li class="col-lg-12 col-sm-12 col-xs-3"><a href="<c:url value="/agents"/>">Agents</a></li>
					</ul>
				</div>

				<div class="col-lg-4 col-sm-4">
					<h4>Newsletter</h4>
					<p>Get notified about the latest properties in our marketplace.</p>
					<form class="form-inline" role="form">
						<input type="text" placeholder="Enter Your email address" class="form-control">
						<button class="btn btn-success" type="button">Notify Me!</button>
					</form>
				</div>

				<div class="col-lg-4 col-sm-4">
					<h4>Contact us</h4>
					<p>
						<b>WAA @ Tina.</b><br> <span class="glyphicon glyphicon-map-marker"></span> 1000 N 4th St, IA, USA, 52557 <br>
						<span class="glyphicon glyphicon-envelope"></span><a href="mailto:name@email.com"> waa@mum.edu</a><br> <span
							class="glyphicon glyphicon-earphone"></span> (111) 999-9999
					</p>
				</div>
			</div>
			<p class="copyright">Copyright  @2017. All rights reserved.</p>
		</div>
