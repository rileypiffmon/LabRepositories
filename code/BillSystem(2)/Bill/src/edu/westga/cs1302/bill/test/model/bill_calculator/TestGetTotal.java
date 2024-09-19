package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestGetTotal {

	@Test
	public void testItemsCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTotal(null);
		});
	}
	
	@Test
	public void testArrayCannotBeEmpty() {
		BillItem [] testItems = new BillItem[3];
		assertThrows(IllegalArgumentException.class, () -> {
			BillCalculator.getTotal(testItems);
		});
	}
	
	@Test
	public void testTotalIsCalculatedCorrectlyInFullArray() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		testItems[2] = new BillItem("test", 15.7);
		assertEquals(47.32, BillCalculator.getTotal(testItems));	
	}
	
	@Test
	public void testTotalIsCalculatedCorrectlyWithTwoItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		testItems[1] = new BillItem("test", 8.5);
		assertEquals(26.91, BillCalculator.getTotal(testItems));
	}
	
	@Test
	public void testTotalIsCalculatedCorrectlyWithOneItem() {
		BillItem[] testItems = new BillItem[3];
		testItems[0] = new BillItem("test", 12.2);
		assertEquals(15.86, BillCalculator.getTotal(testItems));
	}

}
