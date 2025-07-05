package lld.questions.parkingLot;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(10,5);

        EntryGate entryGate = new EntryGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot);


        Vehicle vehicle1 = new Vehicle("KA-01-1234", VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("KA-02-5678", VehicleType.BIKE);

        Ticket ticket1= entryGate.reserve(vehicle1, BillType.HOURLY);
        Ticket ticket2 = entryGate.reserve(vehicle2, BillType.DAILY);



        Thread.sleep(5000); // Simulating some time spent in the parking lot

        int price1 = exitGate.checkout(ticket1);
        System.out.println("Price for vehicle 1: " + price1);
        int price2 = exitGate.checkout(ticket2);

        System.out.println("Price for vehicle 2: " + price2);
    }
}
