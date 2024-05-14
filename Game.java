import java.util.Scanner;
/**
 * Represents a tic-tac-toe game.
 *
 * @author Chaz Harrison
 * @version 10/30/21
 */

public class Game
{

    //Fields
    /**
     * represents the game board as matrix of player symbols
     */
    char[][] board;
    /**
     * represents board size, a boardSize x boardSize matrix
     */
    final int boardSize;

    //constructor
    /**
     * Constructor for objects of class Game.

     */
    public Game(int boardSize){
        this.boardSize = boardSize;
        board = new char[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                board[i][j] = ' ';
            }
        }
    }

    //Methods
    /**
     * Returns the game board size.
     */

    public int getBoardSize(){
        return boardSize;
    }

    /**
     * Resets the game state so we can play again.
     */
    protected void resetGame(){
        Game gameNew = new Game(boardSize);
        Game game = gameNew;

    }
    
    /**
     * Validates a move made by the players
     */
    public char isValidMove(Move chosenMove){
        char out = ' ';

        if(chosenMove == null){
            out = 'Q';
        }
        else if (chosenMove.row >= boardSize || chosenMove.row < 0){
            out = 'R';
        }
        else if(chosenMove.col >= boardSize || chosenMove.col < 0){
            out = 'C';
        }
        else if (board[chosenMove.row][chosenMove.col] != ' '){
            out = 'P';
        }
        else out = 'V';

        //System.out.println(out);
        return out;
    }

    /**
     * Executes a valid move passed as an argument.
     */
    protected boolean executeMove(Move chosenMove, char symbol){
        boolean move = false;
        if (isValidMove(chosenMove) == 'V'){
            move = true;
            this.board[chosenMove.row][chosenMove.col] = symbol;
        }
        return move;
    }
    
    /**
     * Analyzes the board to determine the current game sate, then game state is returned as a character.

     */
    public char getGameStatus(){

        char gameStatus = '?';
        boolean rowWin = false;
        boolean colWin = false;
        boolean diagWinR = false;
        boolean diagWinL = false;
        boolean fullBoard = false;

        for (int i = 0; i < boardSize; i++){
            char rowSymbol = board[i][0];
            if (rowSymbol == ' '){
                continue;
            }
            for(int j = 0; j < boardSize; j++){
                if(board[i][j] != rowSymbol){
                    break;
                }
                if (j == boardSize - 1){
                    rowWin = true; 
                    gameStatus = rowSymbol;
                    break;
                }
            }
        }

        for (int j = 0; j < boardSize; j++){
            char colSymbol = board[0][j];
            if (colSymbol == ' '){
                continue;
            }

            for(int i = 0; i < boardSize; i++){
                if(board[i][j] != colSymbol){
                    break;
                }
                if (i == boardSize - 1){
                    colWin = true; 
                    gameStatus = colSymbol;
                    break;
                }
            }
        }

        char diagnolLeft = board[0][0];

        for(int i = 0; i < boardSize; i++){

            if(board[i][i] != diagnolLeft){
                break;
            }
            if (diagnolLeft == ' '){
                continue;
            }
            if(i == boardSize-1){
                diagWinL = true;
                gameStatus = diagnolLeft;
                break;
            }
        }

        char diagnolRight = board[0][boardSize - 1];
        for(int i = 0, j = boardSize-1; i < boardSize; i++, j--){
            if(board[i][j] != diagnolRight || diagnolRight == ' '){
                break;
            }
            if(i == boardSize-1){
                diagWinR = true;
                gameStatus = diagnolRight;
                break;
            }
        }

        //Name the outer loop so that we can break out of both loops from the inner loop
        //I found this s65rtgrt265olution by looking up how to break out of two loops
        //The outer loop is usually named "outer" but I decided to name it steve instead
        steve: for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                if (board[i][j] == ' '){
                    fullBoard = false;
                    break steve;   
                }
                else fullBoard = true;
            }
        }

        if (fullBoard == true && gameStatus == '?'){
            gameStatus = 'T';
        }
        return gameStatus;

    }
    
    /**
     * Plays a single game of Tic-tac-toe by having players pick moves in turn until a win condition is met.
     */

    public char playSingleGame(){
        HumanPlayer newPlayer = new HumanPlayer(this, 'X');
        CpuPlayer newCPU= new CpuPlayer(this, 'O');
        char winner = ' ';
        boolean isGameOver = false;
        double order = Math.random();
        if (order > 0.5){

            while (!isGameOver){
                Move playerMove = newPlayer.pickMove();
                if (playerMove == null) 
                {isGameOver = true;
                    winner = 'Q';
                    break;
                }

                executeMove(playerMove, 'X');
                System.out.println(toString());

                if (getGameStatus() == 'X'){
                    isGameOver = true;
                    winner = 'H';
                    break;
                }

                if (getGameStatus() == 'T'){
                    isGameOver = true;
                    winner = 'T';
                    break;
                }

                executeMove(newCPU.pickMove(), 'O');
                System.out.println(toString());

                if (getGameStatus() == 'O'){
                    isGameOver = true;
                    winner = 'C';
                    break;
                }

                if (getGameStatus() == 'T'){
                    isGameOver = true;
                    winner = 'T';
                    break;
                }
            }
        }
        if (order <= 0.5){

            while (!isGameOver){
                executeMove(newCPU.pickMove(), 'O');

                System.out.println(toString());

                if (getGameStatus() == 'O'){
                    isGameOver = true;
                    winner = 'C'; 
                    break;
                }

                if (getGameStatus() == 'T'){
                    isGameOver = true;
                    winner = 'T';
                    break;
                }

                Move playerMove = newPlayer.pickMove();
                if (playerMove == null) 
                {isGameOver = true;
                    winner = 'Q';
                    break;
                }

                executeMove(playerMove, 'X');
                System.out.println(toString());

                if (getGameStatus() == 'X'){
                    isGameOver = true;
                    winner = 'H';
                    break;
                }

                if (getGameStatus() == 'T'){
                    isGameOver = true;
                    winner = 'T';
                    break;
                }

            }
        }
        return winner;
    }
    
    /**
     * Creates a textual representation of the game board
     */
    public String toString(){
        int bsize = getBoardSize();
        String colLabel = "";
        for(int col = 0; col < bsize; col++){
            colLabel = colLabel+ "   " + (col + 1);
        }

        char rowLabel = 'A';

        String dashes = "";
        for(int col = 0; col < bsize; col++){
            if (col == 0){
                dashes = dashes + " ---|";
            }
            else if(col == bsize-1){
                dashes = dashes + "---"; 
            }
            else { dashes = dashes + "---|";}
        }

        String s = colLabel + "\n";
        for(int row = 0; row < bsize; row++){
            for (int col = 0; col < bsize; col++){
                if (col == bsize-1 && row != bsize-1){
                    s = s + " " + board[row][col] + "\n " + dashes +" \n";
                }
                else if(col == bsize-1 && row == bsize-1){
                    s = s + " " + board[row][col];
                }
                else if (col != bsize-1) {
                    if (col == 0){
                        s = s + (rowLabel) + " ";
                        rowLabel++;
                    }
                    s = s + " " + board[row][col] + " |";
                }

            }
        }
        return s;
    }
    
    /**
     * Plays a Tic-tac-toe game and then asks the user if they want to keep playing.
     * Player then can choose to end the session or start a new game
     * Prints the results and statistics of every game for the session.
     */
    public static void main (String[] args){
        int boardSize = 3;
        try {boardSize = Integer.parseInt(args[0]);}
        catch (Exception NumberFormatException){
            System.out.println("Invalid board size. Board size defaulted to 3 X 3");
        }

        if (boardSize < 1 || boardSize > 9){
            System.out.println("Invalid board size. Board size defaulted to 3 X 3");
            boardSize = 3;
        }
        System.out.println("Welcome to Tic-Tac-Toe");
        boolean ender = false;
        GameStats scoreboard = new GameStats();

        while(!ender){
            Game game = new Game(boardSize);
            System.out.println(game.toString());
            Scanner playAgain = new Scanner(System.in);
            System.out.println("Pick a move. Type 'exit' to end game.");
            while (true){
                char gameResult = game.playSingleGame(); 
                if (gameResult == 'H'){
                    System.out.println("You win!"); 
                    scoreboard.recordWin();
                    System.out.println(scoreboard);
                    break;

                }  

                else if (gameResult == 'C') {
                    System.out.println("CPU wins!");
                    scoreboard.recordLoss();
                    System.out.println(scoreboard);
                    break;
                }

                else if (gameResult == 'T') {
                    System.out.println("It's a tie!");
                    scoreboard.recordTie();
                    System.out.println(scoreboard);
                    break;
                }
                if (gameResult == 'Q'){
                    System.out.println("Thanks for playing!");
                    break;
                }
            }
            System.out.println("Play again?");
            System.out.println("Enter 'yes' to play again, 'no' to quit");
            while(true){
                String response = playAgain.next();
                if(response.equals("no")){
                    System.out.println("Session Ended. Thanks for playing!");
                    ender = true; 
                    break;
                }
                else if(response.equals("yes")){
                    break;
                }
                else if(!response.equals("yes") && !response.equals("no")){
                    System.out.println("Invalid command, try again.");
                }
            }
        } 
    }
}
