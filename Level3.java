import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends MyWorld
{

    public Level3() {      
        int[][] map = {
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,5,5,1,  1,1,1,1,0, 0,2,2,},
        {2,2,5,3,1,  3,1,3,1,3, 0,2,2,},
        {2,2,1,1,1,  1,1,1,1,1, 1,2,2,},
        
        {2,2,1,3,0,  3,1,3,1,3, 1,2,2,},
        {2,2,1,0,0,  1,6,1,1,1, 0,2,2,},
        {2,2,1,3,1,  3,1,3,1,3, 0,2,2,},
        {2,2,1,1,1,  0,0,1,1,1, 1,2,2,},
        {2,2,1,3,0,  3,1,3,1,3, 1,2,2,},
        
        {2,2,1,1,0,  1,1,1,1,1, 0,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,},
        {2,2,2,2,2,  2,2,2,2,2, 2,2,2,}
        };
        
        GreenfootImage BG_ASLI = new GreenfootImage("ML3.png");
        BG_ASLI.scale(MyWorld.SCREEN_SIZE, MyWorld.SCREEN_SIZE);
        this.setBackground(BG_ASLI);
        
        int jumlahZombie = 2;
        int jumlahObjective = 8;
        int x = 3;
        int y = 3;
        
        
        world_map = map;
        this.currentLevel = "Level3";
        this.initializeSpawnLocations();
        this.InitialSpawn(jumlahZombie, jumlahObjective);
        this.DrawWall();
    }
}
