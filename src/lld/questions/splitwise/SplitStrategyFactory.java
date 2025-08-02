package lld.questions.splitwise;

public class SplitStrategyFactory {
    public static SplitStrategy getSplitStrategy(ExpenseType expenseType) {
        return switch (expenseType) {
            case EQUAL -> new EqualSplitStrategy();
            case EXACT -> new ExactSplitStrategy();
            case PERCENTAGE -> new PercentSplitStrategy();
        };
    }
}
