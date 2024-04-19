<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Menu Page</title>
    <link href="AddMenu.css" rel="stylesheet">
</head>
<body>
    <div class="menu-container">
        <% 
            session = request.getSession(false);
            if (session != null && session.getAttribute("logged_in") != null && (boolean)session.getAttribute("logged_in")) {
                ResultSet menu = (ResultSet) session.getAttribute("Menu");
                while (menu.next()) { 
        %>
        <div class="menu-item">
            <p><%= menu.getString(1) %></p>
            <p><%= menu.getString(2) %></p>
            <p><%= menu.getInt(3) %></p>
        </div>
        <% 
                }
                %>
                
       </div>
                <form action="./AddMenuSV" class="add-menu-form" method="POST">
                    <label for="item_name">Item Name:</label>
                    <input type="text" required name="item_name" id="item_name" class="form-control">
                    
                    <label for="price">Price:</label>
                    <input type="text" required name="price" id="price" class="form-control">

                    <input type="submit" class="btn btn-primary" value="Add Item">
                </form>
         <%   }
        %>
    

     <!-- Redirect Button to pendingitems.jsp -->
    <button onclick="redirectToPendingItems()" class="btn btn-primary">Go to Pending Items</button><br><br>
    
			<a href="LogoutSV">Log Out</a>

    <!-- JavaScript to handle the redirection -->
    <script>
        function redirectToPendingItems() {
            window.location.href = 'pending_items.jsp';
        }
    </script>
</body>
</html>
