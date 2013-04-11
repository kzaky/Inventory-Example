
public class InventoryTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int total = 8;
		int passes = 0;
		InventoryTest tests = new InventoryTest();

		System.out.println("Running all Inventory tests.");

		System.out.println("\nRunning Set Item Data tests:");
		if (tests.testSetItemData()){
			passes++;
			System.out.println("Set Item Data method result: PASS");
		}else
			System.out.println("" +
					"Set Item Data method method result: FAIL");

		System.out.println("\nRunning Set Remove Item tests:");
		if (tests.testSetRemoveItem()){
			passes++;
			System.out.println("Set Remove Item method result: PASS");
		}else
			System.out.println("Set Remove Item method result: FAIL");

		System.out.println("\nRunning Get Item Code tests:");
		if (tests.testGetItemCode()){
			passes++;
			System.out.println("Get Item Code method result: PASS");
		}else
			System.out.println("Get Item Code method method result: FAIL");
		
		System.out.println("\nRunning Get Item Quantity tests:");
		if (tests.testGetItemQuantity()){
			passes++;
			System.out.println("Get Item Quantity method result: PASS");
		}else
			System.out.println("Get Item Quantity method method result: FAIL");

		System.out.println("\nRunning Get Item Description tests:");
		if (tests.testGetItemDescription()){
			passes++;
			System.out.println("Get Item Description method result: PASS");
		}else
			System.out.println("Get Item Description method method result: FAIL");
		
		System.out.println("\nRunning Get Item Cost tests:");
		if (tests.testGetItemCost()){
			passes++;
			System.out.println("Get Item Cost method result: PASS");
		}else
			System.out.println("Get Item Cost method method result: FAIL");

		System.out.println("\nRunning Set Add Quantity tests:");
		if (tests.testSetAddQuantity()){
			passes++;
			System.out.println("Set Add Quantity method result: PASS");
		}else
			System.out.println("Set Add Quantity method method result: FAIL");

		System.out.println("\nRunning Set Delete Quantity tests:");
		if (tests.testSetDeleteQuantity()){
			passes++;
			System.out.println("Set Delete Quantity method result: PASS");
		}else
			System.out.println("Set Delete Quantity method method result: FAIL");
		
		System.out.println("\nRunning Get All Items Sorted tests:");
		if (tests.testGetAllItemsSorted()){
			passes++;
			System.out.println("Get All Items Sorted method result: PASS");
		}else
			System.out.println("Get All Items Sorted method method result: FAIL");
		
		System.out.println("\nRunning Get All Items In Cost Range tests:");
		if (tests.testGetAllItemsInCostRange()){
			passes++;
			System.out.println("Set Get All Items In Cost Range method result: PASS");
		}else
			System.out.println("Set Get All Items In Cost Range method result: FAIL");
	}

}
