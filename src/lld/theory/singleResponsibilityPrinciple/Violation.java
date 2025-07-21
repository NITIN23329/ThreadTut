package lld.theory.singleResponsibilityPrinciple;


class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String fetchUser(){
        return "Sir " + this.name;
    }


    public void saveToDB(){
        System.out.println("Saving User: " + fetchUser() +" to db");
    }
    public void email(){
        System.out.println("Emailing to User: " + fetchUser());
    }
}
public class Violation {
    public static void main(String[] args) {
        User user = new User("Nitin");
        user.saveToDB();
        user.email();
        // now let say while saving to db, we want to update fetchUser() to something else,
        // this will impact the email method as it is using same method
        // this is unwanted. We want to change it for one thing,
        // and it got chnaged somewhere else as well
    }
}
