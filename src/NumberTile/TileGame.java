package NumberTile;
import java.util.ArrayList;
/**
 * A class that models a Tile game -- the goal of the game is to have two
 * computer players play against each other and whomever has no tiles left in
 * their hand wins the game
 *
 * @author Jahkell Lazarre
 */
public class TileGame {

    private NumberTile[] board;

    /**
     * Creates an empty board and then adds a tile to the board
     */
    public TileGame() {
        board = new NumberTile[1];

        NumberTile initialBoardTile = new NumberTile();

        board[0] = (initialBoardTile); //generates board with one initial Tile

    }

    /**
     * Gets the board in which the players play on
     *
     * @return board to play tile game
     */
    public NumberTile[] getBoard() {
        // Do not modify this method
        return board;
    }
    /**
     * Creates an extra place for a NumberTile to be positioned
     * 
     * @param index the position at which the Board will open space up for
     */
    private void resizeBoard(int index) {

        NumberTile[] temp;

        if (index == 0) {                       //resizes board Array

            temp = new NumberTile[board.length + 1]; 

            System.arraycopy(board, 0, temp, 1, //creates copy of Board
                    board.length); 

            board = temp;                           

        }

        if (index > 0 && index < board.length) {   //resizes board Array

            temp = new NumberTile[board.length + 1];

            System.arraycopy(board, 0, temp, 0, index);

            System.arraycopy(board, index, temp, //creates a copy of Board
                    index + 1, board.length - index);

            temp[index] = null;

            board = temp;                           

        }

        if (index == board.length) {                //resizes board Array

            temp = new NumberTile[board.length + 1];

            System.arraycopy(board, 0, temp, 0, board.length); //creates copy
                                                        //of Board

            temp[temp.length - 1] = null;

            board = temp;                       

        }

    }

    /**
     * Finds the index or position that the tile can be placed on board without
     * rotating -- if there isn't an index for proper fit, method returns a -1
     *
     * @param currentTile tile to get index for fit
     * @return index for fit
     */
    public int getIndexForFit(NumberTile currentTile) {

        int index = -1;

        for (int i = 0; i < 1; i++) {   //determines a match for 
                                //the currentTile's right-side number with the 
                                //left of the Board's first tile

            if (currentTile.getRight() == board[i].getLeft()) {

                index = i;          
            }

        }

        for (int i = 1; i < board.length - 1; i++) {//determines a match for 
                            //the currentTile between any two tiles on Board
                            

            if ((currentTile.getLeft() == board[i - 1].getRight())
                    && (currentTile.getRight() == board[i].getLeft())) {
                index = i;
            }
        }

        for (int i = board.length - 1; i < board.length; i++) { //determines
                         //a match for currentTile at right of last Board tile

            int k = board.length;

            if (currentTile.getLeft() == board[i].getRight()) {

                index = k;
            }

        }

        return index;
    }

    /**
     *
     * Determines whether the tile can be inserted on the board (with or without
     * rotation)
     *
     * @param currentTile the tile to determine whether there is a proper fit on
     * the board for it
     *
     * @return true or false - (can the tile be inserted on the board?)
     */
    public boolean canInsertTile(NumberTile currentTile) {

        if (this.getIndexForFit(currentTile) == -1) { //if current tile in Hand 
                                                      //can't fit...

            int index = -1;

            int i = 0;

            do {                                    

                currentTile.rotate();           //rotate 3 times to determine
                                                //fit and find index...

                index = this.getIndexForFit(currentTile);

                i++;

            } while (i < 3 && !(index >= 0));

            if (index >= 0) {           //if tile can fit, return true
                return true;
            } else {
                return false;           //if tile can't fit, return false
            }

        } else {                    //if there is a index for fit with current
                                    //tile without rotation, return true
            return true;
        }

    }

    /**
     * Game makes move if player's hand allows for it (if not, player picks up
     * an extra tile)
     *
     * @param hand the player's hand of tiles
     * @return if player can make move
     */
    public void makeMove(Hand hand) {

        int i = 0;

        boolean move = false;

        do {

            move = this.canInsertTile(hand.tiles[i]); //can player insert
                                            //current tile onto board?

            if (move == true) {             //if player can make move..

                NumberTile temp = hand.tiles[i];
                
                hand.remove(i);          //remove the tile from player's hand

                int indexForFit = this.getIndexForFit(temp); //get index for 
                                                             //fit

                resizeBoard(indexForFit);   //resize board to make room for
                                            //tile...

                board[indexForFit] = temp;  //and place tile onto Board 

            }

            i++;                    // move to next tile in player's hand

        } while (move == false && i < hand.length()); //continue the 
                                            //quest to find a fittable tile
                                     //on player's hand if player can't make
                              //move with previous tile and there are still
                              //tiles left in player's hand to select

        if (move == false) {        //if player can't make move...

            NumberTile extraTile = new NumberTile();

            hand.add(extraTile);            //make him pick up another one!

        }

    }

    /**
     * Get the board as a String
     *
     * @return the board as a multi-line String
     */
    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < board.length; i++) {    //display each tile on
                                                    //board
            string = string + board[i].toString();
        }

        return string;
    }
} // end of TileGame class 
