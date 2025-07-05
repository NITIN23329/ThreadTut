package lld.questions.ticTakToe;

enum PieceType {
    CROSS('X'), CIRCLE('O'), DEFAULT('.');
    private char symbol;

    PieceType(char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol(){
        return symbol;
    }

}

public class Piece {
    PieceType type;

    public Piece(PieceType type) {
        this.type = type;
    }

    public char getSymbol() {
        return type.getSymbol();
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                '}';
    }
}
