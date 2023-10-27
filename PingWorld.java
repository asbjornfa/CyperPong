import greenfoot.*;
import java.util.Random;
import java.util.List;

/**
 * The Ping World is where Balls and Paddles meet to play pong.
 */
public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500; //adding variable
    private static final int WORLD_HEIGHT = 700; //adding variable
    
    //loading images and sounds:
    GreenfootImage worldBackground= new GreenfootImage("neon background.jpg");
    GreenfootSound gameMusic = new GreenfootSound ("cyberpunk2099.mp3");
    GreenfootSound wakeup = new GreenfootSound ("WakeTheFUp.mp3");
    
    /**
     * Constructor for objects of class PingWorld.
     */
    public PingWorld(boolean gameStarted)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1,false); 
        //constructing world size, we used 'False' to ignore boundaries.
        
        if (gameStarted)
        //if game has started, initializes objects, sounds and resets scores.
        {
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
        showText("Score:  " + Score.getScore() + ".",60,25); //adds score onto screen.
        showText("Game Level:  " + Score.getLevel() + ".",87,45); //adds gamelevel onto screen.
        //run methods:
        PaddleBotsRespawn(); 
        Score.winConditionPlayer(); 
        Victory();
        Gameover();
    }
    
    /**
     * adds initial objects to the world.
     */
    private void initializeGameObjects()
    {
        addObject(new Ball(), WORLD_WIDTH/2, WORLD_HEIGHT/2);
        addObject(new PaddlePlayerOne(100,10), 250, WORLD_HEIGHT - 50);
        addObject(new PaddleComputer (100,10), 250, WORLD_HEIGHT - 650);
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
    private void PaddleBotsRespawn()
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
     * if loosing conditions are met, adds game over button.
     */
    public void Gameover()
    {
        if(Score.hasCPUWon == true && Score.hasPlayerWon != true)
        {
         addObject(new ButtonGameOver(this) , getWidth() / 2 , getHeight() / 2);
        }
    }
    
    /**
     * if winning conditions are met, adds game over button.
     */
    public void Victory()
    {
        if(Score.hasPlayerWon == true && Score.hasCPUWon != true)
        {
         addObject(new ButtonVictory(this) , getWidth() / 2 , getHeight() / 2);
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
    
   
