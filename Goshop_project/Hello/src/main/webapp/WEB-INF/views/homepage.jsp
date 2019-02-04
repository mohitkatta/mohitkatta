<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
    width: 70%;
    margin: auto;
  }
  </style>

</head>
<body>

<jsp:include page="Navbar.jsp" />  

<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
     
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src="<c:url value="/resources/images/electronics.jpg"/>" alt="" width="460" height="345">
        <div class="carousel-caption">
        </div>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/clothes.jpg"/>" alt="" width="460" height="345">
        <div class="carousel-caption">
        <p>Shop now...2 days moree</p>
          </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/bikeaccessories.jpg"/>" alt="Flower" width="460" height="345">
        <div class="carousel-caption">
          <h3>Offers</h3>
          <p>Mega offers online in different categories.</p>
        </div>
      </div>

   
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


<div class="row">
 <c:forEach items="${productlist}" var="p">
 <div class="col-md-4">
 <security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/viewproduct/${p.product_id}'></c:url>" >
    <img src="<c:url value="/resources/images/${p.product_id}.jpg"></c:url>" />
    <br/>
   <center>
    ${p.product_name}
    <br/>
    Stock:${p.product_quantity}
    <br/>
    Price:Rs. ${p.product_price}/-
    <br/>
   <button type="submit" class="btn btn-primary">View Product</button>
    </center>
    
 
</form>
</security:authorize>
   </div>
 </c:forEach>
</div>



</body>
</html>