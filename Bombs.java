import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bombs extends OverClass
{
    
    boolean wallLeaverRight = false; // to control the wall leave out (right)
    boolean wallLeaverLeft = false; // to control the wall leave out (left)
    boolean wallLeaverDown = false; // to control the wall leave out (down)
    boolean wallLeaverUp = false; // to control the wall leave out (up)
    int runden = 0;
    static int firepower = 1;
    private GreenfootSound soundEffect;
    
    private final int SS = MyWorld.SCREEN_SIZE;
    private final int WS = MyWorld.WALL_SIZE;
    private final int WT = MyWorld.WALL_TOTAL;
    private final int CS = MyWorld.COIN_SIZE;
    GifImage gifImage = new GifImage("bomb.gif");
 
    public Bombs() {
        // Inisialisasi objek suara dengan file suara yang sesuai
        soundEffect = new GreenfootSound("Fire.mp3");
    }
    
    
    public void act() 
    {
        setImage(gifImage.getCurrentImage());  
        if (runden == 130)
        {
            soundEffect.play();
            soundEffect.setVolume(40);
            explode(Bombs.class,firepower);
            getWorld().removeObject(this);
            Players.bomba--;
            runden = 0;
        }
        runden++;
    }    
    
    public void explode(Class bomb, int firePower)
    {
        for(int i = 0; i <= firePower; i++)
        {
            int X = getX();
            int Y = getY();
            int nextX, nextY;
    
            nextX = X + (i * WS);
            nextY = Y;
            if (noObjectInWay(nextX, nextY, Border.class) && noObjectInWay(nextX, nextY, Brick.class) && wallLeaverRight == false)
            {
                getWorld().addObject(new Fire(), nextX, nextY);
            }
            if (!noObjectInWay(nextX, nextY, Border.class))
            {
                wallLeaverRight = true;
            }
    
            nextX = X - (i * WS);
            nextY = Y;
            if (noObjectInWay(nextX, nextY, Border.class) && noObjectInWay(nextX, nextY, Brick.class) && wallLeaverLeft == false)
            {
                getWorld().addObject(new Fire(), nextX, nextY);
            }
            if (!noObjectInWay(nextX, nextY, Border.class))
            {
                wallLeaverLeft = true;
            }
    
            nextX = X;
            nextY = Y + (i * WS);
            if (noObjectInWay(nextX, nextY, Border.class) && noObjectInWay(nextX, nextY, Brick.class) && wallLeaverDown == false)
            {
                getWorld().addObject(new Fire(), nextX, nextY);
            }
            if (!noObjectInWay(nextX, nextY, Border.class))
            {
                wallLeaverDown = true;
            }
    
            nextX = X;
            nextY = Y - (i * WS);
            if (noObjectInWay(nextX, nextY, Border.class) && noObjectInWay(nextX, nextY, Brick.class) && wallLeaverUp == false)
            {
                getWorld().addObject(new Fire(), nextX, nextY);
            }
            if (!noObjectInWay(nextX, nextY, Border.class))
            {
                wallLeaverUp = true;
            }
        }
    
        wallLeaverRight = false;
        wallLeaverLeft = false;
        wallLeaverDown = false;
        wallLeaverUp = false;
    }
}