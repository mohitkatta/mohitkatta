<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="Navbar.jsp" /> 
<c:url value="/adduser" var="userurl" />
<form:form action="${userurl}" style="border:1px solid #ccc" method="post">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

<div class="form-group row">
    <form:label path="user_name"><b>user_name</b></form:label>
    <form:input type="text" path="user_name" class="form-control" placeholder="Enter Your First Name" name="First Name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="user_phonenumber"><b>user_phonenumber</b></form:label>
    <form:input type="text" path="user_phonenumber" class="form-control" placeholder="Enter Your Last Name" name="Last Name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="user_mailid"><b>Email</b></form:label>
    <form:input type="text" path="user_mailid" class="form-control" placeholder="Enter Email" name="email" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="user_password"><b>Password</b></form:label>
    <form:input type="password" path="user_password" class="form-control" placeholder="Enter Password" name="psw" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="user_address"><b>user_address</b></form:label>
    <form:input type="text" path="user_address" class="form-control" placeholder="Enter Password" name="psw" required="true"/><br>
</div>

<!-- <div class="form-group row">
    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" class="form-control" placeholder="Repeat Password" name="psw-repeat" required><br>
</div> -->

 <div class="form-group row">
        <form:hidden path="authorities.role" value="ROLE_USER" class="form-control" /><br>
</div>

    <div class="clearfix">
      <button type="button" class="btn btn-danger">Cancel</button>
      <button type="submit" class="btn btn-primary">Sign Up</button>
    </div>
  </div>
</form:form>
</body>
</html>