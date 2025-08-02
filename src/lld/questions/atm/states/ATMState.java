package lld.questions.atm.states;

import lld.questions.atm.Atm;
import lld.questions.atm.TransactionType;

public interface ATMState {
    void insertCard(Atm context);
    void enterPin(Atm context);
    void selectTransaction(Atm context, TransactionType type);
    void performTransaction(Atm context, TransactionType type);
    void ejectCard(Atm context);
    void printReceipt(Atm context);

}
