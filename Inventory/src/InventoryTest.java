import java.util.ArrayList;


public class InventoryTest {
	
	  
	  Inventory inventory = new Inventory();
	  
	  InventoryTest(){

		 
		  inventory.readInventory("sample.txt");
		  
		  
	  }
	  
	  
	 public void printInventory(Inventory inventory1){
		 for(int i=0; i< inventory1.inventory.size();i++){
			 System.out.printf("Item"+(i+1)+": %n"+"ID = " + inventory1.inventory.get(i).getCode()+
					 "%nDescription = " + inventory1.inventory.get(i).getDescription()+
					 "%nCost = " + inventory1.inventory.get(i).getCost()+
					 "%nQuantity = " + inventory1.inventory.get(i).getQuantity() +"%n");
		 }
	 }
	  

	public boolean testSetItemData(){
	
		inventory.setItemData("AEDLOE", "leather jacker", (long) 19, 129);
		printInventory(inventory);
		inventory.setItemData("AEDLOEAAAA", "leather jacker", (long) 19, 129);
		printInventory(inventory);
		inventory.setItemData("AEDLOE", "leather jacker with cool buttons and hood", (long) 19, 129);
		printInventory(inventory);
		if(inventory.inventory.size()==16)
		return true;
		else
			return false;
	}
	
    public boolean testSetRemoveItem(){
    	inventory.setRemoveItem("AABD");
    	printInventory(inventory);
    	if(inventory.inventory.size()==15)
    		return true;
    	else
    	return false;
	}
    
    public boolean testGetItemCode(){
    	System.out.printf("Input: Pasta Sauce"+ "%n"+ "Expected Output: AAAAAAA"+"%n");
    	String itemCode = inventory.getItemCode("Pasta Sauce");
    	System.out.println("Actual Output: " + itemCode);
    	
    	if(itemCode.equals("AAAAAAA"))
    	return true;
    	else{
    		return false;
    	}
    }
    
    public boolean testGetItemDescription(){
    	System.out.printf("Input: DEURJ"+ "%n"+ "Expected Output: Wrench"+"%n");
    	String itemDescription = inventory.getItemDescription("DEURJ");
    	System.out.println("Actual Output: " + itemDescription);
    	
    	if(itemDescription.equals("Wrench"))
    	return true;
    	else{
    		return false;
    	}
    }
    
    public boolean testGetItemCost(){
    	System.out.printf("Input: DEURJ"+ "%n"+ "Expected Output: 6" +"%n");
    	long cost = inventory.getItemCost("DEURJ");
    	System.out.println("Actual Output: " + cost);
    	
    	if(cost == 6)
    	return true;
    	else{
    		return false;
    	}
    }
    
    public boolean testGetItemQuantity(){
    	System.out.printf("Input: EIDKIE"+ "%n"+ "Expected Output: 40" +"%n");
    	long itemQuantity = inventory.getItemQuantity("EIDKIE");
    	System.out.println("Actual Output: " + itemQuantity);
    	
    	if(itemQuantity == 40)
    	return true;
    	else{
    		return false;
    	}
    }
    
    public boolean testSetAddQuantity(){
    	System.out.printf("Input: LMNVGJJ, 20"+ "%n"+ "Expected Output: 60" +"%n");
    	inventory.setAddQuantity("LMNVGJJ", 20);
    	System.out.println("Actual Output: " + inventory.getItemQuantity("LMNVGJJ"));
    	
    	if(inventory.getItemQuantity("LMNVGJJ")==60)
    	return true;
    	else{
    		return false;
    	}
    } 
    
    public boolean testSetDeleteQuantity(){
    	System.out.printf("Input: EUEUEU, 40"+ "%n"+ "Expected Output: 80" +"%n");
    	inventory.setDeleteQuantity("EUEUEU", 40);
    	System.out.println("Actual Output: " + inventory.getItemQuantity("EUEUEU"));
    	
    	if(inventory.getItemQuantity("EUEUEU")==0)
    	return true;
    	else{
    		return false;
    	}
    }
    
    public boolean testGetAllItemsSorted(){
    	inventory.getAllItemsSorted();
    	printInventory(inventory);
    	return true;
    }
    
    public boolean testGetAllItemsInCostRange(){
    	System.out.printf("Input: minCost = 5, maxCost = 100"+ "%n"+ "Expected Output: 12 items with 5<=cost<=100" +"%n");
    	System.out.println("Actual Output: ");
    	inventory.getAllItemsInCostRange(5, 100);
    	inventory.writeInventory("output.txt");
    	return true;
    	}
    }


