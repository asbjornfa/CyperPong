import greenfoot.*;
import java.util.Random;
import java.util.List;

/**
 * The Ping World is where Balls and Paddles meet to play pong.
 * 
 * @author The teachers 
 * @version 1
 */
public class PongWorld extends World
{
    private static final int WORLD_WIDTH = 500; //adding variable
    private static final int WORLD_HEIGHT = 700; //adding variable
    
    //loading images and sounds:
    GreenfootImage worldBackground = new GreenfootImage("neon background.jpg");
    GreenfootSound gameMusic = new GreenfootSound ("cyberpunk2099.mp3");
    GreenfootSound wakeup = new GreenfootSound ("WakeTheFUp.mp3");
    
    /**
     * Constructor for objects of class PongWorld.
     */
    public PongWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1,false); 
        //constructing world size, we used 'False' to ignore boundaries.
        
         if (gameStarted)
        {
         // Create a new world with WORLD_WIDTHxWORLD_HEIGHT cells with a cell size of 1x1 pixels.
            initializeGameObjects();
            initializeGameSounds();
            Score.resetScore();
        }
        else
        {
            Greenfoot.setWorld(new IntroWorld());
        }
    }
    
    public void act()
    {
        showText("Game Level:  " + Score.getLevel() + ".",87,45); //adds gamelevel onto screen.
        showText("P1: " + Score.getP1Score() + ".",450,645); //adds player 1 score onto screen.
        showText("P2: " + Score.getP2Score() + ".",450,55); //adds player 2 score onto screen.
        
        //run methods:
        PaddleBotsRespawn();
        Score.winConditionMultiplayer();
        Player1Won();
        Player2Won();
    }
    
    /**
     * adds initial objects to the world.
     */
    private void initializeGameObjects()
    {
        addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        addObject(new PaddlePlayerOne(100,10), 250, WORLD_HEIGHT - 50);
        addObject(new PaddlePlayerTwo(100,10), 250, WORLD_HEIGHT - 650);
        addObject(new PaddleBotLeft(100,10), -50, WORLD_HEIGHT - (Greenfoot.getRandomNumber(300)+200));
        addObject(new PaddleBotRight(100,10), 550, WORLD_HEIGHT - (Greenfoot.getRandomNumber(300)+200)); 
    }
    
    /**
     * modify and start initial sounds.
     */
    private void initializeGameSounds()    
    {
        gameMusic.setVolume(25);
        gameMusic.playLoop();
        wakeup.setVolume(30);
        wakeup.play();
    }
    
    /**
    * Checking for any objects of PaddleBotLeft and PaddleBotRight class. 
    * If there isn't any of one or the other, adds one.
    */
    public void PaddleBotsRespawn()   
    {
           if(getObjects(PaddleBotLeft.class).isEmpty())
        {
            addObject(new PaddleBotLeft(0 , 0) , -50 , WORLD_HEIGHT - (Greenfoot.getRandomNumber(300)+200));
        }
        if(getObjects(PaddleBotRight.class).isEmpty())
        {
            addObject(new PaddleBotRight(0 , 0) , 550 , WORLD_HEIGHT - (Greenfoot.getRandomNumber(300)+200));
        } 
    }
    
    /**
     * if winning conditions for player 1 are met, adds player 1 won button.
     */
    public void Player1Won()
    
    {
        if(Score.hasP1Won == true && Score.hasP2Won != true)
        {
         addObject (new Button1PWon(this) , getWidth() / 2 , getHeight() / 2);
        }
    }

    /**
     * if winning conditions for player 2 are met, adds player 2 won button.
     */
    public void Player2Won()
    
    {
        if(Score.hasP2Won == true && Score.hasP1Won != true)
        {
         addObject (new Button2PWon(this) , getWidth() / 2 , getHeight() / 2);
        }
    }

    /**
     * method to stop gameMusic, if it is playing.
     */
    public void stopGameMusic()
    {
        if(gameMusic != null)
        {
            gameMusic.stop();
        }
    }
}
    
   
