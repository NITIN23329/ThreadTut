package lld.questions.splitwise;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<User> allUsers;
    private List<Expense> expenses;
    public Group(String groupName) {
        this.groupName = groupName;
        allUsers = new ArrayList<>();
        expenses = new ArrayList<>();
    }
    public void  addUser(User user) {
        allUsers.add(user);
    }
    public void removeUser(User user) {
        allUsers.remove(user);
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}


class GroupController {
    private Group group;
    private BalanceSheet balanceSheet;
    public GroupController(Group group) {
        this.group = group;
        balanceSheet = new BalanceSheet();
    }

    public void addUser(User user) {
        group.addUser(user);
    }
    public void removeUser(User user) {
        group.removeUser(user);
    }

    public void addExpense(Expense expense){
        group.getExpenses().add(expense);
        balanceSheet.addExpense(expense);
    }

    public void showOwes(){
        balanceSheet.showOwes();
    }
}
