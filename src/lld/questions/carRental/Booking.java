package lld.questions.carRental;

import java.util.Date;

enum BookingType {
    HOURLY, DAILY
}

public class Booking {
    private static int counter = 0;
    private int id;
    private Customer customer;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
    private BookingType bookingType;
    private PaymentStrategy paymentStrategy;

    public Booking(Customer customer, Vehicle vehicle, Date startDate, Date endDate, BookingType bookingType, PaymentStrategy paymentStrategy) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingType = bookingType;
        this.paymentStrategy = paymentStrategy;
        vehicle.book();
        id = counter++;
    }
    public int calculatePrice(){
        return this.paymentStrategy.calculatePrice(this);

    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getStartDate() {
        return startDate;
    }


    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", bookingType=" + bookingType +
                '}';
    }
}
