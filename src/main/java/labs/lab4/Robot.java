package labs.lab4;

import java.awt.Point;

/**
 * A class for simulating a robot wandering on a 10 x 10 plane.
 */
public class Robot {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	int location_x;
	int location_y;
	char direction;
	
	/**
	 * Creates a Robot at location (0, 0), which is in the center of the plane,
	 * and facing north
	 */
	public Robot() {
		location_x = 0;
		location_y = 0;
		direction = 'N';
		// FILL IN
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnLeft() {
		// FILL IN
		switch (direction) {
			case 'N':
					direction = 'W';
				break;
		
			case 'E':
					direction = 'N';
				break;

			case 'S':
					direction = 'E';
				break;


			case 'W': 
					direction = 'S';
				break;

			default:
				break;
		}
		
	}
	

	/**
	 * Changes the direction but not the location
	 */
	public void turnRight() {
		switch (direction) {
			case 'N':
				direction = 'E';
				break;

			case 'E':
				direction = 'S';
				break;

			case 'S':
				direction = 'W';
				break;

			case 'W':
				direction = 'N';
				break;

			default:
				break;
		}

	}

	
	/**
	 * Moves the robot by one unit in the direction it is facing. Returns true if the
	 * robot is still on the plane, or false if it has fallen off.
	 * 
	 * Note 1: In coordinate terms, |x| must be <= 5 and |y| must be <= 5 for the robot
	 * to stay on the plane (see below example).
	 * 
	 * Note 2: This method can still be called on a robot that has fallen off the plane,
	 * and its location should be updated as if it was still on the plane.
	 * 
	 * @return	true if the robot is still on the plane, false otherwise
	 */
	public boolean move() {

		switch (direction) {
			case 'N':
				location_y += 1;
				break;

			case 'E':
				location_x += 1;
				break;

			case 'S':
				location_y -= 1;
				break;

			case 'W':
				location_x -= 1;
				break;

			default:
				break;
		}

		if (Math.abs(location_x) > 5) {
			return false;
		} else if (Math.abs(location_y) > 5) {
			return false;
		} else {
			return true;
		}
		 // FIX ME
	}

	
	/**
	 * Returns the robot's current location on the plane
	 * 
	 * @return	robot's current location
	 */
	public Point getLocation() {
		return new Point(location_x, location_y); // FIX ME
	}

	
	/**
	 * Returns "N", "E", "S", or "W" (for north, east, south, or west, respectively)
	 * 
	 * @return	the robot's direction
	 */
	public String getDirection() {
		return String.valueOf(direction); // FIX ME
	}
}
