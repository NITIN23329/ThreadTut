package lld.questions.snakeAndLadder;

import java.util.List;

public class Board {
    private Piece[][] board;
    private int n;
    public Board(int n) {
        this.board = new Piece[n][n];
        this.n = n;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                board[i][j] = new Piece(getNumber(i,j));
            }
    }
    public void addSnakeOrLadder(int x, int y, int to){
        board[x][y] = new SnakeOrLadderPiece(getNumber(x,y), to);
    }

    public int getNumber(int x, int y){
        return x * n + y + 1;
    }
    public Piece getPiece(int number){
        int x = (number-1) / n;
        int y = (number-1 + n) % n;
        return board[x][y];
    }

    public int getN() {
        return n;
    }
}
