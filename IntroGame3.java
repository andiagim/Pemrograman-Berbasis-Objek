import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IntroGame3 extends World
{
    private String isi = "Press ENTER to continue...";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;
    public IntroGame3()
    {    
        super(518, 518, 1); 
        GreenfootImage introgame3Image = new GreenfootImage("8.png"); 
        setBackground(introgame3Image); 
    }
    public void act()
    {   
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level3());
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
        background.setFont(new Font("Calibri", 15));  
        int x = 178;  
        int y = 490;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}
