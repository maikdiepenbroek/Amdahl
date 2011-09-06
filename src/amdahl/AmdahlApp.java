package amdahl;
import java.awt.*;
import javax.swing.*;

public final class AmdahlApp {
	static final int MULTIPLYVALUE = 100;
	/**
	 * @param args
	 * @throws InvalidArgumentException 
	 */
	public static void main(final String[] args) throws IllegalArgumentException {
		createWindow();
	}
	
	private static void createWindow() {
		double speedUpFactor;
		final int numberOfCPU = 1000;
		final double sequentialPercentage = 0.01;
		
		JFrame frame = new JFrame("Amdahl Calculation");
		GridLayout grid = new GridLayout(10, 1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(grid);
		frame.setPreferredSize(new Dimension(700, 200));
		frame.setResizable(false);
		
		JLabel textLabel = new JLabel("Amdahl's Law Calculator by Maik Diepenbroek and Wouter Konecny", SwingConstants.CENTER);
		JLabel calculationTop = new JLabel("1000", SwingConstants.CENTER);
		JLabel line = new JLabel("______________________________________________________________", SwingConstants.CENTER);
		JLabel calculationBottom = new JLabel("1+0.01 * ( 1000 "+numberOfCPU+"-1 )", SwingConstants.CENTER);
		JLabel speedUpFactorLine = new JLabel( "The Speedup Factor for an application which can run sequential for 0.01% (percent) and with 1000 CPU's:", SwingConstants.CENTER);
	
		frame.getContentPane().add(textLabel);
		frame.getContentPane().add(speedUpFactorLine);
		frame.getContentPane().add(calculationTop);
		frame.getContentPane().add(line);
		frame.getContentPane().add(calculationBottom);
		
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
}
