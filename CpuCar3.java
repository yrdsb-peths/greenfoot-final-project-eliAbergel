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
    int speed = 10;
    public void act()
    {
        int x = getX();
        int y = getY() + speed + 10;
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            setLocation(Greenfoot.getRandomNumber(500),1);
            speed = Greenfoot.getRandomNumber(20);
        }
    }
}
