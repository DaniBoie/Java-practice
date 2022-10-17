package labs.lab3;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab3.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import java.util.Arrays;

public class Lab3Test {
	
    @Test
    public void problem1() {
        assertEquals("ab", Main.problem1_mirrorEnds("abXYZba"));
        assertEquals("a", Main.problem1_mirrorEnds("abca"));
        assertEquals("aba", Main.problem1_mirrorEnds("aba"));
        assertEquals("", Main.problem1_mirrorEnds("abab"));
        assertEquals("xxYxx", Main.problem1_mirrorEnds("xxYxx"));
        assertEquals("Hi ", Main.problem1_mirrorEnds("Hi and iH"));
        assertEquals("x", Main.problem1_mirrorEnds("x"));
        assertEquals("", Main.problem1_mirrorEnds(""));
        assertEquals("123", Main.problem1_mirrorEnds("123and then 321"));
        assertEquals("xxx", Main.problem1_mirrorEnds("xxx"));
        assertEquals("ba", Main.problem1_mirrorEnds("band andab"));
    }
    
    
    @Test
    public void problem2() {
        assertEquals(2, Main.problem2_maxBlock("hoopla"));
        assertEquals(3, Main.problem2_maxBlock("abbCCCddBBBxx"));
        assertEquals(1, Main.problem2_maxBlock("xyz"));
        assertEquals(2, Main.problem2_maxBlock("xxyz"));
        assertEquals(2, Main.problem2_maxBlock("xyzz"));
        assertEquals(3, Main.problem2_maxBlock("abbbcbbbxbbbx"));
        assertEquals(3, Main.problem2_maxBlock("XXBBBbbxx"));
        assertEquals(4, Main.problem2_maxBlock("XXBBBBbbxx"));
        assertEquals(4, Main.problem2_maxBlock("XXBBBbbxxXXXX"));
        assertEquals(4, Main.problem2_maxBlock("XX2222BBBbbXX2222"));
        assertEquals(0, Main.problem2_maxBlock(""));
    }
    
    
    @Test
    public void problem3() {
        assertTrue(Main.problem3_EHappy("xxEExx"));
        assertFalse(Main.problem3_EHappy("xxExx"));
        assertFalse(Main.problem3_EHappy("xxEyyExx"));
        assertTrue(Main.problem3_EHappy("1234"));
        assertTrue(Main.problem3_EHappy(""));
        assertFalse(Main.problem3_EHappy("E"));
        assertTrue(Main.problem3_EHappy("EE"));
        assertTrue(Main.problem3_EHappy("xxEEExyz"));
        assertFalse(Main.problem3_EHappy("xxEEExyE"));
        assertTrue(Main.problem3_EHappy("xxEEExyEE"));
        assertFalse(Main.problem3_EHappy("MEM"));
        assertTrue(Main.problem3_EHappy("MEEM"));
        assertTrue(Main.problem3_EHappy("YYYEEExYY"));
    }
    
    
    @Test
    public void problem4() {
    	assertEquals(10, Main.problem4_getNumTwists(1729, 5714));
    	assertEquals(4, Main.problem4_getNumTwists(0000, 9999));
    	assertEquals(0, Main.problem4_getNumTwists(4590, 4590));
    	assertEquals(8, Main.problem4_getNumTwists(7712, 1729));
    }
    
    
	@Test
	public void problem5() {
		// Test case 1
		String input = "10\n5\n3\n2\n";

		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);
		
		String result = output.toString();
		assertEquals("People entering or leaving: " + "People in office: 10 | People entering or leaving: " +
				"People in office: 15 | People entering or leaving: " + "People in office: 18 | People entering or leaving: " +
				"People in office: 20 | Office is full", result);
		
		
		// Test case 2
		input = "3\n-2\n-2\n-5\n-1\n-1\n15\n-2\n8\n-8\n16\n14\n-1\n2\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);

		result = output.toString();
		assertEquals("People entering or leaving: " + 
				"People in office: 3 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 1 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 13 | People entering or leaving: "
				+ "People in office: 13 | People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 19 | People entering or leaving: "
				+ "People in office: 18 | People entering or leaving: "
				+ "People in office: 20 | Office is full",
				result);
		
		
		// Test case 3
		input = "500\n3000\n2583\n-60\n280\n10\n6\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 3309);

		result = output.toString();
		assertEquals("People entering or leaving: "
				+ "People in office: 500 | People entering or leaving: "
				+ "People in office: 500 | People entering or leaving: "
				+ "People in office: 3083 | People entering or leaving: "
				+ "People in office: 3023 | People entering or leaving: "
				+ "People in office: 3303 | People entering or leaving: "
				+ "People in office: 3303 | People entering or leaving: "
				+ "People in office: 3309 | Office is full",
				result);
		
		
		// Test case 4
		input = "5\n-5\n-2\n15\n7\n1\n0\n4\n";

		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Main.problem5_officeCrowdControl(new Scanner(System.in), 20);

