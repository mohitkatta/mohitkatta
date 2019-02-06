<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<c:url value="/addproduct" var="prourl"></c:url>
<form:form method="post" action="${prourl}" style="border:1px solid #ccc">
  <div class="container">
    <h1>Product Details</h1>
    
    
    
    

<div class="form-group row">
    <form:label path="productname"><b>Product Name</b></form:label>
    <form:input path="productname" type="text" class="form-control" placeholder=" " name="Product Name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="product_id"><b>Product Id</b></form:label>
    <form:input path="product_id" type="text" class="form-control" placeholder=" " name="product Id" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="description"><b>Description</b></form:label>
    <form:input path="description" type="text" class="form-control" placeholder=" " name="description" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="quantity"><b>Quantity</b></form:label>
    <form:input path="quantity" type="text" class="form-control" placeholder=" " name="quantity" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="price"><b>Price</b></form:label>
    <form:input path="price" type="Price" class="form-control" placeholder=" " name="Price" required="true"/><br>
</div>

          <tr>
         <td colspan = "2">
          <input type = "submit" value = "Submit"/>
          </td>
          </tr>

         <tr>
         <td colspan = "2">
          <input type = "reset" value = "Reset"/>
          </td>
          </tr>
          
 </div>
 </form:form>
<h1>Product Details</h1>

<table class="table"  style="width:100%">
  <tr>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Description</th> 
    <th>Quantity</th>
    <th>Price</th>
   </tr>
   
   
   <c:forEach items="${productlist}" var="p">
  <tr>
    <td>${p.product_id}</td>
    <td>${p.productname}</td>
    <td>${p.description}</td>
    <td>${p.quantity}</td>
    <td>${p.price}</td>
    <td><a href="updateproduct/${p.product_id}"><button type="button" class="btn btn-primary">Update</button></a></td>
    <td><a href="deleteproduct/${p.product_id}"><button type="button" class="btn btn-danger">Delete</button></a></td>
  </tr>
  </c:forEach>
  
</table>
  

</body>
</html>