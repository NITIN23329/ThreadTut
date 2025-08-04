package lld.questions.cricbuzz;

public class PlayerScoreCard implements Subscriber{
    private int totalRuns;
    private int totalBallsPlayed;
    private int totalOversBowled;
    private int totalBoundaryCount;
    private int totalWickets;
    private boolean out;
    private Player player;


    public PlayerScoreCard(Player player) {
        this.totalRuns = 0;
        this.totalBallsPlayed = 0;
        this.totalOversBowled = 0;
        this.totalWickets = 0;
        this.out = false;
        this.player = player;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public void setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
    }

    public int getTotalOversBowled() {
        return totalOversBowled;
    }

    public void setTotalOversBowled(int totalOversBowled) {
        this.totalOversBowled = totalOversBowled;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean out) {
        this.out = out;
    }

    @Override
    public void handleOut() {
        out = true;
        totalRuns++;
        System.out.println("out: " + player.getName());
    }

    @Override
    public void handleBoundary() {
        totalOversBowled++;
        System.out.println("boundary: " + player.getName());
    }

    @Override
    public void handleNoBall( ){
        System.out.println("noball: " + player.getName());
    }
}
