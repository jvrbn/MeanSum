import org.omg.CORBA.PRIVATE_MEMBER;

import java.math.*;
import java.util.Random;

/**
 * The game model handles the logic of the game (generating the numbers, etc.).
 * The instance of the model is used by the view-controller module
 * to trigger actions (for example, generate a new game) and retrieve information
 * about the current status of the game (the digits, the goal, etc.).
 *
 */
public class GameModel {
	
	// TODO Implement attributes (list of numbers, etc.),
	// constructor, and methods (generation of a game, etc.)

    private static final int MAXREGROUPEMENT = 6;
    private static final int MINREGROUPEMENT = 3;
    private static final int MAXCHIFFRE = 9;
    private static final int MINCHIFFRE = 1;
    private static final int MAXNUMBER = 99;
    private static final int MINNUMBER = 10;

    public GameModel(){



    }

    public int nbAlea (){

        Random chiffre = new Random();
        double probabilite = chiffre.nextDouble();

        if(probabilite <= 0.7){

            return chiffre.nextInt((MAXCHIFFRE - MINCHIFFRE) + 1);

        }

        return chiffre.nextInt((MAXNUMBER - MINNUMBER) + 1);
    }
}
