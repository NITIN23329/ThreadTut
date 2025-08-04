package lld.questions.cricbuzz;

import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private TeamController teamController;

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
        this.teamController = new TeamController(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public TeamController getTeamController() {
        return teamController;
    }

    public void setTeamController(TeamController teamController) {
        this.teamController = teamController;
    }
}
