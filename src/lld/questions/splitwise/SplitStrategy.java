package lld.questions.splitwise;

import java.util.List;

public abstract class SplitStrategy {

    public abstract void calculateSplitAmount(Expense expense);
}

class EqualSplitStrategy extends SplitStrategy {
    @Override
    public void calculateSplitAmount(Expense expense) {
        for (Split split : expense.getSplits()) {
            split.setAmount(expense.getAmount() / expense.getSplits().size());
        }
    }
}
class ExactSplitStrategy extends SplitStrategy {
    @Override
    public void calculateSplitAmount(Expense expense) {
        // not needed
    }
}

class PercentSplitStrategy extends SplitStrategy {
    @Override
    public void calculateSplitAmount(Expense expense) {
        // here in place of amount we can take %
        for (Split split : expense.getSplits()) {
            split.setAmount(expense.getAmount() * split.getAmount() / 100);
        }
    }
}
