package lld.questions.cricbuzz;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Nitin", PlayerType.BATTER);
        Player p2 = new Player("Ritik", PlayerType.BOWLER);
        Player p3 = new Player("Opponent1", PlayerType.BATTER);
        Player p4 = new Player("Opponent2", PlayerType.BOWLER);
        Team team1 = new Team("Team 1", List.of(p1, p2));
        Team team2 = new Team("Team 2", List.of(p3, p4));


        TeamController team1Controller = new TeamController(team1);
        TeamController team2Controller = new TeamController(team2);

        System.out.println(team1Controller.getCurrentBatsman());



        Match t20 = new Match("Match 1", team1, team2, 20);

        t20.startMatch();


        t20.getCurrentInning().addOver(new Over(team1Controller));
        t20.getCurrentInning().getOvers().get(0). bowlBall(new Ball(BallType.NO_BALL, 4,false));




    }
}
