package lld.questions.ticketSystem;

public class Seat {
    private int seatNumber;
    private boolean isAvailable;
    private int price;
    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        isAvailable = true;
        price = 10;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

interface Moveable{
    void move();
}
class Recliner extends Seat implements Moveable{
    public Recliner(int seatNumber){
        super(seatNumber);
        super.setPrice(15);
    }
    @Override
    public void move() {
        System.out.println("Recliner move");
    }

}
