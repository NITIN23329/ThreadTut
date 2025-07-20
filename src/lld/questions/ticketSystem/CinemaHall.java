package lld.questions.ticketSystem;

import java.util.ArrayList;
import java.util.List;

public class CinemaHall {
    private String cinemaName;
    private List<Show> shows;

    public CinemaHall(String cinemaName) {
        this.cinemaName = cinemaName;
        shows = new ArrayList<>();
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
