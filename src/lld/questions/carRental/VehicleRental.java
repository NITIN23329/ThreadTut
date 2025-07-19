package lld.questions.carRental;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleRental {

    private List<Vehicle> vehicles = new ArrayList<>();
    private BookingLogs bookingLogs = new BookingLogs();
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public Bill bookVehicle(Vehicle vehicle, Customer customer, Date startDate, Date endDate, BookingType bookingType, PaymentStrategy paymentStrategy) {
        Booking booking = new Booking(customer, vehicle, startDate, endDate, bookingType, paymentStrategy);
        bookingLogs.addBooking(booking);
        Bill bill = new Bill(booking);
        return bill;

    }
    public void unbookVehicle(Vehicle vehicle) {
        vehicle.unbook();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}
