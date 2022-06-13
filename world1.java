import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{
    public static int score = 0;
    public static int turboScore1 = 0;
    public String ready = "Ready!";
    public String notReady = "Not Ready";
    static Label scoreLabel;
    static Label turboLabel;
    public int checkCar2 = 0;
    public int checkCar3 = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public World1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1, false);
        UserCar userCar = new UserCar();
        addObject(userCar, 100, 450);
        spawnCar();
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        turboLabel = new Label(0,50);
        addObject(turboLabel,200,50);
        turboLabel.setValue("GO!!!");   
        
    }
    public void act()
    {
        if(score == 15 && checkCar2 == 0)
        {
            spawnCar2();
            checkCar2++;
        }
        if(score == 30 && checkCar3 == 0)
        {
            spawnCar3();
            checkCar3++;
        }
    }
    public static void crashLabel()
    {
        turboLabel.setValue(""); 
        scoreLabel.setValue(""); 
    }
    public static void minusTurbo()
    {
        turboScore1 = turboScore1 - 10;
    }
    public void spawnCar()
    {
        CpuCar3 redCar = new CpuCar3();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(redCar,x,y);
        
    }
    public void spawnCar2()
    {
        CpuCar2 blackCar = new CpuCar2();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(blackCar,x,y);
    }
    public void spawnCar3()
    {
        CpuCar blueCar = new CpuCar();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(blueCar,x,y);
    }
    public static void addScore()
    {
        score++;
        turboScore1++;
        scoreLabel.setValue(score);
        if (turboScore1 >= 10)
        {
            turboLabel.setValue("Ready!");
        }
        else
        {
            turboLabel.setValue("Not Ready");
        }
 
    }
}
