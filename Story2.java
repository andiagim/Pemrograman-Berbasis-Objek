import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Story2 extends World
{
    private String isi = "The Wizard ventured into a dark\n"+
                        "        and mysterious forest\n"+
                        "         ..........(press 2)..........";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;
    
    public Story2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(518,518, 1); 
    }
    public void act()
    {   
        if (Greenfoot.isKeyDown("2")) {
            Greenfoot.setWorld(new Story3());
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
        int x = 110;  
        int y = 400;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}
