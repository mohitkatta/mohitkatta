<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<div class="container">
<nav class="navbar navbar-inverse" id="navcolour">
<div class="navbar-header">
<a class="navbar-brand"><img src="D:/my java programs/Bootstrap/logo1.png" height="35px" width="60px"></a>
</div>

<ul class="nav navbar-nav" id="links">
   <li><a href="#">Home</a></li>
   <li><a> About Us</a></li>
   <li class="dropdown">
   <a class="dropdown-toggle" data-toggle="dropdown" href="#">All Products
   <span class="caret"></span></a>
   <ul class="dropdown-menu">
      <li><a href="#"> Electronics</a></li>
      <li><a href="#"> TVs & Appliances</a></li>
      <li><a href="#"> Men</a></li>
      <li><a href="#"> Women</a></li>
      <li><a href="#"> Baby & Kids</a></li>
      <li><a href="#"> Home & Furniture</a></li>
      <li><a href="#"> Sports</a></li>
  </ul>
  </ul>
</li>


<ul class="nav navbar-nav navbar-right">
      <li><a href="signuppage.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="signinpage.html"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Sign Out</a></li>
    </ul>


</div>
</body>
</html>