<%@ page import="java.sql.ResultSet" %>
<%@ page import="dao.GetCartDetailsdb" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojo.UserDetails, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Page</title>
    <link href="cart.css" rel="stylesheet">
</head>
<body>
			<a href="LogoutSV">Log Out</a>
	
<%
    session = request.getSession(false);

    UserDetails user = (UserDetails) session.getAttribute("user");
    String custid = user.getUid();

    GetCartDetailsdb cart = new GetCartDetailsdb();
    ResultSet rs = cart.fetch(custid);

    List<String> itemList = new ArrayList<>();
    List<Integer> quantityList = new ArrayList<>();

    int totalPrice = 0;
    int totalQuantity = 0;
    if (!rs.next()) {
    %>
    	    <div class="message">Nothing is available in the cart.</div>
	<%
	    }
    else{
	%>
	
    <% while (rs.next()) {
        itemList.add(rs.getString(1));
        quantityList.add(rs.getInt(2));
        totalPrice += rs.getInt(3);
        totalQuantity += rs.getInt(2);
%>
    <div class="cart-item">
        <div class="cart-item-info">
            <%= rs.getString(1) %> - Quantity: <%= rs.getInt(2) %>
        </div>
        <div class="cart-item-price">
            Price: <%= rs.getInt(3) %>
        </div>
    </div>
<%
    }

    session.setAttribute("itemList", itemList);
    session.setAttribute("quantityList", quantityList);

    
%>


<div class="cart-total">
    Total Price: <%= totalPrice %>
</div>

<form action="./OrderCompleteSV" method="post">
    <input type="hidden" name="price" value="<%=totalPrice %>">
    <input type="hidden" name="quantity" value="<%=totalQuantity %>">
    <button type="submit" class="pay-button">Pay</button>
</form>
<% } %>
</body>
</html>
