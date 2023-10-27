import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a helper class which controls the score, and it should also be
 * used to increase speed, also be used to count actual score and level?
 */
public class Score extends Actor
{   
    public static boolean hasPlayerWon = false;
    public static boolean hasCPUWon = false;
    public static boolean hasP1Won = false;
    public static boolean hasP2Won = false;
    private static int LEVEL = 1;  // difficulty, increases by every 10 score
    private static int SCORE = 0; // Total times of the ball hitting player one paddle
    private static int CPUSCORE = 0;   // Used to count to 1, so that CPUWIN increases by one.
    private static int P1SCORE = 0;    // numbers of times the ball has his the ceiling in multiplayer
    private static int P2SCORE = 0;    // number of times the ball has his the floor in multiplayer
        
    /**
     * Use score to increase level by 1 for each 10 score. then for each level increase the speed of the game.
     */ 
    
    public static void increaseScore(int amount)
    {
        SCORE += amount; // same as SCORE = SCORE + amount;
        if(SCORE % 10 == 0)
        {
            increaseLevel();
        }
    }
    
    /**
     * resets variables.
     */
    public static void resetScore()
    {
        LEVEL = 1;
        SCORE = 0;
        P1SCORE = 0;
        P2SCORE = 0;
        CPUSCORE = 0;
        hasCPUWon = false;
        hasPlayerWon = false;
        hasP1Won = false;
        hasP2Won = false;
    }
    
    /**
     * level increment
     */
    public static void increaseLevel()
    {
        LEVEL++;
    }
    
    
    // SINGLEPLAYER CODE
    
    
    /**
     * winning conditions for the player in single player.
     */
    public static void winConditionPlayer()
    {
        if(!hasPlayerWon && SCORE == 50 )
        {
            hasPlayerWon = true;
            
        }
    }
    
    /**
     * win conditions for the computer in single player.
     */
    public static void winConditionCPU()
    {
        if (!hasCPUWon && CPUSCORE == 1)
        {
            hasCPUWon = true;
        }
    }
    
    /**
     * returns the SCORE variables. 
     */
    public static int getScore()
    {
        return SCORE;
    }
    
    /**
     * returns the LEVEL variable.
     */
    public static int getLevel()
    {
        return LEVEL;
    }
    
    /**
     * returns the CPUSCORE variable.
     */
    public static int getCPUScore()
    {
        return CPUSCORE;
    }
    
    /**
     * CPUSCORE increment.
     */
    public static void increaseCPUScore()
    {
        CPUSCORE++;
    }

    
    
    
    // MULTIPLAYER CODE
    
    
    
    /**
     * winning conditions for either player 1 or 2 in multiplayer. 
     */
    public static void winConditionMultiplayer()
    {
        if (!hasP1Won && P1SCORE == 5)
        {
            hasP1Won = true;
        }
        if (!hasP2Won && P2SCORE == 5)
        {
            hasP2Won = true;
        }
    }
        
    /**
     * P1SCORE increment.
     */
    public static void increaseP1Score()
    {
        P1SCORE++;
    }
    
    /**
     * P2SCORE increment. 
     */
    public static void increaseP2Score()
    {
        P2SCORE++;
    }
    
    /**
     * returns the P1SCORE variable.
     */
    public static int getP1Score()
    {
        return P1SCORE;
    }
    
    /**
     * returns the P1SCORE variable. 
     */
    public static int getP2Score()
    {
        return P2SCORE;
    }
}
