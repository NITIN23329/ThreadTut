package lld.questions.paymentGateway;

public class PaymentGateway implements Publisher{

    private BankSvc bankSvc;
    private TransferStrategy transferStrategy;
    private TransactionController transactionController;
    public PaymentGateway(TransactionController transactionController) {
        bankSvc = BankSvc.getInstance();
        this.transactionController = transactionController;
    }

    public double checkBalance(Card card) {
        return bankSvc.checkBalance(card);
    }

    public void transfer(Card from, Card to, double amount, TransactionType transactionType) {
        transferStrategy = TransferStrategyFactory.getTransferStrategy(transactionType);
        Transaction transaction = transferStrategy.transfer(from, to, amount);
        transactionController.addTransaction(from.getUser(), transaction);
        publishNotification(to.getUser(), transaction);


    }

    @Override
    public void publishNotification(User user, Transaction transaction) {
        user.getNotification(transaction);
    }
}
