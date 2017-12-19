<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	
	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="<c:url value="/"/>">Home</a> / Upload property</span>
			<h2><spring:message code="property.header"   text="Upload property" /></h2>
		</div>
	</div>
	<!-- banner -->
		<div class="container">
		<div class="spacer">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
					<form:form modelAttribute="newProperty" action="uploadProperty" method="POST" enctype="multipart/form-data">
						<div class="row">
							<form:errors path="*" cssStyle="color : red;" /> 
						</div>
						<div class="row">
							<div class="col-lg-6">
								<label for="name"><spring:message code="property.title" text="Property Title"/> </label>
								<form:input path="name" class="form-control" placeholder="Property title" id="name" required="required" />
							</div>
							<div class="col-lg-6">
								<label for="address"><spring:message code="property.address" text="Address"/></label>
								<form:input class="form-control" placeholder="Address" id="address" path="address" required="required" />
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<label for="purpose"><spring:message code="property.purpose" text="Purpose"/></label>
								<form:select class="form-control" placeholder="Purpose" path="purposeName" id="purpose" onchange="setupPurpose()">
									<form:option value="rent">Rent</form:option>
									<form:option value="sell">Sell</form:option>
								</form:select>
							</div>
							<div class="col-lg-6">
								<label for="type"><spring:message code="property.type" text="Type"/></label>
								<form:select class="form-control" placeholder="Property type" path="propertyType" id="type" onchange="setupType()">
									<form:option value="apartment">Apartment</form:option>
									<form:option value="house">House</form:option>
								</form:select>
							</div>
						</div>

						<div class="row" id="fields">
							<div class="col-lg-4">
								<label for="bedroom"><spring:message code="property.bedroom" text="Bedroom"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Bedroom" path="bedroom" id="bedroom" required="required"/>
							</div>
							<div class="col-lg-4">
								<label for="livingroom"><spring:message code="property.livingroom" text="Living Room"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Living room" path="livingroom" id="livingroom" required="required"/>
							</div>
							<div class="col-lg-4">
								<label for="parking"><spring:message code="property.parking" text="Parking"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Parking" path="parking" id="parking" required="required"/>
							</div>
							<div class="col-lg-4">
								<label for="kitchen"><spring:message code="property.kitchen" text="Kitchen"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Kitchen" path="kitchen" id="kitchen" required="required"/>
							</div>
							<div class="col-lg-4">
								<label for="bathroom"><spring:message code="property.bathroom" text="Bathroom"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Bathroom" path="bathroom" id="bathroom" required="required"/>
							</div>
							<div class="col-lg-4" id="yards">
								<label for="yard"><spring:message code="property.yard" text="Yard"/></label>
								<form:input min="0" value="0" class="form-control" placeholder="Yard" path="yard" id="yard" required="required"/>
							</div>
							<div class="col-lg-4" id="floors">
								<label for="floor"><spring:message code="property.floor" text="Floor"/></label>
								<form:input type="number" min="0" value="0" class="form-control" placeholder="Floor" path="floor" id="floor" required="required" />
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6">
								<label for="agents"><spring:message code="property.agents" text="Agent"/></label>
								<form:select class="form-control" placeholder="Agent" path="agentAccount.id"
									id="agents" required="required" items="${agents}" itemValue="id" itemLabel="firstName">
								</form:select>
							</div>
							<div class="col-lg-6">
								<label for="ucost"><spring:message code="property.ucost" text="Utilities cost"/></label>
								<form:input type="number" min="0" class="form-control" value="0" placeholder="Utilities cost" path="utilitiesCost" required="required" id="ucost"/>
							</div>
						</div>

						<div class="row" id="sellFields">
							<div class="col-lg-6">
								<label for="ucost"><spring:message code="property.sell" text="Sell price"/></label>
								<form:input type="number" min="0" class="form-control" value="0" placeholder="Sell price" path="purposeType.sellPrice" required="required"/>
							</div>
						</div>

						<div class="row" id="rentFields">
							<div class="col-lg-6">
								<label for="ucost"><spring:message code="property.monthly" text="Monthly price"/></label>
								<form:input type="number" min="0" class="form-control" value="0" placeholder="Monthly price" path="purposeType.perMonthPrice" required="required"/>
							</div>
							<div class="col-lg-6">
								<label for="ucost"><spring:message code="property.total" text="Total month"/></label>
								<form:input type="number" min="0" class="form-control" value="0" placeholder="Total month" path="purposeType.rentMonth" required="required"/>
							</div>
							<div class="col-lg-6">
								<label for="ucost"><spring:message code="property.deposit" text="Deposit"/></label>
								<form:input type="number" min="0" class="form-control" value="0" placeholder="Deposit" path="purposeType.deposit" required="required"/>
							</div>
						</div>

						<div class="form-group row" id="addImg">
							<div class="col-lg-6">
								<form:input id="addImg" path="inputImages" type="file" multiple="multiple" required="required"/>
							</div>
						</div>

						<div class="form-group">
							<form:textarea rows="6" class="form-control" placeholder="Property detail" path="description" required="required"></form:textarea>
						</div>

						<button type="submit" class="btn btn-success" name="Submit"><spring:message code="property.submit" text="Upload"/></button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>