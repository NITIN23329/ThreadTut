package lld.questions.atm;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Card card = new Card("123456789" ,"HDFC Regalia");
        Account account = new Account(32456, 10000, "1234");
        Map<String, Account> map = new HashMap<>();
        map.put(card.getCardNumber(), account);
        BankSvc bankSvc  = new BankSvc(map);
        Atm atm = new Atm(bankSvc);
        atm.insertCard(card);
        atm.enterPin();
        atm.selectTransaction(TransactionType.CHECK_BALANCE);
        atm.performTranTransaction(TransactionType.CHECK_BALANCE);
        atm.selectTransaction(TransactionType.WITHDRAW);
        atm.performTranTransaction(TransactionType.WITHDRAW);
        atm.selectTransaction(TransactionType.DEPOSIT);
        atm.performTranTransaction(TransactionType.DEPOSIT);
        atm.selectTransaction(TransactionType.CHECK_BALANCE);
        atm.performTranTransaction(TransactionType.CHECK_BALANCE);

        atm.ejectCard();



    }
}
