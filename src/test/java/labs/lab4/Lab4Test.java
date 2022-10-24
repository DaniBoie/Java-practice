package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab4.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Lab4Test {
	private final double EPSILON = 1e-13;
	
	@Test
	public void problem1() {
		// Test case 1:
		Robot robot = new Robot();
		assertEquals(true, robot.getLocation().equals(new Point(0, 0))); 
		assertEquals("N", robot.getDirection());

		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(0, 1))); 
		assertEquals("N", robot.getDirection());
		
		robot.turnRight(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(2, 1))); 
		assertEquals("E", robot.getDirection());
		
		robot.turnRight(); 
		assertTrue(robot.move());  
		assertTrue(robot.move()); 
		assertEquals(true, robot.getLocation().equals(new Point(2, -1))); 
		assertEquals("S", robot.getDirection());
		
		robot.turnLeft();
		assertTrue(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(3, -1))); 
		assertEquals("E", robot.getDirection());
		
		robot.turnRight();
		robot.turnRight();
		robot.turnRight();
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertTrue(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertFalse(robot.move());
		assertEquals(true, robot.getLocation().equals(new Point(3, 9))); 
		assertEquals("N", robot.getDirection());
		

		// Test case 2:
		Robot robot2 = new Robot();
		assertTrue(robot2.move()); 
		robot2.turnLeft(); 
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertTrue(robot2.move());
		assertFalse(robot2.move());
		assertFalse(robot2.move());
		assertEquals(true, robot2.getLocation().equals(new Point(-7, 1))); 
		assertEquals("W", robot2.getDirection());
	}
	
	
	@Test
	public void problem3() {
		Customer c = new Customer();
		c.makePurchase(75);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(75.0, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(50.25);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(125.25, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(9.99);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(134.241, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(234.30);
		assertEquals(2, c.getNumDiscountsToUse());
		assertEquals(368.541, c.getTotalAmountSpent(), EPSILON);
		c.makePurchase(10);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(377.541, c.getTotalAmountSpent(), EPSILON);
	}
	
	
	@Test
	public void problem5() {
		ComboLock lock = new ComboLock(38, 14, 7);
		lock.turnRight(2);
		lock.turnLeft(16);
		lock.turnRight(7);
		assertTrue(lock.open());
		lock.reset();
		lock.turnRight(2);
		lock.turnLeft(21);
		lock.turnRight(7);
		assertFalse(lock.open());
	}
	
	
	@Test
	public void problem6() {
		BankAccount account = new BasicAccount(100.0);
		account.withdraw(80.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
		account.withdraw(50.00);
		assertEquals(20.0, account.getBalance(), EPSILON);
	}
	
	
	@Test
	public void problems7to10() {
		// Test case 1
		List<String> actors = new ArrayList<String>();
		actors.add("Amy Adams");
		actors.add("Glenn Close");
		actors.add("Haley Bennett");
		actors.add("Gabriel Basso");
		DVD dvd1 = new DVD("Hillbilly Elegy", actors);
		Magazine mag1 = new Magazine("Time", 435, "February 2021");
		DigitalBook db1 = new DigitalBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb1 = new PrintBook("Hillbilly Elegy", "J.D. Vance", 264);
		PrintBook pb2 = new PrintBook("The Warmth of Other Suns", "Isabel Wilkerson", 622);
		PrintBook pb3 = new PrintBook("Caste", "Isabel Wilkerson", 496);
		AudioBook ab1 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		AudioBook ab2 = new AudioBook("Hillbilly Elegy", "J.D. Vance", 6.8);
		assertEquals(true, ab1.equals(ab2));
		assertEquals(false, dvd1.equals(db1));
		assertEquals(false, pb2.equals(pb3));

		LibraryItem[] items = new LibraryItem[8];
		items[0] = dvd1;
		items[1] = mag1;
		items[2] = db1;
		items[3] = pb1;
		items[4] = pb2;
		items[5] = pb3;
		items[6] = ab1;
		items[7] = ab2;
		
		String[] checkoutDays = new String[] {"7 days", "7 days", "14 days", "21 days", "21 days", "21 days", "28 days", "28 days"};
		for (int i=0;i<items.length; i++) {
			assertEquals(checkoutDays[i], items[i].checkOut());
		}
		assertEquals("28 days", items[6].checkOut());
		assertEquals("NOT ALLOWED", items[6].checkOut());
		items[6].checkIn();
		assertEquals("28 days", items[6].checkOut());
	}
}
