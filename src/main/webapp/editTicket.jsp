<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your ticket</title>
</head>
<body>
<form action = "editTicketServlet" method="post">
First Name: <input type ="text" name = "fname" value="${itemToEdit.firstName}"> <br>
Last Name: <input type = "text" name = "lname" value="${itemToEdit.firstName}"><br>
Email: <input type ="email" name = "email" value="${itemToEdit.email}"><br>
Number of tickets: <input type = "number" name = "tickets" value="${itemToEdit.numTickets}"><br>
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Order">
</form>
</body>
</html>