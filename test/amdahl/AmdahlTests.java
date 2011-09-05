package amdahl;
import amdahl.Amdahl;

import org.junit.Test;
import static org.junit.Assert.*;

public class AmdahlTests {

	@Test
	public void testAmdahlSpeedupFactorWithPositiveNumberOfCPU() throws InvalidArgumentException
	{
		final int numberOfCPU 				= 1000;
		final double sequentialPercentage 	= 0.01;
		double expected						= 500.250;
		
		assertEquals(expected, Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage), 0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAmdahlSpeedupFactorWithNegativeNumberOfCPU() throws InvalidArgumentException
	{
		final int numberOfCPU 				= -1;
		final double sequentialPercentage 	= 0.01;
		
		Amdahl.calculateSpeedUpFactor(numberOfCPU, sequentialPercentage);
	}
	
	
	@Test
	public void testAmdahlSpeedupFactorWithZeroNumberOfCPU() throws InvalidArgumentException
	{
		final int numberOfCPU 				= 0;
		final double sequentialPercentage 	= 0.01;
		
		assertEquals(0, Amdahl.calculateSpeedUpFactor( numberOfCPU, sequentialPercentage ), 0.001);
	}
	
}