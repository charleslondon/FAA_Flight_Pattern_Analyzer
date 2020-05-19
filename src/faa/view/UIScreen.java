package faa.view;

import java.awt.*;
import javax.swing.*;


/**
 *@author Robert Seedorf
 *@author Charles London
 *@author Ben Xu
 *@author Brian Grillo
 * @author Dan Boemke
 * @author Debra Lufadeju
 * @version  1.0
 * @since 12/2015
 * This class contains the Graphic User interface. 
 */
public class UIScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private final InformationPanel dataPanel;
	private final ButtonPanel buttons;
	private JButton visualize;
	private final FilterPanel filterPanel;

	/**
	 * Constructs the main display Window. 
	 * Sets the option for the window to 
	 * close on exit.
	 */
	public UIScreen() {
		super("Flight Pattern Analyzer Ver_1.0.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();

		dataPanel = new InformationPanel();

		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHWEST;
		con.gridx = 2;
		con.gridy = 0;
		con.weightx = 2;
		con.weighty = 1;
		con.gridwidth = 1;
		con.gridheight = 2;
		con.ipadx = 200;
		con.ipady = 0;

		add(dataPanel, con);

		buttons = new ButtonPanel();
		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.NORTHEAST;
		con.gridx = 0;
		con.gridy = 0;
		con.weightx = 0.5;
		con.weighty = 0.5;
		con.gridwidth = 1;
		con.gridheight = 1;
		con.ipadx = 0;
		con.ipady = 0;

		add(buttons, con);

		filterPanel = new FilterPanel();

		con.fill = GridBagConstraints.BOTH;
		con.anchor = GridBagConstraints.SOUTHWEST;
		con.gridx = 0;
		con.gridy = 1;
		con.weightx = 0.5;
		con.weighty = 0.5;
		con.gridwidth = 1;
		con.gridheight = 1;
		con.ipadx = 0;
		con.ipady = 0;

		add(filterPanel, con);

		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		JMenu menu2 = new JMenu("Options");
		menubar.add(menu1);
		menubar.add(menu2);
		setJMenuBar(menubar);

		pack();
		setSize(1200, 900);
		setVisible(true);
	}

	/**
	 * This method returns the visualize
	 * button.
	 * @return visualize
	 */
	public JButton getVisualizer() {
		return visualize;
	}
	
	/**
	 * This method returns the an instance 
	 * of the buttons' panel
	 * @return buttons
	 */
	public ButtonPanel getButtonPanel() {
		return buttons;
	}
	
	/**
	 * This method returns an instance of
	 * the information panel
	 * @return information panel
	 */
	public InformationPanel getInfoPanel() {
		return dataPanel;
	}

	/**
	 * This method returns an instance of
	 * the filter panel
	 * @return filter panel
	 */
	public FilterPanel getFilterPanel() {
		return filterPanel;
	}

}
