<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Details</title>
    <!-- Bootstrap 5.3.2 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <% if(session!=null && session.getAttribute("orderid") != null){
        	String orderId = (String) session.getAttribute("orderid"); 
    %>
    
    <div class="card">
        <div class="card-body">
            <h3 class="card-title">Your Order ID:</h3>
            <p class="card-text"><%= orderId %></p>
            <a href="LogoutSV" class="btn btn-primary">Logout</a>
        </div>
    </div>
    <% } else{ response.sendRedirect("login.html"); } %>
    	
</div>

<!-- Optional: Add Bootstrap JS and Popper.js for Bootstrap functionalities -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+Jc2+EJNQ8l5zo" crossorigin="anonymous"></script>

</body>
</html>
