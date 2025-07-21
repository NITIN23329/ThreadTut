package lld.theory.liskovSubstitutionPrinciple;

interface Shape{
    public int calculateArea();
}
class RectangleFix implements Shape{
    int width, height;

    public RectangleFix(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public int calculateArea() {
        return width * height;
    }
}
class SquareFix implements Shape{
    int side;

    public SquareFix(int side) {
        this.side = side;
    }

    @Override
    public int calculateArea() {
        return side * side;
    }
}
public class Fix {
    public static void main(String[] args) {
        Shape rectange = new RectangleFix(3,4);
        System.out.println(rectange.calculateArea());
        rectange = new SquareFix(5);
        System.out.println(rectange.calculateArea());
    }
}
