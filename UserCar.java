import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The player's car.
 * 
 * @author (Eli Abergel) 
 * @version (June 8 2022)
 */
public class UserCar extends Actor
{
    /**
     * Act - do whatever the UserCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //a int for the x value of the car, used for moving up and down becuase
    //there isnt a move(x); for the y axis
    int x = 0;
    //used to keep score of how much turbo the car has
    public static int turboScore = 0;
    //crashing sound affect
    GreenfootSound crashSound = new GreenfootSound("crashsound1.mp3");
    //this is the int for checking if he car went off the road
    int blocker = 50;
    //the revving sound for turboing
    GreenfootSound revvingSound = new GreenfootSound("revving.mp3");
    public void act()
    {
        if (blocker >= 200)
        {
            //this makes sure the car dosent go off the background road
            setLocation(getX(), getY()+3);
            blocker = blocker - 3;
        }
        if(Greenfoot.isKeyDown("up"))
        {
            //moves the car up and adds to the blocker int so the car dosent 
            //go off the road 
            setLocation(getX(), getY()-3);
            x = getX();
            blocker = blocker + 3;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            //moves the car down and blocks takes away from the blocker int 
            //so the car isnt stuck only going down
            setLocation(getX(), getY()+3);
            x = getX();
            blocker = blocker - 3;
        }
        if(getX() == 0)
        {
            /**this is the code for when the car crashs, it sets the location
             * off screen and and removes all the cars by activating "crash
             * happened. Removes all labels with "crash label". Crates and 
             * transports player to the game over world. resets turbo score,
             * the on screen turbo score and score, which are both in the
             * main game world
             */
            crashSound.play();
            setLocation(1000, 1000);
            CpuCar3.crashHappened();
            CpuCar2.crashHappened();
            CpuCar.crashHappened();
            World1.crashLabel();
            GameOver gameOver = new GameOver();
            Greenfoot.setWorld(gameOver);
            turboScore = 0;
            World1.turboScore1 = 0;
            World1.score = 0;
        }
        else
        {
            //resets and makes sure that that cars spawn(glitchs happen on
            //repeat plays if this is not here)
            CpuCar3.crashDidNotHappen();
            CpuCar2.crashDidNotHappen();
            CpuCar.crashDidNotHappen();
        }
        //turbo and getting hit methods
        turbo();
        hit();
    }
    public void turbo()
    {
        //this is the turbo method which moves the car forward if they have
        //enough points
        if ((turboScore - 9) > 0 && Greenfoot.isKeyDown("right"))
        {
            /**moves car 50 forward, takes the points needed for turbo use,
             *plays sound affects, and takes 10 points from the worlds turbo
             *counter
             */
            move(50);
            turboScore = turboScore - 10;
            revvingSound.play();
            World1.minusTurbo();
        }
    }
    public void hit()
    {
        //moves player car back 10 while cpu cars are touching
        if(isTouching(CpuCar3.class))
        {
            move(-10);
        }
        if(isTouching(CpuCar2.class))
        {
            move(-10);
        }
        if(isTouching(CpuCar.class))
        {
            move(-10);
        }
    }
    public static void addTurboScore()
    {
        //used by cpu cars when they pass the screen, used for adding to the
        //turbo score
        turboScore = turboScore + 1;
    }
}
