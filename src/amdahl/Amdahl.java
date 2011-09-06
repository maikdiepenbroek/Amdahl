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
	
	private static final int SEQUENTIALPERCENTAGEDIVIDER = 10;
	
	private Amdahl() {	}
	
	/**
	 * @param numberOfCPU The number of CPU's
	 * @param sequentialPercentage The percentage of the program that needs to run sequential,  where 1 = 100%
	 * @return the speedUpFactor
	 * @throws IllegalArgumentException when number of CPU < 1 or sequential percentage != 0 <= sequentialPercentage <= 1
	 */
	public static double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) throws IllegalArgumentException {
		validateNumberOfCPU(numberOfCPU);		
		validateSequentialPercentage(sequentialPercentage);
	
		return numberOfCPU / (1 + sequentialPercentage/SEQUENTIALPERCENTAGEDIVIDER * ( numberOfCPU-1) ) ;	
	}
	
	/**
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU's
	 * @return the efficiencyFactor
	 * @throws IllegalArgumentException when number of CPU < 1 or speedUpFactor < 0
	 */
	public static double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) throws IllegalArgumentException {
		validateSpeedUpFactor(speedUpFactor);
		validateNumberOfCPU(numberOfCPU);		
		return speedUpFactor / numberOfCPU;
	}
	
	/**
	 * @param numberOfCPU The number of CPU's
	 * @throws IllegalArgumentException when number of CPU < 1
	 */
	private static void validateNumberOfCPU(final int numberOfCPU) throws IllegalArgumentException {
		if(numberOfCPU < 1) {
			throw new IllegalArgumentException( "You cannot have zero or negative amount of CPU." );
		}
	}

	/**
	  * @param sequentialPercentage The percentage of the program that needs to run sequential,  where 1 = 100%
	  * @throws IllegalArgumentException when number of sequentialPercentage < 0
	 */
	private static void validateSequentialPercentage(final double sequentialPercentage) throws IllegalArgumentException {
		if(sequentialPercentage < 0) {
			throw new IllegalArgumentException( "You cannot have a negative amount of sequential percentage." );
		}
	}
	
	/**
	  * @param speedUpFactor The calculated speedUpFactor
	  * @throws IllegalArgumentException when number of speedUpFactor < 0
	 */
	private static void validateSpeedUpFactor(final double speedUpFactor) throws IllegalArgumentException {
		if(speedUpFactor < 0) {
			throw new IllegalArgumentException( "You cannot have a negative amount of speedup factor (double speedUpFactor)." );
		}
	}

}
