import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends World
{
    public int score = 0;
    public static int turboScore1 = 0;
    public String ready = "Ready!";
    public String notReady = "Not Ready";
    static Label scoreLabel;
    static Label turboLabel;
    Label tutorialLabel;
    Label tutorial2Label;
    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Tutorial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1, false); 
        UserCar userCar = new UserCar();
        addObject(userCar, 100, 450);
        tutorialLabel = new Label("Welcome to Sunset Turbo(press space)",40);
        addObject(tutorialLabel,300,100); 
        tutorial2Label = new Label("",40);
        addObject(tutorial2Label,300,150);    
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        turboLabel = new Label(0,50);
        addObject(turboLabel,200,50);
        turboLabel.setValue("GO!!!"); 
        spawnCar();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            tutorialLabel.setValue("Press up and down to move");
            tutorial2Label.setValue("car(press space)");
            if(Greenfoot.isKeyDown("space"))
            {
                tutorialLabel.setValue("Now dodge a car");
                tutorial2Label.setValue("");
                
            }
        }
    }
    
    public void spawnCar()
    {
        TutorialCar tutCar = new TutorialCar();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(tutCar,x,y);
    }
    public void addScore()
    {
        score++;
        turboScore1++;
        scoreLabel.setValue(score);
        if (turboScore1 >= 10)
        {
            turboLabel.setValue(ready);
        }
        else
        {
            turboLabel.setValue(notReady);
        }
 
    }
    public static void crashLabel()
    {
        turboLabel.setValue(""); 
        scoreLabel.setValue(""); 
    }
}
