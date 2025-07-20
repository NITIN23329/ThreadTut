package lld.questions.ticketSystem;

import java.awt.print.Book;

public class Payment {
    private int paymentID;
    private BookingStatus status = BookingStatus.PENDING;
    public int calculatePrice(Booking booking) {
        int price = 0;
        for(Seat seat : booking.getSeats()) {
            price += seat.getPrice();
        }
        return price;
    }
    // can have multiple strategies to pay
    public void pay(Booking booking) {
        int price = calculatePrice(booking);
        System.out.println("Please pay: " + price);
        status = BookingStatus.SUCCESS;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
