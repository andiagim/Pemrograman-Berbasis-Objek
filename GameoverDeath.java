import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameoverDeath extends Actor
{
    private static boolean soundPlayed = false;
    public int transparency = 0;

    public void act()
    {
        if(!soundPlayed) {
            GreenfootSound soundEffectDie = new GreenfootSound("Die.mp3");
            soundEffectDie.play();
            soundEffectDie.setVolume(60);
            soundPlayed = true;
        }
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new IntroGame());
        }
        
        GreenfootImage img = new GreenfootImage ("GO.png");
        setImage(img);
        setLocation(MyWorld.SCREEN_SIZE/2, MyWorld.SCREEN_SIZE/2);
    }
}