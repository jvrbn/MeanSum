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

    private int [] tabSuiteChiffre;

    public int[] getTabSuiteChiffre() {

        return tabSuiteChiffre;

    }

    public GameModel(){

        int nombreRegroupement = getRandom(MAXREGROUPEMENT, MINREGROUPEMENT);

        tabSuiteChiffre = new int[nombreRegroupement];

        for(int i = 0; i < nombreRegroupement; i++){

            tabSuiteChiffre[i] = nbAlea();

        }
    }

    private int getRandom(int borneSup, int borneInf){

        Random chiffre = new Random();

        return chiffre.nextInt((borneSup - borneInf) + 1)  + borneInf;

    }

    private int nbAlea (){

        Random chiffre = new Random();

        double probabilite = chiffre.nextDouble();

        if(probabilite < 0.7){

            return getRandom(MAXCHIFFRE , MINCHIFFRE);

        }

        return getRandom(MAXNUMBER, MINNUMBER);
    }

    public int getGoal(){

        GameModel game = new GameModel();

        int goal = 0;

        for(int i = 0; i < game.tabSuiteChiffre.length; i++){

            goal += game.tabSuiteChiffre[i];

        }

        return goal;
    }



    /**public static void main(String [] args) {

        for (int n = 0; n < 50; ++n) {
            GameModel gm = new GameModel();

            System.out.print("[ ");
            for (int i = 0; i < gm.tab.length; ++i) {
                System.out.print(gm.tab[i] + " ");
            }
            System.out.println("]");
        }
    }*/
}
