import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UserCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserCar extends Actor
{
    /**
     * Act - do whatever the UserCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x = 0;
    public static int turboScore = 0;
    int blocker = 50;
    public void act()
    {
        if (blocker >= 200)
        {
            setLocation(getX(), getY()+3);
            blocker = blocker - 3;
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-3);
            x = getX();
            blocker = blocker + 3;
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+3);
            x = getX();
            blocker = blocker - 3;
        }
        if(getX() == 0)
        {
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
            CpuCar3.crashDidNotHappen();
            CpuCar2.crashDidNotHappen();
            CpuCar.crashDidNotHappen();
        }
        turbo();
        hit();
    }
    public void turbo()
    {
        if ((turboScore - 9) > 0 && Greenfoot.isKeyDown("right"))
        {
            move(50);
            turboScore = turboScore - 10;
            
            World1.minusTurbo();
        }
    }
    public void hit()
    {
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
        turboScore = turboScore + 1;
    }
}
