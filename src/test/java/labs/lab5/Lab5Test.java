package labs.lab5;

import static org.junit.Assert.*;

import org.junit.Test;

import labs.lab5.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Lab5Test {

	private final double EPSILON = 1e-3;

	@Test
	public void problems1through5() {
		Player robert = new Player("Robert");
		assertEquals(0.5, robert.getHealth(), EPSILON);
		
		Ingestible broccoli = new Food("broccoli", 10);
		Ingestible cheetos = new Food("cheetos", 0);
		Ingestible water = new Drink("water", 100);
		Ingestible wine = new Drink("wine", 5);
		Ingestible vitamins = new Pills("vitamins", 9);
		Ingestible illegalDrugs = new Pills("illegal drugs", -100);
		
		Doable work = new Activity("work", 3, 8);
		Doable sleep = new Activity("sleep", 10, 7);
		Doable play = new Activity("play", 8, 1);
		Doable study = new Activity("study", 4, 3);
		
		assertEquals("Robert is eating broccoli", broccoli.ingest(robert));
		assertEquals(1.0, robert.getHealth(), EPSILON);
		assertEquals("Robert is eating broccoli", broccoli.ingest(robert));
		assertEquals(1.0, robert.getHealth(), EPSILON);
		assertEquals("Robert is eating cheetos", cheetos.ingest(robert));
		assertEquals(0.5, robert.getHealth(), EPSILON);
		assertEquals("Robert is drinking water", water.ingest(robert));
		assertEquals(0.75, robert.getHealth(), EPSILON);
		assertEquals("Robert is drinking wine", wine.ingest(robert));
		assertEquals(0.75, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		assertEquals(0.25, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking vitamins", vitamins.ingest(robert));
		assertEquals(0.65, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing work for 8 hours", work.doIt(robert));
		assertEquals(0.55, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing sleep for 7 hours", sleep.doIt(robert));
		assertEquals(0.8, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing play for 1 hours", play.doIt(robert));
		assertEquals(0.95, robert.getHealth(), EPSILON);
		assertEquals("Robert is doing study for 3 hours", study.doIt(robert));
		assertEquals(0.9, robert.getHealth(), EPSILON);
		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		assertEquals(0.4, robert.getHealth(), EPSILON);
		
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		assertEquals("Robert is taking illegal drugs", illegalDrugs.ingest(robert));
		
		String result = output.toString();
		assertEquals("Robert died!", result);
		
		assertEquals(0.0, robert.getHealth(), EPSILON);
		
		
		Player emily = new Player("Emily");
		
		Ingestible boba = new Drink("boba", 2);
		
		assertEquals("Emily is drinking boba", boba.ingest(emily));
		assertEquals(0.35, emily.getHealth(), EPSILON);
		assertEquals("Emily is doing play for 1 hours", play.doIt(emily));
		assertEquals(0.5, emily.getHealth(), EPSILON);
		assertEquals("Emily is eating broccoli", broccoli.ingest(emily));
		assertEquals(1.0, emily.getHealth(), EPSILON);
		assertEquals("Emily is taking vitamins", vitamins.ingest(emily));
		assertEquals(1.0, emily.getHealth(), EPSILON);
	}
	
	
    @Test
    public void problems6through8() {
        Telemarketer telemarketer = new Telemarketer("Jose");
        Sibling s1 = new Sibling("Mollie");
        Sibling s2 = new Sibling("Corey");
        Pest[] pests = {
                telemarketer,
                s1,
                s2,
                new Ad(),
                new Ad(),
                new Fly()
        };
        String [] expected = new String [] {
                "Call during dinner | Continue talking when you say no",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Tease you about your insecurities | Laugh at you when you are mad",
                "Block something you really want to see | Don't go away even when you click X",
                "Block something you really want to see | Don't go away even when you click X",
                "Fly around your head | Land on things",
        };
        for (int i = 0; i < pests.length; i++) {
            assertEquals(expected[i], pests[i].annoy());
        }

        Person[] people = { telemarketer, s1, s2 };
        Arrays.sort(people); // people is now sorted: Corey, Jose, Mollie
        String [] expected_name = new String [] {"Corey", "Jose", "Mollie"};
        for (int i = 0; i < people.length; i++){
            assertEquals(expected_name[i], people[i].getName());
        }
    }
    
    
	@Test
	public void problems9through10() {
		String book = " 0 1 2 3 4 5 6 7 8 910111213141516171819";
		Segment fullbook = new Segment(book, 0, 40);
		assertEquals(book, fullbook.toString());
		
		Segment firstHalf = new Segment(book, 0, 20);
		assertEquals(" 0 1 2 3 4 5 6 7 8 9", firstHalf.toString());
		
		Segment secondHalf = new Segment(book, 20, 40);
		assertEquals("10111213141516171819", secondHalf.toString());

		
		// Using subSequence:
		CharSequence firstHalfcs = fullbook.subSequence(0, 20);
		assertEquals(firstHalf.toString(), firstHalfcs.toString());
		
		CharSequence secondHalfcs = fullbook.subSequence(20, 40);
		assertEquals(secondHalf.toString(), secondHalfcs.toString());

		// Checking charAt:
		assertEquals('3', firstHalf.charAt(7));
		assertEquals('9', firstHalf.charAt(19));
		assertEquals(' ', firstHalf.charAt(0));
		
		// Checking length:
		assertEquals(20, firstHalf.length());
		assertEquals(10, firstHalf.subSequence(5, 15).length());

		// Demonstrate that join works with Segments:
		assertEquals(" 0 1 2 3 4 5 6 7 8 9XXXXX10111213141516171819", 
				String.join("XXXXX", firstHalf, secondHalf));

		// Demonstrate PrintSteam.append works with Segments
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		System.out.print(firstHalf);
		System.out.print("-----");
		System.out.print(secondHalf);
		
		String result = output.toString();
		assertEquals(" 0 1 2 3 4 5 6 7 8 9-----10111213141516171819", result);
	}
}
