package lld.questions.amazon;

public abstract class PaymentStrategy {


    public abstract void makePayment(double amount);
}

class UPIPaymentStrategy extends PaymentStrategy {

    @Override
    public void makePayment(double amount) {
        System.out.println("UPI Payment: " + amount+" is done");
    }
}

class CreditCardPaymentStrategy extends PaymentStrategy {

    @Override
    public void makePayment(double amount) {
        System.out.println("CreditCard Payment: " + amount+" is done");
    }
}

