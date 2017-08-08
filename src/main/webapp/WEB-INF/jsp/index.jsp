<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<META CHARSET="UTF-8">
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">

<title>Savings App | Home</title>

<link href="/static/css/bootstrap-sandstone.min.css" rel="stylesheet">
<!-- <link href="/static/css/bootstrap.min.css" rel="stylesheet"> -->

<script src="/static/js/jquery-3.1.1.min.js"></script>
<script src="/static/js/bootstrap.min.js"></script>

<style type="text/css">
.input-group-addon {
	min-width: 120px;
	text-align: left;
}
</style>


</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/">Savings App</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/">Home</a></li>
						<li><a href="budget">Manage Budget </a></li>
						<li><a href="expense">Manage Expense</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<c:choose>

			<c:when test="${MODE == 'HOME'}">
				<div class="jumbotron">
					<h1>Savings Application</h1>
					<p>Money is a terrible master but an excellent servant. --P.T.
						Barnum</p>
					<p>
						<a class="btn btn-primary btn-lg" href="/">Show summary</a>
					</p>
				</div>
			</c:when>

		</c:choose>

	</div>

</body>
</html>
