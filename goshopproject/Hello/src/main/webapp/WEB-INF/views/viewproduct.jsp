<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp" />  
<div class="container">
<b>Product Details</b>
<pre>
<img src="<c:url value="/resources/images/${product.product_id }.jpg"></c:url>" height="50px" width="50px" class="img-circle">
<b>Product Name  :</b> ${product.product_name}
<b>Description   :</b>${product.product_description }
<b>Price         :</b>${product.product_price }
<b>In Stock      :</b>${product.product_quantity }
<security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/cart/addtocart/${product.product_id}'></c:url>" >
Enter required units<br>
<input type="number" name="requestedQuantity" min="1">
<c:if test="${product.product_quantity>0}">
<c:if test="${pageContext.request.userPrincipal.name != 'mohit@goshop'}">
<input type="submit" class="btn btn-lg btn-warning" value="Add To Cart">
</c:if>
</c:if>
<c:if test="${product.product_quantity<=0}">
<c:if test="${pageContext.request.userPrincipal.name != 'mohit@goshop'}">
<input type="button" disabled class="btn btn-lg btn-danger" value="Out of stock">
</c:if>
</c:if>
</form> 
</security:authorize>
</pre>
<a href="<c:url value='/homepage'></c:url>">Home</a>
</div>
</body>
</html>

