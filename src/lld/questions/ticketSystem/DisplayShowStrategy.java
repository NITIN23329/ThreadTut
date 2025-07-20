package lld.questions.ticketSystem;

import java.util.ArrayList;
import java.util.List;


// strategy desing pattern
public abstract class  DisplayShowStrategy {
    private List<CinemaHall> cinemaHalls;

    public DisplayShowStrategy() {
        this.cinemaHalls = new ArrayList<>();
    }
    public void addCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHalls.add(cinemaHall);
    }
    public abstract List<Show> getShows();

    public List<CinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

    public void setCinemaHalls(List<CinemaHall> cinemaHalls) {
        this.cinemaHalls = cinemaHalls;
    }
}
class DisplayByLanguageStrategy extends DisplayShowStrategy {
    private String language;
    public DisplayByLanguageStrategy(String language) {
        this.language = language;
    }

    @Override
    public List<Show> getShows() {
        List<Show> allShows = new ArrayList<>();
        for(CinemaHall cinemaHall:getCinemaHalls() ) {
            List<Show> shows = cinemaHall.getShows();
            for(Show show:shows) {
                if(show.getMovie().getLanguage().equals(language)) {
                    allShows.add(show);
                }
            }
        }
        return allShows;
    }

}
class DisplayByMovieStrategy extends DisplayShowStrategy {
    private String movieName;
    public DisplayByMovieStrategy(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public List<Show> getShows() {
        List<Show> allShows = new ArrayList<>();
        for(CinemaHall cinemaHall:getCinemaHalls() ) {
            List<Show> shows = cinemaHall.getShows();
            for(Show show:shows) {
                if(show.getMovie().getName().equals(movieName)) {
                    allShows.add(show);
                }
            }
        }
        return allShows;
    }

}

