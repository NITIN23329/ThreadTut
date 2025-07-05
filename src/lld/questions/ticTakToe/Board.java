package lld.questions.ticTakToe;

public class Board {

    Piece[][] board;

    public Board(int n) {
        board= new Piece[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = new Piece(PieceType.DEFAULT);
    }

    public boolean placePiece(int row, int col, Piece piece) {
        if(board[row][col].getSymbol() != PieceType.DEFAULT.getSymbol()){
            System.out.println("Piece is already present at row: "+ row +", col: "+col);
            return false;
        }
        board[row][col] = piece;
        return true;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public int getSize(){
        return board.length;
    }
    public void printBoard(){
        for(Piece[] row : board){
            for(Piece col : row){
                System.out.print(col.getSymbol()+" ");
            }
            System.out.println();
        }
    }

}
