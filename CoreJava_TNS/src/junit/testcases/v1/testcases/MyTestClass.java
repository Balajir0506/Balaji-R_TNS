package junit.testcases.v1.testcases;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import junit.testcases.v1.businesslogic.ArithmeticOperations;


//@Disabled
public class MyTestClass {
	
	@Disabled
	@Test
	public void squareTest()
	{		
		int sq=ArithmeticOperations.getSquare(-2);
		assertEquals(4, sq);
	}
	
	@Test
	public void MaxArrayTestOne()
	{
		int a[]= {-12,-23,-34,-5,-30};
		int max=ArithmeticOperations.findMaximum(a);
		assertEquals(-5, max);
	}
	
	@Test
	public void MaxArrayTestTwo()
	{
		int a[]= {12,0,23,34,5,-30};
		int max=ArithmeticOperations.findMaximum(a);
		assertEquals(34, max);
	}
	
	@Test
	public void palindromeTestOne()
	{
		assertTrue(ArithmeticOperations.checkPalindrome(121));
	}
	
	@Test
	public void palindromeTestTwo()
	{
		assertFalse(ArithmeticOperations.checkPalindrome(123));		
	}

}
