<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<link href="${contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="thumbnail">
					<div class="caption">
						<h3></h3>
						<table class="table table-condensed">
							<tr>
								<td class="active">First Name</td>
								<td>${user.firstName}</td>
							</tr>
							<tr>
								<td class="active">Last Name</td>
								<td>${user.lastName}</td>
							</tr>
							<tr>
								<td class="active">Patronymic</td>
								<td>${user.patronymic}</td>
							</tr>
							<tr>
								<td class="active">Username</td>
								<td>${user.username}</td>
							</tr>
						</table>
						<a href="<c:url value='/edit-user/${user.id}'/>" class="btn btn-default btn-block" title="change this user">
							<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						</a>
						<a href="<c:url value='/logout'/>" class="btn btn-default btn-block" title="Log out">
							<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<table class="table table-bordered">
					<tr>
						<th><p class="text-center">#</p></th>
						<th><p class="text-center">Date</p></th>
						<th><p class="text-center">Price</p></th>
						<th><p class="text-center">Action</p></th>
					</tr>
					<c:forEach items="${user.tickets}" var="ticket">
						<tr>
							<td><p class="text-center">${ticket.id}</p></td>
							<td><p class="text-center">${ticket.date}</p></td>
							<td><p class="text-center">${ticket.price}</p></td>
							<td>
								<div class="btn-group btn-block" role="group">
									<button type="button" class="btn btn-block btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										Action<span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li>
											<a href="<c:url value='/edit-ticket/${ticket.id}'/>">
												Edit <span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span>
											</a>
										</li>
										<li>
											<a href="<c:url value='/delete-ticket/${ticket.id}'/>">
												Delete <span class="glyphicon glyphicon-remove  pull-right" aria-hidden="true"></span>
											</a>
										</li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="7"><a href="<c:url value='/ticket'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>