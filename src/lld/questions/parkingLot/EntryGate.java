package lld.questions.parkingLot;

public class EntryGate {

    private ParkingLot parkingLot;

    public EntryGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket reserve(Vehicle vehicle, BillType billType) {
        Spot spot = parkingLot.getAvailableSpot(vehicle.getVehicleType());
        Ticket ticket = new Ticket(vehicle, spot, billType);
        parkingLot.bookSpot(ticket);
        return ticket;

    }
}
