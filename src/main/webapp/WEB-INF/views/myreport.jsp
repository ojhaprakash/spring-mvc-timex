<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="container">
		<h1>My Report</h1>
		<!-- <div class="well text-center"> -->
		<div class="row">
			<c:choose>
				<c:when test="${ empty timesheets}">
				You haven't added any timesheets yet.
			</c:when>
				<c:otherwise>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Status</th>
								<th>Ending Date</th>
								<th>Department</th>
								<th>Mon</th>
								<th>Tue</th>
								<th>Wed</th>
								<th>Thu</th>
								<th>Fri</th>
								<th>Sat</th>
								<th>Sun</th>
								<th>Weekly Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${timesheets }" var="timesheet">
								<tr>
									<td>
										<c:choose>
											<c:when test="${empty timesheet.statusCode }">
												Not Submitted
											</c:when>
											<c:otherwise>
												<c:out value="${timesheet.statusCode}" />
											</c:otherwise>
										</c:choose>
									</td>
									<td><c:out value="${timesheet.periodEndingDate}" /></td>
									<td><c:out value="${timesheet.departmentCode}" /></td>
									<td><c:out value="${timesheet.minutesMon}" /></td>
									<td><c:out value="${timesheet.minutesTue}" /></td>
									<td><c:out value="${timesheet.minutesWed}" /></td>
									<td><c:out value="${timesheet.minutesThu}" /></td>
									<td><c:out value="${timesheet.minutesFri}" /></td>
									<td><c:out value="${timesheet.minutesSat}" /></td>
									<td><c:out value="${timesheet.minutesSun}" /></td>
									<td><c:out value="${timesheet.total}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

