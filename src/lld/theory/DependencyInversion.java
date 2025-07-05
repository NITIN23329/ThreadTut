package lld.theory;

interface Keyboard{
    void setUp();
}
class WiredKeyboard implements Keyboard{
    @Override
    public void setUp() {
        System.out.println("plug in the keyboard");
    }
}
class WirelessKeyboard implements Keyboard{
    @Override
    public void setUp() {
        System.out.println("turn on bluetooth and connect");
    }
}
class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public void switchOn(){
        keyboard.setUp();
    }
}
public class DependencyInversion {
    public static void main(String[] args) {
        Computer c = new Computer(new WirelessKeyboard());
        c.switchOn();
    }
}
