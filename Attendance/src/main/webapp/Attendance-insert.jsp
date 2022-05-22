<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style type="text/css">
.header {
	background-color: #000099;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

.well {
	background-color: #4dff88;
	padding: 10px;
	border-radius: 13px
}
</style>
<title>SunSet Hotel Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="CSS/InsertForm.css">

</head>
<body>


	<header>

		<div class="header">
			<h1>SunSet Hotel Management</h1>
		</div>

	</header>

	<div class="bg">

		<br>
		<div class="container">

			<div class="col-lg-6 well">
				<div class="tit">
					<h2 align="center">Add Staff Member</h2>
				</div>

				<div class="card">
					<div class="card-body">



						<c:if test="${attendance != null}">
							<form action="update" method="post">
						</c:if>
						<c:if test="${attendance == null}">
							<form action="insert" method="post">
						</c:if>

						<caption>
							<h2>

								<c:if test="${attendance == null}">

								</c:if>
							</h2>
						</caption>




						<c:if test="${attendance != null}">
							<input type="hidden" name="id"
								value="<c:out value='${attendance.id}' />" />
						</c:if>

						<fieldset class="form-group">
							<label>Name</label> <input type="text"
								placeholder="Type Member name here"
								value="<c:out value='${attendance.name}' />" class="form-control"
								name="name" required="required">
						</fieldset>

					<fieldset class="form-group">
							<label>Type Of Work</label> <select
								placeholder="Select the Type Of Work" name="typeOfWork"
								class="form-control"
								value="<c:out value='${attendance.typeOfWork}'/>">

								<option>Sales Manager</option>
								<option>General Manager</option>
								<option>HR Manager</option>

							</select>
						</fieldset>

						<fieldset class="form-group">
							<label>Date</label> <input type="date"
								placeholder="Enter Date here"
								value="<c:out value='${attendance.date}' />"
								class="form-control" name="date" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>In Time</label> <input type="time"
								placeholder="Enter IN Time here"
								value="<c:out value='${attendance.address}' />" class="form-control"
								name="inTime" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Out Time</label> <input type="time"
								placeholder="Enter Out Time here"
								value="<c:out value='${attendance.address}' />" class="form-control"
								name="outTime" required="required">
						</fieldset>



						<button type="submit" class="btn btn-info">ADD</button>
						<button type="reset" class="btn btn-info">CANCEL</button>
						<br />
						<br />
						<ul class="navbar-nav">
							<li><a href="<%=request.getContextPath()%>/list"
								class="btn btn-secondary" class="nav-link">View All Attendance</a></li>
						</ul>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
>
