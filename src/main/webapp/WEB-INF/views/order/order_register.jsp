<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:setLocale value="en_US" />
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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
			<div class="row register">
				<div
					class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
					<form:form method="POST" modelAttribute="order" action="register?propertyId=${property.getId()}">
						<div><form:errors path="*" cssStyle="color : red;" /></div>
						<form:hidden path="propertyId" value="${property.getId()}"/>
						<label for="role">Your offer</label>

						<c:choose>
							<c:when test="${property.getPurposeName() == 'sell'}">
								<div class="form-group row">
									<form:input type="text" class="form-control" placeholder="Amount"
										path="offerBuyAmount" required="required"/>
								</div>
							</c:when>
							<c:otherwise>

								<div class="form-group row">
									<form:input type="text" class="form-control" placeholder="Total months" path="offerRentMonths" required="required"/>
									<form:input type="text" class="form-control" placeholder="Amount (Per month)" path="offerRentPerMonthAmount" required="required"/>
									<form:input type="text" class="form-control" placeholder="Deposit" path="offerRentDespositAmount" required="required"/>
									<label for="role">To extend : </label>
									<form:radiobutton path="offerIsExtend" value="1" id="Yes"/>
									<label for="Yes">Yes</label>
									<form:radiobutton path="offerIsExtend" value="0" id="No" checked="checked"/>
									<label for="No"> No</label>
								</div>
							</c:otherwise>
						</c:choose>

						<div class="form-group row">
							<form:textarea rows="6" class="form-control" placeholder="Order Comment" path="comment" required="required"></form:textarea>
						</div>
						<button type="submit" class="btn btn-success" name="Submit">Create</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>