<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "pojo.*"%>
     <%@ page import="java.util.*,java.io.*,java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Profile</title>
<style type="text/css">
	body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f0f0f0;
}

.profile-container {
    max-width: 600px;
    margin: 50px auto;
    background-color: #fff;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.profile-header {
    text-align: center;
}

.profile-header img {
    border-radius: 50%;
    width: 150px;
    height: 150px;
    object-fit: cover;
}

.profile-header h1 {
    margin: 10px 0;
    color: #333;
}

.profile-header p {
    color: #777;
}

.profile-details h2 {
    color: #333;
    border-bottom: 2px solid #ddd;
    padding-bottom: 5px;
    margin-top: 20px;
}

.profile-details p {
    color: #555;
    line-height: 1.6;
}

.profile-details ul {
    list-style: none;
    padding: 0;
}

.profile-details li {
    color: #777;
    margin-bottom: 10px;
}
		
</style>
</head>
<body>
	<% jakarta.servlet.http.HttpSession a = request.getSession(false);
	if(a != null && session.getAttribute("user") != null){
	UserDetails user = (UserDetails)session.getAttribute("user"); %>
	<div class="profile-container">
        <div class="profile-header">
            <h1><%=user.getUname() %></h1>
        </div>
        
        <div class="profile-details">
            
            <h2>Contact Information</h2>
            <ul>
                <li>Email: <%=user.getEmail() %> </li>
                
            </ul>
            <a href="./LogoutSV"><button type="submit" >Logout</button></a>
        </div>
    </div>
    <% } else{ response.sendRedirect("login.html");%>
    <%} %>
    
        
    
</body>
</html>