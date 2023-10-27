import greenfoot.*;
import java.util.Random;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class PaddleBotRight extends Actor
{
    private int width;
    private int height;
    private int dx;
    GreenfootImage PaddleBot = new GreenfootImage("blue neon.png");
    private Random rand = new Random();
    /**
     * Constructs a new paddle with the given dimensions.
     */
    public PaddleBotRight (int width, int height)
    {
        this.width = rand.nextInt(60) + 60;
        this.height = rand.nextInt(10) + 5;
        dx = 1;
        createImage();
    }

    /**
     * Act - do whatever the SelfPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(getX()<=-50)
        {
          getWorld().removeObject(this); 
        }
        else
        {
            move(-dx * 4);
        }
    }
        
    /**
     * Creates and sets an image for the paddle, the image will have the same dimensions as the paddles width and height.
     */
    private void createImage()
    {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(Color.CYAN);
        image.fill();
        setImage(image);
    }
}
