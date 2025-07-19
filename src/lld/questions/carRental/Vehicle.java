package lld.questions.carRental;


enum VehicleType{
    CAR, BIKE
}
// to get rental price daily or weekly we enforce child classes to do it.
public abstract class Vehicle {
    private int vehicleId;
    private VehicleType vehicleType;
    private Owner owner;

    private boolean available;
    public abstract int  getDailyRentalPrice();
    public abstract int  getHourlyRentalPrice();

    public Vehicle(int vehicleId, VehicleType vehicleType, Owner owner) {
        this.available = true;
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.owner = owner;
    }
    public void book(){
        if(!available){
            throw new IllegalStateException("Vehicle is not available");
        }
        available = false;
    }
    public void unbook(){
        available = true;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleType=" + vehicleType +
                ", owner=" + owner +
                ", available=" + available +
                '}';
    }
}

class Car extends Vehicle{
    public Car(int vehicleId, Owner owner) {
        super(vehicleId, VehicleType.CAR, owner);
    }

    @Override
    public int getDailyRentalPrice() {
        return 1000;
    }

    @Override
    public int getHourlyRentalPrice() {
        return 10;
    }
}
class Bike extends Vehicle{
    public Bike(int vehicleId, Owner owner) {
        super(vehicleId, VehicleType.BIKE, owner);
    }

    @Override
    public int getDailyRentalPrice() {
        return 500;
    }

    @Override
    public int getHourlyRentalPrice() {
        return 5;
    }


}