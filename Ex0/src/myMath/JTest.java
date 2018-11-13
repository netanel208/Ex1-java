package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author 
 *
 */
class JTest {

	@Test
	void testAddToZeroPolynom() {
		Polynom p1 = new Polynom();
		Polynom_able p2 = new Polynom();
		p1.add(new Monom(1,2));
		p1.add(new Monom(1,2));
		p1.add(new Monom(2,3));
		p1.add(new Monom(1,2));
		p2.add(p1);
		Polynom pexpected = new Polynom();
		pexpected.add(new Monom(1,2));
		pexpected.add(new Monom(1,2));
		pexpected.add(new Monom(2,3));
		pexpected.add(new Monom(1,2));
		boolean actual = pexpected.equals(p2);
		boolean expected = true;
		assertEquals(expected, actual, "");
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
