import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story3 extends World
{
private String isi = "What's that? a cave\n"+ 
                    "(press 3)...";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;
    
    public Story3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(518,518, 1); 
    }
    public void act()
    {   
        if (Greenfoot.isKeyDown("3")) {
            Greenfoot.setWorld(new Story4());
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
    
    private void displayTextEffect()
    {
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.setFont(new Font("Calibri", 25));  
        int x = 260;  
        int y = 170;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}
