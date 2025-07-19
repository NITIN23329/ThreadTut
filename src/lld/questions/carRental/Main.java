package lld.questions.carRental;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car(1, new Owner("Surabhi"));
        Vehicle bike  = new Bike(2, new Owner("Nitin"));
        VehicleRental rental = new VehicleRental();
        rental.addVehicle(car);
        rental.addVehicle(bike);

        FilterVehiclesStrategy filterVehiclesStrategy = new FilterByType(VehicleType.BIKE);
        System.out.println(filterVehiclesStrategy.display(rental.getVehicles()));

        Bill bill = rental.bookVehicle(bike, new Customer("Manas"), new Date(2025, 12,01), new Date(2025, 12, 10), BookingType.DAILY, new DailyPaymentStrategy());
        System.out.println(bill);




    }
}
