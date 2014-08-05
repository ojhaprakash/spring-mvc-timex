<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="printTemplate">
	<tiles:putAttribute name="container">
		<h1>
			My Weekly Report for
			<c:out value="${timesheet.periodEndingDate}"></c:out>
		</h1>
		<!-- <div class="well text-center"> -->
		<div class="row">
			<table class="table table-striped table-hover">
				<tbody>
					<tr>
						<td>Status</td>
						<td><c:out value="${timesheet.statusCode }"></c:out></td>
					</tr>
					<tr>
						<td>Ending Date</td>
						<td><c:out value="${timesheet.periodEndingDate}" /></td>
					</tr>
					<tr>
						<td>Department</td>
						<td><c:out value="${timesheet.departmentCode}" /></td>
					</tr>
					<tr>
						<td>Mon</td>
						<td><c:out value="${timesheet.minutesMon }"></c:out></td>
					</tr>
					<tr>
						<td>Tue</td>
						<td><c:out value="${timesheet.minutesTue }"></c:out></td>
					</tr>
					<tr>
						<td>Wed</td>
						<td><c:out value="${timesheet.minutesWed }"></c:out></td>
					</tr>
					<tr>
						<td>Thur</td>
						<td><c:out value="${timesheet.minutesThu }"></c:out></td>
					</tr>
					<tr>
						<td>Fri</td>
						<td><c:out value="${timesheet.minutesFri }"></c:out></td>
					</tr>
					<tr>
						<td>Sat</td>
						<td><c:out value="${timesheet.minutesSat }"></c:out></td>
					</tr>
					<tr>
						<td>Sun</td>
						<td><c:out value="${timesheet.minutesSun }"></c:out></td>
					</tr>
					<tr>
						<td>Total :</td>
						<td><c:out value="${timesheet.total /60 }"></c:out> Hr(s)</td>
					</tr>
				</tbody>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
