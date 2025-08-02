package lld.questions.atm.states;

import lld.questions.atm.Atm;
import lld.questions.atm.TransactionType;

public class IdleState implements ATMState {

    @Override
    public void insertCard(Atm context) {
        System.out.println("Please insert a valid card");
        context.setAtmState(new CardInsertedState());
    }

    @Override
    public void enterPin(Atm context) {
    }

    @Override
    public void selectTransaction(Atm context, TransactionType transactionType) {
    }

    @Override
    public void performTransaction(Atm context, TransactionType transactionType) {
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
