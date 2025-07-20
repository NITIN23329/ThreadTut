package lld.questions.ticketSystem;

import lld.questions.elevator.Display;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("3 Idiots","HINDI", 9);
        Movie movie2 = new Movie("War","ENGLISH", 8);
        Show show1 = new Show(1, 1, 10, movie1);
        Show show2 = new Show(2, 20, 30, movie1);

        CinemaHall cinemaHall1 = new CinemaHall("PVR Nexus");
        CinemaHallController cinemaHallController1 = new CinemaHallController(cinemaHall1);
        cinemaHallController1.addShow(show1);
        cinemaHallController1.addShow(show2);

        CinemaHall cinemaHall2 = new CinemaHall("PVR Soul Space");
        CinemaHallController cinemaHallController2 = new CinemaHallController(cinemaHall2);

        Show show3 = new Show(3, 20, 30, movie1);
        Show show4 = new Show(4, 1, 10, movie2);
        cinemaHallController2.addShow(show3);
        cinemaHallController2.addShow(show4);


        DisplayShowStrategy displayShowStrategy = new DisplayByLanguageStrategy("HINDI");
        displayShowStrategy.addCinemaHall(cinemaHall1);
        displayShowStrategy.addCinemaHall(cinemaHall2);
        System.out.println(displayShowStrategy.getShows());

        BookingController bookingController = BookingController.getInstance();


        Show selectedShow = displayShowStrategy.getShows().get(0);

        Booking booking = new Booking(1, new Customer("Nitin"),selectedShow, List.of(selectedShow.getSeats().get(0), selectedShow.getSeats().get(1)) );
        bookingController.book(booking);


    }
}
