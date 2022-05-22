<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Report Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"crossorigin="anonymous">


<link rel="stylesheet" type="text/css" href="CSS/Report.css">

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>   
<script type="text/javascript" src="https://html2canvas.hertzen.com/dist/html2canvas.js"></script>  


<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>

<!--  
<script type="text/javascript" src="https://unpkg.com/jspdf@2.5.1/dist/jspdf.es.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script> -->


<script type="text/javascript">

function Convert_HTML_To_PDF() {
	  var elementHTML = document.getElementById('contentToPrint');

	  html2canvas(elementHTML, {
	    useCORS: true,
	    onrendered: function(canvas) {
	      var pdf = new jsPDF('p', 'pt', 'A4');

	      var pageHeight = 980;
	      var pageWidth = 900;
	      for (var i = 0; i <= elementHTML.clientHeight / pageHeight; i++) {
	        var srcImg = canvas;
	        var sX = 0;
	        var sY = pageHeight * i; // start 1 pageHeight down for every new page
	        var sWidth = pageWidth;
	        var sHeight = pageHeight;
	        var dX = 0;
	        var dY = 0;
	        var dWidth = pageWidth;
	        var dHeight = pageHeight;

	        window.onePageCanvas = document.createElement("canvas");
	        onePageCanvas.setAttribute('width', pageWidth);
	        onePageCanvas.setAttribute('height', pageHeight);
	        var ctx = onePageCanvas.getContext('2d');
	        ctx.drawImage(srcImg, sX, sY, sWidth, sHeight, dX, dY, dWidth, dHeight);

	        var canvasDataURL = onePageCanvas.toDataURL("image/png", 1.0);
	        var width = onePageCanvas.width;
	        var height = onePageCanvas.clientHeight;

	        if (i > 0) // if we're on anything other than the first page, add another page
	          pdf.addPage(612, 864); // 8.5" x 12" in pts (inches*72)

	        pdf.setPage(i + 1); // now we declare that we're working on that page
	        pdf.addImage(canvasDataURL, 'PNG', 20, 40, (width * .62), (height * .62)); // add content to the page
	      }
				
		  // Save the PDF
	      pdf.save('document.pdf');
	    }
	  });
	}

</script>
  
<script type="text/javascript">     
        //Create PDf from HTML...
function CreatePDFfromHTML() {
    var HTML_Width = $(".html-content").width();
    var HTML_Height = $(".html-content").height();
    var top_left_margin = 15;
    var PDF_Width = HTML_Width + (top_left_margin * 2);
    var PDF_Height = (PDF_Width * 1.5) + (top_left_margin * 2);
    var canvas_image_width = HTML_Width;
    var canvas_image_height = HTML_Height;

    var totalPDFPages = Math.ceil(HTML_Height / PDF_Height) - 1;

    html2canvas($(".html-content")[0]).then(function (canvas) {
        var imgData = canvas.toDataURL("image/jpeg", 1.0);
        var pdf = new jsPDF('p', 'pt', [PDF_Width, PDF_Height]);
        pdf.addImage(imgData, 'JPG', top_left_margin, top_left_margin, canvas_image_width, canvas_image_height);
        for (var i = 1; i <= totalPDFPages; i++) { 
            pdf.addPage(PDF_Width, PDF_Height);
            pdf.addImage(imgData, 'JPG', top_left_margin, -(PDF_Height*i)+(top_left_margin*4),canvas_image_width,canvas_image_height);
        }
        pdf.save("Your_PDF_Name.pdf");
        $(".html-content").hide();
    });
}
        
</script> 

</head>
<body>

<div class="main-page">
      <div class="sub-page">
        <h3 align='center'></h3>
        <div id="contentToPrint">
        <div id="html-content">
        
        <header>
			<h1>HOTEL SUNSET</h1>
			<address >
				<p>SUN SET HOTEL,</p>
				<p>GotaGo Road,<br>GallFace,<br>SriLanka.</p>
				<p>036XXXXXXX</p>
			</address>
			<span><img alt="" src="Images/Sunset.png"></span>
		</header>
		<article>
		<table class="meta">
			<c:forEach var="reservation" items="${listReservation}">
				<tr>
					<th><span >Customer ID </span></th>
					<td><span ><c:out value="${reservation.customerid}" /> </span></td>
				</tr>
				<tr>
					<th><span >Check in Date </span></th>
					<td><span ><c:out value="${reservation.checkindate}" /> </span></td>
				</tr>
				<tr>
					<th><span >Check out Date </span></th>
					<td><span > <c:out value="${reservation.checkoutdate}" /> </span></td>
				</tr>
				<tr>
					<th><span >PaymentMethod </span></th>
					<td><span > <c:out value="${reservation.paymentMethod}" /> </span></td>
				</tr>
				</c:forEach>
			</table>
		
		</br></br></br></br></br></br>
		</br></br></br>
		
		<table class="table table-bordered table table-hover"id="myTable">
				<thead class="thead-dark">
					<tr>
						<th>Room ID</th>
						<th>Room Number</th>
						<th>Room Type</th>
						<th>Number Of Beds</th>
						<th>WiFi</th>
						<th>Phone Service</th>
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="room" items="${listRoom}">

						<tr>
							<td><c:out value="${room.id}" /></td>
							<td><c:out value="${room.number}" /></td>
							<td><c:out value="${room.type}" /></td>
							<td><c:out value="${room.noOfBeds}" /></td>
							<td><c:out value="${room.wifi}" /></td>
							<td><c:out value="${room.phoneService}" /></td>
						
						</tr>
					</c:forEach>
				
				</tbody> 

			</table>
		
		</article>
		
		</br></br></br></br>
		</br></br></br></br>
		</br></br></br></br>
		</br></br></br></br>
		
		
		<aside>
			<h1><span >Contact us</span></h1>
			<div >
				<p align="center">Email :- info@sunset.com || Web :- www.sunsethotel.com || Phone :- 036XXXXXXX </p>
				
			</div>
		</aside>
		
		
		</div>
        </div>
      </div>    
    </div>
    
    <button onclick="Convert_HTML_To_PDF();">Report</button>
    
    

</body>
</html>