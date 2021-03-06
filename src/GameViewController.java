import java.awt.*;
import java.awt.event.*;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.util.Random;


/**
 * The view-controller class handles the display (tiles, buttogit guins, etc.)
 * and the user input (actions from selections, clicks, etc.).
 * <p>
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

    private JButton next;
    private JButton reset;
    private JLabel goal;
    private JLabel currentSum;
    private JLabel textNombre;
    private int nombreRegroupement;
    private String chaineChiffre;

    private int tileIdPressed;
    private int tileIdRelease;


    private void setupListeners() {
        // TODO Set up the required listeners on the UI components (button clicks, etc.)

        reset.addActionListener(new Action());
        next.addActionListener(new Action());

        // Example of a mouse listener with a click event
        tilePanel.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {

                //compare ou je relache avec la position garder en memoire
                tileIdRelease = tilePanel.getTileId(e.getX(),e.getY());

                if(tileIdRelease == tileIdPressed){

                    gameModel.setNewSoloGroup(tileIdPressed);
                    System.out.print(tileIdPressed);

                }

                else if(tileIdRelease < tileIdPressed && tileIdRelease != -1){

                    int tileTmp = tileIdRelease;
                    tileIdRelease = tileIdPressed;
                    tileIdPressed = tileTmp;

                    gameModel.setNewGroup(tileIdPressed);
                    System.out.print(tileIdPressed);
                }

                else if(tileIdRelease == -1){

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

                //garder la position en memoire
                tileIdPressed = tilePanel.getTileId(e.getX(),e.getY());

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                tilePanel.changeColour();
            }
        });
    }

    public GameViewController() {
        // TODO Initialize our game model
        gameModel = new GameModel();

        // The layout defines how components are displayed
        // (here, stacked along the Y axis)
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tilePanel = new TilePanel(gameModel);
        this.add(tilePanel);

        chaineChiffre = gameModel.getChaine();

        // TODO Initialize all the UI components

        reset = new JButton("Reset");
        next = new JButton("Next");
        goal = new JLabel("Goal: " + gameModel.getGoal(), SwingConstants.CENTER);
        currentSum = new JLabel("Current Sum: ", SwingConstants.CENTER);
        textNombre = new JLabel("");

        this.add(reset);
        this.add(next);
        this.add(goal);
        this.add(currentSum);


        setupListeners();
    }

    public class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == next) {

                tilePanel.removeAll();
                goal.setText("Current goal: " + gameModel.getGoal());
                gameModel = new GameModel();
                tilePanel.repaint();

            } else if (e.getSource() == reset) {

                nombreRegroupement = 0;
                for (int i = 0; i < gameModel.getChaine().length(); i++) {


                }

                currentSum.setText("Current sum: (" + nombreRegroupement + ")");
            }
        }
    }
}
