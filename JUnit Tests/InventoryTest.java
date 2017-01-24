/**
 * 
 */


import static org.junit.Assert.*;
import inventory.Inventory;
import inventory.Item;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lucas Rudd
 *
 */
public class InventoryTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Inventory in = new Inventory();
		assertTrue(in.add(new Item("Burger")));
		assertTrue(in.searchByName("Burger"));
		assertFalse(in.add(new Item("Burger")));
		
		
	}

}
