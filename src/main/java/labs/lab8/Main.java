package labs.lab8;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
public class Main {

	/**
	 * Takes as a parameter any object that implements the Iterable<E> interface, and 
	 * returns a  String containing its elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space. 
	 * 
	 * @param <T>		type of the iterable parameter
	 * @param <E>		type of the elements contained in T
	 * @param iterable	object to get elements from
	 * 
	 * @return	a String containing iterable's elements (whatever is returned by that 
	 * element's toString method), each one separated by a comma and a space
	 */
	public static <T extends Iterable<E>, E> String problem1_getElements(T iterable) {
		ArrayList<String> newString = new ArrayList<>();
		Iterator<E> it = iterable.iterator();
		while(it.hasNext()) {
			newString.add(it.next().toString());
		}
		return String.join(", ", newString);
	}
	
	
	/**
	 * Takes a Pair, swaps the two elements, and returns it
	 * 
	 * @param <T>	type of the first element in the pair
	 * @param <S>	type of the second element in the pair
	 * @param p		the pair to swap
	 * 
	 * @return		the swapped pair
	 */
	// WRITE PROBLEM 2 METHOD HERE
	public static <T, S> Pair<S, T> problem2_swap(Pair<T, S> inputPair) {
		return new Pair<S, T>(inputPair.getSecond(), inputPair.getFirst());
	}
	
	/**
	 * Checks whether a generic list is a palindrome; that is, whether 
	 * the values at index i and n - 1 - i are equal to each other, where n 
	 * is the size of the list. 
	 * 
	 * @param <T>	the type of element in the List
	 * @param a		the List
	 * 
	 * @return	true if it is a palindrome, or false if not
	 */
	public static <T> boolean problem5_isPalindrome(List<T> li) {
		int size = li.size();

			for (int i = 0; i < size/2; i++) {
				if (li.get(i) != li.get(size - 1 - i)) {
					return false;
				}
			}

		return true;
	}
}
