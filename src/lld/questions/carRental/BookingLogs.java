package lld.questions.carRental;

import java.util.ArrayList;
import java.util.List;

public class BookingLogs {
    List<Booking> bookings;

    public BookingLogs() {
        this.bookings = new ArrayList<>();
    }
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }
}
