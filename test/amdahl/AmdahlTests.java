package amdahl;
import amdahl.Amdahl;

import org.junit.Test;
import static org.junit.Assert.*;

public class AmdahlTests {

	@Test
	public void testAmdahlSpeedupFactorWithPositiveNumberOfCPU() throws IllegalArgumentException
	{
		final int numberOfCPU 				= 1000;
		final double sequentialPercentage 	= 0.01;
		final double expected				= 500.250;
		
		assertEquals(expected, Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAmdahlSpeedupFactorWithNegativeNumberOfCPU() throws IllegalArgumentException
	{
		final int numberOfCPU 				= -1;
		final double sequentialPercentage 	= 0.01;
		
		Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testAmdahlSpeedupFactorZeroNumberOfCPU() throws IllegalArgumentException
	{
		final int numberOfCPU 				= 0;
		final double sequentialPercentage 	= 0.01;
		
		Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage);
	}
	
	@Test
	public void testAmdahlEfficiencyFactorWithPositiveNumberOfCPU() throws IllegalArgumentException
	{
		final double speedUpFactor			= 500.250;
		final int numberOfCPU 				= 1000;
		final double expected				= 0.5;
		
		assertEquals(expected, Amdahl.calculateEfficiencyFactor( speedUpFactor, numberOfCPU ), 0.001);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testAmdahlEfficiencyFactorWithNegativeNumberOfCPU() throws IllegalArgumentException
	{
		final double speedUpFactor			= 500.250;
		final int numberOfCPU 				= -1;
		
		Amdahl.calculateEfficiencyFactor(speedUpFactor, numberOfCPU);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAmdahlEfficiencyFactorWithZeroNumberOfCPU() throws IllegalArgumentException
	{
		final double speedUpFactor			= 500.250;
		final int numberOfCPU 				= 0;
		
		Amdahl.calculateEfficiencyFactor( speedUpFactor, numberOfCPU );
	}
}