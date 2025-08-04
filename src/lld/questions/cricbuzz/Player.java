package lld.questions.cricbuzz;

enum PlayerType {
    BATTER, BOWLER, WICKET_KEEPER;
}
public class Player {
    private String name;
    private PlayerType playerType;
    private PlayerScoreCard playerScoreCard;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
        playerScoreCard = new PlayerScoreCard(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public PlayerScoreCard getPlayerScoreCard() {
        return playerScoreCard;
    }

    public void setPlayerScoreCard(PlayerScoreCard playerScoreCard) {
        this.playerScoreCard = playerScoreCard;
    }
}
