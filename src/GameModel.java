import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The game model handles the logic of the game (generating the numbers, etc.).
 * The instance of the model is used by the view-controller module
 * to trigger actions (for example, generate a new game) and retrieve information
 * about the current status of the game (the digits, the goal, etc.).
 *
 * Javier Beltran
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

    private String chaineChiffre;
    private int[] tabSuiteChiffre;
    private ArrayList<Integer> numberList;
    private ArrayList<Integer> idList;
    private int index = 0;

    /**
     * Constructeur de GameModel
     * met les chiffre aleatoire dans un tableau
     * met les caractere de chaque case du tableau dans un string
     */
    public GameModel(){

        int nombreRegroupement = getRandom(MAXREGROUPEMENT, MINREGROUPEMENT);

        //pour une nouvelle partie on va devoir reinitialiser les arraylist et le tableau
        tabSuiteChiffre = new int[nombreRegroupement];
        chaineChiffre = "";
        numberList = new ArrayList<>(Collections.nCopies(chaineChiffre.length(),0));
        idList = new ArrayList<>(chaineChiffre.length());

        for(int i = 0; i < nombreRegroupement; i++){

            tabSuiteChiffre[i] = nbAlea();
            chaineChiffre += String.valueOf(tabSuiteChiffre[i]);
        }
    }

    /**
     * Genere des chiffre ou des nombres aleatoires selon des bornes
     * @param borneSup Le plus grand nombres qui peux etre generer
     * @param borneInf le plus petit nombre qui peux etre generer
     * @return le nombre aleatoire
     */
    private int getRandom(int borneSup, int borneInf){

        Random chiffre = new Random();

        return chiffre.nextInt((borneSup - borneInf) + 1)  + borneInf;

    }

    /**
     * Genere des chiffre aleatoire selon une probabilite
     * @return Retourne les nombre aleatoire genere
     */
    private int nbAlea (){

        Random chiffre = new Random();

        double probabilite = chiffre.nextDouble();

        if(probabilite < 0.7){

            return getRandom(MAXCHIFFRE , MINCHIFFRE);

        }

        return getRandom(MAXNUMBER, MINNUMBER);
    }

    /**
     *
     * @return Retourne la somme total a atteindre
     */
    public int getGoal(){

        int goal = 0;

        for(int j = 0; j < tabSuiteChiffre.length; j++){

            goal = tabSuiteChiffre[j] + goal;
            System.out.print(tabSuiteChiffre[j]);
        }

        return goal;
    }

    public String getChaine() {

        return chaineChiffre;

    }

    public int getDigit (int n){

        return numberList.get(n);

    }

    public int getNextAvailableId(){

        int id = index++;
        idList.add(id);

        if(idList.contains(id) && id < chaineChiffre.length()){

            System.out.print(id);
            return id;

        }

        System.out.print(id);
        return id;

    }

    public void setNewGroup(int start){

        int id = getNextAvailableId();
        numberList.add(start, id);
        numberList.add(start + 1, id);

    }

    public void setNewSoloGroup(int start){

        numberList.add(start, getNextAvailableId());

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
