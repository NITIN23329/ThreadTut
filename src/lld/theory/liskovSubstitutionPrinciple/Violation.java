package lld.theory.liskovSubstitutionPrinciple;

class Rectangle{
    int width, height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea(){
        return width * height;
    }
}
class Square extends Rectangle{
    @Override
    public void setWidth(int width){
        super.width = super.height = width;
    }
    @Override
    public void setHeight(int height){
        super.width = super.height = height;
    }

}
public class Violation {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(5);
        rectangle.setWidth(10);
        System.out.println(rectangle.calculateArea());
        rectangle = new Square();
        rectangle.setHeight(5);
        rectangle.setWidth(10);
        System.out.println(rectangle.calculateArea());
    }
}
