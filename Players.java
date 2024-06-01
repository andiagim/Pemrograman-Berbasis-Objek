import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Players extends OverClass
{
    public static int bomb = 1;
    public static int bomba = 1;
    int x, y;
    public static int winCounter = 0;
    static boolean alive;
    boolean KI;
    boolean regulator;
    private GreenfootSound soundEffect;
    private final int SS = MyWorld.SCREEN_SIZE;
    private final int WS = MyWorld.WALL_SIZE;
    private final int WT = MyWorld.WALL_TOTAL;
    private final int CS = MyWorld.COIN_SIZE;
    
    GifImage gifImage = new GifImage("player.gif");
    
    public Players()
    {
        alive = true;
        KI = false;
        Bombs.firepower = 1;
        Players.bomb = 1;
        soundEffect = new GreenfootSound("Coin.mp3");
    }
    
    public void act() 
    {
        if (KI == false)
        {
            if (alive)
            {
                setImage(gifImage.getCurrentImage());  
                x = getX();
                y = getY();
        
                if(Greenfoot.isKeyDown("w"))
                {
                    y-=CS;
                    if(noObjectInWay(x, y, Border.class) && noObjectInWay(x, y, Box.class)&& noObjectInWay(x, y, Brick.class))
                    {
                        movement(1);
                    }
                }
                
                if(Greenfoot.isKeyDown("s"))
                {
                    y+=CS;
                    if(noObjectInWay(x, y, Border.class) && noObjectInWay(x, y, Box.class)&& noObjectInWay(x, y, Brick.class))
                    {
                        movement(2);
                    }
                }
                
                if(Greenfoot.isKeyDown("d"))
                {
                    x+=CS;
                    if(noObjectInWay(x, y, Border.class) && noObjectInWay(x, y, Box.class)&& noObjectInWay(x, y, Brick.class))
                    {
                        movement(3);
                    }
                }
                
                if(Greenfoot.isKeyDown("a"))
                {
                    x-=CS;
                    if(noObjectInWay(x, y, Border.class) && noObjectInWay(x, y, Box.class)&& noObjectInWay(x, y, Brick.class))
                    {
                        movement(4);
                    }
                }
                
                if(Greenfoot.isKeyDown("e"))
                {
                    movement(5);
                }
                
                if(isTouching(Enemy.class)) {
                    alive = false;
                }
                
                if(isTouching(Fire.class))
                {
                    alive = false;
                }
            
                if(objectAtSameLocation(Relik1.class))
                {
                    getWorld().removeObject(getOneObjectAtOffset(0, 0, Relik1.class));
                    winCounter++;
                    soundEffect.play();
                    soundEffect.setVolume(40);
                }
            }
        } //if(KI)
    } 
    
    protected void movement(int key)
    {
        switch(key)
        {
            case 1:
            moveUp();
            break;
        
            case 2:
            moveDown();
            break;
        
            case 3:
            moveRight();
            break;
        
            case 4:
            moveLeft();
            break;
            
            case 5:
            throwBomb();
            break;
    
        }
    }    

    public void throwBomb ()
    {
            if (bomb >= bomba)
            {   
                int X = getX();
                int Y = getY();
                getWorld().addObject(new Bombs(), X, Y);
                bomba++;                
            }
    }
    
    public void moveUp()
    {
        setLocation(getX(),getY()-1);
    }
    
    public void moveDown()
    {
        setLocation(getX(),getY()+1);
    }
    
    public void moveRight()
    {
        setLocation(getX()+1,getY());
    }
    
    public void moveLeft()
    {
        setLocation(getX()-1,getY());
    }
}
