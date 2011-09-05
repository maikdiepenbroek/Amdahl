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
	 * @throws NegativeArgumentException 
	 */
	public static void main(final String[] args) throws NegativeArgumentException {
		System.out.println("Amdahl's Law Calculator by Maik Diepenbroek and Wouter Konecny");
	}
	
	private Amdahl() {	}
	
	/**
	 * @author maikdiepenbroek
	 * @param numberOfCPU The number of CPU'S
	 * @param sequentialPercentage The sequential percentage
	 * @return the speedUpFactor
	 * @throws NegativeArgumentException
	 */
	public static double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) throws NegativeArgumentException {
		if(numberOfCPU < 0) { throw new NegativeArgumentException( "You cannot have a negative amount of CPU." );}
		
		return numberOfCPU / (1 + sequentialPercentage/10 * ( numberOfCPU-1) ) ;		
	}
	
	/**
	 * @author maikdiepenbroek
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU'S
	 * @return the efficiencyFactor
	 * @throws NegativeArgumentException
	 */
	public static double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) throws NegativeArgumentException {
		if(numberOfCPU < 0) { throw new NegativeArgumentException( "You cannot have a negative amount of CPU." );	}
		
		return speedUpFactor / numberOfCPU;
	}

}
