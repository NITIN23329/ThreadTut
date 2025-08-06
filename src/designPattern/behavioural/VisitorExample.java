package designPattern.behavioural;
// interface to enforce class to accept a visitor object
interface RoomElement{
    void accept(Visitor visitor);
}
// concrete class calling visitor visit method and passing object
class SingleRoom implements RoomElement{
    int price;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class DoubleRoom implements RoomElement{
    int price;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
// visitor interface giving same functionality to each class of same type
interface Visitor {
    public void visit(SingleRoom singleRoom);
    public void visit(DoubleRoom doubleRoom);
}
// each concrete visitor is a functionality
class RoomPriceCalculator implements Visitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        singleRoom.price = 1000;
        System.out.println("Setting single room price");
    }
    @Override
    public void visit(DoubleRoom doubleRoom) {
        doubleRoom.price = 2000;
        System.out.println("Setting double room price");
    }
}
class RoomService implements Visitor{
    @Override
    public void visit(SingleRoom singleRoom) {
        System.out.println("service for single room");
    }
    @Override
    public void visit(DoubleRoom doubleRoom) {
        System.out.println("service for double room");
    }
}
public class VisitorExample {
    public static void main(String[] args) {

        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();

        // now we want to call price calculation method
        Visitor roomPriceCalculation = new RoomPriceCalculator();
        singleRoom.accept(roomPriceCalculation);
        System.out.println(((SingleRoom)singleRoom).price);
        doubleRoom.accept(roomPriceCalculation);
        System.out.println(((DoubleRoom)doubleRoom).price);

        // now call room service for double room
        Visitor roomService = new RoomService();
        doubleRoom.accept(roomService);


    }
}
