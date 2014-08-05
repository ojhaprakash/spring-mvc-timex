<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="container">

		<h1><spring:message code="label.mytimesheets"/></h1>
		<!-- <div class="well text-center"> -->

		<div class="row">
			<span class="pull-right"><a class="btn btn-default btn-sm"
				href='<c:url value="/timesheets/new"></c:url>'><spring:message code="label.addtimesheets"/></a></span>
		</div>
		<div class="row">
			<c:choose>
				<c:when test="${ empty timesheets}">
				<spring:message code="label.notimesheets"/>
			</c:when>
				<c:otherwise>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th><spring:message code="label.status"/></th>
								<th><spring:message code="label.endingdate"/></th>
								<th><spring:message code="label.department"/></th>
								<th>Mon</th>
								<th>Tue</th>
								<th>Wed</th>
								<th>Thu</th>
								<th>Fri</th>
								<th>Sat</th>
								<th>Sun</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${timesheets }" var="timesheet">
								<tr>
									<td><c:choose>
											<c:when test="${empty timesheet.statusCode }">
												<a class="btn btn-default btn-sm"
													href='<c:url value="/timesheets/submit/${timesheet.id}"/>'>Submit
													<spring:message code="label.submit" />
													</a>
											</c:when>
											<c:otherwise>
												<c:out value="${timesheet.statusCode}" />
											</c:otherwise>
										</c:choose></td>
									<td><a href='<c:url value="/timesheets/${timesheet.id}"/>'><c:out
												value="${timesheet.periodEndingDate}" /></a></td>
									<td><c:out value="${timesheet.departmentCode}" /></td>
									<td><c:out value="${timesheet.minutesMon}" /></td>
									<td><c:out value="${timesheet.minutesTue}" /></td>
									<td><c:out value="${timesheet.minutesWed}" /></td>
									<td><c:out value="${timesheet.minutesThu}" /></td>
									<td><c:out value="${timesheet.minutesFri}" /></td>
									<td><c:out value="${timesheet.minutesSat}" /></td>
									<td><c:out value="${timesheet.minutesSun}" /></td>
									<td><a class="btn btn-default btn-sm" target="_blank"
										href='<c:url value="/timesheets/printreport/${timesheet.id}"/>'><spring:message code="label.print"/></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

