import greenfoot.*;  

public class GameOverFade extends Actor
{
    public int transparency = 0;
    GreenfootImage img = new GreenfootImage(MyWorld.SCREEN_SIZE, MyWorld.SCREEN_SIZE);
    int i = 0;
    public MyWorld world;
    public String currentWorldName; 
    public GameOverFade() {
        img.setColor(Color.BLACK);    
        img.fill();
        img.setTransparency(0);
        setImage(img);
    }
    
    protected void addedToWorld(World current){
        world = (MyWorld)current;
        currentWorldName = world.currentLevel;
    }
    
    public void act() {
        if(i <= 255) {
            img.setTransparency(i);
            i+=5;
        }
        if (i == 255) {
            i++;
            MyWorld world = (MyWorld) getWorld();
            if (Players.alive==false){
            Greenfoot.setWorld(new GameOver(world.timer));
            }
            if (currentWorldName == "Level3"){
            Greenfoot.setWorld(new VictoryScreen(world.timer));
            }
        }
    }
    
}
