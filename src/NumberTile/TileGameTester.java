package NumberTile;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Jahkell Lazarre
 */
public class TileGameTester {

    public static void main(String[] args) {

        String input;

        do {
            TileGame game = new TileGame();

            NumberTile[] board = game.getBoard();

            Hand hand1 = new Hand();

            Hand hand2 = new Hand();

            System.out.println("****** Initial Hand 1 ******\n"
                    + hand1.toString()
                    + "\n****** Initial Hand 2 ******\n" + hand2.toString());
            
            do {
                game.makeMove(hand1);

                game.makeMove(hand2);
            
            } while (hand1.length() > 0 && hand2.length() > 0);

            System.out.println("****** Final Board ******\n"
                    + game.toString() + "\n****** Final Hand 1 ******\n"
                    + hand1.toString() + "\n****** Final Hand 2 ******\n"
                    + hand2.toString());

            if (hand1.length() == 0 && !(hand2.length() == 0)) {

                System.out.println("****** Winner is Hand 1! ******");

            }

            if (hand2.length() == 0 && !(hand1.length() == 0)) {

                System.out.println("****** Winner is Hand 2! ******");

            }

            if (hand2.length() == 0 && hand1.length() == 0) {

                System.out.println("****** Both Hands are Winners!"
                        + " - Tie ******");

            }

            input = JOptionPane.showInputDialog("Play another game?"
                    + " (type Y to play again or type any other key to quit)");

        } while (input.equalsIgnoreCase("Y"));

    }

}
