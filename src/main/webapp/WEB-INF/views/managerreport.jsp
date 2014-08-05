<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="container">
			<h1>Report for All Employees</h1>
		<!-- <div class="well text-center"> -->
	
		<div class="row">
		
		<c:forEach items="${employees }" var="employee">	
		<h3>
			<c:out value="${employee.name }"></c:out>
		</h3>
			<c:choose>
				<c:when test="${ empty employee.timesheets}">
				No timesheet for This employee.
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
							<c:forEach items="${employee.timesheets }" var="timesheet">
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
		</c:forEach>
		</div> <!-- //row -->
	</tiles:putAttribute>
</tiles:insertDefinition>