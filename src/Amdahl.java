/**
 * Amdahl's law java implementation
 */

/**
 * @author maikdiepenbroek
 *
 */
public class Amdahl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) {
		return numberOfCPU / (1 + ((numberOfCPU-1)/numberOfCPU));		
	}

}
