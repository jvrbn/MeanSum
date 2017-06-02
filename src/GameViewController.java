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
	
	// TODO Add all the other required UI components (labels, buttons, etc.)
    private JButton reset;
    private JButton next;
    private JButton giveUp;
    private JButton findMean;

    private JLabel goal ;
    private JLabel currentSum;
    private JTextArea textGoal;
    private JTextArea textCurrentSum;
	
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

        reset = new JButton("Reset");
        next = new JButton("Next");
        giveUp = new JButton("Give Up");
        findMean = new JButton("Find Mean");
        goal = new JLabel("Goal: ", SwingConstants.CENTER);
        currentSum = new JLabel("Current Sum: ", SwingConstants.CENTER);

		// The layout defines how components are displayed
		// (here, stacked along the Y axis)
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		tilePanel = new TilePanel(gameModel);

		this.add(tilePanel);
		this.add(reset);
		this.add(next);
		this.add(giveUp);
		this.add(findMean);
		this.add(goal);
		this.add(currentSum);


		// TODO Initialize all the UI components
		
		setupListeners();
	}
	
}
