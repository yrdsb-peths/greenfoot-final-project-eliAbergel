import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this is the third car that is spawned at round 30.
 * 
 * @author (Eli Abergel) 
 * @version (June 8 2022)
 */
public class CpuCar extends Actor
{
    //this int is the base speed
    int speed = 5;
    //is a boolean that removes the car from the world when crashed
    public static boolean crash = false;
    //this sound affect that plays when the car is despawned to give the alusion that the car has
    //passed by the player
    GreenfootSound driveby = new GreenfootSound("driveby.mp3");
    public void act()
    {
        //code that moces car forward
        int x = getX() + -speed + -5;
        int y = getY();
        setLocation(x,y);
        World1 world = (World1) getWorld();
        if (crash == true)
        {
            //removes car from world when player car crashes
            world.removeObject(this);    
        }
        if(getX() <= 0)
        {
            //plays sound affect of a car passing by, resets the location, re-randomizes the speed,
            //adds score and turbo to the world, and add turbo to the car
            driveby.play();
            setLocation(800,Greenfoot.getRandomNumber(200)+300);
            speed = Greenfoot.getRandomNumber(5);
            world.addScore();
            UserCar.addTurboScore();
        }
    }
    public static void crashHappened()
    {
        //sets crash to true when the player car crashes, this is used to delete car when crash
        //happened
        crash = true;
    }
    public static void crashDidNotHappen()
    {
        //resets boolean when game restarts after repeat plays
        crash = false;
    }
}
