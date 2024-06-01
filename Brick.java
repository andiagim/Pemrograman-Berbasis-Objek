import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Brick extends OverClass
{
    public void act() 
    {
        GreenfootImage col = new GreenfootImage("brick.jpg");
        col.scale(40, 40);
        setImage(col);
    }
}