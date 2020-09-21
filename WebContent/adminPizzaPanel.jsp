<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pizza.services.PizzaServicesInterface"%>
<%@page import="com.pizza.services.PizzaServices"%>
<%@page import="com.pizza.model.Pizza"%>
<%

	String userName =  (String) session.getAttribute("email");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>pizzahut | ADMIN </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--Browser ICON-->
    <link rel="icon" type="images" href="images/logo.png">


    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/aos.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    <!--css for tables-->
    <link rel="stylesheet" href="css/notes.css">

    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/mobileDestop.css">

    <!--css for notification and message-->
    <link rel="stylesheet" href="css/modal.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://kit.fontawesome.com/68eb695a6c.js" crossorigin="anonymous"></script>
    <!--End of css for notification and message-->

  </head>
  <body class="goto-here">
		<div class="py-1 bg-primary">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-md-0">
	    		<div class="col-lg-12 d-block">
		    		<div class="row d-flex">
		    			<div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-phone2"></span></div>
						    <span class="text">+94 77 XXX XXXX</span>
					    </div>
					    <div class="col-md pr-4 d-flex topper align-items-center">
					    	<div class="icon mr-2 d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
						    <span class="text">pizzahut@gmail.com</span>
					    </div>
					    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						    <span class="text">Join With US</span>
					    </div>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>



<!--************************************************************
                    nav bar Admin
***********************************************************-->

   <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
		<a class="navbar-brand" href="index.php"><img src="images/logo.png" width=80>PizzaHut</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	      
	       <ul class="navbar-nav ml-auto">
	       
			<li class="nav-item"><a href="admin.jsp" class="nav-link">Admin Panel</a></li>
           
	        <li class="nav-item" ><a href="logout.jsp" style="color:#2d9416; font-weight: bold;" class="nav-link"><%=userName %> (Logout)</a></li>

	        </ul>
	        
	      </div>
	    </div>
	  </nav>

<!--************************************************************
              End of nav bar Admin
 ***********************************************************-->

	


  <!--Mobile View Banner-->
  <div class="MobileViewBanner">
    <div class="hero-wrap hero-bread" style="background-image: url('images/banner1Mobile.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <br><br><br>
          </div>
        </div>
      </div>
  </div>
</div>
<!--End of Mobile View Banner-->

<!--Destop VIEW banner-->
  
  <div class="DestopViewBanner">
  
  <div class="hero-wrap hero-bread" style="background-image: url('images/banner1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <br><br><br><br><br><br>
          </div>
        </div>
      </div>
	</div>
  
</div>
<!--End of Destop VIEW banner-->


	
<br>
<center><h1>ADMIN PANEL<h1></center>
<br><br><hr>


<!--***********************************************************************
          Manage Pizzza Div
    ***********************************************************************-->

<div class="adminTable col-md-12">

<center><h3>Pizza Details<h3></center>
<div>
<table id="customers" style="overflow-x: auto;">
  <tr>
   					<th>Pizza ID</th> 
                    <th>Pizza Name</th>   
                    <th>Description</th>
                    <th>Price</td> 
                    <th>Image</th>
                    <th>Edit</th>
                    <th>Delete</th>
  </tr>


   					<!-- Call classes of services package -->
	 				<%
					     
					      PizzaServicesInterface pizzaServices = new PizzaServices();
						  ArrayList<Pizza> arrayList = pizzaServices.getPizzaList();
								
						  for(Pizza pizza : arrayList){
					%>

                            <tr>
                            <td><%=pizza.getPizzaID() %></td>
                            <td><%= pizza.getName() %></td>
                            <td><%=pizza.getDescription() %></td>
                            <td><%=pizza.getPrice() %></td>
                            <td><img height="50" width="50" src="Storage/<%=pizza.getFileName() %>"></td>
                    
                            <td><a href="editPizzaDetails.jsp?pizzaID=<%=pizza.getPizzaID() %>"><button>Edit</button></a></td>
                            <td><a href="deletePizzaAdmin?pizzaID=<%=pizza.getPizzaID() %>"><button>Delete</button></a></td>
                            </tr>

          			<%
          			
						  }
						  
          			%>
  
</table>
</div>
</div>





   <br><br>
   <hr>
   <br><br>

<!-- Insert Papers-->

   <div class="formAdminUpload">

   <h3 class="text-center">Add New Pizza</h3>
  <form action="insertPizza" method="post" enctype='multipart/form-data'  >
    <label for="Email">Name</label>
    <input type="text" id="name" name="name" placeholder="Pizza Name" required>
    <label for="description">Description</label>
    <input type="text" id="description" name="description" placeholder="Pizza Description" required>
    <label for="price">Price</label>
    <input type="text" id="price" name="price" placeholder="Price" required>
    <label for="file">Pizza Image</label>
  	 <input type="file"  name="file" required>
    <input type="submit"  value="Add Pizza">
  </form>
  </div>





                        
        <!--End of From Grid-->

        <br><br>
   <hr>
   <br><br>

<!--***********************************************************************
      End of Manage Pizza Panel Div
    *********************************************************************-->



 <!--************************************************************
                    Footer
    ***********************************************************-->
    	<!--FOOTER-->
    <section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
      <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
          <div class="col-md-6">
          	<h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
          	<span>Get e-mail updates </span>
          </div>
          <div class="col-md-6 d-flex align-items-center">
            <form action="#" class="subscribe-form">
              <div class="form-group d-flex">
                <input type="text" class="form-control" placeholder="Enter email address">
                <input type="submit" value="Subscribe" class="submit px-3">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <footer class="ftco-footer ftco-section">
      <div class="container">
      	<div class="row">
      		<div class="mouse">
						<a href="#" class="mouse-icon">
							<div class="mouse-wheel"><span class="ion-ios-arrow-up"></span></div>
						</a>
					</div>
      	</div>
        <div class="row mb-5">
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Pizza Hut</h2>
              <p>PIZZA MAKES ANYTHING POSSIBLE</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="#"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md">
            <div class="ftco-footer-widget mb-4 ml-md-5">
              <h2 class="ftco-heading-2"></h2>
              <ul class="list-unstyled">
               
                <li><a href="#" class="py-2 d-block">All rights <span style="font-weight:bold; color:green;"> Reserved </span> </a></li>

              </ul>
            </div>
          </div>
          
          <div class="col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">Colombo  Sri Lanka</span></li>
	                <li><a href="#"><span class="icon icon-phone"></span><span class="text">+94 77 XX XXX XX</span></a></li>
	                <li><a href="#"><span class="icon icon-envelope"></span><span class="text">PIZZAHUT@GMAIL.COM</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>

      </div>
    </footer>

	<!--End of FOOTER-->

<!--************************************************************
              End of Footer
 ***********************************************************-->
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>


<script>
document.onkeydown = function(e) {
  if(event.keyCode == 123) {
     return false;
  }
  if(e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)) {
     return false;
  }
  if(e.ctrlKey && e.shiftKey && e.keyCode == 'C'.charCodeAt(0)) {
     return false;
  }
  if(e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)) {
     return false;
  }
  if(e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)) {
     return false;
  }
}

</script>