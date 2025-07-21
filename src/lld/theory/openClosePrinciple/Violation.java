package lld.theory.openClosePrinciple;

class Calculator {
    private int a, b;
    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int add(){
        return a + b;
    }
    public int subtract(){
        return a - b;
    }
}
public class Violation {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(3, 4);
        System.out.println(calculator.add());
        System.out.println(calculator.subtract());
        // now each time we add new calculation, we need to update existing class which is bad
    }
}
