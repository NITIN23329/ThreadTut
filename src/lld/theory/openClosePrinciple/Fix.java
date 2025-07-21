package lld.theory.openClosePrinciple;

abstract class CalculatorFix{
     int a , b;
    public CalculatorFix(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public abstract int calculate();
}
class Addition extends CalculatorFix{
    public Addition(int a, int b) {super(a, b);}

    @Override
    public int calculate() {return a + b;}
}
class Substraction extends CalculatorFix{
    public Substraction(int a, int b) {super(a, b);}

    @Override
    public int calculate() {return a - b;}
}
class Multiplication extends CalculatorFix{
    public Multiplication(int a, int b) {super(a, b);}

    @Override
    public int calculate() {return a * b;}
}

public class Fix {
    public static void main(String[] args) {
        CalculatorFix addition = new Addition(1, 2);
        System.out.println(addition.calculate());
        CalculatorFix substraction = new Substraction(1, 2);
        System.out.println(substraction.calculate());
        CalculatorFix multiplication = new Multiplication(1, 2);
        System.out.println(multiplication.calculate());

    }
}
