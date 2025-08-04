package lld.questions.cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private Team battingTeam;
    private Team bowlingTeam;
    private List<Over> overs;

    public Innings(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.overs = new ArrayList<>();
    }

    public Team getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(Team battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Team getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(Team bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public void addOver(Over over) {
        this.overs.add(over);
    }

    public List<Over> getOvers() {
        return overs;
    }

    public void setOvers(List<Over> overs) {
        this.overs = overs;
    }
}
