import greenfoot.*;

public class BacksoundGame extends Actor
{
    private GreenfootSound backsoundGame;

    public BacksoundGame() {
        backsoundGame = new GreenfootSound("BacksoundGame.mp3");
    }
    
    public void started() {
        backsoundGame.playLoop();
        backsoundGame.setVolume(25);
    }

    public void stopped() {
        backsoundGame.stop();
    }
}