		result = output.toString();
		assertEquals("People entering or leaving: "
				+ "People in office: 5 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 0 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 15 | People entering or leaving: "
				+ "People in office: 16 | People entering or leaving: "
				+ "People in office: 16 | People entering or leaving: "
				+ "People in office: 20 | Office is full",
				result);
	}
	
	
	@Test
	public void problem6() {
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 0, 1, 0, 0, 1, 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 3, 3, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 2, 2, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 3, 2, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 1, 0, 1, 0 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 1, 2 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] { 2, 1 })));
		assertTrue(evensFirst(Main.problem6_evenOdd(new int[] {})));
	}
	
	
	// returns true if all the evens come before all the odds in an array of ints
	private boolean evensFirst(int[] nums) {
		// if an even comes after an odd, return false:
		for (int i=1; i<nums.length; i++) {
			if ((nums[i-1] % 2 == 1) && (nums[i] % 2 == 0)) {
				return false;
			}
		}
		return true;
	}
	
	
	@Test
	public void problem7() {
        assertArrayEquals(new int[]{1, 2}, Main.problem7_after4(new int[]{2, 4, 1, 2}));
        assertArrayEquals(new int[]{2}, Main.problem7_after4(new int[]{4, 1, 4, 2}));
        assertArrayEquals(new int[]{1, 2, 5}, Main.problem7_after4(new int[]{4, 4, 1, 2, 5}));
        assertArrayEquals(new int[]{}, Main.problem7_after4(new int[]{1, 4, 4}));
        assertArrayEquals(new int[]{2}, Main.problem7_after4(new int[]{4, 2}));
        assertArrayEquals(new int[]{3}, Main.problem7_after4(new int[]{4, 4, 3}));
        assertArrayEquals(new int[]{}, Main.problem7_after4(new int[]{4, 4}));
        assertArrayEquals(new int[]{}, Main.problem7_after4(new int[]{4}));
        assertArrayEquals(new int[]{3, 2}, Main.problem7_after4(new int[]{2, 4, 1, 4, 3, 2}));
        assertArrayEquals(new int[]{2, 2, 2}, Main.problem7_after4(new int[]{4, 1, 4, 2, 2, 2}));
        assertArrayEquals(new int[]{3, 2}, Main.problem7_after4(new int[]{3, 4, 3, 2}));
	}
	
	
    @Test
    public void test_problem8() {
    	// Test case 1:
        int [][] nums1 = {
                { 16, 3, 2, 13 },
                { 5, 10, 11, 8 },
                { 9, 6, 7, 12 },
                { 4, 15, 14, 1 }
        };
        Square s1 = new Square(nums1);
        assertEquals(34, s1.rowSum(0));
        assertEquals(34, s1.rowSum(3));
        assertEquals(34, s1.columnSum(1));
        assertEquals(34, s1.columnSum(2));
        assertEquals(34, s1.diagonalSum(true));
        assertTrue(s1.isMagic());
        
    	// Test case 2:
        int [][] nums2 = {
                { 6, 3, 20 },
                { 15, 0, 1 },
                { 7, 2, 17 }
        };
        Square s2 = new Square(nums2);
        assertEquals(16, s2.rowSum(1));
        assertEquals(26, s2.rowSum(2));
        assertEquals(28, s2.columnSum(0));
        assertEquals(5, s2.columnSum(1));
        assertEquals(27, s2.diagonalSum(false));
        assertFalse(s2.isMagic());
    }
    
    
    @Test
    public void problem9() {
        SeatingChart chart = new SeatingChart();
        String seating = "40 50 50 50 40" + System.lineSeparator() +
                "30 40 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                "10 20 20 20 10" + System.lineSeparator() +
                "10 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());

        chart.sellSeatByNumber('D', 5);
        chart.sellSeatByNumber('B', 2);
        chart.sellSeatByNumber('b', 3);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(30);
        chart.getSeatingChart();
        seating = "40 50 50 50 40" + System.lineSeparator() +
                " 0  0 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                " 0 20 20 20  0" + System.lineSeparator() +
                " 0 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());
    }
    
    
	@Test
	public void problem10() {
		
		// test case 1:
		double[][] heights1 = { 
				{ 0, 1, 2 },
				{ 2, 5, 6 },
				{ 3, -2, 0 }
		};
		Terrain terrain = new Terrain(heights1);
		char[][] floodMap1 = {
				{ '*', '*', '-' },
				{ '-', '-', '-' },
				{ '-', '*', '*' }
		};
		assertTrue(Arrays.deepEquals(floodMap1, terrain.getFloodMap(2)));
		
		
		// test case 2:
		char[][] floodMap2 = {
				{ '-', '-', '-' },
				{ '-', '-', '-' },
				{ '-', '*', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap2, terrain.getFloodMap(0)));

		
		// test case 3:
		char[][] floodMap3 = {
				{ '*', '*', '*' },
				{ '*', '*', '*' },
				{ '*', '*', '*' }
		};
		assertTrue(Arrays.deepEquals(floodMap3, terrain.getFloodMap(9)));

		
		// test case 4:
		char[][] floodMap4 = {
				{ '-', '-', '-' },
				{ '-', '-', '-' },
				{ '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap4, terrain.getFloodMap(-3)));
		
		
		// test case 5:
		double[][] heights2 = { 
				{ 0.3, 1.88, 2.0, 8.8 },
				{ 2, 0.005, 6.3, 8.2 },
				{ -68.34, -2, 0.0, -3.4 },
				{ 0, 4, 6.0, 9 }
		};
		terrain = new Terrain(heights2);
		char[][] floodMap5 = {
				{ '*', '*', '-', '-' },
				{ '-', '*', '-', '-' },
				{ '*', '*', '*', '*' },
				{ '*', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap5, terrain.getFloodMap(2)));
		
		
		// test case 6:
		char[][] floodMap6 = {
				{ '-', '-', '-', '-' },
				{ '-', '-', '-', '-' },
				{ '*', '*', '-', '*' },
				{ '-', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap6, terrain.getFloodMap(-0.02)));
		
		
		// test case 7:
		char[][] floodMap7 = {
				{ '*', '-', '-', '-' },
				{ '-', '*', '-', '-' },
				{ '*', '*', '*', '*' },
				{ '*', '-', '-', '-' }
		};
		assertTrue(Arrays.deepEquals(floodMap7, terrain.getFloodMap(1.87)));
	}
}
