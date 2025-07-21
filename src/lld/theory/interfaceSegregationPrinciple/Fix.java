package lld.theory.interfaceSegregationPrinciple;
interface PrinterFix{
    public void print();
}
interface Scanner {
    public void scan();
}
class SimplePrinterFix implements PrinterFix{

    @Override
    public void print() {
        System.out.println("Printing the document");
    }

}
class AdvancePrinterFix implements PrinterFix, Scanner{

    @Override
    public void print() {
        System.out.println("Printing the document");

    }

    @Override
    public void scan() {
        System.out.println("scaning the document");

    }
}
public class Fix {
    public static void main(String[] args) {
        SimplePrinterFix printer = new SimplePrinterFix();
        printer.print();

        AdvancePrinterFix advancePrinter = new AdvancePrinterFix();
        advancePrinter.scan();
    }
}