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
    static Label scoreLabel;
    static Label turboLabel;
    public String ready = "Ready!";
    public String notReady = "Not Ready";
    Label tutorialLabel;
    Label tutorial2Label;
    Label tutorial3Label;
    public static int carDone = 0;
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
        addObject(tutorialLabel,320,100); 
        tutorial2Label = new Label("",40);
        addObject(tutorial2Label,320,150);    
        tutorial3Label = new Label("",40);
        addObject(tutorial3Label,320,200);  
        
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
            tutorial2Label.setValue("the car");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("up") && tutCounter == 2)
        {
            tutorialLabel.setValue("Now try to dodge a car. Hitting cars pushs");
            tutorial2Label.setValue("you back, when you get to the edge");
            tutorial3Label.setValue("of the screen your game will be over");
            spawnCar();
            tutCounter++; 
        }
        if(carDone == 1 && tutCounter == 3)
        {
            tutorialLabel.setValue("Nice! Cars passing give you points, which");
            tutorial2Label.setValue("can be used with turbo. turbo gives you");
            tutorial3Label.setValue("more space before crashing(press space)");
            tutCounter++;
            
        }
        if(Greenfoot.isKeyDown("space") && tutCounter == 4)
        {
            tutorialLabel.setValue("Turbo costs 10 points");
            turboLabel.setValue("Ready!");
            scoreLabel.setValue("10");
            UserCar.turboScore = 10;
            tutorial2Label.setValue("Here's the 10 points needed to use turbo");
            tutorial3Label.setValue("Press right to use turbo");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("right") && tutCounter == 5)
        {
            tutorialLabel.setValue("Good job, now try the full game");
            tutorial2Label.setValue("To go back to the title");
            tutorial3Label.setValue("screen press ENTER");
            turboLabel.setValue("Not Ready");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("enter") && tutCounter == 6)
        {
            tutCounter = 0;
            carDone--;
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
    
    public void spawnCar()
    {
        TutorialCar tutCar = new TutorialCar();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(tutCar,x,y);
    }
    public static void crashLabel()
    {
        turboLabel.setValue(""); 
        scoreLabel.setValue(""); 
    }
}
