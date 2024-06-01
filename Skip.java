import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skip extends Actor
{
    public void act()
    {
        if (Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),(int)Math.round(getImage().getHeight()*0.9));
            
            Greenfoot.delay(5);
            Greenfoot.setWorld(new IntroGame());

        }
    }
}
