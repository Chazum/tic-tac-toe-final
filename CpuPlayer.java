
/**
 * A computer-controlled Tic-tac-toe player that implements a random playing strategy.
 *
 * @author Chaz Harrison
 * @version 10/30/21
 */

public class CpuPlayer extends APlayer
{
    
    /**
     * Constructor for objects of class CpuPlayer
     */
    
    public CpuPlayer(Game game, char symbol){
        this.game = game;
    }

    /**
     * The symbol of the computer player, in this case 'O'
     */
    char symbol = 'O';
    
    /**
     * Picks a move uniformly at random. 
     * It does this by generating random moves within the game board boundaries 
     * until it finds an unnocupied position. Assumes the game isn't over yet, 
     * otherwise it'd go into an infinite loop.
     */
    
    public Move pickMove(){
        Move chosenMove = new Move(-1, 1);
        do{
        int randomRow = (int)Math.floor(Math.random()*(9-1+1)+1)-1;
        int randomCol = (int)Math.floor(Math.random()*(9-1+1)+1)-1;
        chosenMove = new Move(randomRow, randomCol);
        //System.out.println(randomRow + " " + randomCol);
    
    } while (game.isValidMove(chosenMove) != 'V'); 
        return chosenMove;
    

}
}
