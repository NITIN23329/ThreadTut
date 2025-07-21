package lld.theory.dependencyInversionPrinciple;

class MySQL {
    public void save(){
        System.out.println("Saving to mysql db");
    }
}

class ShoppingCart{
    private MySQL mySQL = new MySQL();
    public void checkout(){
        mySQL.save();
    }
}

public class Violation {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.checkout();
    }
}
