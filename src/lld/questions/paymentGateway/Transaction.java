package lld.questions.paymentGateway;

enum TransactionType {
    NEFT, IMPS;
}
enum TransactionStatus {
    SUCCESS, PENDING, FAILED
}

public class Transaction {
    private Card from;
    private Card to;
    private TransactionType type;
    private TransactionStatus status;
    private double amount;
    private int id;

    public Transaction(Card from, Card to, TransactionType type, TransactionStatus status, double amount) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.status = status;
        this.amount = amount;
    }

    public Card getFrom() {
        return from;
    }

    public Card getTo() {
        return to;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "from=" + from +
                ", to=" + to +
                ", type=" + type +
                ", status=" + status +
                ", amount=" + amount +
                ", id=" + id +
                '}';
    }
}
