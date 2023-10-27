import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * a clickable button that says <2 player>.
 */
public class ButtonStart2P extends Actor

{
    private IntroWorld introWorld; //instance variable, refer to IntroWorld object.
    boolean mouseDown; //boolean variable
    /**
     * Class constructor that takes a IntroWorld parameter called world, 
     * when an instance of ButtonStart2P is created, 
     * it receives a reference to "IntroWorld" and initializes the "introWorld" variable.
     */
    public ButtonStart2P(IntroWorld world)
    {
        GreenfootImage PlayerPong2 = new GreenfootImage("2PlayerPong.png");
        setImage(PlayerPong2);
        mouseDown = false; //sets mouseDown variable to false in construction.
        introWorld = world; //Initialize the introWorld variable, with the passed-in world.
    }
    
    /**
     * When the button is clicked, it changes world to HowToPlay2Player, plays a click sound and
     * checks if introWorld refers to IntroWorld, if it does (is not null), it calls the method stopIntroMusic from IntroWorld.
     */
    public void act()
    {
        if (!mouseDown && Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new HowToPlay2Player());
            Greenfoot.playSound("soundClick.mp3");
            if (introWorld != null) 
            {
            introWorld.stopIntroMusic(); // Call a method in IntroWorld.
            }
        }
    }
}
