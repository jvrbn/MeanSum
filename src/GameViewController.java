import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.util.Random;


/**
 * The view-controller class handles the display (tiles, buttogit guins, etc.)
 * and the user input (actions from selections, clicks, etc.).
 *
 * Javier Beltran
 */
public class GameViewController extends JPanel {

    /**
     * Instance of the game (logic, state, etc.)
     */
    private GameModel gameModel;

    /**
     * A single tile panel displays all the tiles of the game
     */
    private TilePanel tilePanel;

    // TODO Add all the other required UI components (labels, buttons, etc.)
    private JButton reset;
    private JButton next;

    private JButton buttonGroup[];

    private JButton premierSelectionner;
    private JButton dernierSelectionner;

    private JLabel goal;
    private JLabel currentSum;

    private int sommeCourante = 0;

    private Color[] couleur;
    private Color couleurTemporaire;

    private String suiteChiffre;


    /**
     *On ajoute les ecouteur au bouton next et reset
     */
    private void setupListeners() {
        // TODO Set up the required listeners on the UI components (button clicks, etc.)

        next.addActionListener(new Action());
        reset.addActionListener(new Action());

        // Example of a mouse listener with a click event

    }

    /**
     * Les boutons sont mis dans le paneau
     */
    public GameViewController() {
        // TODO Initialize our game model
        gameModel = new GameModel();

        suiteChiffre = gameModel.getChaine();

        tilePanel = new TilePanel(gameModel);

        reset = new JButton("Reset");
        next = new JButton("Next");
        goal = new JLabel("Goal: " + gameModel.getGoal(), SwingConstants.CENTER);
        currentSum = new JLabel("Current Sum: " +sommeCourante, SwingConstants.CENTER);

        buttonGroup = new JButton[suiteChiffre.length()];

        for (int i = 0; i < suiteChiffre.length(); i++) {

            tilePanel.setLayout(new GridLayout());
            buttonGroup[i] = new JButton();
            tilePanel.add(buttonGroup[i]);
            buttonGroup[i].setText(String.valueOf(suiteChiffre.charAt(i)));
            buttonGroup[i].setBackground(Color.WHITE);
            buttonGroup[i].addMouseListener(new Mouse());

        }

        // The layout defines how components are displayed
        // (here, stacked along the Y axis)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(tilePanel);
        this.add(reset);
        this.add(next);
        this.add(goal);
        this.add(currentSum);

        // TODO Initialize all the UI components

        setupListeners();

    }

    /**
     * Si le bouton next est appuyer, on creer une nouvelle partie donc un nouveau GameModel
     * Si le bouton reset est appuyer, la somme redevient a 0 et la couleur redevient blanc
     */
    public class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == next) {

                gameModel = new GameModel();
                goal.setText("Current goal: "+gameModel.getGoal());
                tilePanel.removeAll();
                tilePanel = new TilePanel(gameModel);

            } else if (e.getSource() == reset) {

                for (int i = 0; i < gameModel.getChaine().length(); i++) {

                    buttonGroup[i].setBackground(Color.WHITE);
                    sommeCourante = 0;

                }
            }
        }
    }

    /**
     *  Strategie, je voulais selectionner un bouton puis drag jusqu'au second bouton si
     *  desirer, j'ai creer une couleurTemporaire afin de garder la meme couleur pour 2 cases
     *  choisi en meme temps
     */
    public class Mouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }



        //change la couleur du button
        public void mouseReleased(MouseEvent e) {


            dernierSelectionner = (JButton) e.getComponent();

            if(dernierSelectionner != premierSelectionner){

                dernierSelectionner.setBackground(couleurTemporaire);

            }
            int nombre = Integer.parseInt(premierSelectionner.getText()) * 10 +
                                                                        Integer.parseInt(dernierSelectionner.getText());
            sommeCourante = sommeCourante + nombre;
            currentSum.setText("Current sum: " +sommeCourante);
        }

        //change la couleur du boutton selectionner
        @Override
        public void mousePressed(MouseEvent e) {

            Random rd = new Random();
            int couleurAleatoire = rd.nextInt(12);
            couleur = tilePanel.getTileColours();

            couleurTemporaire = couleur[couleurAleatoire];

            premierSelectionner = (JButton) e.getComponent();
            premierSelectionner.setBackground(couleurTemporaire);

        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {


        }

    }
}
