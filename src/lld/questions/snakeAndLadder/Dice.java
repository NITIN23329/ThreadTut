package lld.questions.snakeAndLadder;

import java.util.Random;

public class Dice {
    private static int upto ;
    private Dice(){}
    public static int roll(){
        Random rand = new Random();
        return 1 + rand.nextInt(upto);
    }
}
