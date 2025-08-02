package lld.questions.atm.states;

import lld.questions.atm.*;

import java.util.Scanner;

public class TransactionState implements ATMState{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void insertCard(Atm context) {

    }

    @Override
    public void enterPin(Atm context) {

    }

    @Override
    public void selectTransaction(Atm context, TransactionType type) {

    }

    @Override
    public void performTransaction(Atm context, TransactionType type) {
        TransactionStrategy strategy = TransactionFactory.getTransactionStrategy(type);
        Account account = context.getBankSvc().getAccount(context.getCurrentCard().getCardNumber());
        double amount  = 0;
        if(type == TransactionType.DEPOSIT || type == TransactionType.WITHDRAW) {
            System.out.println("Enter amount : ");
             amount = scanner.nextDouble();
        }
        strategy.execute(account, amount);
        context.setAtmState(new ValidatedPinState());

    }

    @Override
    public void ejectCard(Atm context) {
        System.out.println(" Eject card");
        context.setAtmState(new IdleState());

    }

    @Override
    public void printReceipt(Atm context) {

    }
}
