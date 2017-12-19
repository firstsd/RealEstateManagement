<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

		<div class="header">
			<a href="<c:url value="/"/>"><img src="<c:url value="/resources/images/logo.png"/>" alt="Realestate"></a>
			<ul class="pull-right">
<%-- 				<c:if test="${not empty currentUser}"> --%>
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${currentUser.role == 4}"> --%>
<%-- 							<li><a href="${ContextPath}/property/requests">Pending requests</a></li> --%>
<%-- 						</c:when> --%>
<%-- 						<c:when test="${currentUser.role == 2}"> --%>
<%-- 							<li><a href="${ContextPath}/property/property_upload">Upload property</a></li> --%>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
<%-- 					<li><a href="${ContextPath}/bookappointment/list">Appointments</a></li> --%>
<%-- 					<li><a href="${ContextPath}/order/list">Orders</a></li> --%>
<%-- 				</c:if> --%>
<!-- 				<li><a href="#" onclick="submitForm(2)">Sell</a></li> -->
<!-- 				<li><a href="#" onclick="submitForm(1)">Rent</a></li> -->
			</ul>
		</div>
