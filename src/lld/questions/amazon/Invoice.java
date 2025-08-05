package lld.questions.amazon;

public class Invoice {
    private User user;
    private ShoppingCart shoppingCart;
    private PaymentStrategy paymentStrategy;

    public Invoice(User user, ShoppingCart shoppingCart, PaymentStrategy paymentStrategy) {
        this.user = user;
        this.shoppingCart = shoppingCart;
        this.paymentStrategy = paymentStrategy;
    }
}
