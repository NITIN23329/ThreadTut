package lld.questions.paymentGateway;

import lld.questions.atm.TransactionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionController {

    private Map<User, List<Transaction>> transactionList;
    private TransactionHistoryStrategy transactionHistoryStrategy;

    public TransactionController() {
        this.transactionList = new HashMap<>();
    }
    public void addTransaction(User user, Transaction transaction) {
        if(!transactionList.containsKey(user)) transactionList.put(user, new ArrayList<>());
        transactionList.get(user).add(transaction);
    }
    public List<Transaction> getTransactionList(User user, TransactionHistoryStrategy transactionHistoryStrategy) {
        this.transactionHistoryStrategy = transactionHistoryStrategy;
        return transactionHistoryStrategy.getTransactionHistory(transactionList.get(user));
    }


}
