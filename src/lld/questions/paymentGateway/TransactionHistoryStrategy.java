package lld.questions.paymentGateway;

import java.util.ArrayList;
import java.util.List;

public abstract class TransactionHistoryStrategy {

    abstract List<Transaction> getTransactionHistory(List<Transaction> transactionList);

}

class TransactionHistoryByTransactionType extends TransactionHistoryStrategy {
    private TransactionType transactionType;

    public TransactionHistoryByTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    List<Transaction> getTransactionHistory(List<Transaction> transactionList) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if(transaction.getType().equals(transactionType)) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

}
// can have more strategies.
