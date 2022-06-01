import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * its a bear, he does bear things.
 * 
 * @author (eli abergel) 
 * @version (may 31 2022)
 */
public class Bear extends Actor
{
    GreenfootSound laResistince = new GreenfootSound("la.mp3");
    GreenfootImage[] turnRight = new GreenfootImage[6];
    GreenfootImage[] turnLeft = new GreenfootImage[6];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Bear()
    {
        
        for(int i = 0; i < turnRight.length; i++)
        {
            turnRight[i] = new GreenfootImage("images/spinfolder/walk" + i + ".png");
            turnRight[i].scale(70, 70);
        }
        for(int i = 0; i < turnLeft.length; i++)
        {
            turnLeft[i] = new GreenfootImage("images/spinfolder/walk" + i + ".png");
            turnLeft[i].mirrorHorizontally();
            turnLeft[i].scale(70, 70);
        }
        animationTimer.mark();
        setImage(turnRight[0]);
    }
    
    int imageIndex = 0;
    public void animateBear()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(turnRight[imageIndex]);
            imageIndex = (imageIndex + 1) % turnRight.length;
        }
        else
        {
            setImage(turnLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % turnLeft.length;            
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        
        eat();
        animateBear();
    }
    
    public void eat()
    {
        if(isTouching(Bread.class))
        {
            removeTouching(Bread.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBread();
            world.increaseScore();
            laResistince.play();
        }
    }
}
