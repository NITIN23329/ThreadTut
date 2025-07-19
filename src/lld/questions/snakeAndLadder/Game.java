package lld.questions.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
     private Board board;
    private Dice dice;
    List<Player> players;

    public Game(int n ) {
        board = new Board(n);
        dice = new Dice();
        players = new ArrayList<>();

        // randomly generate snake and ladder
        Random random = new Random();
        for(int i=0;i<10;i++){
            int x = random.nextInt(1,n);
            int y = random.nextInt(1,n);
            int to = random.nextInt(1,n);
            board.addSnakeOrLadder(x, y, to);
        }

    }
    public void addPlayer(Player player) {
        players.add(player);
    }
    private Player makeMove() {
        for(Player player : players) {
            int newPosition = dice.roll() + player.getPosition();
            if(newPosition  > board.getN() * board.getN()){
                System.out.println("Player " + player.getName() + " skipping");
                continue;
            }
            Piece piece = board.getPiece(newPosition);
            if(piece instanceof SnakeOrLadderPiece) {
                newPosition = ((SnakeOrLadderPiece) piece).jump();
            }
            player.setPosition(newPosition);
            System.out.println("Player " + player.getName() + " moved to position " + newPosition);
            if(newPosition == board.getN() * board.getN()) {
                return player;
            }

        }
        return null;
    }
    public void play(){
        boolean gameOver = false;
        while (!gameOver) {
            Player player = makeMove();
            gameOver = player != null;
            if(gameOver) {
                System.out.println("Game Over," + player.getName()+" won!!");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game(8);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        game.play();
    }

}
