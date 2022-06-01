import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * its a bear, he does bear things.
 * 
 * @author (eli abergel) 
 * @version (may 31 2022)
 */
public class Bear extends Actor
{
    //"la resistance" sound affect
    GreenfootSound laResistince = new GreenfootSound("la.mp3");
    //the sets of animation for the bear
    GreenfootImage[] turnRight = new GreenfootImage[6];
    GreenfootImage[] turnLeft = new GreenfootImage[6];
    //the string for facing right or left
    String facing = "right";
    //timer for the speed of the animations
    SimpleTimer animationTimer = new SimpleTimer();
    public Bear()
    {
        //code to keep the bear looking right
        for(int i = 0; i < turnRight.length; i++)
        {
            turnRight[i] = new GreenfootImage("images/spinfolder/walk" + i + ".png");
            turnRight[i].scale(70, 70);
        }
        //code to make the bear look left
        for(int i = 0; i < turnLeft.length; i++)
        {
            turnLeft[i] = new GreenfootImage("images/spinfolder/walk" + i + ".png");
            //this flips the image and the animation
            turnLeft[i].mirrorHorizontally();
            turnLeft[i].scale(70, 70);
        }
        //starts timer
        animationTimer.mark();
        //starts image at the first frame
        setImage(turnRight[0]);
    }
    //sets up the number for the image to start at
    int imageIndex = 0;
    public void animateBear()
    {
        //timer for animation and how long each frame lasts
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        //if the string facing is "right" then it looks right
        //else it looks left
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
        //the moving of the bear
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
        //the comand to get a point and delete the current
        //bread from the screen
        eat();
        //the command to make the bear look like its walking 
        animateBear();
    }
    
    public void eat()
    {
        //if its touching bread, it removes it, adds a point,
        //plays a sound and makes a new bread
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
