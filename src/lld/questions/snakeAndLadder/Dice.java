package lld.questions.snakeAndLadder;

import java.util.Random;

public class Dice {
    int upto ;
    public Dice() {
        upto = 6;
    }
    public int roll(){
        Random rand = new Random();
        return 1 + rand.nextInt(upto);
    }
}
