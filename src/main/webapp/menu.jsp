<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.GetMenudb, java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Menu Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link href="menu.css" rel="stylesheet" />
  </head>
  <body>
    <section id="menu" class="menu section-bg">
      <div class="container" data-aos="fade-up">
        <div class="section-title">
          <h2>Menu</h2>
          <p>Check Our Tasty Menu</p>
          <% session = request.getSession(false);
          
          if(   session != null && session.getAttribute("logged_in") != null && (boolean)session.getAttribute("logged_in")){

          %>
          
          <!-- Button to redirect to cart.jsp -->
			<div class="cart-button-container">
			    <button onclick="redirectToCart()" class="btn btn-primary">Go to Cart</button>
			</div>
			<%}  %>
			<a href="LogoutSV">Log Out</a>
        </div>



        <div class="row menu-container" data-aos="fade-up" data-aos-delay="200">
          <div class="col-lg-6 menu-item filter-starters">
        
        <% 
            GetMenudb get = new GetMenudb();
            ResultSet menu = get.fetchMenu(); 
        %>
        
        <% 
            int index = 0; 
            while(menu.next()){ 
        %>

            <div class="menu-content">
              <a href="#"><%= menu.getString(2) %> <span>Rs: <%= menu.getInt(3) %></span></a>
            </div>
        <% 
            if (session != null && session.getAttribute("logged_in") != null && (boolean)session.getAttribute("logged_in")) { 
        %>
            <div class="menu-ingredients">
              <form action="CartSV" method="post">
                <input
                  type="hidden"
                  name="item_id"
                  value="<%= menu.getString(1) %>"
                />

                <div>
                  <button
                    type="button"
                    class="btn btn-outline-secondary"
                    onclick="decrement(<%= index %>, <%= menu.getInt(3) %>);"
                  >
                    -
                  </button>
                  <input
                    type="text"
                    name="quantity"
                    id="quantity_<%= index %>"
                    value="0"
                    style="width: 60px"
                    class="btn btn-outline-secondary"
                    readonly
                    required
                  />
                  <button
                    type="button"
                    class="btn btn-outline-secondary"
                    onclick="increment(<%= index %>, <%= menu.getInt(3) %>);"
                  >
                    +
                  </button>
                  <button type="submit" class="btn btn-outline-secondary">
                    Add
                  </button>
                  <p class="text-secondary">
                    Total Price: Rs:<span id="total_<%= index %>">0</span>
                  </p>
                  <input
                    type="hidden"
                    name="totalPrice"
                    id="totalPrice_<%= index %>"
                    value="0"
                  />
                </div>
              </form>
        <% 
            } 
        %>
        
    
            
        <% 
                index++; 
        %>
        <% 
            }  
        %>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- End Menu Section -->
    <script>
        let quantities = Array.from({ length: <%= index %> }, () => 0);
        
        decrement = (index, price) => {
            if (quantities[index] > 0) {
                quantities[index]--;
                updateQuantityAndTotal(index, price);
            }
        }

        increment = (index, price) => {
            quantities[index]++;
            updateQuantityAndTotal(index, price);
        }

        updateQuantityAndTotal = (index, price) => {
            let quantityInput = document.getElementById("quantity_" + index);
            let totalSpan = document.getElementById("total_" + index);
            let totalPriceInput = document.getElementById("totalPrice_" + index); 
            
            quantityInput.value = quantities[index];
            totalSpan.textContent = quantities[index] * price;
            totalPriceInput.value=quantities[index] * price;// Calculate total price
        }
        
     // Function to redirect to cart.jsp
        function redirectToCart() {
            window.location.href = 'cart.jsp';
        }
    </script>
  </body>
</html>
