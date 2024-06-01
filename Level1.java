import greenfoot.*;  

public class Level1 extends MyWorld
{   
    public Level1() {      
        int[][] map = {
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,5,5,1,  0,0,1,1,0, 0,2,2,},
        {2,2,5,3,1,  3,0,3,1,3, 0,2,2,},
        {2,2,1,1,0,  0,0,1,1,1, 1,2,2,},
        
        {2,2,1,3,0,  3,1,3,1,3, 1,2,2,},
        {2,2,1,0,0,  1,1,6,1,1, 0,2,2,},
        {2,2,1,3,1,  3,1,3,1,3, 0,2,2,},
        {2,2,1,1,1,  0,0,1,1,1, 1,2,2,},
        {2,2,1,3,0,  3,1,3,1,3, 1,2,2,},
        
        {2,2,1,1,0,  1,1,1,1,1, 0,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,}
        };
        
        GreenfootImage BG_ASLI = new GreenfootImage("Map1.png");
        BG_ASLI.scale(MyWorld.SCREEN_SIZE, MyWorld.SCREEN_SIZE);
        this.setBackground(BG_ASLI);
        
        int jumlahZombie = 2;
        int jumlahObjective = 10;
        int x = 3;
        int y = 3;
        
        
        world_map = map;
        this.currentLevel = "Level1";
        this.initializeSpawnLocations();
        this.InitialSpawn(jumlahZombie, jumlahObjective);
        this.DrawWall();
    }
}
