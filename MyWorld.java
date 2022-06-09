import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 700, 1, false);
        UserCar userCar = new UserCar();
        addObject(userCar, 250, 600);
        spawnCar();
        
    }
    public void spawnCar()
    {
        CpuCar3 redCar = new CpuCar3();
        int x = Greenfoot.getRandomNumber(500);
        int y = 0;
        addObject(redCar,x,y);
    }
}
