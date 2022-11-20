package labs.lab8;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.reflect.Array;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> a, List<T> b) {
		List<T> newLen = new ArrayList<T>();
		for (T element : a) {
			newLen.add(element);
		}

		for (T element : b) {
			newLen.add(element);
		}

		return newLen;
	}

	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[] a, T[] b) {
		List<T> newLen = new ArrayList<T>();
		int index = 0;

		for (int i = 0; i < a.length; i ++) {
			newLen.add(index, a[i]);
			index += 1;
		}

		for (int i = 0; i < b.length; i++) {
			newLen.add(index, b[i]);
			index += 1;
		}
		return newLen.toArray(a);
	}
}