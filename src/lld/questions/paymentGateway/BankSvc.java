package lld.questions.paymentGateway;

public class BankSvc {
    private static BankSvc instance;
    private BankSvc() {}
    public static BankSvc getInstance() {
        if (instance == null) instance = new BankSvc();
        return instance;
    }
    public double checkBalance(Card card) {
        // logic for checking balance for a card
        return 10000.0;
    }

    public Transaction transferByNEFT(Card from , Card to, double amount) {
         return new Transaction(from, to, TransactionType.NEFT, TransactionStatus.SUCCESS, amount);
    }
    public Transaction transferByIMPS(Card from, Card to, double amount) {
        return new Transaction(from, to, TransactionType.IMPS, TransactionStatus.SUCCESS, amount);
    }
}
