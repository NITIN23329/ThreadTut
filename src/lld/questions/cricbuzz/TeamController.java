package lld.questions.cricbuzz;

public class TeamController {
    private Team team;
    public TeamController(Team team) {
        this.team = team;
    }

    public Player getCurrentBatsman(){
        for (Player player : team.getPlayers()) {
            if (player.getPlayerType() ==  PlayerType.BATTER && !player.getPlayerScoreCard().isOut()){
                return player;
            }
        }
        return team.getPlayers().get(0);
    }
    private Player getCurrentBowler(){
        for (Player player : team.getPlayers()) {
            if (player.getPlayerType() ==  PlayerType.BOWLER && player.getPlayerScoreCard().getTotalOversBowled() < 5){
                return player;
            }
        }
        return team.getPlayers().get(0);
    }

}
