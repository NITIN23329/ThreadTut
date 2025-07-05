package lld.questions.ticTakToe;

public class Player {
    private String name;
    private Piece piece;

    public Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", piece=" + piece +
                '}';
    }
}
