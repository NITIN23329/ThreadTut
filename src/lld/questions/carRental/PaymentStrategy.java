package lld.questions.carRental;

import java.util.Date;

public abstract class PaymentStrategy {

    public abstract int calculatePrice(Booking booking);
}

class HourlyPaymentStrategy extends PaymentStrategy {
    @Override
    public int calculatePrice(Booking booking) {
        Date startDate = booking.getStartDate();
        Date endDate = booking.getEndDate();
        int startDateHours = startDate.getHours();
        int endDateHours = endDate.getHours();
        return (endDateHours - startDateHours + 1) * booking.getVehicle().getHourlyRentalPrice();
    }
}
class DailyPaymentStrategy extends PaymentStrategy {
    @Override
    public int calculatePrice(Booking booking) {
        Date startDate = booking.getStartDate();
        Date endDate = booking.getEndDate();
        int startDateHours = startDate.getDate();
        int endDateHours = endDate.getDate();
        return (endDateHours - startDateHours + 1) * booking.getVehicle().getDailyRentalPrice();
    }
}
