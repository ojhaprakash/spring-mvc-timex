<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="printTemplate">
	<tiles:putAttribute name="container">
		<div class="well col-sm-6">
			<h3>
				<spring:message code="label.login"></spring:message>
			</h3>

			<c:if test="${not empty param.error}">
				<div id="infomessage" class="alert alert-danger">
					<spring:message code="message.loginfail.reason" />:
					<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
				</div>
			</c:if>
			<c:if test="${not empty param.logout}">
				<div id="infomessage" class="alert alert-info">
					<spring:message code="message.successful.logout" />
					.
				</div>
			</c:if>
			<form name='loginForm' class="form-horizontal"
				action="<c:url value='j_spring_security_check' />" method='POST'>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group">
					<label for="username" class="col-sm-4 control-label"><spring:message
							code="label.username" />:</label>
					<div class="col-sm-4">
						<input type="text" name="username"
							placeholder="<spring:message code="label.username" />" />
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-4 control-label"><spring:message
							code="label.password" />:</label>
					<div class="col-sm-4">
						<input type="password" name="password"
							placeholder="<spring:message code="label.password" />" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<!-- <label class="inline">  -->
						<a href="?locale=en">English</a> &nbsp;|&nbsp;
						<!-- </label> --> <a href="?locale=fr">French</a>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<button type="submit" name="submit" class="btn btn-default">
							<spring:message code="label.login" />
						</button>
					</div>
				</div>
			</form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

