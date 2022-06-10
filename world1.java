import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class world1 extends World
{
    public int score = 0;
    public static int turboScore1 = 0;
    public String ready = "Ready!";
    public String notReady = "Not Ready";
    Label scoreLabel;
    Label turboLabel;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public world1()
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
    public void addScore()
    {
        score++;
        turboScore1++;
        scoreLabel.setValue(score);
        if (turboScore1 >= 10)
        {
            turboLabel.setValue(ready);
        }
        else
        {
            turboLabel.setValue(notReady);
        }
 
    }
}
