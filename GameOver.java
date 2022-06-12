import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Label gameOver1Label;
    Label gameOver2Label;
    Label gameOver3Label;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {   
        super(800, 500, 1); 
        gameOver1Label = new Label("Game Over!",100);
        addObject(gameOver1Label,400,250);
        gameOver2Label = new Label("Press space to play again",50);
        addObject(gameOver2Label,400,300);
        gameOver3Label = new Label("or press enter to go to the title screen",50);
        addObject(gameOver3Label,400,350);        
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            World1 world = new World1();
            Greenfoot.setWorld(world);
        }
        if(Greenfoot.isKeyDown("enter"))
        {
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
}
