package lld.questions.ticketSystem;

// template desing pattern
// singleteon design pattern
public class BookingController {
    private static BookingController bookingController;
    private BookingController() {}
    public static BookingController getInstance() {
        if (bookingController == null) {
            bookingController = new BookingController();
        }
        return bookingController;
    }
    public boolean book(Booking booking) {
        synchronized (booking) {
            Payment payment = new Payment();
            payment.pay(booking);
            if(payment.getStatus() !=  BookingStatus.SUCCESS)return false;
            for(Seat seat : booking.getSeats()) {
                seat.setAvailable(false);
            }
            booking.setStatus(BookingStatus.SUCCESS);
            return true;
        }
    }
}
