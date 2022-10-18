package labs.lab3;

/**
 * A magic square is an n x n matrix which, if filled with numbers, the sum of
 * the elements in each row, each column, and the two diagonal is the same
 * value.
 */
public class Square {
	// ADD YOUR INSTANCE VARIABLES HERE
	int[][] squareArray;

	/**
	 * Construct a Square object.
	 * 
	 * @param nums	the square array (assume it will always be n x n)
	 */
	public Square(int[][] nums) {
		// FILL IN
		squareArray = nums.clone();
	}

	/**
	 * Add the numbers in a row of the square.
	 * 
	 * @param i the row index
	 * @return the sum of the row
	 */
	public int rowSum(int i) {

		int sum = 0;
		for (int j = 0; j < squareArray[i].length; j++) {
			sum += squareArray[i][j];
		}

		return sum; // FIX ME
	}

	/**
	 * Add the numbers in a column of the square.
	 * 
	 * @param i the column index
	 * @return the sum of the column
	 */
	public int columnSum(int i) {
		int sum = 0;

		for (int j = 0; j < squareArray.length; j ++) {
			sum += squareArray[j][i];
		}

		return sum; // FIX ME
	}

	/**
	 * Find the sum of the diagonal.
	 * 
	 * @param mainDiagonal true if it is the main diagonal (left/top to right/bottom),
	 * false otherwise (right/top to left/bottom)
	 * 
	 * @return sum the sum of the diagonal
	 */
	public int diagonalSum(boolean mainDiagonal) {

		int sum = 0;

		if (mainDiagonal) {
			for (int i = 0; i < squareArray.length; i++) {
				sum += squareArray[i][i];
			}
		} else {
			for (int i = 0; i < squareArray.length; i++) {
				sum += squareArray[squareArray.length - i - 1][i];
			}
		}
		return sum; // FIX ME
	}

	/**
	 * Determine if the square is a magic square.
	 * 
	 * @return true if square is a magic square, false otherwise
	 */
	public boolean isMagic() {

		int match = diagonalSum(true);
		boolean valid = false;

		if (match == diagonalSum(false)){
			valid = true;
		} else {
			return valid;
		}

		for (int i = 0; i < squareArray.length ; i++) {
			if (rowSum(i) != match) {
				valid = false;
			}
			if (columnSum(i) != match) {
				valid = false;
			}
		}

		return valid; // FIX ME
	}
}
