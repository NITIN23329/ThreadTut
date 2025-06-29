package designPattern.behavioural;

import java.util.Scanner;

// strategy interface delares the algoritm
interface PaymentInterface {
    void pay(int amount);
}
// different concrete strategy class implementing their onw version
class UPIPayment implements PaymentInterface {
    @Override
    public void pay(int amount) {
        System.out.println("Amount paid using UPI: " + amount);
    }
}
class CreditCardPayment implements PaymentInterface {
    @Override
    public void pay(int amount) {
        System.out.println("Amount paid using Credit card: " + amount);
    }
}
class CashPayment implements PaymentInterface {
    @Override
    public void pay(int amount) {
        System.out.println("Amount paid using cash: " + amount);
    }
}
// Context class hold reference to one of strategies given by user
class ShoppingCart{
    PaymentInterface paymentInterface;

    public ShoppingCart() {
    }

    public void setPaymentInterface(PaymentInterface paymentInterface) {
        this.paymentInterface = paymentInterface;
    }
    public void pay(int amount) {
        paymentInterface.pay(amount);
    }
}
public class StrategyExample {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 1 for UPI, 2 for CreditCard, 3 for Cash");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: shoppingCart.setPaymentInterface(new UPIPayment());
            break;
            case 2: shoppingCart.setPaymentInterface(new CreditCardPayment());
            break;
            case 3: shoppingCart.setPaymentInterface(new CashPayment());
        }
        shoppingCart.pay(1000);

    }
}
