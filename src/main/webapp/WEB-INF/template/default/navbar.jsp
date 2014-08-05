<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navrbar-collapse">
					<span class="sr-only">Toggle Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<span class="navbar-brand"><spring:message code="label.navbarbrand"/></span>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a
						href='<c:url value="/timesheets"></c:url>'><spring:message code="label.timesheets"/></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><spring:message code="label.report"/> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href='<c:url value="/timesheets/myreport"></c:url>'><spring:message code="label.myreport"/></a></li>

							<li class="divider"></li>
							<li class="dropdown-header"><spring:message code="label.managers.report"/></li>
							<%-- <li><a href='<c:url value="/timesheets/managerreport"></c:url>'>Manager's
									Report</a></li> --%>
							<li class="divider"></li>
							<li class="dropdown-header"><spring:message code="label.executives.report"/></li>
						</ul>
						
						</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" id="logout"><spring:message code="label.logout"/></a></li>
				</ul>
			</div>
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- navbar navigation -->