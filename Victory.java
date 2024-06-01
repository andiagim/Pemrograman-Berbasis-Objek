import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Victory extends Actor
{
    public void act()
    {
            GreenfootImage img = new GreenfootImage ("Victory.jpg");
            img.scale(MyWorld.SCREEN_SIZE, MyWorld.SCREEN_SIZE);
            setImage(img);
            setLocation(MyWorld.SCREEN_SIZE/2, MyWorld.SCREEN_SIZE/2);
            
            if(Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),(int)Math.round(getImage().getHeight()*0.9));
            Greenfoot.delay(5);
            Greenfoot.setWorld(new MenuUtama());
            }
    }
}