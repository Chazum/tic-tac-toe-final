
/**
 * Abstract class APlayer - 
 * An abstract class representing a generic Tic-tac-toe game player.

 *
 * @author Chaz Harrison
 * @version 10/30/21
 */
public abstract class APlayer
{
    
    //fields
    /**
     * the game the player is playing

     */
    Game game;
    
    /**
     * character to represent the player's moves on the board

     */
    
    char symbol = ' ';
    
    //constructors
    /**
     * Empty constructor for objects of class APlayer.
     */
    APlayer(){
    
    }
    
    /**
     * Constructor for objects of class APlayer.
     */
    APlayer(Game game, char symbol){
        
    }

   
}
