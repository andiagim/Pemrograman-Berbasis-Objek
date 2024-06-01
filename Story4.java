import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story4 extends World
{
private String isi = "Without the wizard knowing, He entered a cave\n"+ 
                    "  filled with monsters and various obstacles.\n"+ 
                    "\n                      Can he make it out ?\n"+
                    "                       ........(press 4)........";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;
    
    public Story4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(518,518, 1); 
    }
    public void act()
    {   
        if (Greenfoot.isKeyDown("4")) {
            Greenfoot.setWorld(new IntroGame());
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
        background.setColor(Color.WHITE);
        background.setFont(new Font("Calibri", 25));  
        int x = 18;  
        int y = 250;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}
