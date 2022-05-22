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
	<h2 align="center">Update Customer Information</h2>
	</div>
	
		<div class="card">
			<div class="card-body">
			
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>

				<caption>
					<h2>
						
					<c:if test="${customer == null}">
            			
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Title</label>
					<select placeholder="Select Customer Titel" name= "title" class="form-control" 
						value="<c:out value='${customer.title}'/>" >
                                                      
                              <option >Mr</option>
                              <option >Mrs</option>
					</select>
				</fieldset>
				
				

				<fieldset class="form-group">
					<label>First Name</label> <input type="text"placeholder="Type first name here"
						value="<c:out value='${customer.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"placeholder="Type last name here"
						value="<c:out value='${customer.lname}' />" class="form-control"
						name="lname" required="required">
				</fieldset>
				

				<fieldset class="form-group">
					<label>Email</label> <input type="text"placeholder="Type Email here"
						value="<c:out value='${customer.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Phone No</label> <input type="text"placeholder="Type phone number here"
						value="<c:out value='${customer.phoneNo}' />" class="form-control"
						name="phoneNo" required="required">
				</fieldset>
				
				<fieldset class="form-group">
				 <label>Nationality</label> 
				 
				 <div class="custom-control custom-radio custom-control-inline">
                     <input type="radio" id="local" name="nationality" value="Local" class="custom-control-input" checked>                     
                     <label class="custom-control-label" for="local">Local</label>
                 </div>
                 <div class="custom-control custom-radio custom-control-inline">
                     <input type="radio" id="Foreign" name="nationality" value="Foreign"  class="custom-control-input">
                     <label class="custom-control-label" for="Foreign">Foreign</label>
                 </div>
                </fieldset>

				
				<button type="submit" class="btn btn-info">UPDATE</button>
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