package lld.questions.amazon;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        ProductCatalog mobile = inventory.createProductCatalog(new MobileCatalogFactory());
        ProductCatalog laptop = inventory.createProductCatalog(new LaptopCatalogFactory());
        mobile.addProduct(new Product(1, "Iphone", 10, 1000));
        mobile.addProduct(new Product(2, "Nothing", 5, 500));
        laptop.addProduct(new Product(3, "MacBook", 50, 10000));


        OrderController orderController = new OrderController();


        User user = new User("Nitin", List.of(new Address("B209", "Bellandur", "Bangalore")));

        ShoppingCart shoppingCart = new ShoppingCart(user,orderController);
        shoppingCart.addProduct(mobile.getProducts().get(0));
        shoppingCart.addProduct(mobile.getProducts().get(0));
        shoppingCart.addProduct(mobile.getProducts().get(1));

        shoppingCart.checkout(new CreditCardPaymentStrategy());


        orderController.getOrders().forEach(System.out::println);


    }
}
