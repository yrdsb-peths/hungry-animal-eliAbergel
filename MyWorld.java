import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * its a world ruled by bears, just like the real world.
 * 
 * @author (eli abergel) 
 * @version (may 31 2022)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * bear
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1 ,false); 
        //this is the main bear
        Bear bear = new Bear();
        addObject(bear, 300, 200);
        //this is the score counter in the top
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        //this creates the bread
        createBread();
        prepare();
    }
    
    public void gameOver()
    {
        //this is the game over when the bread falls
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        //this is the code of the score counter
        score++;
        scoreLabel.setValue(score);
        if(score % 5 == 0)
        {
            //this increasses the level every 5 points
            level += 1;
        }
    }

    public void createBread()
    {
        //this is the code for the bread and the location the bread spawns at
        Bread bread = new Bread();
        bread.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(bread,x,y);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
