import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * title screen of the super french bear.
 * 
 * @author (eli) 
 * @version (may 31 2022)
 */
public class titleScreen extends World
{
    //labels for the this screen
    Label titleLabelP1 = new Label("Super patriotic", 80);
    Label titleLabelP2 = new Label("french bear!!!", 80);
    Label overTitleLabel = new Label("welcome to", 40);
    Label instructionLabel = new Label("Press \u2190 and \u2192 to move", 45);
    Label spaceLabel = new Label("press space to continue", 40);
    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //all the labels put into the title screen
        addObject(titleLabelP1, getWidth()/2, getHeight()/3);
        addObject(titleLabelP2, getWidth()/2,getHeight()/2);
        addObject(overTitleLabel, getWidth()/2, getHeight()/4);
        addObject(instructionLabel, 300, 300);
        addObject(spaceLabel, 300, 350);
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            //the activation for starting the game
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //the still bear on the title screen
        Bear bear = new Bear();
        addObject(bear,300,250);
        bear.setLocation(312,247);
        bear.setLocation(320,263);
    }
}
