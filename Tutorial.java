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
    public static int turboScore1 = 1;
    public int tutCounter = 1;
    public String ready = "Ready!";
    public String notReady = "Not Ready";
    static Label scoreLabel;
    static Label turboLabel;
    Label tutorialLabel;
    Label tutorial2Label;
    Label tutorial3Label;
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
        tutorial3Label = new Label("",40);
        addObject(tutorial3Label,300,200);  
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        turboLabel = new Label(0,50);
        addObject(turboLabel,200,50);
        turboLabel.setValue("GO!!!"); 
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space") && tutCounter == 1)
        {
            tutorialLabel.setValue("Press up and down to move");
            tutorial2Label.setValue("car(press space)");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("space") && tutCounter == 2)
        {
            tutorialLabel.setValue("Now try to dodge a car(press space)");
            tutorial2Label.setValue("");
            spawnCar();
            tutCounter++; 
        }
        if(Greenfoot.isKeyDown("space") && tutCounter == 3)
        {
            tutorialLabel.setValue("Great! Cars passing you give you");
            tutorial2Label.setValue("points,which can be used turbo(press space)");
            tutCounter++;
            
        }
        if(Greenfoot.isKeyDown("space") && tutCounter == 4)
        {
            tutorialLabel.setValue("Every 10 points turbo can be used, it");
            tutorial2Label.setValue("gives it gives you more space intill");
            tutorial3Label.setValue("you crash(press space)");
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
