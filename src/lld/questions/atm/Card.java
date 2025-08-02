package lld.questions.atm;

public class Card {
    private String cardNumber;
    private String cardName;


    public Card(String cardNumber, String cardName) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}
