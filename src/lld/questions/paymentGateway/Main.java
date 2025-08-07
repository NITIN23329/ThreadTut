package lld.questions.paymentGateway;

public class Main {
    public static void main(String[] args) {

        TransactionController transactionController = new TransactionController();
        PaymentGateway paymentGateway = new PaymentGateway(transactionController);
        User user1 = new User("Nitin", paymentGateway,transactionController);
        user1.addCard(new Card("1234", "1234", user1));


        User user2 = new User("Ritik", paymentGateway,transactionController);
        user2.addCard(new Card("1234", "1234", user2));


        user1.checkBalance();

        user1.transfer(user2, 200, TransactionType.IMPS);
        user1.transfer(user2, 400, TransactionType.IMPS);
        user1.transfer(user2, 200, TransactionType.NEFT);


        user1.getTransactionHistory(new TransactionHistoryByTransactionType(TransactionType.IMPS));


    }
}
