package lld.questions.carRental;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterVehiclesStrategy {
    public abstract List<Vehicle> display(List<Vehicle> vehicles);
}
class FilterByType extends FilterVehiclesStrategy {
    private VehicleType vehicleType;
    public FilterByType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public List<Vehicle> display(List<Vehicle> vehicles) {
        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equals(vehicleType)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }
}
class FilterByPrice extends FilterVehiclesStrategy {
    private int maxPrice;
    private BookingType bookingType;

    public FilterByPrice(BookingType bookingType, int maxPrice) {
        this.bookingType = bookingType;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Vehicle> display(List<Vehicle> vehicles) {
        List<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles) {
            if (bookingType == BookingType.HOURLY && vehicle.getHourlyRentalPrice() <=maxPrice) {
                filteredVehicles.add(vehicle);
            }
            else if (bookingType == BookingType.DAILY && vehicle.getDailyRentalPrice() <=maxPrice) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }
}
