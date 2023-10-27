import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * a clickable button that says game over.
 */
public class ButtonGameOver extends Actor

{
    private PingWorld pingWorld; //instance variable, refer to PingWorld.
    boolean mouseDown; //boolean variable
    
    /**
     * Class constructor that takes a PingWorld parameter called world, 
     * when an instance of ButtonGameOver is created, 
     * it receives a reference to "PingWorld" and initializes the "pingWorld" variable.
     */
    public ButtonGameOver(PingWorld world)
    {
        GreenfootImage gameover = new GreenfootImage("GameOver.png");
        setImage(gameover);
        mouseDown = false; //sets mouseDown variable to false in construction.
        pingWorld = world; //Initialize the pingWorld variable, with the passed-in world.
    }

    /**
     * When the button is clicked, it changes world to IntroWorld, plays a click sound and
     * checks if pingWorld refers to PingWorld, if it does (is not null), it calls the method stopGameMusic from PingWorld.
     */
    public void act()
    {
        if (!mouseDown && Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new IntroWorld());
            Greenfoot.playSound("soundClick.mp3");
            if (pingWorld != null) 
            {
                pingWorld.stopGameMusic(); // Call a method in PingWorld.
            }
        }
    }
}
