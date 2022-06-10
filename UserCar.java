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
    int health = 1;
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
        if (health == 0)
        {
            
        }
        if(getX() <= 0)
        {
            
        }
        turbo();
        crash();
    }
    public void turbo()
    {
        if ((turboScore - 10) > 0 && Greenfoot.isKeyDown("right"))
        {
            move(50);
            turboScore = turboScore - 10;
            
            world1.minusTurbo();
        }
    }
    public void crash()
    {
        if(isTouching(CpuCar3.class))
        {
            move(-20);
            health--;
        }
    }
    public static void addTurboScore()
    {
        turboScore = turboScore + 1;
    }

}
