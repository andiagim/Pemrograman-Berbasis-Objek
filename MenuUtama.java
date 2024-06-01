import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuUtama extends World
{
    private BacksoundMenu backSoundMenu;
    private boolean isStarted = false;
    private String isi = "Press SPACE to start...";              
    private int currentIndex = 0; 
    private boolean textDisplayed = false;
    private boolean enterVisible = false;
    private int enterBlinkCount = 0;
    private int enterBlinkInterval = 1;
    private int timer = 0;
    private int delay = 1;

    public MenuUtama() {
        super(518, 518, 1);
        backSoundMenu = new BacksoundMenu();
        addObject(backSoundMenu, 0, 0);
        TombolBantuan bantuan = new TombolBantuan();
        addObject(bantuan,55,460);
        TombolBoard board = new TombolBoard();
        addObject(board,460,460);
        GreenfootImage introgameImage = new GreenfootImage("HP.png"); 
        setBackground(introgameImage); 
    }
    
    public void started() {
        backSoundMenu.started();
    }

    public void stopped() {
        backSoundMenu.stopped();
    }

    public void act() {
        super.act();
        if (!isStarted) {
            started();
            isStarted = true;
        }
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Story());
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
        background.setFont(new Font("Calibri", 18));  
        int x = 170;  
        int y = 490;  
        background.drawString(isi.substring(0, currentIndex), x, y);
        currentIndex++;
    }
}