package NumberTile;
import java.util.Random;
/**
 * A class that models a numbered tile object -- the tile has 4 corners and 
 * each corner is labeled with a random integer between 1 and 9
 *
 * @author Jahkell Lazarre
 */
public class NumberTile {

    public int [] tile;
    private static int TILE_LIMIT = 4;  //tile should only have 4 numbers!

    /**
     * Constructs a NumberTile object using 4 random integers in the range 1 
     * to 9
     */
    public NumberTile() {

        tile = new int [TILE_LIMIT];

        Random generator = new Random();

        for (int i = 0; i < 4; i++) {   //generates 4 random integers (1-9) and
                                      //puts them on each side of tile
            tile[i] = (generator.nextInt(9) + 1);
            
            
        }

    }

    /**
     * Rotates the tile 90 degrees
     */
    public void rotate() {

        int temp;

        for (int i = 0; i < this.tile.length - 1; i++) {

            temp = this.tile[i + 1];    //rotate number tile 90 degrees
            this.tile[i + 1] = this.tile[0];
            this.tile[0] = temp;

        }

    }

    /**
     * Gets the number that labels the left corner of the tile
     *
     * @return the left number on the tile
     */
    public int getLeft() {
        
        return tile[0];             //returns left-side number of tile
    }

    /**
     * Gets the number that labels the right corner of the tile
     *
     * @return the right number on the tile
     */
    public int getRight() {
        
        return tile[2];             //returns right-side number of tile
    }

    /**
     * Returns the tile as a string      *
     * @return the tile as a string
     */
    
    
    public String toString() {
                                    //returns tile numbers in a diamond-like
                                    //fashion!
        String out = "\n   " + this.tile[1] + "\n" + this.tile[0] + 
                "     " + this.tile[2] + "\n   " + this.tile[3] + "   ";

        return out;
    }

} // end of NumberTile class
