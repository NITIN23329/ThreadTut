package lld.questions.paymentGateway;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber{

    private String name;
    private List<Card> cards;
    private PaymentGateway paymentGateway;
    private TransactionController transactionController;

    public User(String name, PaymentGateway paymentGateway, TransactionController transactionController) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.paymentGateway = paymentGateway;
        this.transactionController = transactionController;
    }
    public void addCard(Card card) {
        cards.add(card);
    }
    public void checkBalance() {
        // default card id 0
        System.out.println(paymentGateway.checkBalance(cards.get(0)));
    }
    public void transfer(User to, double amount, TransactionType transactionType) {
        paymentGateway.transfer(cards.get(0), to.cards.get(0),amount, transactionType  );
    }
    public void getNotification(Transaction transaction) {
        System.out.println("Notification for current user: " + name);
        System.out.println(transaction);
    }
    public void getTransactionHistory(TransactionHistoryStrategy transactionHistoryStrategy){
        List<Transaction> history = transactionController.getTransactionList(this, transactionHistoryStrategy);
        System.out.println("Printing history for user : " + name);
        System.out.println(history);
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
