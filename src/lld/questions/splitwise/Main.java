package lld.questions.splitwise;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        User u1 = new User("Nitin", "123");
        User u2 = new User("Surabhi", "123");
        User u3 = new User("Manas", "123");

        Group group1 = new Group("TriCount");
        GroupController groupController = new GroupController(group1);
        groupController.addUser(u1);
        groupController.addUser(u2);
        groupController.addUser(u3);

        Expense expense1 = new Expense(1, "cab",  300d, u1, ExpenseType.EQUAL, List.of(new Split(u1, 100), new Split(u2, 200), new Split(u3, 300)));
        groupController.addExpense(expense1);

        Expense expense2 =  new Expense(2, "eat", 1000, u2, ExpenseType.PERCENTAGE, List.of(new Split(u1, 30), new Split(u2, 20), new Split(u3, 50)));
        groupController.addExpense(expense2);

        groupController.showOwes();
    }
}
