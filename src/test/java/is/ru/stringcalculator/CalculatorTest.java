package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void differentDeliminator() {
		assertEquals(13, Calculator.add("//;\n10;3"));
	}
	@Test
	public void differentDeliminator2() {
		assertEquals(19, Calculator.add("//!\n10!9"));
	}
	@Test
	public void differentDeliminatorMoreNumber() {
		assertEquals(28, Calculator.add("//;\n10;3;15"));
	}
	@Test
	public void tesNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	@Test
	public void tesMultipleNewLine() {
		assertEquals(15, Calculator.add("1\n2,3,4\n5"));
	}
	@Test
	public void testOneNumber() {
		assertEquals(12, Calculator.add("12"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testLargerNumbers(){
    	assertEquals(1000000219, Calculator.add("10,200,3,3,3,1000000000"));
    }

    @Test
    public void illegalInput(){
    assertEquals(0, Calculator.add("a"));
    }

	 @Test
	public void testIndexOutOfBoundsException() {
    assertEquals("Negatives not allowed: -1,-5", Calculator.add("-1,-5"));
	}

}