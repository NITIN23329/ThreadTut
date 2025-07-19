package lld.questions.snakeAndLadder;

public class Piece {
    private int number;

    public Piece(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}

class SnakeOrLadderPiece  extends Piece  implements Jumpable{
    private int destination;
    public SnakeOrLadderPiece(int number, int destination) {
        super(number);
        this.destination = destination;
    }

    @Override
    public int jump() {
        System.out.println("***********Jumping from " + super.getNumber() + " to " + destination+"***********");
        return destination;
    }
}