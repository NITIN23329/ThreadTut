package lld.questions.carRental;

import java.awt.print.Book;

public class Bill {
    private Booking booking;
    private int price;
    private boolean billPaid;
    public Bill(Booking booking) {
        this.booking = booking;
        this.price = this.booking.calculatePrice();
        this.billPaid = false;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "booking=" + booking +
                ", price=" + price +
                ", billPaid=" + billPaid +
                '}';
    }

    // here we can have bill payment strategy online/cash

}
