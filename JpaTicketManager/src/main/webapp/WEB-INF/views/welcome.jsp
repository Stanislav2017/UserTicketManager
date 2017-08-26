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
	<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
 <!--      <a class="navbar-brand" href="#">Private room</a> -->
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <!-- <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul> -->
     <%--  <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>  --%>
      <a class="btn btn-default navbar-btn navbar-right" href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Log out</a>
      <h4 class="navbar-text navbar-right">Hi, ${user.username}</h4>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
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
					</div>
				</div>
			</div>
			<div class="col-md-6 col-md-offset-1">
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
									<button type="button" class="btn btn-block btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Action<span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li><a href="<c:url value='/edit-ticket/${ticket.id}'/>">Edit <span class="glyphicon glyphicon-pencil pull-right" aria-hidden="true"></span></a></li>
										<li><a href="<c:url value='/delete-ticket/${ticket.id}'/>">Delete <span class="glyphicon glyphicon-remove  pull-right" aria-hidden="true"></span></a></li>
									</ul>
								</div>
							</td>
						</tr>
					</c:forEach>
					<tr><td colspan="7"><a href="<c:url value='/ticket'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a></td></tr>
				</table>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>