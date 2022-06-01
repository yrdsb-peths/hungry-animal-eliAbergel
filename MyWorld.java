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

        Bear bear = new Bear();
        addObject(bear, 300, 200);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
        
        createBread();
        prepare();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        score++;
        scoreLabel.setValue(score);
        if(score % 5 == 0)
        {
            level += 1;
        }
    }

    public void createBread()
    {
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
