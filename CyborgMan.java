import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CyborgMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CyborgMan extends Actor
{
    
    private GreenfootImage[] runRight = new GreenfootImage[12]; // Array to store animation frames
    
    private int frame = 0; // Current frame index
    private int animationDelay = 15; //Delay between frame changes
     
    public CyborgMan()
    {
        initAnimationSprites(); // Initialize animation frames
        setImage(runRight[0]); // Set the initial image
    }
    
    /**
     * Act - do whatever the CyborgMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Check if CyborgMan is out of the screen, 
        if(getX() >=getWorld().getWidth())
        {
            setLocation(150, getY()); // Wrap around to the left side when the right edge is reached
        }
        animate(); // Call the animation method
    }
    
    public void initAnimationSprites(){
        for(int i = 0; i < 12; i++)
        {
            String filename = "Cyborg_run" + (i + 1) + ".png"; // Construct image filename
            runRight[i] = new GreenfootImage(filename); // Load each animation frame
        }
    }
    
    public void animate()
    {
        if(frame >= runRight.length) 
        {
            frame = 0; // Reset frame index if it goes beyond the array length
        }
        setImage(runRight[frame]); // Set the current animation frame as the image 
        frame++; // Move to the next frame
        
        Greenfoot.delay(animationDelay); // Add a delay between frame changes
        
    }
    
}
