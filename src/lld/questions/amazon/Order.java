package lld.questions.amazon;

enum OrderStatus {
    CREATED, SHIPPED, OUT_FOR_DELIVERY, DELIVERED
}

public class Order {
    private User user;;
    private int id;
    private ShoppingCart cart;
    private Address address;
    private Invoice invoice;
    private OrderStatus status;

    public Order(User user, int id, ShoppingCart cart, Address address, Invoice invoice, OrderStatus status) {
        this.user = user;
        this.id = id;
        this.cart = cart;
        this.address = address;
        this.invoice = invoice;
        this.status = status;
    }
}
