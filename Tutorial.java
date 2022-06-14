import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a tutorial world to help the player get understand the controls.
 * and feel of the game.
 * 
 * @author (Eli Abergel) 
 * @version (June 11 2022)
 */
public class Tutorial extends World
{
    //these are the counters used to track the score, if turbo is ready, 
    //and what step the tutorial is on
    public int score = 0;
    public static int turboScore1 = 1;
    public int tutCounter = 1;
    //these are used to track the score
    static Label scoreLabel;
    static Label turboLabel;
    //these are the sentinces that are used in the tutorial
    Label tutorialLabel;
    Label tutorial2Label;
    Label tutorial3Label;
    //this checks if the car in the tutorial passes so that the next step
    //can be read
    public static int carDone = 0;
    /**
     * Constructor for objects of class Controls.
     * 
     */
    public Tutorial()
    {    
        super(800, 500, 1, false); 
        //this spawns the user's car
        UserCar userCar = new UserCar();
        addObject(userCar, 100, 450);
        //these are the starting labels for tutorial and them being added to
        //the world
        tutorialLabel = new Label("Welcome to Sunset Turbo(press space)",40);
        addObject(tutorialLabel,320,100); 
        tutorial2Label = new Label("",40);
        addObject(tutorial2Label,320,150);    
        tutorial3Label = new Label("",40);
        addObject(tutorial3Label,320,200);  
        //these are the labels for the score and turbo
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        turboLabel = new Label("GO!!!",50);
        addObject(turboLabel,200,50);
    }
    public void act()
    {
        //this is the tutorials code
        if(Greenfoot.isKeyDown("space") && tutCounter == 1)
        {
            //if space is pressed starts tutorial with movement
            //controls and readys the next step
            tutorialLabel.setValue("Press up and down to move");
            tutorial2Label.setValue("the car");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("up") && tutCounter == 2)
        {
            //if up is pressedtalks about the dangers of getting hit by a car,
            //and spawns a car for the player to dodge, and readys next step
            tutorialLabel.setValue("Now try to dodge a car. Hitting cars pushs");
            tutorial2Label.setValue("you back, get hit off screen and game ");
            tutorial3Label.setValue("over. Every 15 rounds a new car spawns");
            spawnCar();
            tutCounter++; 
        }
        if(carDone == 1 && tutCounter == 3)
        {
            //if the car has passed congratulations are given, and turbo is 
            //explained, as well as the next step being readied
            tutorialLabel.setValue("Nice! Cars passing give you points, which");
            tutorial2Label.setValue("can be used with turbo. turbo gives you");
            tutorial3Label.setValue("more space before crashing(press space)");
            tutCounter++;
            
        }
        if(Greenfoot.isKeyDown("space") && tutCounter == 4)
        {
            //if space is pressed, the player gets 10 points, is shown how to use 
            //use turbo and turbo is used by the player, and readys the next step
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
            //when turbo is pressed the tutorial is completed and the user
            //is told to go back to the title screen
            tutorialLabel.setValue("Good job, now try the full game");
            tutorial2Label.setValue("To go back to the title");
            tutorial3Label.setValue("screen press ENTER");
            turboLabel.setValue("Not Ready");
            tutCounter++;
        }
        if(Greenfoot.isKeyDown("enter") && tutCounter == 6)
        {
            //brings player to title screen and resets tutorial
            tutCounter = 0;
            carDone--;
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
    public void spawnCar()
    {
        //spawns new car and randomizes its spawn point
        TutorialCar tutCar = new TutorialCar();
        int x = 800;
        int y = Greenfoot.getRandomNumber(200) + 300;
        addObject(tutCar,x,y);
    }
}
