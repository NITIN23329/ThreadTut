package lld.questions.atm;

public class CashDispenser {
    private CashDispenser next;
    private double denomination;


    public CashDispenser(double denomination) {
        this.next = next;
        this.denomination = denomination;
    }

    public void setNext(CashDispenser next) {
        this.next = next;
    }

    public void dispense(Account account, double amount){
        int cnt = 0;
        while(amount >= denomination){
            account.setBalance(account.getBalance() - denomination);
            cnt++;
            amount -=  denomination;
        }
        System.out.println(cnt + " " + denomination+" withdrawn, pending: " + amount);
        if(next != null){
            next.dispense(account, amount);
        }

    }

}
class CashDispenserSingleTon {

    private static CashDispenser cashDispenser = null;

    private CashDispenserSingleTon() {
    }

    public static CashDispenser getCashDispenser(){
        if(cashDispenser == null){
            CashDispenser cashDispenser100 = new CashDispenser(100);
            CashDispenser cashDispenser500 = new CashDispenser(500);
            CashDispenser cashDispenser2000 = new CashDispenser(2000);
            cashDispenser2000.setNext(cashDispenser500);
            cashDispenser500.setNext(cashDispenser100);
            cashDispenser = cashDispenser2000;
        }
        return cashDispenser;
    }
}
