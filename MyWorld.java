import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * its a world ruled by bears, just like the real world.
 * 
 * @author (eli abergel) 
 * @version (may 31 2022)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * bear
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        Bear bear = new Bear();
        addObject(bear, 300, 200);

        createBread();
        prepare();
    }

    public void createBread()
    {
        Bread bread = new Bread();
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
