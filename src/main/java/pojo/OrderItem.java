package pojo;

public class OrderItem {
    String item;
    int quantity;

    public OrderItem(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item: " + item + ", Quantity: " + quantity;
    }
}
