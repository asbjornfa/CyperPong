import greenfoot.*;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class PaddlePlayerOne extends Actor
{
    private int width;
    private int height;
    private int dx;
    private static final int PADDLE_SIZE = 100;
    GreenfootImage player= new GreenfootImage("green neon.png");

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public PaddlePlayerOne(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 2;
        setImage(player);
    }

    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        keyboardControl();
    }    
    
    /**
     * press key, move paddle.
     */
    private void keyboardControl()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            /*When pressing the "right" arrow key, we calculate the potential new x-coordinate 
            for moving right (newRight) by adding 2 * dx to the current x-coordinate*/
            
            int newLeft = getX() - 4*dx;
            
            /*Check if the new x-coordinate is still within the world boundary by comparing it
            to the left edge (0) plus half og the objects width*/
            
            if (newLeft - getImage().getWidth() / 2 > 0 )
            {
                setLocation(newLeft, getY());
                
            }
            
        }
        if (Greenfoot.isKeyDown("right"))
        {
            /*When pressing the "right" arrow key, we calculate the potential new x-coordinate  
            for moving right (newRight) by adding 2 * dx to the current x-coordinate*/
            
            int newRight = getX() + 4*dx;
            
            /*Check if the new x-coordinate is still within the world boundary by comparing it
            to the right edge ('getWorld().getWidth()') minus half og the object's width.*/
            
            if (newRight + getImage().getWidth() / 2 < getWorld().getWidth())
            {
                setLocation(newRight, getY());
                
            }
        }
    }
}
