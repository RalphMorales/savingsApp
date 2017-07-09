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

<script>
	$(function() {
		$("#budget-content").load("/budget/manage-budget.html");
	});
</script>

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
						<li><a href="/">Home</a></li>
						<li><a href="budget">Manage Expense </a></li>
						<li class="active"><a href="expense">Manage Expense</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<c:choose>

			<c:when test="${MODE == 'ALL_EXPENSE'}">

				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">


						<div class="panel panel-default">
							<div class="panel-heading">Summary</div>
							<div class="panel-body">
								<table class="table">
									<tbody>
										<tr>
											<td>Total Expense</td>
											<td><span class="label label-primary">${totalExpense}</span></td>
										</tr>
										<tr>
											<td>Remaining Expense</td>
											<td><span class="label label-primary">${remainingExpense}</span></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>


						<div class="panel panel-default">
							<div class="panel-heading">Add Budget</div>
							<div class="panel-body">
								<div style="padding: 15px;">
									<form action="save-budget" method="POST"
										class="form-horizontal">
										<input type="hidden" name="id" value="${budget.id}">
										<div class="panel">
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon" id="basic-addon1">Description</span>
													<input type="text" class="form-control" name="description"
														placeholder="Description" value="${budget.description}"
														aria-describedby="basic-addon1">
												</div>
											</div>
											<div class="form-group">
												<div class="input-group">
													<span class="input-group-addon" id="basic-addon2">Amount
													</span> <input type="text" class="form-control"
														placeholder="Amount" name="amount"
														value="${budget.amount}" aria-describedby="basic-addon1">
												</div>
											</div>
											<div class="form-group text-center">
												<input type="submit" class="btn btn-primary"
													value="Add Budget" />
											</div>
										</div>
									</form>
								</div>
							</div>

						</div>
					</div>

					<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>#</th>
									<th>Description</th>
									<th>Date Created</th>
									<th>Amount</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${not empty budgets}">
									<c:forEach var="budget" items="${budgets}">
										<tr>
											<td>${budget.id}</td>
											<td>${budget.description}</td>
											<td><fmt:formatDate type="both"
													value="${budget.dateCreated}" /></td>
											<td>${budget.amount}</td>
											<td><a href="delete-budget?id=${budget.id}"><span
													class="glyphicon glyphicon-trash"></span></a></td>
										</tr>
									</c:forEach>
								</c:if>
							</tbody>
						</table>
					</div>
				</div>
			</c:when>

		</c:choose>

	</div>

</body>
</html>
