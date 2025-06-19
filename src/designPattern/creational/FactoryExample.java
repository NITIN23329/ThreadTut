package designPattern.creational;

import java.util.Scanner;

// create a interface for product. All product will implement it,this give use a generics
interface Button2 {
    void onClick();
}
// create different concrete products
class WindowButton implements Button2{
    @Override
    public void onClick() {
        System.out.println("Clicking Windows button");
    }
}
class HTMLButton implements Button2{
    @Override
    public void onClick() {
        System.out.println("Clicking HTML button");
    }
}
// create Factory creator abstract class
abstract class ButtonFactory{
    public abstract Button2 createButton(); // factory method
    public void render(){
        Button2 button = createButton();
        button.onClick();
    }

}
// create concrete factory for each product
class WindowButtonFactory extends ButtonFactory{
    @Override
    public Button2 createButton(){
        return new WindowButton();
    }
}
class HTMLButtonFactory extends ButtonFactory{
    @Override
    public Button2 createButton(){
        return new HTMLButton();
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        System.out.println("Enter 1 for Window button, 2 for HTML");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        ButtonFactory buttonFactory;
        if(choice == 1){
            buttonFactory = new WindowButtonFactory();
        }else if(choice == 2){
            buttonFactory = new HTMLButtonFactory();
        }else buttonFactory = null;

        buttonFactory.render();

    }
}
