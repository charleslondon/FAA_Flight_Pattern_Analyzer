package faa.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


/*
 * The Information Panel class creates the area of the UI 
 * that will display the data that is currently being filtered
 * allowing the user to scroll through the data when needed.
 * 
 * @Author Charles London
 */
public class InformationPanel extends JPanel {
	private static final long serialVersionUID = 7290866987404009331L;
	private final JTextArea textArea;

	/*
	 * Creates the area where the Flight Data that is currently 
	 * being filtered can be viewed by the user. 
	 * Sets all the settings for the Panel within the UI.
	 * Creates the text area where the Flight Data can be displayed.
	 * When no data is present the panel should be a blank gray panel.
	 */
	public InformationPanel() {
		TitledBorder centerBorder = BorderFactory.createTitledBorder("Flight Data");
		centerBorder.setTitleJustification(TitledBorder.CENTER);
		setBorder(centerBorder);

		setLayout(new BorderLayout());

		textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createEtchedBorder());
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Serif", Font.PLAIN, 12));
		textArea.setLineWrap(false);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setVisible(true);

		JScrollPane pane = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		pane.setPreferredSize(getMinimumSize());
		pane.setVisible(true);		
		add(pane, BorderLayout.CENTER);
		setVisible(true);
	}

	/*
	 * Reads in a String of universeData to load the textArea with the chosen
	 * data or filtered data.
	 * @param String of unfiltered or filtered universeData.
	 */
	public void setPanelTextArea(String string) {
		textArea.setText(string);
	}

}
