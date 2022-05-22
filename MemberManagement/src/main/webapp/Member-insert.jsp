<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2 align="center">Add Member Information</h2>
	</div>
	
		<div class="card">
			<div class="card-body">
			
			
			
				<c:if test="${member != null}">
					<form action="update" method="post"> 
				</c:if> 
				<c:if test="${member == null}">
					<form action="insert" method="post"> 
				</c:if>

				<caption>
					<h2>
						
					<c:if test="${member == null}">
            			
            		</c:if>
					</h2>
				</caption>

				


				<c:if test="${member != null}">
					<input type="hidden" name="no" value="<c:out value='${member.no}' />" />
				</c:if>
								

				<fieldset class="form-group">
					<label>Full Name</label> <input type="text"placeholder="Type full name here"
						value="<c:out value='${member.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Customer ID</label> <input type="text"placeholder="Type Customer ID here"
						value="<c:out value='${member.cid}' />" class="form-control"
						name="cid" required="required">
				</fieldset>
				

				<fieldset class="form-group">
					<label>Membership Type</label> <input type="text"placeholder="Type Member type here"
						value="<c:out value='${member.type}' />" class="form-control"
						name="type" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Valid From</label> <input type="date"
						value="<c:out value='${member.sdate}' />" class="form-control"
						name="sdate" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Valid Until</label> <input type="date"
						value="<c:out value='${member.edate}' />" class="form-control"
						name="edate" required="required">
				</fieldset>

                							
				
				<button type="submit" class="btn btn-info">ADD</button>
				<button type="reset" class="btn btn-info">CANCEL</button>
				<br/><br/>
				<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="btn btn-secondary" class="nav-link">View All Member</a></li>
			</ul>
				
				</form>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>