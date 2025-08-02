package lld.questions.splitwise;

import java.util.List;

enum ExpenseType {
    EQUAL, EXACT, PERCENTAGE
}
public class Expense {
    private int id;
    private String description;
    private double amount;
    private User paidBy;
    private ExpenseType type;
    private List<Split> splits;

    public Expense(int id, String description, double amount, User paidBy, ExpenseType type, List<Split> splits) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.type = type;
        this.splits = splits;

        SplitStrategy splitStrategy = SplitStrategyFactory.getSplitStrategy(type);
        splitStrategy.calculateSplitAmount(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }
}
