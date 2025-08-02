package lld.questions.atm;

import lld.questions.atm.states.ATMState;
import lld.questions.atm.states.IdleState;

public class Atm {
    private ATMState atmState;
    private BankSvc bankSvc;
    private Card currentCard;

    public Atm(BankSvc svc) {
        this.atmState = new IdleState();
        this.bankSvc = svc;
    }


    public void insertCard(Card currentCard) {
        this.currentCard = currentCard;
        atmState.insertCard(this);
    }

    public void enterPin(){
        atmState.enterPin(this);
    }

    public void selectTransaction(TransactionType type){
        atmState.selectTransaction(this, type);
    }

    public void performTranTransaction(TransactionType type){
        atmState.performTransaction(this, type);
    }
    public void ejectCard() {
        atmState.ejectCard(this);
        this.currentCard = null;

    }


    public Card getCurrentCard() {
        return currentCard;
    }



    public void setAtmState(ATMState atmState) {
        this.atmState = atmState;
    }

    public BankSvc getBankSvc() {
        return bankSvc;
    }

}
