<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style type="text/css">
  .header{
   background-color: #000099;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
  
  } 
  .well{
      background-color: #4dff88;
      padding:10px;
      border-radius:13px
  }
   
   
</style>
<title>SunSet Hotel Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
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
	<h2 align="center">Add Room</h2>
	</div>
	
		<div class="card">
			<div class="card-body">
			
				<c:if test="${room != null}">
					<form action="update" method="post">
				</c:if>

				<caption>
					<h2>
						
					<c:if test="${room == null}">
            			
            		</c:if>
					</h2>
				</caption>

				<c:if test="${room != null}">
					<input type="hidden" name="id" value="<c:out value='${room.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>CODE</label> <input type="text"placeholder="Type CODE here"
						value="<c:out value='${room.code}' />" class="form-control"
						name="code" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Stock Name</label> <input type="text"placeholder="Type stock name here"
						value="<c:out value='${room.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Brand</label> <input type="text"placeholder="Type brand here"
						value="<c:out value='${stock.brand}' />" class="form-control"
						name="brand" required="required">
				</fieldset>

				
				<fieldset class="form-group">
					<label>QTY <input type="text" placeholder="Type quantity here" 
						value="<c:out value='${stock.qty}' />" class="form-control"
						name="qty" required="required">
				</fieldset>

				
				<fieldset class="form-group">
					<label>Import Date</label> <input type="date"
						value="<c:out value='${stock.importdate}' />" class="form-control"
						name="importdate" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Expire Date</label> <input type="date"
						value="<c:out value='${stock.expiredate}' />" class="form-control"
						name="expiredate">
				</fieldset>
				
				
				
				<button type="submit" class="btn btn-info">ADD</button>
				<button type="reset" class="btn btn-info">CANCEL</button>
				<br/><br/>
				<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="btn btn-secondary" class="nav-link">View All Stocks</a></li>
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