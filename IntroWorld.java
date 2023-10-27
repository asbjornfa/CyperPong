import greenfoot.*;

/**
 * Write a description of class IntroWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500; //adding variable
    private static final int WORLD_HEIGHT = 700; //adding variable
    
    //Loading songs and images:
    GreenfootSound introMusic = new GreenfootSound ("cyberpunkAtomic.mp3");
    GreenfootImage introbackground = new GreenfootImage("neoncity.jpg");
    /**
     * Constructor for objects of class IntroWorld.
     */
        public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); //constructing world size
        
        introMusic.setVolume(25); // Sets volume of introMusic.
        introMusic.playLoop(); // plays introMusic in a loop until it gets called off.
        
        setBackground(introbackground); // Sets our initial background.
        
        addObject(new CyborgMan(), 250, 650); //adding object 
        addObject(new ImageTitle(), 250, 200); //adding object 
        addObject(new ButtonStart1P(this), 250, 450); // Pass a reference to this IntroWorld object.
        addObject(new ButtonStart2P(this), 250, 550); // Pass a reference to this IntroWorld object.
    }
    
    
    /**
     * Method to stop introMusic if it's playing.
     */
    public void stopIntroMusic()
    
    {
        if(introMusic != null)
        {
            introMusic.stop();
        }
    }
}
