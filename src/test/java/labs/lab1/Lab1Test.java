package labs.lab1;

import static org.junit.Assert.*;

import java.awt.Color;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import labs.lab1.*;


public class Lab1Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problem1() {
		assertEquals("hi", Main.problem1_frontMatch("hippo", "hi"));
		assertEquals("hip", Main.problem1_frontMatch("hippo", "xip"));
		assertEquals("", Main.problem1_frontMatch("hippo", "dog"));
		assertEquals("h", Main.problem1_frontMatch("hippo", "i"));
		assertEquals("", Main.problem1_frontMatch("hippo", "ix"));
		assertEquals("", Main.problem1_frontMatch("h", "ix"));
		assertEquals("", Main.problem1_frontMatch("", "i"));
		assertEquals("hi", Main.problem1_frontMatch("hip", "zi"));
		assertEquals("hip", Main.problem1_frontMatch("hip", "zip"));
		assertEquals("", Main.problem1_frontMatch("hip", "zig"));
		assertEquals("h", Main.problem1_frontMatch("h", "z"));
		assertEquals("hippo", Main.problem1_frontMatch("hippo", "xippo"));
		assertEquals("", Main.problem1_frontMatch("hippo", "xyz"));
		assertEquals("hip", Main.problem1_frontMatch("hippo", "hip"));
		assertEquals("kit", Main.problem1_frontMatch("kitten", "cit"));
		assertEquals("kit", Main.problem1_frontMatch("kit", "cit"));
	}
	
	
	@Test
	public void problem2() {
		assertEquals("abcat", Main.problem2_concatNoDoubles("abc", "cat"));
		assertEquals("dogcat", Main.problem2_concatNoDoubles("dog", "cat"));
		assertEquals("abc", Main.problem2_concatNoDoubles("abc", ""));
		assertEquals("abccc", Main.problem2_concatNoDoubles("abc", "ccc"));
		assertEquals("cat", Main.problem2_concatNoDoubles("", "cat"));
		assertEquals("pig", Main.problem2_concatNoDoubles("pig", "g"));
		assertEquals("pigdoggy", Main.problem2_concatNoDoubles("pig", "doggy"));
	}
	
	
	@Test
	public void problem3() {
		assertEquals(new Color(35, 70, 105), Main.problem3_darker(50, 100, 150));
		assertEquals(new Color(89, 0, 0), Main.problem3_darker(128, 0, 0));
		assertEquals(new Color(86, 72, 166), Main.problem3_darker(123, 104, 238));
		assertEquals(new Color(0, 0, 0), Main.problem3_darker(0, 0, 0));
		assertEquals(new Color(178, 178, 178), Main.problem3_darker(255, 255, 255));
	}
	
	
	@Test
	public void problem4() {
		assertEquals("Thursday", Main.problem4_getDayOfWeek(2022, Calendar.AUGUST, 4));
		assertEquals("Saturday",Main.problem4_getDayOfWeek(2021, Calendar.DECEMBER, 25));
		assertEquals("Friday", Main.problem4_getDayOfWeek(2020, Calendar.DECEMBER, 18));
		assertEquals("Monday", Main.problem4_getDayOfWeek(1934, Calendar.APRIL, 2)); 
	}
	
	
	@Test
	public void problem5() {
		assertEquals(new BigInteger("1881676411868862234942354805142998028003108518161"), Main.problem5_bigCube(new BigInteger("12345678987654321")));
		assertEquals(new BigInteger("999999996666664003703709628260254595333443072"), Main.problem5_bigCube(new BigInteger("999999998888888")));
	}
	
	
	// @Test
	// public void problem6() {
	// 	Employee robert = new Employee("Robert Navarro", 100000);
	// 	robert.raiseSalary(10);
	// 	assertEquals(110000.0, robert.getSalary(), EPSILON);
	// 	Employee george = new Employee("George Glass", 500);
	// 	assertEquals(500.0, george.getSalary(), EPSILON);
	// 	george.raiseSalary(0);
	// 	assertEquals(500.0, george.getSalary(), EPSILON);
	// 	george.raiseSalary(100);
	// 	assertEquals(1000.0, george.getSalary(), EPSILON);
	// }
	
	// @Test
	// public void problem7() {
	// 	Balloon balloon = new Balloon();
	// 	balloon.inflate(2.0);
	// 	assertEquals(33.510, balloon.getVolume(), EPSILON);
	// 	balloon.inflate(0.0);
	// 	assertEquals(33.510, balloon.getVolume(), EPSILON);
	// 	balloon.inflate(1.5);
	// 	assertEquals(179.594, balloon.getVolume(), EPSILON);
	// }
	
	// @Test
	// public void problem8() {
	// 	CashRegister register1 = new CashRegister();
		
	// 	register1.recordPurchase(29.50);
	// 	register1.recordPurchase(9.25);
	// 	assertEquals(2,register1.getItemCountInPurchase()); 
		
	// 	register1.receivePayment(50.00);
	
	// 	register1.giveChange();
		
	// 	register1.recordPurchase(30);
	// 	register1.recordPurchase(10);
	// 	register1.receivePayment(50);
	// 	register1.giveChange();

	// 	register1.recordPurchase(20);
	// 	register1.receivePayment(20);
	// 	register1.giveChange();
	// 	assertEquals(98.75, register1.getSalesTotal(), EPSILON); 
	// 	assertEquals(3, register1.getSalesCount()); 

		
	// 	CashRegister register2 = new CashRegister();
		
	// 	register2.recordPurchase(29.50);
	// 	register2.recordPurchase(9.25);
	// 	register2.receivePayment(50.00);

	// 	String receipt = register2.getReceipt();
	// 	boolean correctReceipt = true; 
		
	// 	Scanner scanner = new Scanner(receipt);
	// 	List<Double> history = new ArrayList<>();
		
	// 	try {
	// 		while (scanner.hasNextLine()) {
	// 			  String line = scanner.nextLine();	  
	// 			  history.add(Double.valueOf(line));
	// 		}			
	// 	} catch(Exception e) {
	// 		correctReceipt = false;
	// 		System.out.println(e.getMessage()); //Something went wrong with the conversion from String to Double.
	// 	}

	// 	assertEquals(true, correctReceipt); //All numbers are doubles in different lines.
	// 	assertEquals(3, history.size()); //Only 3 values in history
		
	// 	if (history.size() == 3) {
	// 		// All lines must be correct in content and order
	// 		assertEquals(29.5, history.get(0), EPSILON);
	// 		assertEquals(9.25, history.get(1), EPSILON);
	// 		assertEquals(38.75, history.get(2), EPSILON);
	// 	}
	// 	scanner.close();
	// }
	
	// @Test
	// public void problem9() {
	// 	Sheet sheet = new Sheet();
	// 	assertEquals("A0", sheet.getName());
	// 	assertEquals(841, sheet.getWidth());
	// 	assertEquals(1189, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A1", sheet.getName());
	// 	assertEquals(594, sheet.getWidth());
	// 	assertEquals(841, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A2", sheet.getName());
	// 	assertEquals(420, sheet.getWidth());
	// 	assertEquals(594, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A3", sheet.getName());
	// 	assertEquals(297, sheet.getWidth());
	// 	assertEquals(420, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A4", sheet.getName());
	// 	assertEquals(210, sheet.getWidth());
	// 	assertEquals(297, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A5", sheet.getName());
	// 	assertEquals(148, sheet.getWidth());
	// 	assertEquals(210, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A6", sheet.getName());
	// 	assertEquals(105, sheet.getWidth());
	// 	assertEquals(148, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A7", sheet.getName());
	// 	assertEquals(74, sheet.getWidth());
	// 	assertEquals(105, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A8", sheet.getName());
	// 	assertEquals(52, sheet.getWidth());
	// 	assertEquals(74, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A9", sheet.getName());
	// 	assertEquals(37, sheet.getWidth());
	// 	assertEquals(52, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A10", sheet.getName());
	// 	assertEquals(26, sheet.getWidth());
	// 	assertEquals(37, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A11", sheet.getName());
	// 	assertEquals(18, sheet.getWidth());
	// 	assertEquals(26, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A12", sheet.getName());
	// 	assertEquals(13, sheet.getWidth());
	// 	assertEquals(18, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A13", sheet.getName());
	// 	assertEquals(9, sheet.getWidth());
	// 	assertEquals(13, sheet.getLength());

	// 	sheet = sheet.cutInHalf();
	// 	assertEquals("A14", sheet.getName());
	// 	assertEquals(6, sheet.getWidth());
	// 	assertEquals(9, sheet.getLength());
	// }
	
	// @Test
	// public void problem10() {
	// 	Battery battery1 = new Battery(100.0);
	// 	assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);
	// 	battery1.drain(23.4);
	// 	battery1.drain(9.7);
	// 	assertEquals(66.9, battery1.getRemainingCapacity(), EPSILON);
	// 	battery1.charge();
	// 	assertEquals(100.0, battery1.getRemainingCapacity(), EPSILON);

	// 	Battery battery2 = new Battery(55.75);
	// 	assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.drain(55.75);
	// 	assertEquals(0.0, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.charge();
	// 	assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.drain(1.0);
	// 	assertEquals(54.75, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.charge();
	// 	assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.charge();
	// 	assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	// 	battery2.drain(0);
	// 	assertEquals(55.75, battery2.getRemainingCapacity(), EPSILON);
	// }
}