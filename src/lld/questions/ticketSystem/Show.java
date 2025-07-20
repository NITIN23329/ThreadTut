package lld.questions.ticketSystem;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int showId;
    private int startTime;
    private int endTime;
    private Movie movie;
    private List<Seat> seats;

    public Show(int showId, int startTime, int endTime, Movie movie) {
        this.showId = showId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;

        seats = new ArrayList<>();
        for(int i=0;i<10;i++)seats.add(new Seat(i));
        for(int i=0;i<5;i++)seats.add(new Recliner(i+10));
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", movie=" + movie +
                ", seats=" + seats +
                '}';
    }
}
