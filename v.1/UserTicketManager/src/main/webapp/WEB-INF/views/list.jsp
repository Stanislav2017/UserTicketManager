<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass List</title>
<link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/resources/css/bootstrap-theme.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="thumbnail">
					<a href="<c:url value='/newuser'/>" class="btn btn-block btn-default"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
					<div class="btn-group btn-block" role="group">
						<button type="button" class="btn btn-block btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Action<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<c:forEach items="${users}" var="u">
								<li><a href="<c:url value='/userinfo/${u.id}'/>">${u.firstName}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>