<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="container">
		<h1>Add/Modify Timesheet</h1>
<!-- <div class="well text-center"> -->
<div class="row">
	<c:url var="formUrl" value="/timesheets"></c:url>
	<form:form action="${formUrl }" modelAttribute="timesheet"
		cssClass="form-horizontal">
		<form:hidden path="employee.id" />
		<div class="form-group">
			<label for="periodEndingDate" class="col-sm-2 control-label">End
				Date:</label>
			<div class="col-sm-2">
				<form:input path="periodEndingDate" placeholder="YYYY-MM-DD"
					cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="statusCode" class="col-sm-2 control-label">Status:</label>
			<div class="col-sm-2">
				<form:input path="statusCode" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="departmentCode" class="col-sm-2 control-label">Department:</label>
			<div class="col-sm-2">
				<form:select path="departmentCode" cssClass="form-control"
					items="${departments }" itemLabel="name" itemValue="departmentCode"></form:select>
			</div>
		</div>
		<div class="form-group">
			<label for="minutesMon" class="col-sm-2 control-label">minutesMon:</label>
			<div class="col-sm-1">
				<form:input path="minutesMon" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesTue" class="col-sm-2 control-label">minutesTue:</label>
			<div class="col-sm-1">
				<form:input path="minutesTue" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesWed" class="col-sm-2 control-label">minutesWed:</label>
			<div class="col-sm-1">
				<form:input path="minutesWed" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesThu" class="col-sm-2 control-label">minutesThu:</label>
			<div class="col-sm-1">
				<form:input path="minutesThu" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesFri" class="col-sm-2 control-label">minutesFri:</label>
			<div class="col-sm-1">
				<form:input path="minutesFri" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesSat" class="col-sm-2 control-label">minutesSat:</label>
			<div class="col-sm-1">
				<form:input path="minutesSat" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="minutesSun" class="col-sm-2 control-label">minutesSun:</label>
			<div class="col-sm-1">
				<form:input path="minutesSun" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default btn-sm">Save</button>
			</div>
		</div>
	</form:form>
</div>
	</tiles:putAttribute>
</tiles:insertDefinition>


