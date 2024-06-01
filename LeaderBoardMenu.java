import greenfoot.*; 
import java.util.*;
/**
 * Write a description of class LeaderBoardMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderBoardMenu extends World
{
    private int SS = MyWorld.SCREEN_SIZE;     
    private int WS = MyWorld.WALL_SIZE;
    private int CS = MyWorld.COIN_SIZE;
    private String isi = "Press ENTER to continue...";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;
    
    public LeaderBoardMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(518, 518, 1);
        //currentUserInfo();
        leaderboard();
        GreenfootImage introgameImage = new GreenfootImage("LeaderBoard.png"); 
        setBackground(introgameImage); 
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MenuUtama());
        }
        if (!textDisplayed)
        {
            if (timer % delay == 0 && currentIndex <= isi.length())
            {
                displayTextEffect();
            }
            if (currentIndex > isi.length())
            {
                textDisplayed = true;
                enterVisible = true;
            }
        }
        timer++;
    }
    
    //public void currentUserInfo(){
       // if (UserInfo.isStorageAvailable()) {
            // UserInfo myInfo = UserInfo.getMyInfo();
             //String Username = myInfo.getUserName();
             //Integer TotalScore = myInfo.getScore();
             
            // addObject(new Information(Username), SS/2, 1*WS + CS);
             //addObject(new Information(TotalScore.toString()), SS/2, 2*WS + CS);
         //}
   // }
    
    public void leaderboard(){
        List<UserInfo> topGlobal = UserInfo.getTop(5);
        for (int i = 0; i < topGlobal.size(); i++){
             UserInfo currentPlayer = topGlobal.get(i);
             String Username = currentPlayer.getUserName();
             Integer TotalScore = currentPlayer.getScore();
       
             addObject(new Information(Username),    SS/2, (1+1+(2*i))*WS + (i+1)*CS);
             addObject(new Information(TotalScore.toString()), SS/2, (2+1+(2*i))*WS + (i+1)*CS);
        }
    }
    
    private void displayTextEffect()
    {
        GreenfootImage background = getBackground();
        background.setColor(Color.WHITE);
        background.setFont(new Font("Calibri", 15));  
        int x = 178;  
        int y = 455;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}
