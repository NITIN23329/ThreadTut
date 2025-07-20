package lld.questions.ticketSystem;

public class CinemaHallController {
    private CinemaHall cinemaHall;
    public CinemaHallController(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
    public void addShow(Show show) {
        cinemaHall.getShows().add(show);
    }
    public void removeShow(Show show) {
        cinemaHall.getShows().remove(show);
    }
}
