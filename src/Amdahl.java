/**
 * Amdahl's law java implementation
 */

/**
 * @author maikdiepenbroek
 * @author wouter konecny
 *
 */
public class Amdahl {

	/**
	 * @param args
	 */
	public void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @author maikdiepenbroek
	 * @param numberOfCPU The number of CPU'S
	 * @param sequentialPercentage The sequential percentage
	 * @return the speedUpFactor
	 */
	public double calculateSpeedUpFactor(final int numberOfCPU, final double sequentialPercentage) {
		return numberOfCPU / (1 + ((numberOfCPU-1)/numberOfCPU));		
	}
	
	/**
	 * @author maikdiepenbroek
	 * @param speedUpFactor The calculated speedupfactor
	 * @param numberOfCPU The number of CPU'S
	 * @return the efficiencyFactor
	 */
	public double calculateEfficiencyFactor(final double speedUpFactor, final int numberOfCPU) {
		return speedUpFactor/numberOfCPU;
	}

}
