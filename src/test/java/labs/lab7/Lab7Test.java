package labs.lab7;

import static org.junit.Assert.*;

import labs.lab7.*;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Lab7Test {

	@Test
	public void problem1() {
		assertEquals(1, Main.problem1_countElevens(new int[] { 1, 2, 11 }, 0));
		assertEquals(2, Main.problem1_countElevens(new int[] { 11, 11 }, 0));
		assertEquals(0, Main.problem1_countElevens(new int[] { 1, 2, 3, 4 }, 0));
		assertEquals(3, Main.problem1_countElevens(new int[] { 1, 11, 3, 11, 11 }, 0));
		assertEquals(1, Main.problem1_countElevens(new int[] { 11 }, 0));
		assertEquals(0, Main.problem1_countElevens(new int[] { 1 }, 0));
		assertEquals(0, Main.problem1_countElevens(new int[] {}, 0));
		assertEquals(2, Main.problem1_countElevens(new int[] { 11, 2, 3, 4, 11, 5 }, 0));
		assertEquals(2, Main.problem1_countElevens(new int[] { 11, 5, 11 }, 0));
	}


	@Test
	public void problem2() {
		assertEquals(0, Main.problem2_countEars(0));
		assertEquals(2, Main.problem2_countEars(1));
		assertEquals(5, Main.problem2_countEars(2));
		assertEquals(7, Main.problem2_countEars(3));
		assertEquals(10, Main.problem2_countEars(4));
		assertEquals(12, Main.problem2_countEars(5));
		assertEquals(15, Main.problem2_countEars(6));
		assertEquals(25, Main.problem2_countEars(10));
	}


	@Test
	public void problem3() {
		assertEquals(1, Main.problem3_count8s(8));
		assertEquals(2, Main.problem3_count8s(818));
		assertEquals(4, Main.problem3_count8s(8818));
		assertEquals(4, Main.problem3_count8s(8088));
		assertEquals(0, Main.problem3_count8s(123));
		assertEquals(2, Main.problem3_count8s(81238));
		assertEquals(6, Main.problem3_count8s(88788));
		assertEquals(1, Main.problem3_count8s(8234));
		assertEquals(1, Main.problem3_count8s(2348));
		assertEquals(3, Main.problem3_count8s(23884));
		assertEquals(0, Main.problem3_count8s(0));
		assertEquals(5, Main.problem3_count8s(1818188));
		assertEquals(5, Main.problem3_count8s(8818181));
		assertEquals(1, Main.problem3_count8s(1080));
		assertEquals(3, Main.problem3_count8s(188));
		assertEquals(9, Main.problem3_count8s(88888));
		assertEquals(2, Main.problem3_count8s(9898));
		assertEquals(1, Main.problem3_count8s(78));
	}


	@Test
	public void problems4Through5() throws IOException {
		// names1.txt:
		NameSorter ns = new NameSorter("res/names1.txt");
		ns.sortNames();
		;
		List<String> linesList = Arrays.asList("Johnson, Jim", "Jones, Aaron", "Jones, Chris", "Ling, Mai",
				"Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina");
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File("res/names1.txt").toPath()));

		// names1.txt:
		ns = new NameSorter("res/names2.txt");
		ns.sortNames();
		;
		linesList = Arrays.asList("ARNOLD, ALAN", "glass, george", "Johnson, Jim", "Jones, Aaron", "Jones, Chris",
				"Ling, Mai", "Ling, Mai", "Swift, Geoffrey", "Xiong, Fong", "Zarnecki, Sabrina");
		assertEquals(linesList, java.nio.file.Files.readAllLines(new File("res/names2.txt").toPath()));
	}


	@Test
	public void problem6() {
		// test1.txt:
		WordCounter wc1 = new WordCounter("res/test1.txt");
		assertEquals(37, wc1.getNumUniqueWords());
		assertEquals(50, wc1.getNumWords());
		ArrayList<String> result = new ArrayList<String>(Arrays.asList("a", "across", "actually", "alice", "and", "at",
				"before", "either", "feet", "flashed", "for", "had", "her", "hurried", "it", "its", "looked", "mind",
				"never", "of", "on", "or", "out", "rabbit", "seen", "she", "started", "take", "that", "the", "then",
				"to", "took", "waistcoatpocket", "watch", "when", "with"));
		assertEquals(result, wc1.getUniqueWords());

		// test2.txt:
		WordCounter wc2 = new WordCounter("res/test2.txt");
		assertEquals(23, wc2.getNumUniqueWords());
		assertEquals(26, wc2.getNumWords());
		result = new ArrayList<String>(Arrays.asList("a", "as", "but", "disappointment", "down", "empty", "from",
				"great", "her", "it", "jar", "labelled", "marmalade", "of", "one", "orange", "passed", "she", "shelves",
				"the", "to", "took", "was"));
		assertEquals(result, wc2.getUniqueWords());

		// text3.txt:
		WordCounter wc3 = new WordCounter("res/test3.txt");
		assertEquals(28, wc3.getNumUniqueWords());
		assertEquals(33, wc3.getNumWords());
		result = new ArrayList<String>(Arrays.asList("12", "again", "alice", "began", "cat", "dinah", "dinahll", "do",
				"down", "else", "i", "me", "miss", "much", "nothing", "old", "should", "so", "soon", "talking", "the",
				"there", "think", "to", "tonight", "very", "was", "years"));
		assertEquals(result, wc3.getUniqueWords());
	}


	@Test
	public void problem7() {
		Driveway driveway = new Driveway();
		assertEquals(Arrays.asList("Driveway: 1", "Street: "), driveway.add(1));
		assertEquals(Arrays.asList("Driveway: 1 2", "Street: "), driveway.add(2));
		assertEquals(Arrays.asList("Driveway: 1 2 3", "Street: "), driveway.add(3));
		assertEquals(Arrays.asList("That car is already in the driveway."), driveway.add(3));
		assertEquals(Arrays.asList("Driveway: 1 2 3 4", "Street: "), driveway.add(4));
		assertEquals(Arrays.asList("Driveway: 1 2 3", "Street: 4", "Driveway: 1 2", "Street: 4 3", "Driveway: 1 3",
				"Street: 4", "Driveway: 1 3 4", "Street: "), driveway.remove(2));
		assertEquals(Arrays.asList("Driveway: 1 3", "Street: "), driveway.remove(4));
		assertEquals(Arrays.asList("Driveway: 1 3 5", "Street: "), driveway.add(5));
		assertEquals(Arrays.asList("Driveway: 1 3 5 6", "Street: "), driveway.add(6));
		assertEquals(Arrays.asList("Driveway: 1 3 5", "Street: 6", "Driveway: 1 3", "Street: 6 5", "Driveway: 1",
				"Street: 6 5 3", "Driveway: 3", "Street: 6 5", "Driveway: 3 5", "Street: 6", "Driveway: 3 5 6",
				"Street: "), driveway.remove(1));
		assertEquals(Arrays.asList("That car is not in the driveway."), driveway.remove(1));
	}


	@Test
	public void problems8And9() {
		// Test Block class:
		Block myBlock = new Block(5, 10);
		assertEquals(10, myBlock.getPrice());
		assertEquals(5, myBlock.getQuantity());

		myBlock.sell(4);
		assertEquals(1, myBlock.getQuantity());

		// Test StockSimulator class
		StockSimulator mySimulator = new StockSimulator();

		Block myBlock1 = new Block(100, 12);
		Block myBlock2 = new Block(100, 10);
		mySimulator.buy(100, 12);
		mySimulator.buy(100, 10);
		assertEquals(myBlock1.getPrice(), mySimulator.getBlocks().get(0).getPrice());
		assertEquals(myBlock1.getQuantity(), mySimulator.getBlocks().get(0).getQuantity());
		assertEquals(myBlock2.getPrice(), mySimulator.getBlocks().get(1).getPrice());
		assertEquals(myBlock2.getQuantity(), mySimulator.getBlocks().get(1).getQuantity());

		assertEquals(550, mySimulator.sell(150, 15));
		assertEquals(250, mySimulator.sell(50, 15));

		// Test exceptions:
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			mySimulator.sell(100, 5);
		});
		String expectedMessage = "Unable to complete sale";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			mySimulator.sell(20, 1);
		});
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			mySimulator.buy(-9, 5);
		});
		expectedMessage = "Unable to complete purchase";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));

		exception = assertThrows(IllegalArgumentException.class, () -> {
			mySimulator.buy(9, -5);
		});
		expectedMessage = "Unable to complete purchase";
		actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}


	// @Test
	// public void problem10() {
	// 	EmergencyRoom er = new EmergencyRoom();

	// 	er.addPatient(Injury.ABDOMINAL_PAIN, "18 year old says stomach hurts");
	// 	er.addPatient(Injury.BURN, "Person burned hand while cooking dinner");
	// 	er.addPatient(Injury.CHEST_PAIN, "63 year old has chest pain");
	// 	er.addPatient(Injury.FRACTURE, "10 year old hurt knee while playing soccer, possible fracture");
	// 	er.addPatient(Injury.HEMORRHAGE, "23 year old complaining of paper cut");
	// 	er.addPatient(Injury.OTHER, "UCI student with a hangnail");

	// 	assertEquals(Injury.HEMORRHAGE, er.nextPatient().getInjury());

	// 	Patient p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

	// 	p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

	// 	p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.FRACTURE) || p.getInjury().equals(Injury.ABDOMINAL_PAIN));

	// 	p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.FRACTURE) || p.getInjury().equals(Injury.ABDOMINAL_PAIN));

	// 	assertEquals(Injury.OTHER, er.nextPatient().getInjury());

	// 	assertNull(er.nextPatient());

	// 	er.addPatient(Injury.OTHER, "45 year old complains of a runny nose");
	// 	er.addPatient(Injury.SEIZURE, "person having a seizure");
	// 	er.addPatient(Injury.ABDOMINAL_PAIN,
	// 			"UCI student complains of stomach pain after participating in a hot dog eating contest");
	// 	er.addPatient(Injury.SEIZURE, "person having a seizure");

	// 	assertEquals(Injury.SEIZURE, er.nextPatient().getInjury());
	// 	assertEquals(Injury.SEIZURE, er.nextPatient().getInjury());
	// 	assertEquals(Injury.ABDOMINAL_PAIN, er.nextPatient().getInjury());

	// 	er.addPatient(Injury.FRACTURE, "person says pinky toe hurts, possible fracture");
	// 	er.addPatient(Injury.CHEST_PAIN, "heart patient complaining of chest pain");
	// 	er.addPatient(Injury.BURN, "person stayed at the beach too long and forgot sunscreen");

	// 	p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

	// 	p = er.nextPatient();
	// 	assertTrue(p.getInjury().equals(Injury.BURN) || p.getInjury().equals(Injury.CHEST_PAIN));

	// 	er.addPatient(Injury.OTHER, "Stubbed toe");

	// 	assertEquals(Injury.FRACTURE, er.nextPatient().getInjury());
	// 	assertEquals(Injury.OTHER, er.nextPatient().getInjury());
	// 	assertEquals(Injury.OTHER, er.nextPatient().getInjury());
	// 	assertNull(er.nextPatient());
	// 	assertNull(er.nextPatient());
	// }

}
