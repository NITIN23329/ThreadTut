package lld.questions.amazon;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<>();
    }
    public  Order createOrder(User user, ShoppingCart cart, Address address,  Invoice invoice) {
        int id = orders.size() + 1;
        Order order = new Order(user, id, cart, address, invoice, OrderStatus.CREATED);
        orders.add(order);
        return order;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
