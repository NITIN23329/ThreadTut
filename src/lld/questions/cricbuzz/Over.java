package lld.questions.cricbuzz;

import java.util.ArrayList;
import java.util.List;

public class Over implements Publisher{
    private List<Ball> balls;
    private List<Subscriber> subscribers;
    private TeamController teamController;


    public Over(TeamController teamController) {
        this.balls = new ArrayList<>();
        this.teamController = teamController;
    }
    public void bowlBall(Ball ball){
        if (ball.getBallType() == BallType.NO_BALL ){
           notifyNoBall(teamController.getCurrentBatsman());
        }
        if (ball.isWicket()){
            notifyOut(teamController.getCurrentBatsman());
        }
        if (ball.getRuns() >=4){
            notifyBoundary(teamController.getCurrentBatsman());
        }

        balls.add(ball);
    }

    @Override
    public void notifyOut(Player player) {
        player.getPlayerScoreCard().handleOut();
    }

    @Override
    public void notifyBoundary(Player player) {
        player.getPlayerScoreCard().handleBoundary();
    }

    @Override
    public void notifyNoBall(Player player) {
        player.getPlayerScoreCard().handleNoBall();

    }
}
