package lld.questions.cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String name;
    private Team team1;
    private Team team2;
    private int totalOvers;
    private List<Innings> innings;
    private Innings currentInning;;

    public Match(String name, Team team1, Team team2, int totalOvers) {
        this.name = name;
        this.team1 = team1;
        this.team2 = team2;
        this.totalOvers = totalOvers;
        this.innings = new ArrayList<>();

    }
    public void startMatch(){
        innings.add(new Innings(team1, team2));
        currentInning = innings.get(0);
    }
    public void nextInning() {
        innings.add(new Innings(team2, team1));
        currentInning = innings.get(1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTotalOvers() {
        return totalOvers;
    }

    public void setTotalOvers(int totalOvers) {
        this.totalOvers = totalOvers;
    }

    public Innings getCurrentInning() {
        return currentInning;
    }

    public void setCurrentInning(Innings currentInning) {
        this.currentInning = currentInning;
    }
}
