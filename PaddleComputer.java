import greenfoot.*;
import java.util.List;


/**
 * A paddle is an object that goes back and forth. Though it would be nice if balls would bounce of it.
 * 
 * @author The teachers 
 * @version 1
 */
public class PaddleComputer extends Actor
{
    private int width;
    private int height;
    private int dx;
    private static final int PADDLE_SIZE = 100;
    
    private int initialX = 250;
    private int initialY = 50;
    GreenfootImage bot= new GreenfootImage("red neon.png");

    /**
     * Constructs a new paddle with the given dimensions.
     */
    public PaddleComputer(int width, int height)
    {
        this.width = width;
        this.height = height;
        dx = 1;
        setImage(bot);
    }
    
    
    /**
     * Act - do whatever the BotPaddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        chaseThatBall();
    }
    
    private void chaseThatBall()
    {
        Ball ball = targetBall();
        // the Bot Paddle will look for the Ball
        
        if(ball!=null)
            {
            //The BotPaddle will move towards 
            turnTowards(ball.getX(), initialY);
            move(4*dx);
            }    
            
        else if (getX() != initialX || getY() != initialY)
            {
            turnTowards(initialX, initialY);  
            move(4*dx);
            }
        setRotation(0);
    }
    
    private Ball targetBall()
    {
        List<Ball> ballList = getObjectsInRange(250, Ball.class);
        
        if(ballList.isEmpty())
            {
            return null;
            }
        else
            {
            return ballList.get(0);
            }
    }

}
