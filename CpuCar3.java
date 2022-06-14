import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this is the first car that is spawned.
 * 
 * @author (Eli Abergel) 
 * @version (June 8 2022)
 */
public class CpuCar3 extends Actor
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
        //code that moves the car forward
        int x = getX() + -speed + -5;
        int y = getY();
        setLocation(x,y);
        World1 world = (World1) getWorld();
        if (crash == true)
        {
            //this is for getting rid of the car on screen when the player car crashes
            world.removeObject(this);    
        }
        if(getX() <= 0)
        {
            //plays sound affect of a car passing by, resets the location, re-randomizes the speed,
            //adds score and turbo to the world, and add turbo to the car
            driveby.play();
            setLocation(800,Greenfoot.getRandomNumber(200)+300);
            speed = Greenfoot.getRandomNumber(5);
            World1.addScore();
            UserCar.addTurboScore();
        }
    }
    public static void crashHappened()
    {
        //sets crash as happened so that the car is deleted
        crash = true;
    }
    public static void crashDidNotHappen()
    {
        //makes sure the car isnt deleted when the game is played again
        crash = false;
    }

}
