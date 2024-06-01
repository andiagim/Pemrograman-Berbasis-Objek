import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private int SS = MyWorld.SCREEN_SIZE;     
    private int WS = MyWorld.WALL_SIZE;
    private int CS = MyWorld.COIN_SIZE;
    public int finalScore;
    
    
    public GameOver(int finalScore)
    {    
        super(MyWorld.SCREEN_SIZE, MyWorld.SCREEN_SIZE, 1);
        this.finalScore = finalScore;
        addObject(new GameoverDeath(), SS/2, SS/2);
        updateScore();
    }
    
    public void updateScore(){
        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            myInfo.setScore(finalScore);
            myInfo.store();
        }
    }
}
