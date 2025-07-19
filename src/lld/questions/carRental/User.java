package lld.questions.carRental;

public class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}
class Owner extends User {
    public Owner(String name) {
        super(name);
    }
}
class Customer extends User {
    public Customer(String name) {
        super(name);
    }
}
