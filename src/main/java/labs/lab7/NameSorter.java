package labs.lab7;
import java.util.Hashtable;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Comparator;
/**
 * Sorts a file of names alphabetically, ignoring case
 */
public class NameSorter {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private String nameFile;
	private ArrayList<String> names;
	
	private class CustomStringComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			return s1.compareToIgnoreCase(s2);
		}
	}

	/**
	 * Constructs a name sorter with the names from the input file
	 * 
	 * @param inputFile	name of the input file
	 */
	public NameSorter(String inputFile) {
		nameFile = inputFile;
	}
	
	
	/**
	 * Sorts the names from the input file alphabetically, ignoring case, 
	 * then writes the sorted names back to the file, overwriting the 
	 * previous content
	 */
	public void sortNames() {
		try (Scanner input = new Scanner(new File(nameFile))) {
			names = new ArrayList<String>();

			while (input.hasNextLine()) {
				String name = input.nextLine();
				names.add(name);
			}

			names.sort(new CustomStringComparator());

			String newFileContents = "";
			for (String name : names) {
				newFileContents += name + "\n";
			}

			PrintWriter out = new PrintWriter(nameFile);
			out.print(newFileContents);
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}