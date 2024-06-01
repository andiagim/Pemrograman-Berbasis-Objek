import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends OverClass
{
    protected enum Direct { TOP, BOTTOM, RIGHT, LEFT };
    private int x, y;
    private Direct nowDirect = null;
    private GreenfootImage img, img1, img2;
    private int rnd = Greenfoot.getRandomNumber(2);
    static boolean alive=true;
    private int counter=0;
    private int CS = MyWorld.COIN_SIZE;
    public MyWorld world;
    public String currentWorldName;
    
    GifImage gifImage1 = new GifImage("m1.gif");
    GifImage gifImage2 = new GifImage("m2.gif");
    GifImage gifImage3  = new GifImage("m3.gif");
    
    public void act()
    {   
        renderImage();
        if(counter==3)
        {
            move();
            counter=0;
        }
        counter++;
        if(objectAtSameLocation(Fire.class))
        {
            getWorld().removeObject(this);
        }

    }
    
    protected void addedToWorld(World current){
        world = (MyWorld)current;
        currentWorldName = world.currentLevel;
    }
    
    public void renderImage() {
        if(currentWorldName == "Level1") {
            setImage(gifImage1.getCurrentImage()); 
        } else if(currentWorldName == "Level2") {
            setImage(gifImage2.getCurrentImage()); 
        } else if(currentWorldName == "Level3") {
            setImage(gifImage3.getCurrentImage()); 
        }
    }
    
    public static Direct randomDirect()  {
        Direct[] directions = { Direct.BOTTOM, Direct.TOP, Direct.RIGHT, Direct.LEFT };
        return directions[Greenfoot.getRandomNumber(directions.length)];
    }
    
    private void move() {
        int xNew = getX();
        int yNew = getY();
        if (nowDirect == null) {
            nowDirect = randomDirect();
        }

        if (!canMove(nowDirect)) {
            nowDirect = randomDirect();
            return;
        }
        changeCoor(nowDirect);
        setLocation(xNew + x, yNew + y);
    }
    
    private boolean canMove(Direct nowDirect) {
        int xNew = getX();
        int yNew = getY();
    
        int xx = xNew;
        int yy = yNew;
        
        if (nowDirect == Direct.TOP) {
            yy -= CS;
        }
        if (nowDirect == Direct.BOTTOM) {
            yy += CS;
        }
        if (nowDirect == Direct.RIGHT) {
            xx += CS;
        }
        if (nowDirect == Direct.LEFT) {
            xx -= CS;
        }
        
        return noObjectInWay(xx, yy, Border.class) && 
               noObjectInWay(xx, yy, Box.class) &&
               noObjectInWay(xx, yy, Brick.class);
    }
    
    private void changeCoor(Direct direction) {
        x = 0;
        y = 0;
        if (canMove(direction)) {
            if (direction == Direct.TOP) {
                y = -1;
            }
            if (direction == Direct.BOTTOM) {
                y = 1;
            }
            if (direction == Direct.RIGHT) {
                x = 1;
            }
            if (direction == Direct.LEFT) {
                x = -1;
            }
        }
    }
}