package lld.questions.amazon;

import lld.questions.amazon.User;
import lld.questions.ticketSystem.Payment;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private User user;
    private Map<Product, Integer> products;
    private PaymentStrategy paymentStrategy;
    private OrderController orderController;



    public ShoppingCart(User user, OrderController orderController) {
        this.user = user;
        this.products = new HashMap<>();
        this.orderController = orderController;
    }

    public void addProduct(Product product){
        products.put(product, products.getOrDefault(product, 0) + 1);
    }
    public void removeProduct(Product product){
        products.put(product, products.get(product) - 1);
        if (products.get(product) == 0)products.remove(product);
    }

    public double getTotalPrice(){
        double total = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    // template desing pattern
    public void checkout(PaymentStrategy paymentStrategy){
        // calculate price
        // choose deliver address
        // payment
        // generate Invoice
        // create order
        double total = getTotalPrice();
        System.out.println("Total price: " + total);
        Address address = user.getAddress().get(0); // can be user input
        this.paymentStrategy = paymentStrategy;
        paymentStrategy.makePayment(total);
        Invoice invoice = new Invoice(user, this, paymentStrategy);
        orderController.createOrder(user, this, address, invoice);

    }


}
