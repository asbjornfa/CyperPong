import greenfoot.*;

/**
 * Write a description of class HowToPlay2Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HowToPlay2Player extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    
    GreenfootImage introbackground = new GreenfootImage("neoncity.jpg");
    
    /**
     * Constructor for objects of class HowToPlay2Player.
     */
        public HowToPlay2Player()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        setBackground(introbackground);
        addObject(new ImageHTP2Players(), 250, 300);
        addObject(new ButtonEnterGame(), 250, 520);
    }
    
    public void act()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("enter"))
        {
            Greenfoot.setWorld(new PongWorld(true));
            Greenfoot.playSound("soundClick.mp3");
        }
    }
}
