package lld.theory.dependencyInversionPrinciple;


interface Database{
    public void save();
}
class MySQLFix implements Database {
    @Override
    public void save() {
        System.out.println("Saving to mysql db");
    }
}
class NoSQL implements Database {
    @Override
    public void save() {
        System.out.println("Saving to nosql db");
    }
}
class ShoppingKartFix {
    Database database;

    public ShoppingKartFix(Database database) {
        this.database = database;
    }
    public void checkout(){
        database.save();
    }
}
public class Fix {
    public static void main(String[] args) {
        ShoppingKartFix shoppingCart = new ShoppingKartFix(new MySQLFix());
        shoppingCart.checkout();

        shoppingCart = new ShoppingKartFix(new NoSQL());
        shoppingCart.checkout();
    }
}
