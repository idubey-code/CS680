package edu.umb.cs680.hw06;

public class DVDPlayer {

    private static DVDPlayer instance = null;
    private static State state;

    private DVDPlayer(State state) {
        this.state = state;
    }

    public static DVDPlayer getInstance(){
        if(instance==null){
            state = DrawerClosedNotPlaying.getInstance();
            instance = new DVDPlayer(state);
        }
        return instance;
    }

    public void changeState(State s){
        state = s;
    }

    public void openCloseButtonPushed(){
        state.openCloseButtonPushed();
    }

    public void playButtonPushed(){
        state.playButtonPushed();
    }

    public void stopButtonPushed(){
        state.stopButtonPushed();
    }

    public void open(){
        System.out.println("Opening Drawer...");
    }

    public void close(){
        System.out.println("Closing Drawer...");
    }

    public void play(){
        System.out.println("Playing Media...");
    }

    public void stop(){
        System.out.println("Stopping Media...");
    }

    public State getState() {
        return state;
    }

    public static void main(String[] args) {
        DVDPlayer player = DVDPlayer.getInstance();
        player.openCloseButtonPushed();
        player.playButtonPushed();
        player.stopButtonPushed();
    }

}
