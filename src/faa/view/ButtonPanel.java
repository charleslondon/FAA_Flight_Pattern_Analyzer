package faa.view;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


/*
 * This class creates both the frame where the
 * save,open,filter,and limit buttons will be 
 * contained; in addition to creating the individual
 * buttons themselves.
 * 
 * @Author Charles London
 */
public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JButton save;
	private final JButton open;
	private final JButton visualize;
	private final JButton reset;
	
	/*
	 * Creates the frame that houses the JButtons
	 * Creates the individual buttons that will be
	 * displayed within the buttonPanel frame.
	 * 
	 * @param Takes in a GridLayout for organizing the display
	 * of the buttons.
	 */
	public ButtonPanel() {
		setLayout(new GridLayout(2, 2));

		save = new JButton("Save");
		open = new JButton("Open");
		visualize = new JButton("Visualize");
		reset = new JButton("Reset Filters");
		
		save.setEnabled(false);
		visualize.setEnabled(false);
		reset.setEnabled(false);
		
		
		add(save);
		add(open);
		add(visualize);
		add(reset);
		
		
		TitledBorder border = BorderFactory.createTitledBorder("Options");
		border.setTitleJustification(TitledBorder.CENTER);
		setBorder(border);
	}
	
	/*
	* Set the buttons save, limit, visualize and reset 
	* so that they have been enabled for use. 
	*/
	public void enableButtons() {
		save.setEnabled(true);
		visualize.setEnabled(true);
		reset.setEnabled(true);
	}

	/*
	 * Below here are the getter methods for the
	 * Save, Open, Filter, Limit, Reset, and Visualize Jbutton objects.
	 * 
	 * @ return Save, Open, Limit, Reset, Visualize JButton objects
	 */
	public JButton getSave() {
		return save;
	}
	
	public JButton getOpen() {
		return open;
	}
	
	public JButton getReset() {
		return reset;
	}
	
	public JButton getVisualize() {
		return visualize;
	}
	
}
