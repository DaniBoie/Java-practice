package labs.lab8;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import labs.lab8.*;


public class Lab8Test {
	
	private final double EPSILON = 1e-3;


    @Test
    public void problem1() {
        String sentence = "Mary had a little lamb";
        Iterable<String> it = Arrays.asList(sentence.split(" "));
        assertEquals("Mary, had, a, little, lamb", Main.problem1_getElements(it));
       
		assertEquals("3, 12, 78, 45, 44", Main.problem1_getElements(Arrays.asList(3, 12, 78, 45, 44)));
    }
    
    
    // @Test
    // public void problem2() {
    //     Pair<String, Integer> p = new Pair<>("Lucky Number", 13);
    //     Pair<Integer, String> q = Main.c;
    //     assertEquals(13, q.getFirst().intValue());
    //     assertEquals("Lucky Number", q.getSecond());

    //     Pair<Double, Boolean> r = new Pair<>(8.5, false);
    //     Pair<Boolean, Double> s = Main.problem2_swap(r);
    //     assertFalse(s.getFirst());
    //     assertEquals(8.5, s.getSecond().doubleValue(), EPSILON);
    // }
    
    
    @Test
    public void problem3() {
		String[] words = { "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet",
				"Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform",
				"Victor", "Whiskey", "X-Ray", "Yankee", "Zulu" };
		BinarySearcher<String> strSearcher = new BinarySearcher<>(words);
		assertEquals(13, strSearcher.search("November"));
		assertEquals(-1, strSearcher.search("October"));
		assertEquals(0, strSearcher.search("Alpha"));
		assertEquals(25, strSearcher.search("Zulu"));

		Integer[] ints = { 3, 4, 8, 13, 15, 28, 45, 46, 80, 95, 110, 112, 113, 2000, 28938 };
		BinarySearcher<Integer> intSearcher = new BinarySearcher<>(ints);
		assertEquals(-1, intSearcher.search(-8));
		assertEquals(7, intSearcher.search(46));
		assertEquals(-1, intSearcher.search(-3));
		assertEquals(0, intSearcher.search(3));
		assertEquals(1, intSearcher.search(4));
		assertEquals(14, intSearcher.search(28938));
		assertEquals(13, intSearcher.search(2000));

		Double[] dbls = { -10.22, -9.0, -3.229, 0.0, 4.4, 18.2, 99.003, 101.0, 283.88978, 329.0, 444003.1, 500999.882,
				278397483.3 };
		BinarySearcher<Double> dblSearcher = new BinarySearcher<>(dbls);
		assertEquals(-1, dblSearcher.search(4.0));
		assertEquals(-1, dblSearcher.search(9.0));
		assertEquals(3, dblSearcher.search(0.0));
		assertEquals(7, dblSearcher.search(101.0));
		assertEquals(8, dblSearcher.search(283.88978));
    }
    
    
    // @Test
    // public void problem4() {
		// List<String> a = Arrays.asList("apple", "orange");
		// List<String> b = Arrays.asList("pear", "banana");
		// List<String> c = Appender.append(a, b);
		// assertEquals(Arrays.asList("apple", "orange"), a);
		// assertEquals(Arrays.asList("pear", "banana"), b);
		// assertEquals(Arrays.asList("apple", "orange", "pear", "banana"), c);

		// List<Integer> intList1 = Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0);
		// List<Integer> intList2 = Arrays.asList(-8, 19, 4, 0, 20);
		// List<Integer> intList3 = Appender.append(intList1, intList2);
		// assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0), intList1);
		// assertEquals(Arrays.asList(-8, 19, 4, 0, 20), intList2);
		// assertEquals(Arrays.asList(3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20), intList3);

		// List<Double> dblList1 = Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0);
		// List<Double> dblList2 = Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0);
		// List<Double> dblList3 = Appender.append(dblList1, dblList2);
		// assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0), dblList1);
		// assertEquals(Arrays.asList(-0.0008, 1.9, 4.2, 0.0, 2.0), dblList2);
		// assertEquals(Arrays.asList(3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0),
		// 		dblList3);

		// String[] d = { "apple", "orange" };
		// String[] e = { "pear", "banana" };
		// String[] f = Appender.append(d, e);
		// assertTrue(Arrays.equals(new String[] { "apple", "orange" }, d));
		// assertTrue(Arrays.equals(new String[] { "pear", "banana" }, e));
		// assertTrue(Arrays.equals(new String[] { "apple", "orange", "pear", "banana" }, f));

		// Integer[] intArr1 = { 3, 13, 44, 18, 987, -29, -3, 0 };
		// Integer[] intArr2 = { -8, 19, 4, 0, 20 };
		// Integer[] intArr3 = Appender.append(intArr1, intArr2);
		// assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0 }, intArr1));
		// assertTrue(Arrays.equals(new Integer[] { -8, 19, 4, 0, 20 }, intArr2));
		// assertTrue(Arrays.equals(new Integer[] { 3, 13, 44, 18, 987, -29, -3, 0, -8, 19, 4, 0, 20 }, intArr3));

		// Double[] dblArr1 = { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 };
		// Double[] dblArr2 = { -0.0008, 1.9, 4.2, 0.0, 2.0 };
		// Double[] dblArr3 = Appender.append(dblArr1, dblArr2);
		// assertTrue(Arrays.equals(new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0 }, dblArr1));
		// assertTrue(Arrays.equals(new Double[] { -0.0008, 1.9, 4.2, 0.0, 2.0 }, dblArr2));
		// assertTrue(Arrays.equals(
		// 		new Double[] { 3.2, 13.3, 44.4, 18.0, 987.9385, -29.0, -0.3, 0.0, -0.0008, 1.9, 4.2, 0.0, 2.0 },
		// 		dblArr3));
    // }
    
    
    // @Test
    // public void problem5() {
    //     List<String> a = Arrays.asList("apple", "orange", "apple");
    //     assertTrue(Main.problem5_isPalindrome(a));
    //     List<Color> b = Arrays.asList(Color.RED, Color.GREEN);
    //     assertFalse(Main.problem5_isPalindrome(b));
    //     List<Color> c = Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.GREEN, Color.RED);
    //     assertTrue(Main.problem5_isPalindrome(c));
    // }
}
