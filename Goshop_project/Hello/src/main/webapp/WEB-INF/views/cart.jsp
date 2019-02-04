<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp" />  

<div class="container">
		<b>Cart Page</b><br>
		<c:set var="grandTotal" value="0"></c:set>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th></th>
					<th>Image</th>
					<th>Product</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>TotalPrice</th>
					<th>Remove</th>
				</tr>
			</thead>
			<c:forEach var="cartItem" items="${cartItems }">
			<form action="<c:url value='/cart/updatecartitem'></c:url>">
             <tr>
             <td><input type="hidden" name="cartItemId" value="${cartItem.cartItemId }"></td>
             <td><img src="<c:url value='/resources/images/${cartItem.product.product_id}.jpg'></c:url>" height="40px" width="40px" alt="No Image"></td>
             <td>${cartItem.product.product_id }</td>
             <td><input type="number" name="requestedQuantity" value='${cartItem.quantity }' onchange="this.form.submit()" min="1"></td>
             <td>${cartItem.product.product_price }</td>
             <td>${cartItem.totalPrice }</td>
             <td><a href="<c:url value='/cart/deletecartitem/${cartItem.cartItemId }'></c:url>" class="btn btn-danger">Remove</a></td>
             <c:set var="grandTotal" value="${cartItem.totalPrice +grandTotal }"></c:set>
             </tr>
             </form>
			</c:forEach>

		</table>
		<h4>Grand Total : ${grandTotal }</h4> <a class="btn btn-success" href="<c:url value='/Carddetails'></c:url>">Place Order</a>
	</div>
</body>
</html>