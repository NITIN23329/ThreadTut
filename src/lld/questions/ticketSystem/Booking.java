package lld.questions.ticketSystem;

import java.util.List;

enum BookingStatus {
    SUCCESS, PENDING, FAILED;
}

public class Booking {
    private int bookingID;
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private BookingStatus status;

    public Booking(int bookingID, Customer customer, Show show, List<Seat> seats) {
        this.bookingID = bookingID;
        this.customer = customer;
        this.show = show;
        this.seats = seats;
        status = BookingStatus.PENDING;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
