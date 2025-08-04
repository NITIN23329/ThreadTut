package lld.questions.cricbuzz;

enum BallType {
    NO_BALL, WIDE_BALL, NORMAL_BALL;
}
public class Ball {
    private BallType ballType;
    private int runs;
    private boolean isWicket;

    public Ball(BallType ballType, int runs, boolean isWicket) {
        this.ballType = ballType;
        this.runs = runs;
        this.isWicket = isWicket;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public boolean isWicket() {
        return isWicket;
    }

    public void setWicket(boolean wicket) {
        isWicket = wicket;
    }
}
