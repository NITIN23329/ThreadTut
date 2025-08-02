package lld.questions.atm.states;

import lld.questions.atm.Atm;
import lld.questions.atm.TransactionType;

import java.util.Scanner;

public class CardInsertedState implements ATMState {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void insertCard(Atm context) {}

    @Override
    public void enterPin(Atm context) {
        int pinAttempt = 0;
        while (pinAttempt < 3){
            System.out.println("Please enter pin number: ");

            String pin = scanner.nextLine();
            if(context.getBankSvc().validatePin(context.getCurrentCard().getCardNumber(), pin)){
                System.out.println("Pin validated!!");
                context.setAtmState(new ValidatedPinState());
                return;

            }
            pinAttempt++;
        }
        System.out.println("Max pin limit reached, try again");
        context.setAtmState(new IdleState());

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
