import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialCar extends Actor
{
    public static boolean crash = false;
    public void act()
    {
        int x = getX() + -3;
        int y = getY();
        setLocation(x,y);
        
        Tutorial world = (Tutorial) getWorld();
        if (crash == true)
        {
            world.removeObject(this);    
        }
        if(getX() <= 0)
        {
            Tutorial.carDone = 1;
        }
    }
    public static void crashHappened()
    {
        crash = true;
    }
    public static void crashDidNotHappen()
    {
        crash = false;
    }
}
