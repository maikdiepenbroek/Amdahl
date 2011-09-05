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
	 */
	public static void main(final String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @author maikdiepenbroek
	 * @param numberOfCPU The number of CPU'S
	 * @param sequentialPercentage The sequential percentage
	 * @return the speedUpFactor
	 */
	public static double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) {
		return numberOfCPU / (1 + ((numberOfCPU-1)/numberOfCPU));		
	}
	
	/**
	 * @author maikdiepenbroek
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU'S
	 * @return the efficiencyFactor
	 */
	public static double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) {
		return speedUpFactor/numberOfCPU;
	}

}
