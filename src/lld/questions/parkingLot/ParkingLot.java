package lld.questions.parkingLot;

import java.util.List;
import java.util.Map;

// we can have 2 wheller parking lot and 4 wheller parking lot (inherirance)
public class ParkingLot {
    private List<Spot> spots;
    private Map<Integer, Ticket> tickets;

    public ParkingLot(int twoWheelerSpots, int fourWheelerSpots) {
        int n = twoWheelerSpots + fourWheelerSpots;
        this.spots = new java.util.ArrayList<>(n);
        this.tickets = new java.util.HashMap<>(n);
        for(int i=0;i<n;i++){
            if ( i < twoWheelerSpots) spots.add(new Spot(i,true, SpotType.TWO_WHEELER));
            else spots.add(new Spot(i,true, SpotType.FOUR_WHEELER));
        }
    }
    // now you can use strategy design pattern to find spot in different ways
    public Spot getAvailableSpot(VehicleType vehicleType) {
        SpotType spotType = null;
        if(vehicleType == VehicleType.CAR) {
            spotType = SpotType.FOUR_WHEELER;
        } else if(vehicleType == VehicleType.BIKE) {
            spotType = SpotType.TWO_WHEELER;
        } else {
            System.out.println("Invalid vehicle type: " + vehicleType);
            return null;
        }
        for(Spot spot : spots){
            if(spot.isAvailable() && spot.getSpotType() == spotType){
                return spot;
            }
        }
        System.out.println("No available spot for type: " + spotType);
        return null;
    }
    public void bookSpot(Ticket ticket){
        Spot spot = ticket.getSpot();
        spot.setAvailable(false);
        this.tickets.put(ticket.getTicketId(), ticket);
    }
    public int calculatePrice(Ticket ticket) {
        Spot spot = ticket.getSpot();
        BillType billType = ticket.getBillType();
        int price = 0;
        if (spot.getSpotType() == SpotType.TWO_WHEELER)
            price = billType.getPrice() ;
        else price = billType.getPrice() * 2; // Assuming four wheeler costs double
        long endTime = System.currentTimeMillis();
        int factors = (int) ((endTime - ticket.getEntryTime()) / 100);
        return price * factors;
    }
    public void releaseSpot(Ticket ticket) {
        Spot spot = ticket.getSpot();
        spot.setAvailable(true);
        int spotId = spot.getSpotId();
        this.tickets.remove(spotId);

    }


    @Override
    public String toString() {
        return "ParkingLot{" +
                "spots=" + spots +
                ", tickets=" + tickets +
                '}';
    }
}
