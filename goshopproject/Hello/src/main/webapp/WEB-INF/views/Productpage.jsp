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
<jsp:include page="Navbar.jsp" /> 
<c:url value="/admin/addproduct" var="prourl"></c:url>
<form:form method="post" action="${prourl}" style="border:1px solid #ccc" enctype="multipart/form-data">
  <div class="container">
    <h1>Product Details</h1>
    
    

<div class="form-group row">
    
    <form:hidden path="product_id"  class="form-control" placeholder=" " name="product Id" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="product_price"><b>product_price</b></form:label>
    <form:input path="product_price" type="text" class="form-control" placeholder=" " name="product_price" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="product_name"><b>product_name</b></form:label>
    <form:input path="product_name" type="text" class="form-control" placeholder=" " name="product_name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="product_quantity"><b>product_quantity</b></form:label>
    <form:input path="product_quantity" type="text" class="form-control" placeholder=" " name="product_quantity" required="true"/><br>
</div>
<div class="form-group row">
    <form:label path="product_description"><b>product_description</b></form:label>
    <form:input path="product_description" type="text" class="form-control" placeholder=" " name="product_description" required="true"/><br>
</div>
Select Category   : <form:select path="category.category_id">	
<c:forEach items="${categories }" var="c"><%--model.addAttribute("categories",categories), items refers the model attribute categories --%>
<form:option value="${c.category_id }">${c.category_name}</form:option>
</c:forEach>
</form:select>

Select Supplier   : <form:select path="supplier.suppliers_id">	
<c:forEach items="${suppliers }" var="s"><%--model.addAttribute("suppliers",suppliers), items refers the model attribute suppliers --%>
<form:option value="${s.suppliers_id }">${s.suppliers_name}</form:option>
</c:forEach>
</form:select>
<div class="form-group row">
 Upload image      : <form:input path="image" type="file"/>


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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form:form>
<h1>Product Details</h1>

<table class="table"  style="width:100%">
  <tr>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Description</th> 
    <th>Quantity</th>
    <th>Price</th>
    <th>image</th>
   </tr>
   
   
   <c:forEach items="${productlist}" var="p">
  <tr>
    <td>${p.product_id}</td>
    <td>${p.product_name}</td>
    <td>${p.product_description}</td>
    <td>${p.product_quantity}</td>
    <td>${p.product_price}</td>
    <td><img src="<c:url value="/resources/images/${p.product_id}.jpg"></c:url>"/></td>
    <td><a href="<c:url value="updateproduct/${p.product_id}"/>"> <button type="button" class="btn btn-primary">Update</button></a></td>
    <td><a href="<c:url value="deleteproduct/${p.product_id}"/>"><button type="button" class="btn btn-danger">Delete</button></a></td>
  </tr>
  </c:forEach>
  
</table>
  

</body>
</html>