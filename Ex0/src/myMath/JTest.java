package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author 
 *
 */
class JTest {

	public static Monom m = new Monom("-12x^2");
	@Test
	public void testAddToZeroPolynom() {
		
	}
	
	@Test
	public void testMonomStringConstructor1() {
	    Monom m1 = new Monom("2");
	    Monom m2 = new Monom("2");
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor2() {
		Monom m1 = new Monom("2");
	    Monom m2 = new Monom(2,0);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor3() {
		Monom m1 = new Monom("2x");
	    Monom m2 = new Monom(2,1);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor4() {
		Monom m1 = new Monom("-2.9087x");
	    Monom m2 = new Monom(-2.9087,1);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomStringConstructor5() {
		Monom m1 = new Monom("x^3");
	    Monom m2 = new Monom(-2.9087,1);
	    boolean b = m1.equals(m2);
	    assertEquals(false, b);
	}
	@Test
	public void testMonomStringConstructor6() {
		Monom m1 = new Monom("-x^3");
	    Monom m2 = new Monom(-1,3);
	    boolean b = m1.equals(m2);
	    assertEquals(true, b);
	}
	@Test
	public void testMonomCopyConstructor1()
	{
		Monom m1 = new Monom("-3x");
		Monom m2 = new Monom(m1);
		boolean b = m1.equals(m2);
		assertEquals(true,b);
	}
	@Test
	public void testMonomfx1()
	{
		double actual = m.f(2);
		double expected = -12*Math.pow(2, 2);
		assertEquals(expected, actual);
	}
	@Test
	public void testMonomfx2()
	{
		double actual = m.f(0);
		double expected = -12*Math.pow(0, 2);
		assertEquals(expected, actual);
	}
	@Test
	public void testMonomAdd1()
	{
		Monom m1 = new Monom("-3.99x^2");
		m1.add(m);
		Monom m2 = new Monom("-15.99x^2");
		boolean result = m2.equals(m1);
		assertTrue(result);
	}
	


	/**
	 * This test checks the Derivative function 
	 * By calculates the derivative of polynom and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testDerivativePolynom() {
		Polynom_able p1 = new Polynom("x-1+x^3");
		Polynom_able derivative=p1.derivative();
		Polynom expected = new Polynom("3x^2+1");
		boolean ans =derivative.equals(expected);
		assertTrue(ans);
	}

	/**
	 * This test checks the Add function
	 * By add two polynoms and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testAddPolynom() {
		Polynom_able p1 = new Polynom("1x^0+3x^1+4x^2+12.0x^3");
		Polynom_able p2 = new Polynom("0.001x^0-0.002x^1");
		p1.add(p2);
		Polynom_able expected=new Polynom ("1.001x^0+2.998x^1+4.x^2+12x^3");
		boolean ans =p1.equals(expected);
		assertTrue(ans);

	}

	/**
	 * This test checks the Substract function
	 * By subtracts two polynoms and check if the result 
	 * is the same as what we expected to receive
	 */
	@Test
	void testSubstractPolynom() {
		Polynom_able p1 = new Polynom("x^3-5x^2+6x+9");
		Polynom_able p2 = new Polynom("x^3-4x^2+9");
		p1.substract(p2);
		Polynom_able expected=new Polynom ("-x^2+6x");
		boolean ans =p1.equals(expected);
		assertTrue(ans);

	}
	
	/**
	 * This test checks the F function
	 * By Places a value X in the polynomial and checks whether
	 * this is the result we expected to receive
	 */
	@Test
	void testFPolynom() {
		Polynom p1 = new Polynom( "x^2+5x+5");
		double x= 0.5;
		double res =p1.f(x);
		double expected =7.75;
		assertEquals(expected, res);
	}

	
	/**
	 * This test checks the Root function
	 * By using the root function on Polynom and check if the result close to what we expected to receive
	 * We check that the result we received and what we expected is a distance of Epsilon
	 */
	@Test
	void testRootPolynom() {

		double eps =0.001;
		
		Polynom_able p1 = new Polynom("x^2-4");
		double res =(p1.root(0, 4, eps));
		double expected =2;
		boolean ans =  (Math.abs(expected-res) <=eps );
		assertTrue(ans);
		
		
		Polynom_able p2 = new Polynom("x^3-8.2x^2-0.009x");
		double res2 =(p2.root(5, 10, eps));
		double expected2 =8.2;
		boolean ans2 =  (Math.abs(expected2-res2) <=eps );
		assertTrue(ans2);
		

	}

}
