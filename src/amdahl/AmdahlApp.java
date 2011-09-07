package amdahl;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.*;

public final class AmdahlApp {
	
	private static JFrame frame = new JFrame("Amdahl Calculator");
	private static JPanel background;
	private static Container pane;
	
	private static int numberOfCPU = 1000;
	private final static double sequentialPercentage = 0.01;
	
	private static double speedUpFactor;
	private static double efficiencyFactor;
	
	static final int MULTIPLYVALUE = 100;
	
	/**
	 * @param args
	 * @throws InvalidArgumentException 
	 */
	public static void main(final String[] args) throws IllegalArgumentException {
		performAmdahlCalculations();
		showCalculationsInUI();
	}
	
	/**
	 * @return void
	 * @throws IllegalArgumentException when giving invalid arguments to calculations 
	 */
	private static void performAmdahlCalculations() throws IllegalArgumentException {
		speedUpFactor 		= Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage);
		efficiencyFactor 	= Amdahl.calculateEfficiencyFactor(speedUpFactor, numberOfCPU);
	}
	
	private static void showCalculationsInUI() {
		setUpJFrame();
		drawCalculationsToFrame();
		showFrame();
	}
	
	private static void setUpJFrame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(new Dimension(300, 220));
		frame.setResizable(false);
		
		background = new JPanel();
		background.setLayout(null);
		frame.setContentPane(background);
	}
	
	private static void drawCalculationsToFrame() {
		pane = frame.getContentPane();
		
		drawSpeedUpFactorToPane(pane);
		drawEfficiencyFactorToPane(pane);
		drawCreatorNamesToPane(pane);
		
		drawTextFieldToPane();
	}
	
	private static void drawTextFieldToPane() {
		final JTextField textField = new JTextField("" + numberOfCPU + "");
		textField.setBounds(0, 175, 50, 20);
		textField.addKeyListener(new KeyAdapter() {
		      public void keyReleased(KeyEvent e) {
		    	  try  
		    	   {  
		    		  numberOfCPU = Integer.parseInt( textField.getText() );
		    		  performAmdahlCalculations();
		    	   }  
		    	   catch( Exception ex )  
		    	   {  
		    		   numberOfCPU = 1;
		    	   }
		    	  
		    	  showCalculationsInUI();
		        }
		});
		
		pane.add(textField);
		textField.requestFocus();
		textField.setCaretPosition(textField.getText().length()-1);
	}
	
	private static void drawSpeedUpFactorToPane( Container pane ) {
		drawLabelToPane(pane,
						 "Speedup Factor: (" + sequentialPercentage + "% seq. " + numberOfCPU + " CPU's)",
						 10, 5, 300, 20,
						 SwingConstants.LEFT);
		
		drawLabelToPane(pane,
						"" + roundFourDecimals(speedUpFactor) + " =",
						10, 37, 80, 20,
						SwingConstants.RIGHT);
		
		drawLabelToPane(pane,
						"" + numberOfCPU + "",
						60, 29, 230, 20,
						SwingConstants.CENTER);
		
		drawLabelToPane(pane,
						"______________________",
						60, 32, 230, 20,
						SwingConstants.CENTER);
		
		drawLabelToPane(pane,
						"1 + " + sequentialPercentage + " * ( " + numberOfCPU + " - 1 )",
						60, 48, 230, 20,
						SwingConstants.CENTER);
	}
	
	private static void drawEfficiencyFactorToPane( Container pane ) {
		drawLabelToPane(pane,
						"Efficiency Factor:",
						 10, 95, 300, 20,
						 SwingConstants.LEFT);
		
		drawLabelToPane(pane,
						"" + roundFourDecimals(efficiencyFactor) + " =",
						10, 127, 80, 20,
						SwingConstants.RIGHT);
		
		drawLabelToPane(pane,
						"" + roundFourDecimals(speedUpFactor) + "",
						60, 119, 135, 20,
						SwingConstants.CENTER);
		
		drawLabelToPane(pane,
						"_________",
						60, 122, 135, 20,
						SwingConstants.CENTER);
		
		drawLabelToPane(pane,
						"" + numberOfCPU + "",
						60, 138, 135, 20,
						SwingConstants.CENTER);
	}
	
	private static void drawCreatorNamesToPane( Container pane ) {
		JLabel creatorNamesLabel = new JLabel("by M. Diepenbroek and W. Konecny");
		creatorNamesLabel.setForeground(Color.gray);
		creatorNamesLabel.setBounds(0, 175, 292, 20);
		creatorNamesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pane.add(creatorNamesLabel);
	}
	
	private static void showFrame() {
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	private static void drawLabelToPane( Container pane, final String label, final int x, final int y, final int width, final int height, final int textAlignment ) {
		JLabel newLabel = new JLabel(label);
		newLabel.setHorizontalAlignment(textAlignment);
		newLabel.setBounds(x, y, width, height);
		pane.add(newLabel);
	}
	
	private static double roundFourDecimals(final double d) {
    	DecimalFormat newNumberFormat = new DecimalFormat("#.####");
    	return Double.valueOf(newNumberFormat.format(d));
	}
}
