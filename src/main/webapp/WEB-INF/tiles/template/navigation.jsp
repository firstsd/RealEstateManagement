<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>

		<div class="navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only"><spring:message code="menu.toggle" text="Toggle navigation"/></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<!-- Nav Starts -->
				<div class="navbar-collapse  collapse">
					<ul id="mainMenu" class="nav navbar-nav navbar-right">
						<li>
						<section>
							<div class="pull-right" style="padding-right:50px">
								<a href="?language=en">English</a>|<a href="?language=fr">France</a>
							</div>
						</section>
						</li>
						<li><a href="<c:url value="/index"/>"><spring:message code="menu.home" text="Home"/></a></li>
						<li><a href="<c:url value="/agents"/>"><spring:message code="menu.agent" text="Agents"/></a></li>
						<c:if test="${not empty sessionScope.currentUser}">
							<c:choose>
								<c:when test="${sessionScope.currentUser.role.id == 4}">
									<li><a href="<c:url value="/property/requests"/>"><spring:message code="menu.pending" text="Pending request"/></a></li>
								</c:when>
							</c:choose>
							<c:choose>
								<c:when test="${sessionScope.currentUser.role.id != 1}">
									<li><a href="<c:url value="/property/uploadProperty"/>"><spring:message code="menu.upload" text="Upload property"/></a></li>
									<li><a href="<c:url value="/bookappointment/list"/>"><spring:message code="menu.appointmens" text="Appointmens"/></a></li>
								</c:when>
							</c:choose>
							<li><a href="<c:url value="/order/list"/>"><spring:message code="menu.orders" text="Orders"/></a></li>
							<c:if test="${sessionScope.currentUser.role.id == 4}">
								<li><a href="<c:url value="/register"/>"><spring:message code="menu.register" text="Register"/></a></li>
							</c:if>
						</c:if>
						<c:choose>
							<c:when test="${sessionScope.currentUser != null}">
								<li><a> <c:choose>
											<c:when test="${sessionScope.currentUser.role.id == 1}">
												BUYER
											</c:when>
											<c:when test="${sessionScope.currentUser.role.id ==2}">
												SELLER
											</c:when>
											<c:when test="${sessionScope.currentUser.role.id ==3}">
												AGENT
											</c:when>
											<c:otherwise>
												ADMIN
											</c:otherwise>
										</c:choose> <span>${sessionScope.currentUser.firstName}</span> <span>${sessionScope.currentUser.lastName}</span></a></li>
								<li>
									<form method="get" action="<c:url value="/logout"/>">
										<button id="logout"><spring:message code="menu.logout" text="Log Out"/></button>
									</form>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="login"><spring:message code="menu.login" text="Log In"/></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<!-- #Nav Ends -->

			</div>
		</div>
