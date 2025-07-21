package lld.theory.singleResponsibilityPrinciple;

class UserFixed {
    private String name;

    public UserFixed(String name) {this.name = name;}

    public String fetchUser(){return "Sir " + name;}

    public String getName() {return name;}
}
class SaveToDB {
    UserFixed user;

    public SaveToDB(UserFixed user) {this.user = user;}
    public String fetchUser(){return "Mr " + user.getName();}
    public void saveToDB(){System.out.println("Saving User: " + this.fetchUser() +" to db");}
}
class EmailUser {
    UserFixed user;

    public EmailUser(UserFixed user) {this.user = user;}
    public void email(){System.out.println("Saving User: " + user.fetchUser() +" to db");}
}
public class Fix {
    public static void main(String[] args) {
        UserFixed user = new UserFixed("Nitin");
        SaveToDB saveToDB = new SaveToDB(user);
        EmailUser emailUser = new EmailUser(user);
        saveToDB.saveToDB();
        emailUser.email();
        // now if want to change save to db logic we can do so whitout impacting email
    }
}
