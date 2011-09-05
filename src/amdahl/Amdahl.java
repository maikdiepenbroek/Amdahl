package amdahl;
/**
 * Amdahl's law java implementation
 */

/**
 * @author Maik Diepenbroek
 * @author Wouter Konecny
 *
 */
public final class Amdahl {
	
	/**
	 * @param args
	 * @throws InvalidArgumentException 
	 */
	public static void main(final String[] args) throws IllegalArgumentException {
		double speedUpFactor;
		final int numberOfCPU = 1000;
		final double sequentialPercentage = 0.01;
		
		speedUpFactor = calculateSpeedUpFactor(numberOfCPU, sequentialPercentage);
		
		System.out.println("Amdahl's Law Calculator by Maik Diepenbroek and Wouter Konecny");
		System.out.println("______________________________________________________________");
		System.out.println("The Speedup Factor for an application which can run sequential for " + (sequentialPercentage*100) + "% (percent) and with " + numberOfCPU + " CPU's:");
		System.out.println(speedUpFactor);
		System.out.println("");
		System.out.println("The Efficiency Factor for an application with " + numberOfCPU + " CPU's and a speedup factor of " + speedUpFactor + ":");
		System.out.println(calculateEfficiencyFactor(speedUpFactor, numberOfCPU));
	}
	
	private Amdahl() {	}
	
	/**
	 * @param numberOfCPU The number of CPU's
	 * @param sequentialPercentage The percentage of the program that needs to run sequential, where 1 = 100%
	 * @return the speedUpFactor
	 * @throws InvalidArgumentException
	 */
	public static double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) throws IllegalArgumentException {
		if(numberOfCPU < 0) { throw new IllegalArgumentException( "You cannot have a negative amount of CPU." );}
		
		return numberOfCPU / (1 + sequentialPercentage/10 * ( numberOfCPU-1) ) ;	
	}
	
	/**
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU's
	 * @return the efficiencyFactor
	 * @throws InvalidArgumentException
	 */
	public static double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) throws IllegalArgumentException {
		if(numberOfCPU < 1) { throw new IllegalArgumentException( "You cannot have zero or negative amount of CPU." );	}
		
		return speedUpFactor / numberOfCPU;
	}

}
