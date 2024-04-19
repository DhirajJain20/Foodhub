<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pojo.OrderItem, dao.PendingItemsdb, java.sql.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pending Orders</title>
    <link href="pending_items.css" rel="stylesheet">
</head>
<body>
			<a href="LogoutSV">Log Out</a>
	
    <div class="container">
        <% 
            PendingItemsdb pendingItems = new PendingItemsdb();
            ResultSet rs = pendingItems.fetchItemList();
            Map<String, List<OrderItem>> ordersByOID = new HashMap<>();

            while (rs.next()) {
                String item = rs.getString("item");
                int quantity = rs.getInt("quantity");
                String oid = rs.getString("oid");

                OrderItem orderItem = new OrderItem(item, quantity);
                ordersByOID.computeIfAbsent(oid, k -> new ArrayList<>()).add(orderItem);
            }

            for (Map.Entry<String, List<OrderItem>> entry : ordersByOID.entrySet()) {
        %>
            <div class="order-section">
                <p class="order-id">OID: <%= entry.getKey() %></p>
                
                <% ResultSet statusSet = pendingItems.fetchStatus(entry.getKey());
                
                for (OrderItem orderItem : entry.getValue()) { %>
                    <p class="order-item">&ensp; <%= orderItem %> </p>
                <% } %>

                <% while(statusSet.next()) { %>
                    <p class="status"><%= statusSet.getString(1) %></p>
                    <form action="./UpdateStatusSV" method="post">
                        <input type="hidden" name="oid" value="<%= entry.getKey() %>"> 
                        <input type="submit" class="complete-button" value="Complete">
                    </form>
                <% } %>
            </div>
        <% } %>
    </div>
</body>
</html>
