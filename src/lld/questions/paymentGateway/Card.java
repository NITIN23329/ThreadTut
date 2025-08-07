package lld.questions.paymentGateway;


public class Card {
    private String cardNumber;
    private String pin;
    private User user;


    public Card(String cardNumber, String pin, User user) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.user = user;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "user=" + user +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
