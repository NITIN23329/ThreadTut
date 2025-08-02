package lld.questions.atm.states;

import lld.questions.atm.Atm;
import lld.questions.atm.TransactionType;

public class ValidatedPinState implements ATMState {
    @Override
    public void insertCard(Atm context) {

    }

    @Override
    public void enterPin(Atm context) {

    }

    @Override
    public void selectTransaction(Atm context, TransactionType type) {
        System.out.println("Selected transaction: " + type);
        context.setAtmState(new TransactionState());
    }

    @Override
    public void performTransaction(Atm context, TransactionType type) {

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
