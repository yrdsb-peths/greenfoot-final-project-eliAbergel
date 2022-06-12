import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TutorialCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialCar extends Actor
{
    int speed = 5;
    public static boolean crash = false;
    public void act()
    {
        int x = getX() + -speed + -5;
        int y = getY();
        setLocation(x,y);
        
        Tutorial world = (Tutorial) getWorld();
        if (crash == true)
        {
            world.removeObject(this);    
        }
        if(getX() <= 0)
        {
            setLocation(800,Greenfoot.getRandomNumber(200)+300);
            speed = Greenfoot.getRandomNumber(5);
            world.addScore();
            UserCar.addTurboScore();
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
