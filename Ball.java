import greenfoot.*;


/**
 * A Ball is a thing that bounces of walls and paddles (or at least i should).
 * Ball extends smoothmover to counter problem of int restrictions on ball bounce movement, 
 * making it so that the ball could get stuck in a loop of bouncing up and down.
 * 
 * @author The teachers 
 * @version 1
 */
public class Ball extends SmoothMover
{
    //adding variables:
    private static final int BALL_SIZE = 25; 
    private static final int BOUNCE_DEVIANCE_MAX = 5;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100; 
    
    private int paddleBounceCool = 0;
    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private int delay;
    
    //loading sounds:
    GreenfootSound paddleBounce = new GreenfootSound ("swoosh1.mp3");
    GreenfootSound wallBounce = new GreenfootSound ("swoosh2.mp3");
    GreenfootSound ballout = new GreenfootSound ("BallIsOut.mp3");
   
    /**
     * Contructs the ball and sets it in motion!
     */
    public Ball()
    {
        createImage();
        init();
    }

    /**
     * Creates and sets an image of a black ball to this actor.
     */
    private void createImage()
    {
        GreenfootImage ballImage = new GreenfootImage("cyberpunkBall.png");
        setImage(ballImage);
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            bouncyBall();
            increaseSpeed();
            if(paddleBounceCool > 0)
            {
                paddleBounceCool --;
            }
        }
    }    
    
    /**
     * Compilation of checking methods
     */
    public void bouncyBall()
    {
        checkBounceOffWalls();
        checkBounceOffCeiling();
        checkBounceOffFloor();
        checkBounceOffPaddleplayerOne();
        checkBounceOffPaddlePlayerTwo();
        checkBounceOffPaddleComputer();
        checkBounceOffPaddleBotLeft();
        checkBounceOffPaddleBotRight();
    }
    
    /**
     * Increases speed according to level
     */
    public void increaseSpeed() 
    {
        switch (Score.getLevel()) 
        {
        case 1:
            speed = 6;
            break;
        case 2:
            speed = 7;
            break;
        case 3:
            speed = 8;
            break;
        case 4:
            speed = 9;
            break;
        default:
            speed = 10; // Sets speed to 10, when above level 4
            break;
        }
    }
    
    /**
     * checking if the ball is moving upwards, returns true if it is, false if not.
     */
    public boolean isMovingUp()
    {
        if(getRotation() > 180)
        {
            return true;
        }
        return false;
    }
    
    /**
     * If the ball is touching the PaddlePlayerOne and there isn't cooldown on paddlebounce, 
     * it reverts vertically, adds cooldown to paddle bounce, plays a neat sound and increase score in Score class.
     */
    private void checkBounceOffPaddleplayerOne()
    {
        if (isTouching(PaddlePlayerOne.class) && paddleBounceCool == 0)
            {
                if (! hasBouncedVertically)
                {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
                if (! Score.hasPlayerWon && ! Score.hasCPUWon && ! Score.hasP1Won && ! Score.hasP2Won)//if noone has won score will increase.
                { //if any of them are true score won't be counted. 
                    Score.increaseScore(1); // Increases paddle hit score by one when the ball hits the paddle, configure so its also speed.
                }
                }
            }
        else
            {
            hasBouncedVertically = false;
            }
    }
    
    /**
     * If the ball is touching the PaddlePlayerTwo and there isn't cooldown on paddlebounce, 
     * it reverts vertically, adds cooldown to paddle bounce, plays a neat sound and increase score in Score class.
     */
    private void checkBounceOffPaddlePlayerTwo()
    {
        if (isTouching(PaddlePlayerTwo.class) && paddleBounceCool == 0)
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
                if (! Score.hasP1Won && ! Score.hasP2Won)//if neither P1 or p2 has won continue increasing score
                {
                Score.increaseScore(1);//increasing paddle hit score
                }
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
    
    /**
     * If the ball is touching the PaddleComputer and there isn't cooldown on paddlebounce, 
     * it reverts vertically, adds cooldown to paddle bounce and plays a neat sound.
     */
    private void checkBounceOffPaddleComputer()
    {
        if (isTouching(PaddleComputer.class) && paddleBounceCool == 0)
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
    
    /**
     * If the ball is touching the PaddleBotLeft and there isn't cooldown on paddlebounce, 
     * it reverts vertically if the ball is moving up, adds cooldown to paddle bounce and plays a neat sound.
     * However if the ball is within the PongWorld, it reverts vertically, adds cooldown to paddle bounce and plays a neat sound.
     */
    private void checkBounceOffPaddleBotLeft()
    {
        if (isTouching(PaddleBotLeft.class) && paddleBounceCool == 0)
        {
            if (isMovingUp())
            {
                if (! hasBouncedVertically)
                {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
                }
            }
            
            else if (getWorld() instanceof PongWorld)
            {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }    
        
    /**
     * If the ball is touching the PaddleBotRight and there isn't cooldown on paddlebounce, 
     * it reverts vertically if the ball is moving up, adds cooldown to paddle bounce and plays a neat sound.
     * However if the ball is within the PongWorld, it reverts vertically, adds cooldown to paddle bounce and plays a neat sound.
     */
    private void checkBounceOffPaddleBotRight()
    {
        if (isTouching(PaddleBotRight.class) && paddleBounceCool == 0)
        {
            if (isMovingUp())
            {
                if (! hasBouncedVertically)
                {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
                }
            }
            
            else if (getWorld() instanceof PongWorld)
            {
                revertVertically();
                paddleBounceCool += 30;
                paddleBounce.setVolume(25);
                paddleBounce.play();
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }    
    
    /**
     * Returns true if the ball is touching one of the side walls.
     */
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the ceiling.
     */
    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);
    }

    /**
     * Returns true if the ball is touching the floor.
     */
    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }

    /**
     * Check to see if the ball should bounce off one of the walls.
     * If touching one of the walls, the ball is bouncing off.
     */
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
                wallBounce.setVolume(25);
                wallBounce.play();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If in PingWorld and touching the ceiling the ball is bouncing off.
     * If in PongWorld and touching the ceiling, the ball is reset and P1Score is increased in score class.
     */
    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling() && getWorld() instanceof PingWorld)
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                wallBounce.setVolume(25);
                wallBounce.play();
            }
        }
        if (isTouchingCeiling() && getWorld() instanceof PongWorld)
        {
                ballout.setVolume(25);
                ballout.play();
                init();
                setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                if (! Score.hasP1Won && ! Score.hasP2Won)//if neither P1 or P2 has won, do the following
                {
                    Score.increaseP1Score();//Increasing P1 score everytime ball hit ceiling
                }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }

    /**
     * Check to see if the ball should bounce off the ceiling.
     * If in PingWorld and touching the floor the ball is reset, cpu score increase in score class and 
     * win conditions for cpu is checked in score class.
     * If in PongWorld and touching the floor, the ball is reset and P2Score is increased in score class.
     */
    private void checkBounceOffFloor()
    {
        if (isTouchingFloor() && getWorld() instanceof PingWorld)
        {
            ballout.setVolume(25);
            ballout.play();
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            if (! Score.hasCPUWon && ! Score.hasPlayerWon)//if neither CPU or Player has won score will increase, otherwise scoring won't be counted.
            {
                Score.increaseCPUScore();// Increases score by one when ball hits the floor
            }
            Score.winConditionCPU();
        }
        else if (isTouchingFloor() && getWorld() instanceof PongWorld)
        {
            ballout.setVolume(25);
            ballout.play();
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            if (! Score.hasP2Won && ! Score.hasP1Won)//if neither P1 or P2 has won continue increasing P2Score, otherwise scoring as P2 won't be counted.
            {
                Score.increaseP2Score();//increases P2 Score when ball hit floor in MP
            }
        }
         else
        {
            hasBouncedVertically = false;
        }
    }

    /**
     * Bounces the ball back from a vertical surface.
     */
    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }
    
    /**
     * Bounces the bal back from a horizontal surface.
     */
    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX)- BOUNCE_DEVIANCE_MAX / 2;
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
    }

    /**
     * Initialize the ball settings.
     */
    private void init()
    {
        speed = 2;
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
}
