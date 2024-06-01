import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TombolBantuan extends Actor
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
            Greenfoot.setWorld(new MenuBantuan());
        }
    }
}