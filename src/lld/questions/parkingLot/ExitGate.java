package lld.questions.parkingLot;

public class ExitGate {

    private ParkingLot parkingLot;

    public  ExitGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public int checkout(Ticket ticket) {
        int price = parkingLot.calculatePrice(ticket);
        parkingLot.releaseSpot(ticket);
        return price;
    }
}
