import greenfoot.*;  
import java.util.List;
import java.util.ArrayList;

public class MyWorld extends World
{
    public static final int SCREEN_SIZE = 520;
    public static final int WALL_SIZE = SCREEN_SIZE/13;
    public static final int WALL_TOTAL = SCREEN_SIZE/WALL_SIZE;
    public static final int COIN_SIZE = WALL_SIZE/2;
    
    public static int[][] world_map;
    public long startTime;
    public int timer;
    public static String currentLevel;
    
    public GreenfootImage BG_IMAGE;
    
    
    public MyWorld()
    {    
        super(SCREEN_SIZE, SCREEN_SIZE, 1);
        Greenfoot.setSpeed(50);
        startTime = System.currentTimeMillis();
    }
    
    public void act(){
        if (Players.alive == false){
        timer();
        callGameOver ();
        }
    }
    
    public void callGameOver() {
        addObject(new GameOverFade(), SCREEN_SIZE/2, SCREEN_SIZE/2);
    }

    public ArrayList<Point> spawnLocations = new ArrayList<>();

    public class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }   
    }
    
    public void initializeSpawnLocations() {
        for (int y = 0; y < WALL_TOTAL; y++) {
            for (int x = 0; x < WALL_TOTAL; x++) {
                if (world_map[y][x] == 0) {
                    spawnLocations.add(new Point(x, y));
                }
            }
        }
    }

    public void randSpawn(Actor object) {
        if (spawnLocations.isEmpty()) {
        return;
        }

        int index = Greenfoot.getRandomNumber(spawnLocations.size());
        Point spawnLocation = spawnLocations.remove(index);

        int x = spawnLocation.x * WALL_SIZE + COIN_SIZE;
        int y = spawnLocation.y * WALL_SIZE + COIN_SIZE;

        addObject(object, x, y);
    }
    
    
    public void InitialSpawn(int jumlahZombie, int jumlahObjective) {
        int x = 2;
        int y = 3;
        addObject (new Players(), x * WALL_SIZE + COIN_SIZE,x * WALL_SIZE + COIN_SIZE);
        for(int i = 0; i < jumlahZombie; i++){
            randSpawn(new Enemy());
        }
        
        for(int i = 0; i < jumlahObjective; i++){
            randSpawn(new Box_Relic1());
        }
    }
   
    public void DrawWall() {
        GreenfootImage img = getBackground();
        img.scale(SCREEN_SIZE, SCREEN_SIZE);
        
        for(int y = 0; y < WALL_TOTAL; y++){
            for(int x = 0; x < WALL_TOTAL; x++){
                if(world_map[y][x] == 1){  
                    addObject(new Box(), x* WALL_SIZE + COIN_SIZE, y* WALL_SIZE + COIN_SIZE);
                }else if(world_map[y][x] == 2){
                    addObject(new Border(), x* WALL_SIZE + COIN_SIZE, y* WALL_SIZE + COIN_SIZE);
                }else if(world_map[y][x] == 3){
                    addObject(new Brick(), x* WALL_SIZE + COIN_SIZE, y* WALL_SIZE + COIN_SIZE);
                }else if(world_map[y][x] == 6){
                    addObject(new Door(), x* WALL_SIZE + COIN_SIZE, y* WALL_SIZE + COIN_SIZE);
                }
            }
        }
    }
    
    public void timer (){
            long endTime = System.currentTimeMillis();
            int elapsedTime = (int) (endTime - startTime);
            timer = elapsedTime/1000;
    }
}
