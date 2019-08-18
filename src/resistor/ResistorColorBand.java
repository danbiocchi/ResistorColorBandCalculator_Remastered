package resistor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
	static JPanel multiplierBandPanel;
	static JPanel toleranceBandPanel;
	static JPanel tcrBandPanel;
	static JButton brownBtn;	// Create buttons Globally to reduce the instances required of each
	static JButton redBtn;
	static JButton orangeBtn;
	static JButton yellowBtn;
	static JButton greenBtn;
	static JButton blueBtn;
	static JButton violetBtn;
	static JButton grayBtn;
	static JButton whiteBtn;
	static JButton blackBtn;
	static JButton silverBtn; // Multiply Buttons creation
	static JButton goldBtn;
	
	// Variables used for calculations
    static int numberOfBands = 0;
    static int bandCount = 0;
	static String[] bandArray;
	
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
		try {
			createAndGenerateGUI();
		} catch (Exception err) {
			System.out.println("Failed to build GUI");
		}
		
	}

	
	
	
	
	/* CREATE THE GUI */
	private static void createAndGenerateGUI(){
		
		/*
		 * JFrame Creation
		 */
		JFrame frame = new JFrame("Resistor Band Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,300);
		frame.setLocationRelativeTo(null);
		
		
		/*
		 * Menu bar and Menu item creation
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem menuItemReset = new JMenuItem("Reset");
		JMenuItem menuItemHelp = new JMenuItem("Help");
			// Add Menu Items to menu bar
			menu.add(menuItemReset);
			menu.add(menuItemHelp);
			menuBar.add(menu);
		
		/*
		 * Panel Creation
		 */
		containerPanel = new JPanel(new BorderLayout());
		cacluationPanel = new JPanel(new FlowLayout());
		colorSelectionPanel = new JPanel(new GridLayout(0,2)); // Band 1-2 or 3
		bandIdentifierPanel = new JPanel();
		bandSelectionPanel = new JPanel(new GridLayout(1,4,10,10));
		multiplierBandPanel = new JPanel(new GridLayout(0,2)); // Band 2 or 4
		toleranceBandPanel = new JPanel(new GridLayout(0,2)); // Band 4 or 5
		tcrBandPanel = new JPanel(new GridLayout(0,2)); // Band 6
		
		
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
				    	 bandArray = new String[numberOfBands];
				    	 System.out.println("Number of bands selected: " + numberOfBands + "Band Count:" + bandCount);
				    	 switchToColorPanel(frame);
				    	 bandIdentifier.setText("Select color for band (1/3)");
					}
					// If band 4 button is pressed
					else if(selectedBandNumber.equals("4 Bands")) {
						numberOfBands = 4;
						bandArray = new String[numberOfBands];
				    	System.out.println("Number of bands selected: " + numberOfBands);
				    	switchToColorPanel(frame);
					    bandIdentifier.setText("Select color for band (1/4)");
					}
					// If band 5 button is pressed
					else if(selectedBandNumber.equals("5 Bands")) {
						numberOfBands = 5;
						bandArray = new String[numberOfBands];
				    	switchToColorPanel(frame);
						bandIdentifier.setText("Select color for band (1/5)");
					}
					// If band 6 button is pressed
					else if(selectedBandNumber.equals("6 Bands")) {
						numberOfBands = 6;
						bandArray = new String[numberOfBands];
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
		    	  System.out.println("In Action : band count: " + bandCount);
		    	  
		    	  

		    	  
		    	  if(bandCount == (numberOfBands-1)) {
		    		  bandArray[bandCount] = actionEvent.getActionCommand();
		    		  removeAllPanels(frame);
			    	  bandIdentifier.setText("See calculation below..");
			    	  System.out.println(Arrays.deepToString(bandArray));
			    	  calculateResistance(bandArray);
				  }
		    	  else {
		    		  bandArray[bandCount] = actionEvent.getActionCommand();
		    		  bandCount++;
			    	  bandIdentifier.setText("Select color for band 2(" + (bandCount+1) +
			    			  "/" + numberOfBands + ")");
			    	  System.out.println(Arrays.toString(bandArray));
			    	  
			    	  /*
			    	   * Bands have different logic depending on the total band number.
			    	   */
			    	  if((bandCount) == 2) { // Third band
			    		  System.out.println("Should be band 2: " + bandCount + "numberOfBands:" + numberOfBands);
			    		  switch(numberOfBands) {
				    	  case 3:
				    		  switchToMultiplyPanel(frame);
				    		  break;
				    	  case 4:
				    		  switchToMultiplyPanel(frame);
				    		  break;
				    	  case 5:
				    		  break;
				    	  case 6:
				    		  break;
				    	  }
			    	  }
			    	  else if((bandCount) == 3) { // Forth band
			    		  switch(numberOfBands) {
				    	  case 4:
				    		  switchToTolerancePanel(frame);
				    		  break;
				    	  case 5:
				    		  switchToMultiplyPanel(frame);
				    		  break;
				    	  case 6:
				    		  switchToMultiplyPanel(frame);
				    		  break;
				    	  }
			    	  }
			    	  else if(bandCount == 4) { // Fifth band
			    		  switch(numberOfBands) {
				    	  case 5:
				    		  switchToTolerancePanel(frame);
				    		  break;
				    	  case 6:
				    		  switchToTolerancePanel(frame);
				    		  break;
				    	  }
			    	  }
			    	  else if((bandCount) == 5) { // 6th band
			    		  switch(numberOfBands) {
				    	  case 6:
				    		  break;
				    	  }
			    	  }
		    	  }
		    	  
		    	  
		    	  

		    	  
		      }
		 }; // End of action listener
		
		
		
		/*
		 * Band Color selection for bands 1-2 or 3 Panel 
		 * Black - Created below
		 * Brown - Created below
		 * Red - Created below
		 * Orange - Created below
		 * Yellow - Created below
		 * Green - Created below
		 * Blue - Created below
		 * Violet - Created below
		 * Gray - Created below
		 * White  - Created below
		 * 
		 * Buttons will be added to panel in main method however later panels will re-use
		 * these buttons and since the buttons can only be added to one component at a time
		 * methods will be used to shuffle the buttons around.
		 */
		brownBtn = new JButton("Brown");	// Create buttons
		redBtn = new JButton("Red");
		orangeBtn = new JButton("Orange");
		yellowBtn = new JButton("Yellow");
		greenBtn = new JButton("Green");
		blueBtn = new JButton("Blue");
		violetBtn = new JButton("Violet");
		grayBtn = new JButton("Gray");
		whiteBtn = new JButton("White");
		blackBtn = new JButton("Black");
		blackBtn.setBackground(Color.black);	// Set bg color
		brownBtn.setBackground(new Color(101, 67, 33));
		redBtn.setBackground(Color.red); 
		orangeBtn.setBackground(new Color(255,127,80)); 
		yellowBtn.setBackground(Color.yellow); 
		greenBtn.setBackground(Color.green);
		blueBtn.setBackground(Color.blue);
		violetBtn.setBackground(new Color(128,0,128));
		grayBtn.setBackground(Color.gray);
		whiteBtn.setBackground(Color.white);
		violetBtn.setForeground(Color.white); // If bg color is dark change forground to white
		brownBtn.setForeground(Color.white);
		blueBtn.setForeground(Color.white);
		blackBtn.setForeground(Color.white);
		blackBtn.setFocusPainted(false); // Remove the ugly focused paint on the buttons
		brownBtn.setFocusPainted(false);
		redBtn.setFocusPainted(false);
		orangeBtn.setFocusPainted(false);
		yellowBtn.setFocusPainted(false);
		greenBtn.setFocusPainted(false);
		blueBtn.setFocusPainted(false);
		violetBtn.setFocusPainted(false);
		grayBtn.setFocusPainted(false);
		whiteBtn.setFocusPainted(false);
		colorSelectionPanel.add(blackBtn); // Add to panel
		colorSelectionPanel.add(brownBtn);
		colorSelectionPanel.add(redBtn);
		colorSelectionPanel.add(orangeBtn);
		colorSelectionPanel.add(yellowBtn);
		colorSelectionPanel.add(greenBtn);
		colorSelectionPanel.add(blueBtn);
		colorSelectionPanel.add(violetBtn);
		colorSelectionPanel.add(grayBtn);
		colorSelectionPanel.add(whiteBtn);
		blackBtn.addActionListener(actionListener); // Add listeners
		brownBtn.addActionListener(actionListener);
		redBtn.addActionListener(actionListener);
		orangeBtn.addActionListener(actionListener);
		yellowBtn.addActionListener(actionListener);
		greenBtn.addActionListener(actionListener);
		blueBtn.addActionListener(actionListener);
		violetBtn.addActionListener(actionListener);
		grayBtn.addActionListener(actionListener);
		whiteBtn.addActionListener(actionListener);
		
		
		/*
		 * Band 2 or 4 (MULTIPLIER BAND)
		 * Black
		 * Brown
		 * Red
		 * Orange
		 * Yellow
		 * Green
		 * Blue
		 * Violet
		 * Gray
		 * White
		 * Gold - Created below
		 * Silver - Created below
		 * 
		 * Added in new method to re-use colored buttons from previous panel
		 */
		
		silverBtn = new JButton("Silver"); // Button creation
		goldBtn = new JButton("Gold");
		goldBtn.setBackground(new Color(255,215,0)); // Background colors
		silverBtn.setBackground(new Color(192,192,192));
		goldBtn.addActionListener(actionListener); // Action listener
		silverBtn.addActionListener(actionListener);
		goldBtn.setFocusPainted(false); // Remove the ugly focused paint on the buttons
		silverBtn.setFocusPainted(false);
		
		
		/*
		 * 4th or 5th Band Panel (TOLERANCE BAND)
		 * 
		 * Silver
		 * Gold
		 * Brn
		 * Red
		 * Gren
		 * Blue
		 * Violet
		 * BUTTONS ALREADY CREATED ABOVE, METHODS WILL ARRANGE THIS PANEL
		 */
		
		
		
		/*
		 * 6th Band Panel
		 * Brown
		 * Red
		 * Orange
		 * Yellow
		 * BUTTONS ALREADY CREATED ABOVE, METHODS WILL ARRANGE THIS PANEL
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
                bandCount = 0;
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
	private static void calculateResistance(String[] arr) {
		
	}
	
	
	
	
	private static void switchToMultiplyPanel(JFrame frame) {
		System.out.println("Switching to multiply panel");
		multiplierBandPanel.add(blackBtn);
		multiplierBandPanel.add(brownBtn);
		multiplierBandPanel.add(redBtn);
		multiplierBandPanel.add(orangeBtn);
		multiplierBandPanel.add(yellowBtn);
		multiplierBandPanel.add(greenBtn);
		multiplierBandPanel.add(blueBtn);
		multiplierBandPanel.add(violetBtn);
		multiplierBandPanel.add(grayBtn);
		multiplierBandPanel.add(whiteBtn);
		multiplierBandPanel.add(goldBtn);
		multiplierBandPanel.add(silverBtn);
		frame.remove(colorSelectionPanel);
   	 	frame.add(multiplierBandPanel);
		frame.validate();
   	 	frame.repaint();
	}
	
	/*
	 * 4th or 5th Band Panel (TOLERANCE BAND)
	 * 
	 * Silver
	 * Gold
	 * Brown
	 * Red
	 * GreEn
	 * Blue
	 * Violet
	 */
	
	private static void switchToTolerancePanel(JFrame frame) {
		System.out.println("Switching to multiply panel");
		toleranceBandPanel.add(blackBtn);
		toleranceBandPanel.add(brownBtn);
		toleranceBandPanel.add(greenBtn);
		toleranceBandPanel.add(blueBtn);
		toleranceBandPanel.add(violetBtn);
		toleranceBandPanel.add(grayBtn);
		toleranceBandPanel.add(goldBtn);
		toleranceBandPanel.add(silverBtn);
		frame.remove(multiplierBandPanel);
   	 	frame.add(toleranceBandPanel);
		frame.validate();
   	 	frame.repaint();
	}
	
	
	/*
	 * 6th Band Panel
	 * Brown
	 * Red
	 * Orange
	 * Yellow
	 */
	
	private static void switchToTcrPanel(JFrame frame) {
		System.out.println("Switching to multiply panel");
		toleranceBandPanel.add(blackBtn);
		toleranceBandPanel.add(brownBtn);
		toleranceBandPanel.add(greenBtn);
		toleranceBandPanel.add(blueBtn);
		toleranceBandPanel.add(violetBtn);
		toleranceBandPanel.add(grayBtn);
		toleranceBandPanel.add(goldBtn);
		toleranceBandPanel.add(silverBtn);
		frame.remove(multiplierBandPanel);
   	 	frame.add(toleranceBandPanel);
		frame.validate();
   	 	frame.repaint();
	}
	
	
	
	private static void switchToColorPanel(JFrame frame) {
		System.out.println("Switching to color panel");
		if(bandSelectionPanel.isDisplayable()) {
			frame.remove(bandSelectionPanel);
		}
		
   	 	frame.add(colorSelectionPanel);
   	 	frame.validate();
   	 	frame.repaint();
	}
	
	private static void removeAllPanels(JFrame frame) {
		if(colorSelectionPanel.isDisplayable()) {
			frame.remove(colorSelectionPanel);
		}
		if(multiplierBandPanel.isDisplayable()) {
			frame.remove(multiplierBandPanel);
		}
		if(toleranceBandPanel.isDisplayable()) {
			frame.remove(toleranceBandPanel);
		}
		
		frame.validate();
   	 	frame.repaint();
	}
	
}
