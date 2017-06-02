import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;

/**
 * The view-controller class handles the display (tiles, buttogit guins, etc.)
 * and the user input (actions from selections, clicks, etc.).
 *
 */
public class GameViewController extends JPanel {

	/**
	 * Instance of the game (logic, state, etc.)
	 */
	private GameModel gameModel;

	/**
	 * A single tile panel displays all the tiles of the game
	 */
	private TilePanel tilePanel ;
	private JPanel pane ;
	private JPanel panelDroit ;
	private JPanel panelGauche ;
	
	// TODO Add all the other required UI components (labels, buttons, etc.)
    private JButton reset = new JButton("Reset");
    private JButton next = new JButton("Next");
    private JButton giveUp = new JButton("Give Up");
    private JButton findMean = new JButton("Find Mean");

    private JLabel goal = new JLabel("Goal: ", SwingConstants.CENTER);
    private JLabel currentSum = new JLabel("Current Sum: ", SwingConstants.CENTER);
	
	private void setupListeners() {
		// TODO Set up the required listeners on the UI components (button clicks, etc.)
		
		// Example of a mouse listener with a click event
		tilePanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {

			    if(e.getSource() == reset){

                }else if(e.getSource() == next){

                }else if(e.getSource() == giveUp){

                }else if(e.getSource() == findMean) {

                }

            }
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
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
		pane = new JPanel(new GridLayout(2,1));
		panelDroit = new JPanel(new GridLayout(1,1));
		panelGauche = new JPanel(new GridLayout(1,2));

		this.add(tilePanel);

        panelDroit.add(goal);
        panelDroit.add(currentSum);

		panelGauche.add(reset);
        panelGauche.add(next);
        panelGauche.add(giveUp);
        panelGauche.add(findMean);

		// TODO Initialize all the UI components
		
		setupListeners();
	}
	
}
