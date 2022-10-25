package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {
	private final double EPSILON = 1e-13;

	@Test
	public void testPurchaseLessThan100() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(80);
		assertEquals(0, c.getNumDiscountsToUse());
		assertEquals(80.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testPurchaseMoreThan100() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(101);
		assertEquals(1, c.getNumDiscountsToUse());
		assertEquals(101.0, c.getTotalAmountSpent(), EPSILON);
	}
	
	@Test
	public void testDiscountApplied() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(100);
		assertEquals(1, c.getNumDiscountsToUse());
		c.makePurchase(1);
		assertEquals(0, c.getNumDiscountsToUse());
	}
	
	@Test
	public void testPurchaseEarningMultipleDiscounts() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(300);
		assertEquals(3, c.getNumDiscountsToUse());
	}
	
	@Test
	public void testOnlyOneDiscountApplied() {
		// FILL IN
		Customer c = new Customer();
		c.makePurchase(100);
		assertEquals(1, c.getNumDiscountsToUse());
		c.makePurchase(100);
		assertEquals(190, c.getTotalAmountSpent(), EPSILON);
	}
}
