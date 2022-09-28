package labs.lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	private int width;
	private int length;
	private int size;

	
	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
		// WRITE YOUR CODE HERE
		width = 841;
		length = 1189;
		size = 0;
	}

	
	/**
	 * @return the width of the paper
	 */
	public int getWidth() {
		return width; // FIX ME
	}

	
	/**
	 * @return the length of the paper
	 */
	public int getLength() {
		return length; // FIX ME
	}

	
	/**
	 * @return the ISO name for the paper
	 */
	public String getName() {
		return "A" + String.valueOf(size); // FIX ME
	}

	
	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		
		if (width > length) {
			int width_copy = width / 2;
			width = length;
			length = width_copy;

		} else {
			int length_copy = length / 2;
			length = width;
			width = length_copy;

		}
		size = size + 1;
		return this; // FIX ME
	}
}
