package amdahl;
/**
 * Amdahl's law java implementation
 */

/**
 * @author maikdiepenbroek
 * @author wouter konecny
 *
 */
public final class Amdahl {

	/**
	 * @param args
	 * @throws InvalidArgumentException 
	 */
	public static void main(final String[] args) throws IllegalArgumentException {
		System.out.println("Amdahl's Law Calculator by Maik Diepenbroek and Wouter Konecny");
	}
	
	private Amdahl() {	}
	
	/**
	 * @author maikdiepenbroek
	 * @param numberOfCPU The number of CPU'S
	 * @param sequentialPercentage The sequential percentage
	 * @return the speedUpFactor
	 * @throws InvalidArgumentException
	 */
	public static double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) throws IllegalArgumentException {
		if(numberOfCPU < 0) { throw new IllegalArgumentException( "You cannot have a negative amount of CPU." );}
		
		return numberOfCPU / (1 + sequentialPercentage/10 * ( numberOfCPU-1) ) ;		
	}
	
	/**
	 * @author maikdiepenbroek
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU'S
	 * @return the efficiencyFactor
	 * @throws InvalidArgumentException
	 */
	public static double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) throws IllegalArgumentException {
		if(numberOfCPU < 1) { throw new IllegalArgumentException( "You cannot have zero or negative amount of CPU." );	}
		
		return speedUpFactor / numberOfCPU;
	}

}
