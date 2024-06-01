import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TombolBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TombolBoard extends Actor
{
    public void act()
    {
        if (Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),(int)Math.round(getImage().getHeight()*0.9));
            
            BacksoundMenu backsoundMenu = (BacksoundMenu)getWorld().getObjects(BacksoundMenu.class).get(0);
            if (backsoundMenu != null) {
                backsoundMenu.stopped();
            }
            
            Greenfoot.delay(5);
            Greenfoot.setWorld(new LeaderBoardMenu());

        }
    }
}
