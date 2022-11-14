package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	private int wordCount;
	private String fileName;
	// FILL IN ANY OTHER PRIVATE INSTANCE VARIABLES YOU NEED HERE

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		// FILL IN
		this.fileName = filename;
		
		try (Scanner input = new Scanner(new File(fileName))) {
			wordCount = 0;
			uniqueWords = new TreeSet<String>();

			while (input.hasNext()) {
				String word = input.next();
				String newWord = "";
				wordCount += 1;

				for (int i = 0; i < word.length(); i++) {
					char letter = word.charAt(i);
					if (Character.isLetter(letter) | Character.isDigit(letter)) {
						newWord += letter;
					}
				}
				uniqueWords.add(newWord.toLowerCase());
			}

		} catch (Exception e) {
			System.out.println("File: " + fileName + " not found");
		}
	}


	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		return uniqueWords.size(); // FIX ME
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return wordCount; // FIX ME
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		return List.copyOf(uniqueWords);
	}
}
