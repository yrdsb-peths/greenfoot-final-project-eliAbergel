import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this is a striped down and modified verson of the first cpu car used for the tutorial(dosent hurt
 * the player, much slower to player can read text and it dosent spawn after hitting the edge of the 
 * screen).
 * 
 * @author (Eli Abergel) 
 * @version (June 11 2022)
 */
public class TutorialCar extends Actor
{
    public void act()
    {
        //used to automaticly move the car toward the player car
        int x = getX() + -3;
        int y = getY();
        setLocation(x,y);
        Tutorial world = (Tutorial) getWorld();
        if(getX() <= 0)
        {
            //used for going to the next step when the car is off screen
            Tutorial.carDone = 1;
        }
    }
}
