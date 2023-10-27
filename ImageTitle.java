import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * a image of the title that moves slightly up and down.
 */
public class ImageTitle extends Actor
    {
    int targetX = 250;
    int targetY = 50;
    int initialX = 250;
    int initialY = 200;
        
    public ImageTitle()
    {
        GreenfootImage CyberPongImage = new GreenfootImage("CyberPongImage.png");
        setImage(CyberPongImage);   
    }
    
    public void act() //vi skal have ændret billedet hvis det skal virke, der er "rammer" omkring, ligesom igår.
    {
        if(getY()>=100 && getY()<200)
        {
        turnTowards(initialX, initialY);
        move(5);
        }
        else if(getY()<=200 && getY()>50)
        {
        turnTowards(targetX, targetY);
        move(5);
        }
        
        setRotation(0);
    }
}