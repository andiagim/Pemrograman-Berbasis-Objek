import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Story extends World
{
    private String isi = "After studying various magics,\n"+ 
                        " the Wizard felt interested in\n"+ 
                        "  exploring the world outside\n"+ 
                        "   ...............(press 1)..............";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;

    public Story()
    {    
        super(518, 518, 1);
        Skip skip = new Skip();
        addObject(skip,470,50);
    }
    public void act()
    {   
        if (Greenfoot.isKeyDown("1")) {
            Greenfoot.setWorld(new Story2());
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
