import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Example SpellsArrayListAssociation: a version of the Spells program that
 * uses an ArrayList of Associations
 *
 * @author Jim Teresco
 * @version Fall 2020
 */

public class SpellsArrayListAssociation {

    /**
       Create an array of Association objects representing Harry
       Potter spells, and look up spell actions by name.

       @param args not used
       @throws IOException
    */
    public static void main(String args[]) throws IOException {

	final int NUM_SPELLS = 10;
        // create an ArrayList of the magic spells we know.
        // Note: due to the way Java handles arrays and generic types,
        // we have to leave off the <String,String> in the construction..
        ArrayList<Association<String,String>> spells = new ArrayList<Association<String,String>>();
	Scanner inFile = new Scanner(new File("spells.txt"));
	for (int i = 0; i < NUM_SPELLS; i++) {
	    String spell = inFile.nextLine().trim();
	    String action = inFile.nextLine().trim();
       
	    spells.add(new Association<String,String>(spell, action));
	}
	inFile.close();

        // we play a little game matching spells to descriptions
        // until an invalid spell is specified
        Scanner keyboard = new Scanner(System.in);
        int spellnum = 0;
        while (spellnum >= 0) {
            System.out.print("Which spell will you use? ");
            String spellName = keyboard.next();
            spellnum = spells.indexOf(new Association<String,String>(spellName));
           if (spellnum >= 0) {
                System.out.println(
                spells.get(spellnum).getValue());
            }
            else {
                System.out.println("Your wand doesn't know that one.  It explodes.  Bye!");
            }
        }
    }
}
