import greenfoot.*;

public class BacksoundMenu extends Actor
{
    private GreenfootSound backsoundMenu;

    public BacksoundMenu() {
        backsoundMenu = new GreenfootSound("BacksoundMenu.mp3");
    }
    
    public void started() {
        backsoundMenu.playLoop();
    }

    public void stopped() {
        backsoundMenu.stop();
    }
}