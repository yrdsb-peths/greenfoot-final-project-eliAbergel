import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this is a title screen, it has accses to the tutorial and main/endless game.
 * 
 * @author (Eli Abergel) 
 * @version (June 11 2022)
 */
public class TitleScreen extends World
{
    //the labels for the title and for what button to press
    Label titleLabel;
    Label instruction1Label;
    Label instruction2Label;
    //declares the car starting up sound affects when the player presses a button to start a mode
    GreenfootSound startup = new GreenfootSound("startup.mp3");
    public TitleScreen()
    {   
        super(800, 500, 1);
        //creating and adding the labels for the title screen
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
            //if the space bar is pressed it creates a new endless world, puts player in it and
            //plays the start up sound affect
            World1 world = new World1();
            Greenfoot.setWorld(world);
            startup.play();
        }
        if(Greenfoot.isKeyDown("t"))
        {
            //if T is pressed a new tutorial world is created, and the player is send to it as well 
            //as playing the start up sound affect
            Tutorial tutorial = new Tutorial();
            Greenfoot.setWorld(tutorial);   
            startup.play();
        }
    }
}
