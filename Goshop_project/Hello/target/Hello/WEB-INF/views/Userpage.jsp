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

<form:form  method="post" action="adduser" style="border:1px solid #ccc">
  <div class="container">
    <h1>User Details</h1>
    
    
<div class="form-group row">
    <form:label path="email_id"><b>User emailId</b></form:label>
    <form:input path="email_id" type="text" class="form-control" placeholder="" name="User emailId" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="firstname"><b>First name</b></form:label>
    <form:input path="firstname" type="text" class="form-control" placeholder=" " name="First name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="lastname"><b>last name</b></form:label>
    <form:input path="lastname" type="text" class="form-control" placeholder="" name="last name" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="contactnumber"><b>Contact number</b></form:label>
    <form:input path="contactnumber" type="number" class="form-control" placeholder="" name="Contact number" required="true"/><br>
</div>

<div class="form-group row">
    <form:label path="password"><b>Password</b></form:label>
    <form:input path="password" type="password" class="form-control" placeholder="" name="Password" required="true"/><br>
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



<h1>User Details</h1>

<table class="table" >
  <tr>
    <th>User emailId</th>
    <th>First name</th>
    <th>Last name</th> 
    <th>Contact Number</th>
    <th>password</th>
    
  </tr>
  
  <c:forEach items="${userlist}" var="u">
  <tr>
    <td>${u.email_id}</td>
    <td>${u.firstname}</td>
    <td>${u.lastname}</td>
    <td>${u.contactnumber}</td>
    <td>${u.password}</td>
     <td><button type="button" class="btn btn-primary">Update</button></td>
    <td><button type="button" class="btn btn-danger">Delete</button></td>
  </tr>
  </c:forEach>
  
  
  
</table>
 

</body>
</html>