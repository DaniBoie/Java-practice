package labs.lab6;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab6.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lab6Test {

	@Test
	public void problems1And2() throws IOException {
		TextImprover ti = new TextImprover("./res/overused-words.txt");
		
		// overused1.txt:
		String testFileName = "res/overused1.txt";
		// ti.improveText(testFileName);
		List<String> expLinesList = Arrays.asList(
				"I just had the most astonishing, intriguing day. It was frankly the most critical,",
				"distinctive, fantastic, certainly inspiring experience ever."
				);
		List<String> actualLinesList = java.nio.file.Files.readAllLines(new File(testFileName).toPath());
		// // trim the actual lines in case of any trailing spaces at the end of a line:
		// for (int i=0; i<actualLinesList.size(); i++) {
		// 	actualLinesList.set(i, actualLinesList.get(i).trim());
		// }
		// assertEquals(expLinesList, actualLinesList);
		
		// overused2.txt:
		testFileName = "res/overused2.txt";
		ti.improveText(testFileName);
		expLinesList = Arrays.asList(
				"I just had the most astonishing, intriguing day. It was frankly the most critical,",
				"distinctive, fantastic, certainly inspiring experience ever.",
				"",
				"\"Astonishing\" is really the best way I can think of to describe it.",
				"",
				"Frankly, it is taxing to express how much I liked it. It was amazingly PLEASANT!!!!! Superior, not inferior. I wouldn't transform a bit of it.",
				"",
				"Please, be pleasant and help me fix my writing!! cat BB bbb Bb CAT"
				);
		actualLinesList = java.nio.file.Files.readAllLines(new File(testFileName).toPath());
		// trim the actual lines in case of any trailing spaces at the end of a line:
		for (int i=0; i<actualLinesList.size(); i++) {
			actualLinesList.set(i, actualLinesList.get(i).trim());
		}
		assertEquals(expLinesList, actualLinesList);
		
		// blank.txt:
		testFileName = "res/blank.txt";
		ti.improveText(testFileName);
		expLinesList = new ArrayList<String>();
		actualLinesList = java.nio.file.Files.readAllLines(new File(testFileName).toPath());
		assertEquals(expLinesList, actualLinesList);

		
		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		ti.improveText(nonExistentFileName);
		
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}

	@Test
	public void problem3() {

		// success operations:
		Student george = new Student("George Glass", 1234);
		assertEquals(1234, george.getID());

		george.addClass("ICS 45J");
		george.addClass("Ballet I");
		george.addClass("Chem 51C");
		george.dropClass("Ballet I");

		// exception operations:

		// assigning negative ID:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Student robert = new Student("Robert Navarro", -1234);
		});
		String expectedMessage = "ID cannot be negative";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		// dropping a class that the student doesn't have:
		exception = assertThrows(IllegalArgumentException.class, () -> {
			george.dropClass("ICS 10");
		});
		expectedMessage = "Cannot drop class ICS 10 because student is not enrolled in it";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
		List<String> expClasses = Arrays.asList("Chem 51C", "ICS 45J");
//		assertIterableEquals(expClasses, george.getClasses());
		assertEquals(expClasses, george.getClasses());
	}


	@Test
	public void problem4() throws IOException {
		String prodFileName = "res/products.txt";
		ProductDB db = new ProductDB(prodFileName);

		assertEquals(new Product("Blue plaid bow tie collar", 29.95, 6), db.findProduct("Blue plaid bow tie collar"));
		assertEquals(new Product("Red bandana", 3.99, 16), db.findProduct("Red bandana"));
		assertEquals(new Product("White porcelain food and water bowl set", 23.00, 8),
				db.findProduct("White porcelain food and water bowl set"));
		assertEquals(new Product("XL tan fluffy dog bed", 75.25, 2), db.findProduct("XL tan fluffy dog bed"));
		assertNull(db.findProduct("stuffed sloth"));
		db.addProduct("stuffed sloth", 9.99, 4);
		assertEquals(new Product("stuffed sloth", 9.99, 4), db.findProduct("stuffed sloth"));

		// check that file was updated:
		List<String> linesList = Arrays.asList("Blue plaid bow tie collar;29.95;6", "Red bandana;3.99;16",
				"White porcelain food and water bowl set;23.00;8", "XL tan fluffy dog bed;75.25;2",
				"stuffed sloth;9.99;4");
//		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		assertNull(db.findProduct("stuffed puppy"));
		db.addProduct("stuffed puppy", 19.99, 41);
		assertEquals(new Product("stuffed puppy", 19.99, 41), db.findProduct("stuffed puppy"));

		// check that file was updated:
		linesList = Arrays.asList("Blue plaid bow tie collar;29.95;6", "Red bandana;3.99;16",
				"White porcelain food and water bowl set;23.00;8", "XL tan fluffy dog bed;75.25;2",
				"stuffed sloth;9.99;4", "stuffed puppy;19.99;41");
//		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		// check that previous products are still there:
		assertEquals(new Product("Red bandana", 3.99, 16), db.findProduct("Red bandana"));
		assertEquals(new Product("White porcelain food and water bowl set", 23.00, 8),
				db.findProduct("White porcelain food and water bowl set"));

		// check that a product with the same name as existing product isn't added:
		db.addProduct("stuffed sloth", 0.99, 1);
		assertEquals(new Product("stuffed sloth", 9.99, 4), db.findProduct("stuffed sloth"));

		// check that file is unchanged:
//		assertLinesMatch(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File(prodFileName).toPath()));

		// test exception message is printed out:
		String nonExistentFileName = "res/nothing.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		ProductDB db2 = new ProductDB(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
	}


