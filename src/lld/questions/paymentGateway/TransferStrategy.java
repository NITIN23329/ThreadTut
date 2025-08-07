package lld.questions.paymentGateway;


public abstract class TransferStrategy {

    private BankSvc bankSvc;

    public TransferStrategy() {
        this.bankSvc = BankSvc.getInstance();
    }
    public BankSvc getBankSvc() {
        return bankSvc;
    }

    abstract Transaction transfer(Card from, Card to, double amount);

}
class TransferByNEFT extends TransferStrategy {

    @Override
    Transaction transfer(Card from, Card to, double amount) {
        return getBankSvc().transferByNEFT(from, to, amount);
    }
}


class TransferByIMPS extends TransferStrategy {

    @Override
    Transaction transfer(Card from, Card to, double amount) {
        return getBankSvc().transferByIMPS(from, to, amount);
    }
}
class TransferStrategyFactory {
    public static TransferStrategy getTransferStrategy(TransactionType type) {
        return switch (type){
            case NEFT -> new TransferByNEFT();
            case IMPS -> new TransferByIMPS();
        };
    }
}