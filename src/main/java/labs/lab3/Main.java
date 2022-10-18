package labs.lab3;

import java.util.Scanner;

public class Main {

	/**
	 * Accepts a String as a parameter and looks for a mirror image (backwards)
	 * string at both the beginning and end of the given string. In other words,
	 * zero or more characters at the very beginning of the given string, and at the
	 * very end of the string in reverse order (possibly overlapping). For example,
	 * the string "abXYZba" has the mirror end "ab".
	 * 
	 * @param str the string to check for mirror ends
	 * @return the mirror end, or the empty string if no mirror end exists
	 */
	public static String problem1_mirrorEnds(String str) {

		// splice front of string, splice back of string, loop from front and back at the same time and build string
		int index = str.length() - 1;
		String newStr = "";

		if (index > -1) {

			for (int i = 0; i <= (index/2) + 1; i++) {
				if (str.charAt(i) == str.charAt(index - i)) {
					if (i == index - i){
						return str;
					}
					newStr += str.charAt(i);
				} else {
					break;
				}
			}
		}

		return newStr; // FIX ME
	}


	/**
	 * Given a string, returns the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same.
	 * 
	 * @param str the string to check for blocks
	 * 
	 * @return the length of the largest block in the string
	 */
	public static int problem2_maxBlock(String str) {
		
		int prev_max = 0;
		int max = 0;
		char prev = 0;

		for (int i = 0; i <= str.length() - 1; i++) {

			if (prev == str.charAt(i)) {

				if (max == 0) {
					max += 2;
				} else {
					max += 1;
				}
			} else {
				if (max > prev_max) {
					prev_max = max;
				}
				
				max = 0;
			}

			prev = str.charAt(i);
		}

		if ((prev_max == 0 && max == 0) && str.length() != 0) {
			return 1;
		} else {
			 if (max > prev_max) {
				return max;
			 } else {
				return prev_max;
			 }
		}

	}


	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem3_EHappy(String str) {
		// int spaces = 0;
		boolean seenOnce = false; 
		boolean seenMore = false;
		boolean valid = true;

		for (int i = 0; i <= str.length() - 1; i++) {
			if (str.charAt(i) == 'E') {
				if (!seenOnce) {
					seenOnce = true;
				} else {
					seenMore = true;
				}

			} else {
				// if solo E
				if (seenOnce && !seenMore) {
					valid = false;
				}
				seenOnce = false;
				seenMore = false;
			}
		}

		if (seenOnce && !seenMore) {
			return false;
		}
		return valid; // FIX ME
	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int problem4_getNumTwists(int starting, int target) {

		int twists = 0;

		for (int i = 0; i <= 3; i++) {
			int startingMod = starting % 10;
			int targetMod = target % 10;

			int loosey;
			int tighty;

			if (startingMod > targetMod) {
				loosey = startingMod - targetMod;
				tighty = (10 + targetMod) - startingMod;
				
			} else {
				loosey = targetMod - startingMod;
				tighty = (10 + startingMod) - targetMod;
			}
		

			if (loosey < tighty) {
				twists += loosey;
			} else {
				twists += tighty;
			}

			starting = starting / 10;
			target = target / 10;
		}

		return twists; // FIX ME
	}
	
	
	/**
	 * Manages crowd control in an office
	 * 
	 * @param in       the Scanner to be used for user input
	 * @param capacity of the office
	 * 
	 *                 To run this method using the keyboard for user input, call it
	 *                 like this: problem5_officeCrowdControl(new Scanner(System.in), 100);
	 */
	public static void problem5_officeCrowdControl(Scanner in, int capacity) {
		// FILL IN
		int people = 0;

		do {
			int movement = in.nextInt();

			System.out.print("People entering or leaving: ");
		
			if (movement > 0) {
				if (people + movement <= capacity) {
					people += movement;
				}
			} else {
				if (people + movement >= 0) {
					people += movement;
				}
			}

			System.out.print("People in office: " + people + " | ");

		} while (people < capacity);

		System.out.print("Office is full");
	}
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {

		int[] newArr = new int[nums.length];
		int newIndex = 0;
		int oddIndex = 1;

		for (int i = 0; i <= nums.length - 1; i++) {
			if (nums[i] % 2 == 0) {
				newArr[newIndex] = nums[i];
				newIndex += 1;
			} else {
				newArr[nums.length - oddIndex] = nums[i];
				oddIndex += 1;
			}
		}

		return newArr; // FIX ME
	}
	
	
	/**
	 * Given a non-empty array of ints, returns a new array containing the elements from
	 * the original array that come after the last occurrence of the number 4 in the original
	 * array
	 * 
	 * @param nums	the input array
	 * 
	 * @return	a new array containing the elements from the original array that come after 
	 * the last occurrence of the number 4 in the original array
	 * 
	 */
	public static int[] problem7_after4(int[] nums) {

		int[] newArr = new int[nums.length];
		int newIndex = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4) {
				newArr = new int[nums.length - i - 1];
				newIndex = 0;
			} else {
				newArr[newIndex] = nums[i];
				newIndex += 1;
			}
		}
		return newArr; // FIX ME
	}
}