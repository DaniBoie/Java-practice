package labs.lab6;
import java.io.PrintWriter;
import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;
import java.lang.AutoCloseable;
/**
 * A class to improve a piece of text by replacing over-used words with better
 * word choices
 */
public class TextImprover {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Hashtable<String, String> wordMap;
	/**
	 * Constructor
	 * 
	 * @param wordMapFileName	name of the file containing the over-used words and their replacements
	 */
	public TextImprover(String wordMapFileName) {
		try (Scanner input = new Scanner(new File(wordMapFileName))) {
			wordMap = new Hashtable<>();

			while (input.hasNextLine()) {
				String key = input.next();
				// System.out.println(key);
				String value = input.next();
				System.out.println(key + value);
				wordMap.put(key, value);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}


	/**
	 * Replaces all of the over-used words in the given file with better words, based on the word map
	 * used to create this TextImprover
	 * 
	 * @param fileName	name of the file containing the text to be improved
	 */
	public void improveText(String fileName) {
		// FILL IN
		String newFile = "";
		try (Scanner input = new Scanner(new File(fileName))) {

			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line != "") {
					String[] words = line.split(" ", 0);

					for (String word : words) {
						String newWord = "";
						boolean punctuated = false;
						char punctuation = 0;
						char lastLetter = word.charAt(word.length() - 1);

						if (!Character.isLetter(lastLetter)) {
							punctuated = true;
							punctuation = lastLetter;
							newWord = word.substring(0, word.length() - 1);
						} else {
							newWord = word;
						}

						if (wordMap.containsKey(newWord)) {
							newWord = wordMap.get(newWord);
						} else if (wordMap.containsKey(newWord.toLowerCase())) {
							String caseWord = wordMap.get(newWord.toLowerCase());
							if (Character.isUpperCase(newWord.charAt(1))) {
								
								newWord = caseWord.toUpperCase();
							} else {
								newWord = Character.toUpperCase(caseWord.charAt(0)) + caseWord.substring(1);
							}
						}

						if (punctuated) {
							newWord += punctuation;
						}

						System.out.println(newWord);
						newFile += newWord + " ";
					
					}
					newFile += '\n';
				}

			}

			PrintWriter out = new PrintWriter(fileName);
			out.print(newFile);
			out.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}