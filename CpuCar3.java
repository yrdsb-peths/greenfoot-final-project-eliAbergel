import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CpuCar3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CpuCar3 extends Actor
{
    /**
     * Act - do whatever the CpuCar3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 5;
    public static boolean crash = false;
    public void act()
    {
        int x = getX() + -speed + -5;
        int y = getY();
        setLocation(x,y);
        
        world1 world = (world1) getWorld();
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
