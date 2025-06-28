package designPattern.structural;

// this is abstractor that contains reference object of implementor
abstract class Shape{
    Color color;
    public Shape(Color color) {
        this.color = color;
    }
    abstract void draw();
}
// these are concrete abstractors that may uses implementor object to give them some work
class Square extends Shape{
    public Square(Color color) {
        super(color);
    }
    @Override
    public void draw() {
        System.out.println("Drawing Square with : ");
        this.color.applyColor();
    }
}
class Circle extends Shape{
    public Circle(Color color) {
        super(color);
    }
    @Override
    public void draw() {
        System.out.println("Drawing Circle with: ");
        this.color.applyColor(); // give work to implementor
    }
}

// this is implementor interface
interface Color{
    void applyColor();
}
// these are concrete implementor that do low level job given by concrete abstractors
class RedColor implements Color{
    @Override
    public void applyColor() {
        System.out.println("Red color");
    }
}
class BlueColor implements Color{
    @Override
    public void applyColor() {
        System.out.println("Blue color");
    }
}

public class BridgeExample {
    public static void main(String[] args) {
        Shape redCircle  = new Circle(new RedColor());
        redCircle.draw();

        Shape blueSquare = new Square(new BlueColor());
        blueSquare.draw();
    }
}
