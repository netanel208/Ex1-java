package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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
	
}
