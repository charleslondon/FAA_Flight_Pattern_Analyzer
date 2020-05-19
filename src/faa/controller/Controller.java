package faa.controller;

import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import faa.model.Model;
import faa.view.UIScreen;
import faa.view.Visualizer;


/**
 *	@Author Robert Seedorf
 *	@Author Charles London
 *	@Author Ben Xu
 *	@Author Brian Grillo
 *	@Author Dan Boemke
 *	@Author Debra Lufadeju
 *	
 *	@Version  1.0
 *	@Date 12/2015
 *
 * This class contains the controller. It is the bridge between the model
 * which contains the software logic and the Screen UI;which is the Graphic
 * User Interface of the software.
 */
public class Controller {

	/**
	 *This is the class' main method
	 *and creates a new JFrame.
	 *@param args
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Controller();
	}


	private static UIScreen ui;
	private static Model model;

	/**
	 * Creates a new instance of the UI screen,
	 * new instance of model and calls the 
	 * generatesListeners method.
	 */
	public Controller() {
		ui = new UIScreen();
		model = new Model();
		generateListeners();
	}

	/**
	 * This method sets up the GUI buttons as well as
	 * generates the Action listener for the options and
	 * buttons for the GUI.
	 */
	public void generateListeners() {
		ActionListener saveAction = event -> {
			JFileChooser saveFile = new JFileChooser();

			if (saveFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				try {
					model.writeData(saveFile.getSelectedFile());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		ui.getButtonPanel().getSave().addActionListener(saveAction);

		ActionListener openAction = event -> {
			JFileChooser openFile = new JFileChooser("C:");

			if(openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				model.setFile(openFile.getSelectedFile());
				ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString());
				ui.getFilterPanel().enableButtons();
				ui.getButtonPanel().enableButtons();
			}

		};
		ui.getButtonPanel().getOpen().addActionListener(openAction);

		ActionListener visualizeAction = e -> new Visualizer("Plane Types", model.GetPlanes(), model.GetDestinations(),
				model.GetFlights(), model.GetOrigins(), model.GetStarts());
		ui.getButtonPanel().getVisualize().addActionListener(visualizeAction);

		ActionListener filterAction = e -> {
			ui.getFilterPanel().setFilters();
			model.filterGalaxy(ui.getFilterPanel().getFilters()[0], ui.getFilterPanel().getFilters()[1],
					ui.getFilterPanel().getFilters()[2], ui.getFilterPanel().getFilters()[3],
					ui.getFilterPanel().getFilters()[4], ui.getFilterPanel().getFilters()[5],
					ui.getFilterPanel().getFilters()[6], ui.getFilterPanel().getFilters()[7]);
			updateDisplay();
		};
		ui.getFilterPanel().getApplyButton().addActionListener(filterAction);

		ActionListener resetAction = e -> {
			model.generateGalaxy();
			updateDisplay();
		};
		ui.getButtonPanel().getReset().addActionListener(resetAction);
	}

	/**
	 * This method sets the ui object.
	 * @param screen
	 */
	public static void setUI(UIScreen screen) {
		ui = screen;
	}

	/**
	 * This method sets the display limit of
	 * Flight data
	 * @param val
	 */
	public void setLimit(int val) {
		Integer limit = val;
	}

	/**
	 * This method updates the display for the flight data panel
	 */
	public void updateDisplay() {
		ui.getInfoPanel().setPanelTextArea(model.generateGalaxyString());
	}

}
