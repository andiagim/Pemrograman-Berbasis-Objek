import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Box extends OverClass
{
    int zaehler;
    
    public void act() 
    {
        int x = getX();
        int y = getY();

        GreenfootImage box = new GreenfootImage("BoxOG.jpg");
        box.scale(40, 40);
        setImage(box);
        
        if(isTouching(Fire.class))
        {   
            getWorld().removeObject(this);
        }
    }
}
