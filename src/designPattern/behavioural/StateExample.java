package designPattern.behavioural;
// state interface declares a common method implemented by all states in their own way
interface PlayerState{
    void pressPlay(MediaPlayer context);
}
// concrete states enforcing context to behave in a particular way
// here we are using concrete states to update the state of context
class PlayingState implements PlayerState{
    @Override
    public void pressPlay(MediaPlayer context){
        System.out.println("Pause the music");
        context.setState(new PausedState());
    }
}
class PausedState implements PlayerState{
    @Override
    public void pressPlay(MediaPlayer context){
        System.out.println("Playing the music");
        context.setState(new PlayingState());
    }
}
class StoppedState implements PlayerState{
    @Override
    public void pressPlay(MediaPlayer context){
        System.out.println("Starting the music");
        context.setState(new PlayingState());
    }
}

// context class having the state reference and delegating its work
class MediaPlayer {
    PlayerState state;
    public MediaPlayer(){
        state = new StoppedState(); // set the initial context
    }
    // method to set the context state
    public void setState(PlayerState state){
        this.state = state;
    }

    public void play(){
        state.pressPlay(this);
    }

}
public class StateExample {

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.play(); // stopped -> play
        mediaPlayer.play(); // play -> pause
        mediaPlayer.play(); // pause -> play
    }
}
