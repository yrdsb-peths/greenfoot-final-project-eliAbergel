import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this is the screen that the player is sent to every time they crash, and lets them choose if they
 * want to play again or go to the title screen.
 * 
 * @author (Eli Abergel) 
 * @version (June 8 2022)
 */
public class GameOver extends World
{
    //these are the labels for "Game Over!" and instructions for playing again
    Label gameOver1Label;
    Label gameOver2Label;
    Label gameOver3Label;
    public GameOver()
    {   
        super(800, 500, 1);
        //creates and adds labels
        gameOver1Label = new Label("Game Over!",100);
        addObject(gameOver1Label,400,200);
        gameOver2Label = new Label("Press SPACE to play again",50);
        addObject(gameOver2Label,400,300);
        gameOver3Label = new Label("or press ENTER to go to the title screen",50);
        addObject(gameOver3Label,400,350); 
        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            //when space is pressed the player is teleported to a new instrince of the game world
            World1 world = new World1();
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.isKeyDown("enter"))
        {
            //when enter is pressed the game creates and takes the player to the title screen
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
}
