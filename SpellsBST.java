import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Example SpellsBST: a version of the Spells program that
 * uses a BST of Associations
 *
 * @author Jim Teresco
 * @version Fall 2020
 */

public class SpellsBST {

    /**
    Create an BST of Association objects representing Harry
    Potter spells, and look up spell actions by name.

    @param args not used
    @throws IOException
     */
    public static void main(String args[]) throws IOException {

        final int NUM_SPELLS = 10;
        // create an ArrayList of the magic spells we know.
        // Note: due to the way Java handles arrays and generic types,
        // we have to leave off the <String,String> in the construction..
        BinarySearchTreeT<ComparableAssociation<String,String>> spells = 
            new BinarySearchTreeT<ComparableAssociation<String,String>>();
        Scanner inFile = new Scanner(new File("spells.txt"));
        for (int i = 0; i < NUM_SPELLS; i++) {
            String spell = inFile.nextLine().trim();
            String action = inFile.nextLine().trim();

            spells.add(new ComparableAssociation<String,String>(spell, action));
        }
        inFile.close();

        // we play a little game matching spells to descriptions
        // until an invalid spell is specified
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print("Which spell will you use? ");
            String spellName = keyboard.next();
            ComparableAssociation<String,String> spellAssoc = spells.get(new ComparableAssociation<String,String>(spellName));
            if (spellAssoc != null) {
                System.out.println(spellAssoc.getValue());
            }
            else {
                System.out.println("Your wand doesn't know that one.  It explodes.  Bye!");
                done = true;
            }
        }
    }
}
