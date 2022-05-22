<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
	<h2 align="center">Add Reservation</h2>
	</div>
	 
		<div class="card">
			<div class="card-body">
			
		  	
			<c:if test="${reservation != null}">
					<form action="Rupdate" method="post">
				</c:if> 
				<c:if test="${reservation == null}">
					<form action="Rinsert" method="post">
				</c:if>

				<caption>
					<h2>
						
					<c:if test="${reservation == null}">
            			
            		</c:if>
					</h2>
				</caption>
			
			
			
			<c:if test="${reservation != null}">
					<input type="hidden" name="id" value="<c:out value='${reservation.id}' />" />
				</c:if>
			<!-- 	
				<fieldset class="form-group">
					<label>Customer ID</label> <input type="text"placeholder="Type  here"
						value="<c:out value='${roomreservation.customerid}' />" class="form-control"
						name="customerid" required="required">
				</fieldset>
				-->
				
				<fieldset class="form-group">
					<label>Customer ID</label> <input type="number"oninput="javascript: if (this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" maxlength = "4"
						placeholder="Type Customer ID here"value="<c:out value='${reservation.customerid}' />" class="form-control"
						name="customerid">
				</fieldset> 
				
				
				<fieldset class="form-group">
					<label>Check In Date</label> <input type="date"
						value="<c:out value='${reservation.checkindate}' />" class="form-control"
						name="checkindate" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Check Out Date</label> <input type="date"
						value="<c:out value='${reservation.checkoutdate}' />" class="form-control"
						name="checkoutdate" required="required">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Payment Method</label>
					<select placeholder="Select the Room Type" name= "paymentMethod" class="form-control" 
						value="<c:out value='${reservation.paymentMethod}'/>" >
                               
                              <option >--SELECT--</option>                        
                              <option >Card</option>
                              <option >Cash</option>
					</select>
				</fieldset>
				
				<button type="submit"  class="btn btn-info" >ADD</button>
				<button type="reset" class="btn btn-info">CANCEL</button>
				
				<br/><br/>
				<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="btn btn-secondary" class="nav-link">View Available Rooms</a></li>
			</ul>
			</form>
			</div>
			</div>
			</div>
			</div>
			</div>
	
	

</body>
</html>