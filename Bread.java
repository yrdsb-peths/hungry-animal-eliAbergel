import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * this bear is french, so he eats le bread.
 * 
 * @author (eli abergel) 
 * @version ( may 31 2022)
 */
public class Bread extends Actor
{
    private int speed = 1;
    /**
     * Act - do whatever the Bread wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x ,y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
