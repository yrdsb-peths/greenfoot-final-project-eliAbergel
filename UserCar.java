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
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
    }
    
    public void crash()
    {
        if(isTouching(CpuCar.class))
        {
             
        }
    }
}
