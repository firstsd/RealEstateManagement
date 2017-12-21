<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page session="true" %>

	<div class="inside-banner">
		<div class="container">
			<span class="pull-right"><a href="#">Home</a> / Register</span>
			<h2>Register</h2>
		</div>
	</div>
	<!-- banner -->
	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">

					<form:form modelAttribute="user">
			  		<p>
			  		     <form:errors path="*" cssStyle="color : red;" /> 
			        </p>
					<div class="form-group row">
							<div class="col-lg-6">
								<spring:message code="user.firstName"   text="Username:" var="username"/> 
								<form:input class="form-control" path="firstName"  placeholder="${username}"/> 
								<form:errors path="firstName" class="error"/>
							</div>
							<div class="col-lg-6">
								<spring:message code="user.lastName"  text="Lastname:" var="lastname"/> 
								<form:input class="form-control" path="lastName"  placeholder="${lastname}" />
								<form:errors path="lastName" class="error"/>
							</div>
						</div>
 						<div class="form-group">
							<form:select  class="form-control" items="${roles}" path="role.id" itemLabel="roleName" itemValue="id"/>
						</div>
						<div class="form-group">
							<spring:message code="user.email" text="Email:" var="email"/> 
							<form:input  class="form-control" placeholder="${email}"  path="email" />
							<form:errors path="email" class="error"/>
						</div>
						
						<div class="form-group">
							<spring:message code="user.password" text="Password:" var="password"/>
							<form:input type="password"  class="form-control" placeholder="${password}" path="password"/>
							<form:errors path="password" class="error"/>
						</div>
						
						<div class="form-group">
							<spring:message code="user.mobile" text="Mobile:" var="mobile"/>
							<form:input class="form-control" placeholder="${mobile}" path="mobile" />
							<form:errors path="mobile" class="error"/>
						</div>

						<div class="form-group">
							<spring:message code="address.street" text="Street:" var="street"/>
							<form:input class="form-control"  placeholder="${street}" path="address.street"/>
							<form:errors path="address.street" class="error"/>
						</div>
						<div class="form-group">
							<spring:message code="address.city" text="City:" var="city"/>
							<form:input  class="form-control"  placeholder="${city}" path="address.city"/>
							<form:errors path="address.city" class="error"/>
						</div>
						<div class="form-group">
							<spring:message code="address.state" text="State:" var="state"/>
							<form:input  class="form-control" placeholder="${state}" path="address.state"/>
							<form:errors path="address.state" class="error"/>
						</div>
							<div class="form-group">
							<spring:message code="address.zipcode" text="Zipcode:" var="zipcode"/>
							<form:input class="form-control"  placeholder="${zipcode}" path="address.zipcode"/>
							<form:errors path="address.zipcode" class="error"/>
						</div>
						<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
						<button type="submit" class="btn btn-success" name="_eventId_performRegister"><spring:message code="register" text="Register"/></button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
