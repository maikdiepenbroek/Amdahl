package amdahl;
import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

public final class AmdahlApp {
	
	private static JFrame frame;
	private static JPanel background;
	private static Container pane;
	
	private final static int numberOfCPU = 1000;
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
		frame = new JFrame("Amdahl Calculator");
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
	}
	
	private static void drawSpeedUpFactorToPane( Container pane ) {
		JLabel speedUpFactorLabel = new JLabel("Speedup Factor: (" + sequentialPercentage + "% seq. " + numberOfCPU + " CPU's)");
		speedUpFactorLabel.setBounds(10, 5, 300, 20);
		pane.add(speedUpFactorLabel);
		
		JLabel answerLabel = new JLabel("" + roundFourDecimals(speedUpFactor) + " =");
		answerLabel.setBounds(10, 37, 80, 20);
		answerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pane.add(answerLabel);
		
		JLabel calculationTop = new JLabel("" + numberOfCPU + "");
		calculationTop.setBounds(60, 29, 230, 20);
		calculationTop.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(calculationTop);
		
		JLabel devidingLabel = new JLabel("______________________");
		devidingLabel.setBounds(60, 32, 230, 20);
		devidingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(devidingLabel);
		
		JLabel calculationBottom = new JLabel("1 + " + sequentialPercentage + " * ( " + numberOfCPU + " - 1 )");
		calculationBottom.setBounds(60, 48, 230, 20);
		calculationBottom.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(calculationBottom);
	}
	
	private static void drawEfficiencyFactorToPane( Container pane ) {
		JLabel speedUpFactorLabel = new JLabel("Efficiency Factor:");
		speedUpFactorLabel.setBounds(10, 95, 300, 20);
		pane.add(speedUpFactorLabel);
		
		JLabel answerLabel = new JLabel("" + roundFourDecimals(efficiencyFactor) + " =");
		answerLabel.setBounds(10, 127, 80, 20);
		answerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pane.add(answerLabel);
		
		JLabel calculationTop = new JLabel("" + roundFourDecimals(speedUpFactor) + "");
		calculationTop.setBounds(60, 119, 135, 20);
		calculationTop.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(calculationTop);
		
		JLabel devidingLabel = new JLabel("_________");
		devidingLabel.setBounds(60, 122, 135, 20);
		devidingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(devidingLabel);
		
		JLabel calculationBottom = new JLabel("" + numberOfCPU + "");
		calculationBottom.setBounds(60, 138, 135, 20);
		calculationBottom.setHorizontalAlignment(SwingConstants.CENTER);
		pane.add(calculationBottom);
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
	
	private static double roundFourDecimals(double d) {
    	DecimalFormat newNumberFormat = new DecimalFormat("#.####");
    	return Double.valueOf(newNumberFormat.format(d));
	}
}
