package designPattern.structural;
// component interface
interface Coffee {
    int getPrice();
    String getDescription();
}
// basic component object which we will be wrapping
class SimpleCoffee implements Coffee {
    private int price;
    private String description;
    public SimpleCoffee(int price, String description) {
        this.price = price;
        this.description = description;
    }
    @Override
    public int getPrice() {return this.price;}

    @Override
    public String getDescription() {return this.description;}
}
// create a abstreact decorator class that wraps object of coffee,we overide the methods we want to change
abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    @Override
    public int getPrice(){return this.coffee.getPrice();}
    @Override
    public String getDescription(){return this.coffee.getDescription();}

}
// now we create concrete implemntation of decorators
class Latte extends CoffeeDecorator{
    public Latte(Coffee coffee){super(coffee);}


    @Override
    public int getPrice() {return super.getPrice() + 10;} // modify base functinoalty

    @Override
    public String getDescription() {return super.getDescription()+", Milk";}
}
class ColdCoffee extends CoffeeDecorator{
    public ColdCoffee(Coffee coffee){super(coffee);}

    @Override
    public int getPrice() {return super.getPrice()+ 5;}

    @Override
    public String getDescription() {return super.getDescription()+", Ice";}
}


public class DecoratorExample {
    public static void main(String[] args) {

        Coffee basic = new SimpleCoffee(10,"Coffee");
        System.out.println(basic.getDescription()+" : "+basic.getPrice());

        Coffee latte = new Latte(basic);
        System.out.println(latte.getDescription()+" : "+latte.getPrice());

        Coffee cold = new ColdCoffee(basic);
        System.out.println(cold.getDescription()+" : "+cold.getPrice());
    }
}
