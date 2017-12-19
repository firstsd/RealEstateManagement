<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	

	<div class="container">
		<div class="spacer agents">

			<div class="row">
				<div class="col-lg-8  col-lg-offset-2 col-sm-12">
					<c:forEach var="agent" items="${agents}" varStatus="loop">
<%-- 						<c:set var="i_url" scope="session" value="${loop.index + 1}.jpg" /> --%>
						<!-- 					#foreach($agent in $agents) #set( $i_url = $foreach.count + ".jpg" ) -->
						<!-- agents -->
						<div class="row">
							<div class="col-lg-2 col-sm-2 ">
								<a href="#"><img src="public/images/agents/${i_url}" class="img-responsive" alt="agent name"></a>
							</div>
							<div class="col-lg-7 col-sm-7 ">
								<h4>${agent.firstName} ${agent.lastName}</h4>
								<p>Collaboratively administrate empowered markets via plug-and-play networks. Dynamically procrastinate B2C
									users after installed base benefits. Dramatically visualize customer directed convergence without revolutionary
									ROI.</p>
							</div>
							<div class="col-lg-3 col-sm-3 ">
								<span class="glyphicon glyphicon-envelope"></span> <a href="mailto:${agent.email}">${agent.email}</a><br>
								<span class="glyphicon glyphicon-earphone"></span> ${agent.mobile}
							</div>
						</div>
						<!-- agents -->
					</c:forEach>
					<!-- 					#end -->
				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>