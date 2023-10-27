import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * a clickable button that says player 2 won.
 */
public class Button2PWon extends Actor
{
    private PongWorld pongWorld; //instance variable, refer to PongWorld.
    boolean mouseDown; //boolean variable
    
    /**
     * Class constructor that takes a PongWorld parameter called world, 
     * when an instance of Button2PWon is created, 
     * it receives a reference to "PongWorld" and initializes the "pongWorld" variable.
     */
    public Button2PWon(PongWorld world)
    {
        GreenfootImage player2won = new GreenfootImage("P2Win.png");
        setImage(player2won);
        mouseDown = false; //sets mouseDown variable to false in construction.
        pongWorld = world; //Initialize the pongWorld variable, with the passed-in world.
    }
    
    /**
     * When the button is clicked, it changes world to IntroWorld, plays a click sound and
     * checks if pongWorld refers to PongWorld, if it does (is not null), it calls the method stopGameMusic from PongWorld.
     */
    public void act()
    {
        if (!mouseDown && Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new IntroWorld());
            Greenfoot.playSound("soundClick.mp3");
            if (pongWorld != null) 
            {
                pongWorld.stopGameMusic(); // Call a method in IntroWorld.
            }
        }
    }
}
