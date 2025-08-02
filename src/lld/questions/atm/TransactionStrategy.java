package lld.questions.atm;




public abstract class TransactionStrategy {
    public abstract void execute(Account account, double amount);
}


class WithdrawTransaction extends TransactionStrategy {
    // cash dispenser is chain of responsibility
    CashDispenser cashDispenser= CashDispenserSingleTon.getCashDispenser();


    public void execute(Account account, double amount){
        cashDispenser.dispense(account, amount);
    }
}
class DepositTransaction extends TransactionStrategy {
    @Override
    public void execute(Account account, double amount) {

        System.out.println("Depositing " + amount);
        account.setBalance(account.getBalance() + amount);

    }
}
class CheckBalanceTransaction extends TransactionStrategy {
    @Override
    public void execute(Account account, double amount) {
        System.out.println("balance in account : "+account.getBalance());
    }
}

