package lld.questions.ticTakToe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;
    private Board board;

    private Scanner sc = new Scanner(System.in);

    public Game() {
        players = new ArrayList<>();

        Player p1 = new Player("player1", new CrossPiece());
        Player p2 = new Player("player2", new CirclePiece());

        players.add(p1);
        players.add(p2);

        board = new Board(3);
    }

    public void start() {
        boolean gameOver = false;
        int count = 0;
        while (!gameOver) {
            for(int i=0;i<players.size();i++) {
                board.printBoard();
                if(count == board.getSize() * board.getSize()){
                    System.out.println("Tie");
                    return;
                }
                Player p = players.get(i);
                System.out.println("Turn: "+p);
                boolean ok = false;
                int row = -1, col = -1;
                while(!ok){
                    System.out.println("Enter row and col: ");
                     row = sc.nextInt();
                     col = sc.nextInt();

                    ok = board.placePiece(row,col,p.getPiece());
                }

                if(isWin(row, col)){
                    System.out.println("Player: " + p.getName()+" won");
                    board.printBoard();
                    gameOver = true;
                    break;
                }
                count++;

            }

        }

    }
    private boolean isWin(int row, int col) {
        Piece p = board.getPiece(row,col);
        boolean winRow = true;
        for(int i=0;i<board.getSize();i++){
            if(!board.getPiece(row, i).equals(p)) winRow = false;
        }
        boolean winCol = true;
        for(int i=0;i<board.getSize();i++){
            if(!board.getPiece(i, col).equals(p)) winCol = false;
        }
        boolean winLeftDiag = true;
        for(int i=0;i<board.getSize();i++){
            if(!board.getPiece(i, i).equals(p)) winLeftDiag = false;
        }
        boolean winRightDiag = true;
        for(int i=0;i<board.getSize();i++){
            if(!board.getPiece(i, board.getSize() - i - 1).equals(p)) winRightDiag = false;
        }
        return winRow || winCol || winLeftDiag || winRightDiag;

    }


}
