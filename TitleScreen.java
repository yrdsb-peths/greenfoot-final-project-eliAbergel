import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel;
    Label instruction1Label;
    Label instruction2Label;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public TitleScreen()
    {   
        super(800, 500, 1); 
        titleLabel = new Label("Sunset Turbo",100);
        addObject(titleLabel,400,250);
        instruction1Label = new Label("Press T for tutorial",30);
        addObject(instruction1Label,550,400);
        instruction2Label = new Label("Press SPACE   to start game",30);
        addObject(instruction2Label,600,450);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            World1 world = new World1();
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.isKeyDown("t"))
        {
            Tutorial tutorial = new Tutorial();
            Greenfoot.setWorld(tutorial);            
        }
    }
}
