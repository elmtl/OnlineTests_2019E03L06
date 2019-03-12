package com.acquisio.basic.java.question07;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void sumTest() throws Exception {
		Integer sum = Calculator.applyOperation(1, 2, '+');
		assertEquals(new Integer(3), sum);
	}

	@Test
	public void multiplicationTest() throws Exception {
		Integer tmp = Calculator.applyOperation(7, 3, '*');
		assertEquals(new Integer(21), tmp);
	}

	@Test
	public void divisionTest() throws Exception {
		Integer tmp = Calculator.applyOperation(21, 3, '/');
		assertEquals(new Integer(7), tmp);
	}

	@Test
	public void divideByZeroTest() throws Exception {
		Integer tmp = Calculator.applyOperation(21, 0, '/');
		assertEquals(null, tmp);
	}

	@Test
	public void substractionTest() throws Exception {
		Integer tmp = Calculator.applyOperation(21, 3, '-');
		assertEquals(new Integer(18), tmp);
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidOperatorTest() throws Exception {
		Calculator.applyOperation(21, 3, '!');

	}
}
