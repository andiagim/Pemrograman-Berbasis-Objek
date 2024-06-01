import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends OverClass
{
    public MyWorld world;
    public String currentWorldName;
    
    public void act (){
        image1();
        if (Players.winCounter >= 4){        
        image2();
        handleTouchPortal();
        }
    }
    
    public void image1 (){
        GreenfootImage close = new GreenfootImage("door_closed.png");
        close.scale(40, 40);
        setImage(close);
    }
    
    public void image2(){
        GreenfootImage close = new GreenfootImage("door_open.png");
        close.scale(40, 40);
        setImage(close);

    }
    
    protected void addedToWorld(World current){
        world = (MyWorld)current;
        currentWorldName = world.currentLevel;
    }
    
    private void handleTouchPortal() {
        if(!isTouching(Players.class) || Players.winCounter < 4) {
           return; 
        }

        if(currentWorldName == "Level1") {
            Greenfoot.delay(5);
            Players.winCounter = 0;
            Greenfoot.setWorld(new IntroGame2());
        } else if (currentWorldName == "Level2") {
            Greenfoot.delay(5);
            Players.winCounter = 0;
            Greenfoot.setWorld(new IntroGame3());
        } else if (currentWorldName == "Level3") {
            Players.winCounter = 0;
            world.callGameOver(); 
            return;
        }
        }
    
}
