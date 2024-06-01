import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door_closed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorOpen extends OverClass
{
    public void act()
    {
        GreenfootImage open = new GreenfootImage("door_open.png");
        open.scale(40, 40);
        setImage(open);
    }
}
