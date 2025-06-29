package designPattern.behavioural;
// Base handler having common code of all handlers
abstract class Handler{
    Handler next;
    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }
    abstract void handle(String request);
}
// concrete handler
class AuthHandler extends Handler{
    public void handle(String request) {
       if(request.contains("auth")){
           System.out.println("authenticated!!");
           this.next.handle(request);
       }else {
           System.out.println("Authenticated failed!!");
       }
    }
}
class SpamHandler extends Handler{
    public void handle(String request) {
        if(request.contains("spam")){
            System.out.println("spam detected!!");
        }else {
            System.out.println("spam not detected!!");
            this.next.handle(request);
        }
    }
}
class DataHandler extends Handler{
    public void handle(String request) {
        System.out.println("finally reached to actual data logic");
    }
}
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler chain = new AuthHandler();
        chain.setNext(new SpamHandler())
                .setNext(new DataHandler());

        chain.handle("request is authenticated and this is not a spam");
    }
}
