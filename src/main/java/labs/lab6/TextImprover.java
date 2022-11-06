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
				String value = input.next();
				System.out.println(key + value);
				wordMap.put(key, value);
			}
		} catch (Exception e) {
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
						String punctuationAfter = "";
						String punctuationBefore = "";
						boolean punctuatedAfter = false;
						boolean punctuatedBefore = false;
						boolean foundLetter = false;
						boolean ignore = false;

						for (int i = 0; i < word.length(); i++) {
							char letter = word.charAt(i);
							if (Character.isLetter(letter)) {
								if (punctuatedAfter) {
									ignore = true;
								}
								foundLetter = true;
								newWord += letter;
							} else {
								if (!foundLetter) {
									punctuatedBefore = true;
									punctuationBefore += letter;
								} else {
									punctuatedAfter = true;
									punctuationAfter += letter;
								}
								
							}
						}	

						if (!ignore) {
							
							if (wordMap.containsKey(newWord)) {

								newWord = wordMap.get(newWord);
							
							} else if (wordMap.containsKey(newWord.toLowerCase())) {
								String lowercaseWord = wordMap.get(newWord.toLowerCase());


								if (Character.isUpperCase(newWord.charAt(0))) {
									if (newWord.length() == 1) {
										newWord = lowercaseWord.toUpperCase();
									} else {

										if (Character.isUpperCase(newWord.charAt(1))) {
											newWord = lowercaseWord.toUpperCase();
										} else {
											newWord = Character.toUpperCase(lowercaseWord.charAt(0)) + lowercaseWord.substring(1);
										}

									}

								}

							}

							if (punctuatedBefore) {
								newWord = punctuationBefore + newWord;
							}

							if (punctuatedAfter) {
								newWord += punctuationAfter;
							}

						} else {
							newWord = word;
						}

						System.out.println(newWord);
						newFile += newWord + " ";
					
					}
					newFile += '\n';
				} else {
					newFile += '\n';
				}

			}

			PrintWriter out = new PrintWriter(fileName);
			out.print(newFile);
			out.close();

		} catch (Exception e) {
			System.out.print("File: " + fileName +" not found");
		}
	}
}