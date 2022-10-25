package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Point;

public class RobotTest {

	@Test
    public void testConstructor() {
      Robot robot = new Robot();
        assertEquals(true, robot.getLocation().equals(new Point(0, 0)));
    }

	@Test
    public void testTurnLeft() {
		// FILL IN
        Robot robot = new Robot();
        robot.turnLeft();
        assertEquals("W", robot.getDirection());
    }
	
	@Test
    public void testTurnRight() {
		// FILL IN
        Robot robot = new Robot();
        robot.turnRight();
        assertEquals("E", robot.getDirection());
    }
	
	@Test
    public void testMove() {
		// FILL IN
      Robot robot = new Robot();
      robot.move();
      assertEquals(true, robot.getLocation().equals(new Point(0, 1)));
    }
}
