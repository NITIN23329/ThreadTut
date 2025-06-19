package designPattern.creational;

import java.util.Scanner;

// create interface for each product type
interface Button{
    void click();
}
interface TextBox{
    void display(String text);
}
// create different concrete product class for each product type
class WinButton implements Button{
    @Override
    public void click(){
        System.out.println("Clicking window button");
    }
}
class MacButton implements Button{
    @Override
    public void click(){
        System.out.println("Clicking mac button");
    }
}
class WinTextBox implements TextBox{
    @Override
    public void display(String text){
        System.out.println("Displaying window textbox: " + text);
    }
}

class MacTextBox implements TextBox{
    @Override
    public void display(String text){
        System.out.println("Displaying mac textbox: "+text);
    }
}
// create abstract factory interface that allow you to create all products of same variant
interface UIFactory{
    public Button createButton();
    public TextBox createTextBox();
}
class WinUIFactory implements UIFactory{
    @Override
    public Button createButton(){
        return new WinButton();
    }
    @Override
    public TextBox createTextBox(){
        return new WinTextBox();
    }
}
class MacUIFactory implements UIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }
    @Override
    public TextBox createTextBox(){
        return new MacTextBox();
    }
}
// use it in applicaiotn class
class Application {
    private Button button;
    private TextBox textBox;
    public Application(UIFactory uiFactory){
        button = uiFactory.createButton();
        textBox = uiFactory.createTextBox();
    }
    public void renderUI(){
        button.click();
        textBox.display("Input of text box");
    }
}
public class AbstractExample {
    public static void main(String[] args) {

        System.out.println("Enter 1 for Mac, 2 for Windows");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        UIFactory uiFactory  = null;
        if(choice == 1){
             uiFactory = new MacUIFactory();
        }else if(choice == 2){
            uiFactory = new WinUIFactory();
        }
        Application app = new Application(uiFactory);
        app.renderUI();

    }
}
