<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SunSet Hotel Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"crossorigin="anonymous">
	
	
	
<style type="text/css">

.myInput {
  background-image: url('/css/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
}

.header{
   background-color: #000099;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
</style>

<link rel="stylesheet" type="text/css" href="CSS/List.css">

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
    
	<div class="col-lg-12">
	
		<div class="card">
			<div class="card-body">
	<div class="row">

		<div class="container">
			<h2 class="text-center">Member List</h2>
		
			<div class="container text-left">
			
			<a href="Member-insert.jsp" class="btn btn-secondary">ADD
					New Member</a>

					
				<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for Member ID" title="Type in a name">	

			</div>
			<br>
			<table class="table table-bordered table table-hover"id="myTable">
				<thead class="thead-dark">
					<tr>
						<th>Membership No</th>
						<th>Name</th>
						<th>Customer ID </th>
						<th>Membership Type</th>
						<th>Valid From</th>
						<th>Valid Until</th>
						<th>ACTION</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="member" items="${listMember}">

						<tr>
							<td><c:out value="${member.no}" /></td>
							<td><c:out value="${member.name}" /></td>
							<td><c:out value="${member.cid}" /></td>
							<td><c:out value="${member.type}" /></td>
							<td><c:out value="${member.sdate}" /></td>
							<td><c:out value="${member.edate}" /></td>
						
							<td>
							<div class="btn-group">
                                        <label class="p-0 mr-1 my-0">
                                            <a href="edit?id=<c:out value='${member.no}' />"><button type="submit" class="btn btn-primary">Edit</button></a>
                                        </label>
                                        <label class="p-0 my-0">
                                            <a href="delete?id=<c:out value='${member.no}' />"><button type="submit" class="btn btn-danger"value="delete" onclick="return confirm('Are you sure you want to delete?')">Delete</button>
                                        </label>   
                                    </div>	
							</td>
						</tr>
					</c:forEach>
				
				</tbody> 

			</table>
			
			<script>
			function myFunction() {
				  // Declare variables
				  var input, filter, table, tr, td, i, txtValue;
				  input = document.getElementById("myInput");
				  filter = input.value.toUpperCase();
				  table = document.getElementById("myTable");
				  tr = table.getElementsByTagName("tr");

				  // Loop through all table rows, and hide those who don't match the search query
				  for (i = 0; i < tr.length; i++) {
				    td = tr[i].getElementsByTagName("td")[0];
				    if (td) {
				      txtValue = td.textContent || td.innerText;
				      if (txtValue.toUpperCase().indexOf(filter) > -1) {
				        tr[i].style.display = "";
				      } else {
				        tr[i].style.display = "none";
				      }
				    }
				  }
				}
</script>

<a href="<%=request.getContextPath()%>/report" > <button type="button" class="btn btn-success">Customer Report</button></a>

		</div>
	</div>
	
	<!-- FOOTER -->
        <footer class="container">
            <p class="float-right"><a href="#">Back to top</a></p>
            <p>&copy; 2022 SLIIT. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        </footer>
        </div>
        </div>
        </div>
        </div>
        </div>
</body>
</html>