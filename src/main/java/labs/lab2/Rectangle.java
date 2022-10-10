package labs.lab2;

/**
 * A rectangle defined by its x- and y-coordinates of its upper-left and lower-right corners
 */
public class Rectangle {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	/**
	 * Constructor
	 * 
	 * @param x1	upper-left corner x value
	 * @param y1	upper-left corner y value
	 * @param x2	lower-right corner x value
	 * @param y2	lower-right corner y value
	 */
	public Rectangle(double x1, double y1, double x2, double y2) {
		// FILL IN
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

	}
	
	
	/**
	 * Gets the orientation of this rectangle
	 * 
	 * @return "square", "portrait", or "landscape"
	 */
	public String getOrientation() {
		
		double vert_dist = Math.sqrt((Math.pow(x1 - x1, 2))+(Math.pow(y2 - y1, 2)));
		double hori_dist = Math.sqrt((Math.pow(x1 - x2, 2)) + (Math.pow(y2-y2, 2)));

		if (vert_dist == hori_dist) {
			return "square";
		} else if (vert_dist > hori_dist) {
			return "portrait";
		} else if (hori_dist > vert_dist) {
			return "landscape";
		}
		return "error";
	}
}
