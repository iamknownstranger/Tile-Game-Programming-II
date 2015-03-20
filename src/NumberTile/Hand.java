package NumberTile;
/**
 * A class that models a player's hand that holds five Number Tile objects
 * 
 * @author Jahkell Lazarre
 */
public class Hand {

    public NumberTile[] tiles;
    
    /**
     * Constructs a player's hand with five Number Tile objects
     */
    public Hand() {

        tiles = new NumberTile[5];  //create a Tile Array with 5 null spaces 

        for (int i = 0; i < 5; i++) {   //assigns 5 NumberTiles to hand       

            NumberTile newTile = new NumberTile();

            this.tiles[i] = newTile;

        }

    }
    
    /**
     * Appends a new tile to hand and resizes the hand's array to accommodate
     * new tile
     * 
     * @param tile NumberTile to be appended to hand
     */
    public void add(NumberTile tile) {

        NumberTile[] tempArray = new NumberTile[this.tiles.length + 1];

        System.arraycopy(this.tiles, 0, tempArray, 0, tiles.length);

        this.tiles = tempArray;     //adds and resizes to add extra tile to
                                    //hand

        this.tiles[this.tiles.length - 1] = tile;

    }
    /**
     * Removes the NumberTile from hand at specific index
     * 
     * @param index array position of object desired to be removed
     */

    public void remove(int index) {

        if (index == 0) {     //resizes Array to remove object at stated index

            NumberTile[] tempArray = new NumberTile[this.length() - 1];

            System.arraycopy(this.tiles, 1, tempArray, 0, this.length() - 1);

            this.tiles = tempArray;

        }

        if (index > 0 && index < this.length() - 1) { //resizes Array to 
                                    //remove object at stated index

            NumberTile[] tempArray = new NumberTile[this.length() - 1];

            System.arraycopy(this.tiles, 0, tempArray, 0, index);

            System.arraycopy(this.tiles, index + 1, tempArray, index, (this.length() - 1)
                    - index);

            this.tiles = tempArray;

        }

        if (index == this.length() - 1) { //resizes Array to remove object 
                                          //at stated index

            NumberTile[] tempArray = new NumberTile[this.length() - 1];

            System.arraycopy(this.tiles, 0, tempArray, 0, index);

            this.tiles = tempArray;

        }

    }
    /**
     * Gets the amount of NumberTiles in player's hand
     * 
     * @return the amount of elements (tiles) in hand
     */
    public int length() {

        return this.tiles.length; // return the amount of tiles in Hand

    }

    /**
     * Get the hand as a String
     *
     * @return the hand as a multi-line String
     */
    @Override
    public String toString() {
        String string = "";

        for (int i = 0; i < this.length(); i++) {  //returns the NumberTiles
                                           // in Hand in string form
            string = string + this.tiles[i].toString();
        }

        return string;
    }

}
