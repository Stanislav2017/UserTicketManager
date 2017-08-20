<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/resources/css/bootstrap-theme.css">
</head>
<body>
	<!--formden.js communicates with FormDen server to validate fields and submit via AJAX -->
<script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>

<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3">
				<div class="jumbotron">
					<h2 class="text-center">${message}</h2>
					<hr class="featurette-divider">
					<form:form modelAttribute="ticket" method="POST">
					<form:input type="hidden" path="id" id="id" />
						<div class="form-group">
							<label for="timeStart" class="control-label">Date</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
								<form:input path="date" class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text"/>
							</div>
						</div>
						<div class="form-group">
							<label for="timeStart" class="control-label">Price</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
								<form:input type="text" path="price" id="price" class="form-control" placeholder="Price" />
							</div>
						</div>
						<hr class="featurette-divider">
						<input type="submit" value="Submit" class="btn btn-primary btn-sm btn-block" />
						<a href="<c:url value='/list'/>" class="btn btn-danger btn-sm btn-block">Cancel</a>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Include Date Range Picker -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- Include Date Range Picker -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

	<script>
		$(document).ready(function(){
			var date_input=$('input[name="date"]'); //our date input has the name "date"
			var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
			date_input.datepicker({
				format: 'mm/dd/yyyy',
				container: container,
				todayHighlight: true,
				autoclose: true,
			})
		})
	</script>

</body>
<%-- <body>
	<!--formden.js communicates with FormDen server to validate fields and submit via AJAX -->
	<script type="text/javascript" src="https://formden.com/static/cdn/formden.js"></script>

	<!-- Special version of Bootstrap that is isolated to content wrapped in .bootstrap-iso -->
	<link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

	<!--Font Awesome (added because you use icons in your prepend/append)-->
	<link rel="stylesheet" href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />

	<form:form modelAttribute="ticket" method="POST">
		<div class="modal-dialog">
			<div class="modal-content">
				<form:input type="hidden" path="id" id="id" />
				<div class="modal-header">
					<c:choose>
						<c:when test="${edit}">
							<h4 class="modal-title" id="exampleModalLabel">Change ticket</h4>
						</c:when>
						<c:otherwise>
							<h4 class="modal-title" id="exampleModalLabel">Create new
								ticket</h4>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="dayStart" class="control-label">Date</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
							<form:input class="form-control" id="date" name="date" path="date" placeholder="MM/DD/YYYY" type="text"/>
						</div>
					</div>
					<div class="form-group">
						<label for="timeStart" class="control-label">Price</label>
						<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
							<form:input type="text" path="price" id="price" class="form-control" placeholder="Price" />
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" class="btn btn-primary btn-sm" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" class="btn btn-primary btn-sm" />
						</c:otherwise>
					</c:choose>
					<a href="<c:url value='/list'/>" class="btn btn-default">Close</a>
				</div>
			</div>
		</div>
	</form:form>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>

	<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
	<!-- Include jQuery -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- Include Date Range Picker -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

	<script>
		$(document).ready(
				function() {
					var date_input = $('input[name="date"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'mm/dd/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
					})
				})
	</script>

</body> --%>
</html>