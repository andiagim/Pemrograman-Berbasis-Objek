import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Box_Relic1 extends Box
{    
    public void act() 
    {
        int x = getX();
        int y = getY();
        
        GreenfootImage box = new GreenfootImage("BoxOG.jpg");
        box.scale(40, 40);
        setImage(box);
        
        if(objectAtSameLocation(Fire.class))
        {   
            getWorld().addObject (new Relik1(), x, y);    
            getWorld().removeObject(this);  
        }
    }
}