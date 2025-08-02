package lld.questions.splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheet {
    Map<User, Map<User, Double>> owes ;
    public BalanceSheet() {
        owes = new HashMap<>();
    }
    public void addExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        if(!owes.containsKey(paidBy)) owes.put(paidBy, new HashMap<>());

        List<Split> splits = expense.getSplits();
        for(Split split : splits) {
            if(split.getUser().equals(paidBy)) continue;
            if(!owes.containsKey(split.getUser())) owes.put(split.getUser(), new HashMap<>());
            if(owes.get(paidBy).containsKey(split.getUser())) {
                if (owes.get(paidBy).get(split.getUser()) <= split.getAmount()) {
                    double pending = split.getAmount() - owes.get(paidBy).get(split.getUser());
                    owes.get(paidBy).remove(split.getUser());
                    if( pending > 0) owes.get(split.getUser()).put(paidBy, pending);
                }else {
                    owes.get(paidBy).put(split.getUser(), owes.get(paidBy).get(split.getUser()) - split.getAmount());
                }
            }
            else owes.get(split.getUser()).put(paidBy, split.getAmount());

        }
    }

    public void showOwes(){
        for(User user1 : owes.keySet()) {
            for(User user2 : owes.get(user1).keySet()) {
                System.out.println("User " + user1.getUsername() + " has to pay " + owes.get(user1).get(user2)+" amount to user : " + user2.getUsername());
            }
        }
        System.out.println("---------------------------------------------");
    }
}
