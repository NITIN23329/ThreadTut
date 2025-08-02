package lld.questions.atm;

public class TransactionFactory {
    public static TransactionStrategy getTransactionStrategy(TransactionType transactionType) {
        return switch (transactionType) {
            case CHECK_BALANCE -> new CheckBalanceTransaction();
            case DEPOSIT -> new DepositTransaction();
            case WITHDRAW -> new WithdrawTransaction();
        };
    }
}
