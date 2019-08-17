package resistor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class ResistorColorBand{
	
	// Should have extended Frame and used constructor.
	static JLabel bandIdentifier;
	static JButton threeBandsBtn;
	static JButton fourBandsBtn;
	static JButton fiveBandsBtn;
	static JButton sixBandsBtn;
	static JPanel containerPanel;
	static JPanel cacluationPanel;
	static JPanel colorSelectionPanel;
	static JPanel bandIdentifierPanel;
	static JPanel bandSelectionPanel;
	
	// Variables used for calculations
    static int numberOfBands = 0;
    static int bandCount = 1;
	
	
	public static void main(String[] args) {
		// Adjust look and feel
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    	//System.out.println(info.getName());
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
			System.out.print("Nimbus Unavailbe.");
		}
		// Build GUI
		createAndGenerateGUI();
	}

	
	
	
	
	/* CREATE THE GUI */
	private static void createAndGenerateGUI(){
		
		// Create frame container
		JFrame frame = new JFrame("Resistor Band Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setLocationRelativeTo(null);
		
		
		// Menu bar & components
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItemReset = new JMenuItem("Reset");
		JMenuItem menuItemHelp = new JMenuItem("Help");
			// Add Menu Items to menu bar
			menu.add(menuItemReset);
			menu.add(menuItemHelp);
			menuBar.add(menu);
		
		//Panels Components
		containerPanel = new JPanel(new BorderLayout());
		cacluationPanel = new JPanel(new FlowLayout());
		colorSelectionPanel = new JPanel(new GridLayout(0,2));
		bandIdentifierPanel = new JPanel();
		bandSelectionPanel = new JPanel(new GridLayout(1,4,10,10));
		
		/*
		 * Band Selection Panel
		 */
		
		threeBandsBtn = new JButton("3 Bands");
		fourBandsBtn = new JButton("4 Bands");
		fiveBandsBtn = new JButton("5 Bands");
		sixBandsBtn = new JButton("6 Bands");
		bandSelectionPanel.add(threeBandsBtn);
		bandSelectionPanel.add(fourBandsBtn);
		bandSelectionPanel.add(fiveBandsBtn);
		bandSelectionPanel.add(sixBandsBtn);
		threeBandsBtn.setFocusPainted(false); // Remove ugly focused paint
		fourBandsBtn.setFocusPainted(false);
		fiveBandsBtn.setFocusPainted(false);
		sixBandsBtn.setFocusPainted(false);
		
		

		
		
		
		/*
		 * Displaying resistance calculation Panel
		 */
		JLabel calculationText = new JLabel("Resistance of the band: ");
		JLabel calulatedResistance = new JLabel("Waiting.. Ω");
		cacluationPanel.add(calculationText);
		cacluationPanel.add(calulatedResistance);
		
		
		
		
		 /*
		  * Action Listener for # of bands buttons 
		  */
		 ActionListener numOfBandsListener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//System.out.println(e.getActionCommand());
					// Capture which button was pressed
					String selectedBandNumber = e.getActionCommand();
					
					// If band 3 button is pressed
					if(selectedBandNumber.equals("3 Bands")) {
						 System.out.println("Pressed");
				    	 numberOfBands = 3;
				    	 System.out.println("Number of bands selected: " + numberOfBands);
				    	 switchToColorPanel(frame);
				    	 bandIdentifier.setText("Select color for band (1/3)");
					}
					// If band 4 button is pressed
					else if(selectedBandNumber.equals("4 Bands")) {
						numberOfBands = 4;
				    	//System.out.println("Number of bands selected: " + numberOfBands);
				    	switchToColorPanel(frame);
					    bandIdentifier.setText("Select color for band (1/4)");
					}
					// If band 5 button is pressed
					else if(selectedBandNumber.equals("5 Bands")) {
						numberOfBands = 5;
				    	switchToColorPanel(frame);
						bandIdentifier.setText("Select color for band (1/5)");
					}
					// If band 6 button is pressed
					else if(selectedBandNumber.equals("6 Bands")) {
						numberOfBands = 6;
				    	switchToColorPanel(frame);
						bandIdentifier.setText("Select color for band (1/6)");
					}
					
					
				}
				
			}; // End of action listener
		 
		
		/*
		 * Action listener for color buttons
		 */
		ActionListener actionListener = new ActionListener()
		 {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  if(bandCount >= numberOfBands) {
		    		  removeColorPanel(frame);
		    		  //System.out.println(bandCount + " " + numberOfBands);
			    	  bandIdentifier.setText("See calculation below..");
			          System.out.println(actionEvent.getActionCommand());

				  }
		    	  else {
		    		  bandCount++;
			    	  bandIdentifier.setText("Select color for band (" + bandCount +
			    			  "/" + numberOfBands + ")");
			    	  System.out.println(actionEvent.getActionCommand());
		    	  }
		      }
		 }; // End of action listener
		
		
		
		/*
		 * Band Color selection for bands 1-3 Panel 
		 */
			//Black
		JButton blackBtn = new JButton("Black");
		blackBtn.setBackground(Color.black);
		blackBtn.setForeground(Color.white);
			//Brown
		JButton brownBtn = new JButton("Brown");
		brownBtn.setBackground(new Color(101, 67, 33));
		brownBtn.setForeground(Color.white);
			//Red
		JButton redBtn = new JButton("Red");
		redBtn.setBackground(Color.red); 
			//Orange
		JButton orangeBtn = new JButton("Orange");
		orangeBtn.setBackground(new Color(255,127,80)); 
			//Yellow
		JButton yellowBtn = new JButton("Yellow");
		yellowBtn.setBackground(Color.yellow); 
			//Green
		JButton greenBtn = new JButton("Green");
		greenBtn.setBackground(Color.green);
			//Blue
		JButton blueBtn = new JButton("Blue");
		blueBtn.setBackground(Color.blue);
		blueBtn.setForeground(Color.white);
			// Purple
		JButton purpleBtn = new JButton("Purple");
		purpleBtn.setBackground(new Color(128,0,128));
		purpleBtn.setForeground(Color.white);
			// Gray
		JButton grayBtn = new JButton("Gray");
		grayBtn.setBackground(Color.gray);
			// White
		JButton whiteBtn = new JButton("White");
		whiteBtn.setBackground(Color.white);
		blackBtn.setFocusPainted(false); // Remove the ugly focused paint on the buttons
		brownBtn.setFocusPainted(false);
		redBtn.setFocusPainted(false);
		orangeBtn.setFocusPainted(false);
		yellowBtn.setFocusPainted(false);
		greenBtn.setFocusPainted(false);
		blueBtn.setFocusPainted(false);
		purpleBtn.setFocusPainted(false);
		grayBtn.setFocusPainted(false);
		whiteBtn.setFocusPainted(false);
		colorSelectionPanel.add(blackBtn);
		colorSelectionPanel.add(brownBtn);
		colorSelectionPanel.add(redBtn);
		colorSelectionPanel.add(orangeBtn);
		colorSelectionPanel.add(yellowBtn);
		colorSelectionPanel.add(greenBtn);
		colorSelectionPanel.add(blueBtn);
		colorSelectionPanel.add(purpleBtn);
		colorSelectionPanel.add(grayBtn);
		colorSelectionPanel.add(whiteBtn);
		blackBtn.addActionListener(actionListener);
		brownBtn.addActionListener(actionListener);
		redBtn.addActionListener(actionListener);
		orangeBtn.addActionListener(actionListener);
		yellowBtn.addActionListener(actionListener);
		greenBtn.addActionListener(actionListener);
		blueBtn.addActionListener(actionListener);
		purpleBtn.addActionListener(actionListener);
		grayBtn.addActionListener(actionListener);
		whiteBtn.addActionListener(actionListener);
		
		
		/*
		 * 4th Band Panel
		 */
		
		/*
		 * 5th Band Panel
		 */
		
		/*
		 * 6th Band Panel
		 */
		
		
		
		
		// Band Identifier Label
		bandIdentifier = new JLabel("How many bands on the resistor?");
		bandIdentifierPanel.add(bandIdentifier);
		

		/*
		 * Action listeners band # buttons 3,4,5, and 6.
		 * To be moved into one listener later
		 */
		// 3 bands
		
		threeBandsBtn.addActionListener(numOfBandsListener);
		fourBandsBtn.addActionListener(numOfBandsListener);
		fiveBandsBtn.addActionListener(numOfBandsListener);
		sixBandsBtn.addActionListener(numOfBandsListener);
		
		/*
		 * Menu listeners
		 */
		menuItemReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.remove(colorSelectionPanel);
            	frame.add(bandSelectionPanel);
            	bandIdentifier.setText("How many bands on the resistor?");
            	// Reset variables used in calculations
            	numberOfBands = 0;
                bandCount = 1;
				frame.validate();
				frame.repaint();
            }

        });
		menuItemHelp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "Program for caluclating "
            			+ "the resistance of electrical resistors designed and coded"
            			+ "by Daniel Biocchi");

            }

        });
		
		
		
		/*
		 * Final frame packaging
		 */
		frame.setJMenuBar(menuBar);
		frame.add(containerPanel);
		frame.add(BorderLayout.NORTH, bandIdentifierPanel);
		frame.add(bandSelectionPanel);
		frame.add(BorderLayout.SOUTH, cacluationPanel);
		frame.setVisible(true);

	}
	
	/*
	 * Helper methods to reduce code re-use.
	 */
	private static void switchToColorPanel(JFrame frame) {
		frame.remove(bandSelectionPanel);
   	 	frame.add(colorSelectionPanel);
   	 	frame.validate();
   	 	frame.repaint();
	}
	
	private static void removeColorPanel(JFrame frame) {
		frame.remove(colorSelectionPanel);
		frame.validate();
   	 	frame.repaint();
	}
	
}
