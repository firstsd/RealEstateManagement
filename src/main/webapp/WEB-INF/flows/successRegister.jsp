<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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
					<div class="alert alert-success">
					  <strong>Success!</strong>
					   <p>firstName: ${user.firstName }</p>
					   <p>lastName: ${user.lastName }</p>
					   <p>email: ${user.email }</p>
					</div>
				</div>
			</div>
		</div>
	</div>
