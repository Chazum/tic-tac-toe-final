import java.util.Scanner;
/**
 * A human Tic-tac-toe player that reads moves from the keyboard.

 * @author Chaz Harrison    
 * @version 10/30/21
 */

public class HumanPlayer extends APlayer
{
     
    
    public HumanPlayer(Game game, char symbol){
        this.game = game;
    }
    
    char symbol = 'X';

    /**
     * Asks the user to pick a move. Moves are entered from the keyboard and are specified 
     * by two characters rchar and cchar (rc) where rchar is a letter representing the row 
     * and cchar is a digit representing the column. For instance a1 means the 1st column 
     * of the first row and c2 means the 2nd column of the 3rd row. 
     * If the user enters a position that is outside the bound of the game board or a position
     * that is already occupied, an appropriate error message is shown and 
     * the user is asked for another position. If the user writes 'exit' (regardless of case),
     * the method returns null.
     * The player then has the option to either start a new game or quit the session.
     */
    public Move pickMove(){
        Scanner playerMove = new Scanner(System.in);
        char rchar = ' ';
        char cchar = ' ';
        Move chosenMove;
        while (true){
            System.out.println("Enter a move");
            String pcMove = playerMove.next();
            if (pcMove.equals("exit")){
                chosenMove = null;
                break;
            }
            else if (pcMove.length() != 2){
                System.out.println("Error! Move can only consist of one letter and number. Try again.");
                continue; 
            }
            
            if(pcMove.length() == 2){
            String rString = pcMove.substring(0,1).toUpperCase();
            rchar = rString.charAt(0);
            int rInt = (int)(rchar - 'A');
            cchar = pcMove.charAt(1);
            String cString = "" + cchar;
            int cInt;
            try{
            cInt = Integer.parseInt(cString)-1;}
            catch (NumberFormatException e){
                System.out.println("Error. Move can only consist of one letter and number. Try again.");
                continue;
            }
            chosenMove = new Move(rInt, cInt);
            if (game.isValidMove(chosenMove) == 'V'){
                break;
            }
            else {
                System.out.println("Error. This slot is already filled. Try again.");
            }
        }
        }
        return chosenMove;
    }
}

