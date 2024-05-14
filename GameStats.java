
/**
 * Stores and updates the stats of the game
 *
 * @author Chaz Harrison
 * @version 10/30/21
 */
public class GameStats
{
    /**
     * represents the number of games won by the human player, so far

     */
    int nwins = 0;
    /**
     * represents the number of games that ended in a tie, so far

     */
    int nties = 0;
    /**
     * represents the number of games lost by the human player, so far

     */
    int nlosses = 0;
    
    /**
     * Constructor for objects of class GameStats.

     */
    
    public GameStats(){
        this.nwins = nwins;
        this.nties = nties;
        this.nlosses = nlosses;
    }
    
    /**
     * Increments the number of human wins.

     */
    public void recordWin(){
        nwins++;
    }
    
    /**
     * Increments the number of ties.

     */
    public void recordTie(){
        nties++;
    }
     /**
     * Increments the number of CPU wins/human losses.

     */
    public void recordLoss(){
        nlosses++;
    }
    
    /**
     * Returns a textual representation of the statistics contained in this object.

     */
    public String toString(){
        double winRate = (nwins /((double)nwins+nlosses+nties)*100);
        double tieRate = (nties /((double)nwins+nlosses+nties)*100);
        double lossRate = (nlosses /((double)nwins+nlosses+nties)*100);
        
        String games = ("Games won: " + nwins + " (" + winRate + "%) | Games lost: " +
        nlosses + " (" + lossRate + "%) | Games tied: " + nties +" (" + tieRate + "%)");
        String stats = (games + "\nYou won: " + winRate + "% of games played!");
        return stats;
    }
    
}
