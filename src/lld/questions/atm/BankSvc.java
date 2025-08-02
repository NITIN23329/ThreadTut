package lld.questions.atm;

import java.util.HashMap;
import java.util.Map;

public class BankSvc {

    Map<String, Account > accounts ;

    public BankSvc(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    public boolean validatePin(String cardNumber, String requestedPin){
        String actualPin  = accounts.get(cardNumber).getPin();
        return actualPin.equals(requestedPin);
    }

    public Account getAccount(String cardNumber){
        return   accounts.get(cardNumber);
    }
}
