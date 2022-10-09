package labs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab2.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Lab2Test {
	private final double EPSILON = 1e-13;
	
    @Test
    public void problem1() {
    	Calculator c1 = new Calculator(5, 10);
    	assertEquals(15, c1.getSum());
    	assertEquals(-5, c1.getDifference());
    	assertEquals(50, c1.getProduct());
    	assertEquals(7.5, c1.getAverage(), EPSILON);
    	assertEquals(5, c1.getDistance());
    	assertEquals(10, c1.getMax());
    	assertEquals(5, c1.getMin());
    	
    	Calculator c2 = new Calculator(5, 5);
    	assertEquals(10, c2.getSum());
    	assertEquals(0, c2.getDifference());
    	assertEquals(25, c2.getProduct());
    	assertEquals(5, c2.getAverage(), EPSILON);
    	assertEquals(0, c2.getDistance());
    	assertEquals(5, c2.getMax());
    	assertEquals(5, c2.getMin());
    	
    	Calculator c3 = new Calculator(-10, 10);
    	assertEquals(0, c3.getSum());
    	assertEquals(-20, c3.getDifference());
    	assertEquals(-100, c3.getProduct());
    	assertEquals(0, c3.getAverage(), EPSILON);
    	assertEquals(20, c3.getDistance());
    	assertEquals(10, c3.getMax());
    	assertEquals(-10, c3.getMin());
    	
    	Calculator c4 = new Calculator(-5, -5);
    	assertEquals(-10, c4.getSum());
    	assertEquals(0, c4.getDifference());
    	assertEquals(25, c4.getProduct());
    	assertEquals(-5, c4.getAverage(), EPSILON);
    	assertEquals(0, c4.getDistance());
    	assertEquals(-5, c4.getMax());
    	assertEquals(-5, c4.getMin());
    	
    	Calculator c5 = new Calculator(7, 0);
    	assertEquals(7, c5.getSum());
    	assertEquals(7, c5.getDifference());
    	assertEquals(0, c5.getProduct());
    	assertEquals(3.5, c5.getAverage(), EPSILON);
    	assertEquals(7, c5.getDistance());
    	assertEquals(7, c5.getMax());
    	assertEquals(0, c5.getMin());
    }
    
	@Test
	public void problem2() {
		// Test case 1:
		String input = "53882\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 53,882", result);

		
		// Test case 2:
		input = "1001\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 1,001", result);

		
		// Test case 3:
		input = "523303\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem2_printWithCommas(new Scanner(System.in));
		result = output.toString();
		assertEquals("Please enter an integer between 1000 and 999999: 523,303", result);
	}
	
	
	@Test
	public void problem3() {
		// Test case 1:
		String input = "1.00\n10";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem3_calculateTotal(new Scanner(System.in));
		String total = output.toString();
		assertEquals("Enter price per sticker: " + "Enter the number of stickers: " + "Your total is: $12.50", total); 
		
		
		// Test case 2:
		input = "0\n100";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem3_calculateTotal(new Scanner(System.in));
		total = output.toString();
		assertEquals("Enter price per sticker: " + "Enter the number of stickers: " + "Your total is: $15.00", total); 

		
		// Test case 3:
		input = "3.62\n781";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem3_calculateTotal(new Scanner(System.in));
		total = output.toString();
		assertEquals("Enter price per sticker: " + "Enter the number of stickers: " + "Your total is: $3227.09", total); 
	}
	
	
	@Test
	public void problem4() {
		// Test case 1:
		String input = "1500\n4.3\n6\n4";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_compoundInterest(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$1500.00 invested at 4.3% for 6 years compounded 4 times annually is $1938.84.", result); 
		
		
		// Test case 2:
		input = "10000\n0\n100\n20";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_compoundInterest(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$10000.00 invested at 0.0% for 100 years compounded 20 times annually is $10000.00.", result); 
		
		
		// Test case 3:
		input = "83.95\n5.98\n7\n4";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem4_compoundInterest(new Scanner(System.in));
		result = output.toString();
		assertEquals("Enter principal amount: " + "Enter the annual rate of interest: " + 
				"Enter the number of years the amount is invested: " + 
				"Enter the number of times the interest is compounded per year: " +
				"$83.95 invested at 5.98% for 7 years compounded 4 times annually is $127.20.", result); 
	}
	
	
	@Test
	public void problem5() {
		// Test case 1:
		String input = "21394.88\n5.9\n2000";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_creditCardPayoff(new Scanner(System.in));
		String result = output.toString();
		assertEquals("What is your balance? " + "What is the APR on the card? " + 
				"What is the monthly payment you can make? " + 
				"It will take you 12 months to pay off this card.", result); 
		
		
		// Test case 2:
		input = "5000\n12\n100";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_creditCardPayoff(new Scanner(System.in));
		result = output.toString();
		assertEquals("What is your balance? " + "What is the APR on the card? " + 
				"What is the monthly payment you can make? " + 
				"It will take you 70 months to pay off this card.", result);  
		
		
		// Test case 3:
		input = "0\n100\n1000";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_creditCardPayoff(new Scanner(System.in));
		result = output.toString();
		assertEquals("What is your balance? " + "What is the APR on the card? " + 
				"What is the monthly payment you can make? " + 
				"It will take you 0 months to pay off this card.", result); 
		
		
		// Test case 4:
		input = "1000\n59.1\n50.25";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem5_creditCardPayoff(new Scanner(System.in));
		result = output.toString();
		assertEquals("What is your balance? " + "What is the APR on the card? " + 
				"What is the monthly payment you can make? " + 
				"It will take you 95 months to pay off this card.", result); 
	}
	
	
	@Test
	public void problem6() {
		// Test case 1:
		String input = "y\nNO SIR\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_troubleshootCarIssues(new Scanner(System.in));
		String result = output.toString();
		assertEquals("Is the car silent when you turn the key? " + "Are the battery terminals corroded? " + 
				"Replace cables and try again.", result); 
		
		
		// Test case 2:
		input = "no\nny\nI'm not sure";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_troubleshootCarIssues(new Scanner(System.in));
		result = output.toString();
		assertEquals("Is the car silent when you turn the key? " + "Does the car make a clicking noise? " + 
				"Does the car crank up but fail to start? " + "Invalid input. Exiting.", result); 
		
		
		// Test case 3:
		input = "no\nny\nNOO\ny\nYESS";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		Main.problem6_troubleshootCarIssues(new Scanner(System.in));
		result = output.toString();
		assertEquals("Is the car silent when you turn the key? " + "Does the car make a clicking noise? " + 
				"Does the car crank up but fail to start? " + "Does the engine start and then die? " +
				"Does your car have fuel injection? " + "Get it in for service.", result); 
	}
	
	
	@Test
	public void problem7() {
		assertEquals("very weak", Main.problem7_assessPasswordStrength("12345"));
		assertEquals("weak", Main.problem7_assessPasswordStrength("abcdef"));
		assertEquals("strong", Main.problem7_assessPasswordStrength("abc123xyz"));
		assertEquals("very strong", Main.problem7_assessPasswordStrength("1337h@xor"));
		assertEquals("very strong", Main.problem7_assessPasswordStrength("1337h xor"));
		assertEquals("medium", Main.problem7_assessPasswordStrength("123abc"));
		assertEquals("medium", Main.problem7_assessPasswordStrength("a bc de f"));
		assertEquals("strong", Main.problem7_assessPasswordStrength("abc123XYZ"));
		assertEquals("very strong", Main.problem7_assessPasswordStrength("1337h@x!$or"));
		assertEquals("medium", Main.problem7_assessPasswordStrength("@#$%"));
		assertEquals("medium", Main.problem7_assessPasswordStrength("1337878978978"));
		assertEquals("medium", Main.problem7_assessPasswordStrength("abcdefjkdlskdjfkdjf"));
	}
	
	
	@Test 
	public void problem8() {
        assertEquals(-1.0, Main.problem8_getNumericGrade("G"), EPSILON);
        assertEquals(3.7, Main.problem8_getNumericGrade("a-"), EPSILON);
        assertEquals(2.3, Main.problem8_getNumericGrade("C+"), EPSILON);
        assertEquals(3.0, Main.problem8_getNumericGrade("B"), EPSILON);
        assertEquals("B", Main.problem8_getLetterGrade(2.85));
        assertEquals("D-", Main.problem8_getLetterGrade(0.51));
        assertEquals("A+", Main.problem8_getLetterGrade(4.0));
        assertEquals("Error", Main.problem8_getLetterGrade(8.3));
	}
	
	
	@Test
	public void problem9() {
		Rectangle r1 = new Rectangle(10.5, 22.5, 20.5, 12.5);
		Rectangle r2 = new Rectangle(10.5, 32.5, 21.5, 12.5);
		Rectangle r3 = new Rectangle(-10.5, 22.5, 21.5, 12.5);
		// Test case 1
		assertEquals("square", r1.getOrientation());
		// Test case 2
		assertEquals("portrait", r2.getOrientation());
		// Test case 3
		assertEquals("landscape", r3.getOrientation());
	}
	
	
    @Test
    public void problem10() {
        assertEquals("Hi", Main.problem10_withoutX2("xHi"));
        assertEquals("Hi", Main.problem10_withoutX2("Hxi"));
        assertEquals("Hi", Main.problem10_withoutX2("Hi"));
        assertEquals("XHi", Main.problem10_withoutX2("XHi"));
        assertEquals("Hi", Main.problem10_withoutX2("xxHi"));
        assertEquals("Hix", Main.problem10_withoutX2("Hix"));
        assertEquals("axb", Main.problem10_withoutX2("xaxb"));
        assertEquals("", Main.problem10_withoutX2("xx"));
        assertEquals("", Main.problem10_withoutX2("x"));
        assertEquals("", Main.problem10_withoutX2(""));
        assertEquals("Hello", Main.problem10_withoutX2("Hello"));
        assertEquals("Hexllo", Main.problem10_withoutX2("Hexllo"));
        assertEquals("Hxllo", Main.problem10_withoutX2("xHxllo"));
    }
}