// 	@Test
// 	public void problem5() {
// 		Bank bank1 = new Bank("res/accounts1.dat");
// 		assertEquals(new BankAccount(2, 300.0), bank1.getLowestBalanceAccount());
		
// 		Bank bank2 = new Bank("res/accounts2.dat");
// 		assertEquals(new BankAccount(4, 4), bank2.getLowestBalanceAccount());
		
// 		Bank bank3 = new Bank("res/accounts3.dat");
// 		assertEquals(new BankAccount(9098, 0), bank3.getLowestBalanceAccount());
		
// 		Bank bank4 = new Bank("res/accounts4.dat");
// 		assertEquals(new BankAccount(10, 3), bank4.getLowestBalanceAccount());
		
// 		Bank bank5 = new Bank("res/blank.txt");
// 		assertNull(bank5.getLowestBalanceAccount());

// 		// test exception message is printed out:
// 		String nonExistentFileName = "res/nothing.txt";
// 		ByteArrayOutputStream output = new ByteArrayOutputStream();
// 		System.setOut(new PrintStream(output));
// 		Bank bank6 = new Bank(nonExistentFileName);

// 		String result = output.toString();
// 		assertEquals("File: " + nonExistentFileName + " not found", result);
// 	}
	
	
// 	@Test
// 	public void problems6through10() {
// 		MessagingSystem system = new MessagingSystem();
// 		system.deliver("Emily", "Robert", "Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n");
// 		system.deliver("Emily", "45J Student", "Hey 45J Student,\n"
// 				+ "You are doing great!\n"
// 				+ "Keep up the good work.\n"
// 				+ "-Prof. Navarro\n");
// 		assertEquals(" -----\n"
// 				+ "From: Emily\n"
// 				+ "To: 45J Student\n"
// 				+ "Hey 45J Student,\n"
// 				+ "You are doing great!\n"
// 				+ "Keep up the good work.\n"
// 				+ "-Prof. Navarro\n", system.getMessages("45J Student"));
// 		system.deliver("45J Student", "Robert", "Robert, you are the best dog ever!!!\n");
// 		assertEquals(" -----\n"
// 				+ "From: Emily\n"
// 				+ "To: Robert\n"
// 				+ "Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n"
// 				+ " -----\n"
// 				+ "From: 45J Student\n"
// 				+ "To: Robert\n"
// 				+ "Robert, you are the best dog ever!!!\n", system.getMessages("Robert"));

// 		Message message = new Message("Emily","Robert","Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n");
// 		assertEquals("Robert",message.getRecipient());
// 		assertEquals("From: Emily\n"
// 				+ "To: Robert\n"
// 				+ "Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n",message.toString());
		
// 		Mailbox mailbox = new Mailbox("Robert");
// 		assertEquals("Robert", mailbox.getUser());
// 		Message message1 = new Message("Emily","Robert","Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n");
// 		Message message2 = new Message("45J Student","Robert","Robert, you are the best dog ever!!!\n");
// 		mailbox.addMessage(message1);
// 		mailbox.addMessage(message2);
// 		assertEquals(" -----\n"
// 				+ "From: Emily\n"
// 				+ "To: Robert\n"
// 				+ "Hi Robert,\n"
// 				+ "You are snoring too loud!\n"
// 				+ "I love oyu anyway.\n"
// 				+ "Love,\n"
// 				+ "Mom\n"
// 				+ " -----\n"
// 				+ "From: 45J Student\n"
// 				+ "To: Robert\n"
// 				+ "Robert, you are the best dog ever!!!\n",mailbox.getAllMessages());
// 	}
}
