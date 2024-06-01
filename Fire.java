import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fire extends OverClass
{
    GifImage gifImage = new GifImage("fire.gif");
    int zaehler;
   
    public void act() 
    {   
        setImage(gifImage.getCurrentImage());  
        zaehler++;
        if(zaehler == 50)
        {   
            getWorld().removeObject(this);
        }
    }    
}