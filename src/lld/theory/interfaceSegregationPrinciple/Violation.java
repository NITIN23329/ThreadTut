package lld.theory.interfaceSegregationPrinciple;

interface Printer{
    void print();
    void scanDocument();
}
class SimplePrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing the document");
    }

    @Override
    public void scanDocument() {
        throw  new UnsupportedOperationException("Scan not supported in simple printer");
    }
}
class AdvancePrinter implements Printer{

    @Override
    public void print() {
        System.out.println("Printing the document");

    }

    @Override
    public void scanDocument() {
        System.out.println("scaning the document");

    }
}
public class Violation {
    public static void main(String[] args) {
        SimplePrinter printer = new SimplePrinter();
        printer.scanDocument();
    }
}
