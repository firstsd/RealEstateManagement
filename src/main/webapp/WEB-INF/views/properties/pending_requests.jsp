<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="<c:url value="/index"/>">Home</a> / Requested properties</span>
			<h2><spring:message code="pending.header"   text="Requested Properties" /></h2>
		</div>
	</div>
	<!-- banner -->
	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-12 col-sm-12 col-xs-12 ">

					<div class="table-responsive">
						<table class="table table-hover">
							<tr class="active">
								<th><spring:message code="pending.property"   text="Property" /></th>
								<th><spring:message code="pending.Address"   text="Address" /></th>
								<th><spring:message code="pending.Price"   text="Price" /></th>
								<th><spring:message code="pending.Owner"   text="Owner" /></th>
								<th><spring:message code="pending.Purpose"   text="Purpose" /></th>
								<th></th>
								<th></th>
							</tr>
							<c:forEach var="hotProperty" items="${properties}">
								<tr class="active approw">
									<td>${hotProperty.name}</td>
									<td>${hotProperty.address}</td>
									<td>${hotProperty.utilitiesCost}</td>
									<td>${hotProperty.getOwner().getFirstName()}</td>
									<td>${hotProperty.getPurposeKey()}</td>
									<td><a href="<c:url value="/property/propertyList?id=${hotProperty.id}"/>">View</a></td>
									 <td><a href="#" class="approveRequestBtn" valId="${hotProperty.id}" >Approve</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>