import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the main/endless world.
 * 
 * @author (Eli Abergel) 
 * @version (June 8 2022)
 */
public class World1 extends World
{
    //ints that are used for the labels
    public static int score = 0;
    public static int turboScore1 = 0;
    //the labels used for score and turbo
    static Label scoreLabel;
    static Label turboLabel;
    //these are the ints that only allow 1 car2 and 3 in a level at a time
    public int checkCar2 = 0;
    public int checkCar3 = 0;
    public World1()
    {    
        super(800, 500, 1, false);
        //spawns user car when game starts and adds it to the world
        UserCar userCar = new UserCar();
        addObject(userCar, 100, 450);
        //uses a method that spawns the first computer car and resets it when it gets to the edge of
        //the screen
        spawnCar();
        //creates and adds the labels to track score and turbo
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        turboLabel = new Label(0,50);
        addObject(turboLabel,200,50);
        //sets the starting turbo label to "go"
        turboLabel.setValue("GO!!!");   
    }
    public void act()
    {
        if(score == 15 && checkCar2 == 0)
        {
            //if the score is 15 and no other car2 is on screen it starts spawning car2s
            spawnCar2();
            checkCar2++;
        }
        if(score == 30 && checkCar3 == 0)
        {
            //if the score is 30 and no other car3 is on screen it starts spawning car3s
            spawnCar3();
            checkCar3++;
        }
    }
    public static void crashLabel()
    {
        //when the game ends it makes the turbo and score labels invisible
        turboLabel.setValue(""); 
        scoreLabel.setValue(""); 
    }
    public static void minusTurbo()
    {
        //when turbo is used by the car, it minuses 10 points from the on screen turbo score
        turboScore1 = turboScore1 - 10;
    }
    public void spawnCar()
    {
        //spawns the first car at a random location
        CpuCar3 redCar = new CpuCar3();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(redCar,x,y);
    }
    public void spawnCar2()
    {
        //spawns the second car at a random location
        CpuCar2 blackCar = new CpuCar2();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(blackCar,x,y);
    }
    public void spawnCar3()
    {
        ////spawns the third car at a random location
        CpuCar blueCar = new CpuCar();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(blueCar,x,y);
    }
    public static void addScore()
    {
        /**used when a car goes off screen, this method add points to turbo and score, and when turbo
         *is 10 or above this method chanches the turbo label to "ready" and sets the  score as
         * the score int
         */
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
