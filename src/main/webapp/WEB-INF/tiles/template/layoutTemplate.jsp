<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<c:set var="title"><tiles:getAsString name="title" /></c:set>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.css"/> "/>
	<link rel="stylesheet" href="<c:url value="/resources/assets/style.css"/> " />
	<script src="<c:url value="/resources/assets/jquery-1.9.1.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/assets/script.js"/>"></script>
	
	<!-- Owl stylesheet -->
	<link rel="stylesheet" href="<c:url value="/resources/assets/owl-carousel/owl.carousel.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/assets/owl-carousel/owl.theme.css"/>">
	<script src="<c:url value="/resources/assets/owl-carousel/owl.carousel.js"/>"></script>
	<!-- Owl stylesheet -->
	
	<!-- slitslider -->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/slitslider/css/style.css"/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/assets/slitslider/css/custom.css"/>" />
	<script type="text/javascript" src="<c:url value="/resources/assets/slitslider/js/modernizr.custom.79639.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/assets/slitslider/js/jquery.ba-cond.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/assets/slitslider/js/jquery.slitslider.js"/>"></script>
	<!-- slitslider -->
	
	
	<script type="text/javascript">
		function submitForm(itemValue) {
	
			var form = document.createElement("form");
			form.method = "POST";
			form.action = "property/list";
	
			var element1 = document.createElement("input");
			element1.name = "searchBy";
			element1.value = '';
			form.appendChild(element1);
	
			var element2 = document.createElement("input");
			element2.name = "searchPurposeTypeId";
			element2.value = itemValue;
			form.appendChild(element2);
	
			var element3 = document.createElement("input");
			element3.name = "searchPropertyTypeId";
			element3.value = 0;
			form.appendChild(element3);
	
			var element4 = document.createElement("input");
			element4.name = "order";
			element4.value = 0;
			form.appendChild(element4);
	
			var element5 = document.createElement("input");
			element5.name = "currentPage";
			element5.value = 1;
			form.appendChild(element5);
	
			document.body.appendChild(form);
	
			form.submit();
		}
		var mainMenu = '${mainMenu}';
		$(document).ready(function() {
			$("#mainMenu li").each(function(index) {
				$('li a').removeClass("active");
				if ($(this).text() == mainMenu) {
					$(this).addClass("active");
				}
			});
		});
	</script>

</head>

<body>

	<!-- Header Starts -->
	<div class="navbar-wrapper">
		<tiles:insertAttribute name="navigation" />
	</div>
	<!-- #Header Starts -->

	<div class="container">
		<!-- Header Starts -->
		<tiles:insertAttribute name="header" />
	</div>

	<tiles:insertAttribute name="body" />

	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- Modal -->
	<div id="loginpop" class="modal fade">
		<tiles:insertAttribute name="loginpop" />
	</div>
</body>
</html>
