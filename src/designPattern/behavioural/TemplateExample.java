package designPattern.behavioural;


abstract class OrderProcess{
    // template method enforcing the order, it is not extendable
    public final void processOrder(){
        chooseItems();
        if(giftWrap){
            System.out.println("Wrapping the gifts, hook");
        }
        makePayment();
        collectItems();
    }

    boolean giftWrap = false;

    public void setGiftWrap(boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    abstract void chooseItems();

    public void makePayment(){
        System.out.println("Can pay via cash/upi . This is default behaviour");
    }
    abstract void collectItems();
}
class InstoreOrder extends OrderProcess{
    @Override
    public void chooseItems(){
        System.out.println("Select items physically");
    }
    @Override
    public void collectItems(){
        System.out.println("Immediately collect items physically");
    }
}
class OnlineStore extends OrderProcess{
    @Override
    public void chooseItems(){
        System.out.println("Select items by application");
    }

    @Override
    void collectItems() {
        System.out.println("Wait for items to get delivered");
    }
}
public class TemplateExample {

    public static void main(String[] args) {
        OrderProcess inStore = new InstoreOrder();
        inStore.processOrder();

        System.out.println("--------------------------------------------------------");
        OrderProcess onlineStore = new OnlineStore();
        onlineStore.setGiftWrap(true);
        onlineStore.processOrder();
    }

}
