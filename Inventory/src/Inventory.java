import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Inventory {

  ArrayList<Item> inventory = new ArrayList<Item>();
  
  public void writeInventory(String outputFile){
    BufferedWriter out;
    try
    {
      out = new BufferedWriter(new FileWriter(outputFile));
      for (int index = 0; index < inventory.size(); index++){
          if (inventory.get(index) != null)
          {
              out.write("Item#: " + (index+1) + " Code: " + this.nextSortedCode(index) + " Description: "
                  + this.nextSortedDescription(index) + " Cost: " + this.nextSortedCost(index) + " Quantity: " + 
                  this.nextSortedQuantity(index));
              out.newLine();
          }
      }
      out.close();
    }
    catch (IOException e)
    {
      System.err.println("Can't write to output file");
    }
  }
  
  public void readInventory(String inputFile){
    BufferedReader in;
    try
    {
      
      in = new BufferedReader(new FileReader(inputFile));
      String info = in.readLine();
      int itemNumIndex, codeIndex, descriptionIndex, costIndex, quantityIndex, newQuantity;
      String newCode, newDescription;
      long newCost;
      while (info != null){
          itemNumIndex = info.indexOf(" ") + 1;
          
          codeIndex = info.indexOf(" ", info.indexOf("Code")) + 1;
          newCode = info.substring(codeIndex, info.indexOf(" ", codeIndex));

          
          descriptionIndex = info.indexOf(" ", info.indexOf("Description")) + 1;
          newDescription = info.substring(descriptionIndex, info.indexOf("Cost", descriptionIndex)-1);

          
          costIndex = info.indexOf(" ", info.indexOf("Cost")) + 1;
          newCost = Long.parseLong(info.substring(costIndex, info.indexOf(" ", costIndex)), 10);

          
          quantityIndex = info.indexOf(" ", info.indexOf("Quantity")) + 1;
          newQuantity = Integer.parseInt(info.substring(quantityIndex));
          
          this.setItemData(newCode, newDescription, newCost, newQuantity);
          
          info = in.readLine();
      }
      in.close();
    }
    catch (FileNotFoundException e)
    {
      System.err.println("Input file doesn't exist");
    }
    catch (IOException e)
    {
      System.err.println("Can't close file");
    }
  }
  
  //Linear Search to find item index given its ID Code
  private int searchCode(String code){
      int index;
      
      for (index = 0; index < inventory.size(); index++){
          if (inventory.get(index).getCode().equals(code)){
              break;
          }
      }
      
      return index;
  }
  
  //Linear Search to find item index given its description
  private int searchDescription(String description){
      int index;
      
      for (index = 0; index < inventory.size(); index++){
          if (inventory.get(index).getDescription().equals(description)){
              break;
          }
      }
      
      return index;
  }
  
  //Insertion Sort
  private void insertionSort(){
        for (int j = 1; j < this.inventory.size(); j++){
          Item item = this.inventory.get(j);
          int k = j - 1;
          while (k >= 0 && item.getCode().compareTo(this.inventory.get(k).getCode()) <0){
            this.inventory.set(k+1, this.inventory.get(k));
            k--;
          }
          this.inventory.set(k+1, item); 
        }
  }
  
  public void setItemData(String code, String description, long cost, int quantity){
      if (code.length() > 8){
          System.out.println("Input code must be less than 8 characters");
      } else if (description.length() > 25){
          System.out.println("Input description must be less than 25 characters");
      } else{
          Item item = new Item(code, description, cost, quantity);
          inventory.add(item);
          inventory.trimToSize();
      }
  }
  
  public void setRemoveItem(String code){
      inventory.remove(searchCode(code));
      inventory.trimToSize();
  }
  
  public String getItemCode(String description){
      return inventory.get(searchDescription(description)).getCode();
  }
  
  public String getItemDescription(String code){
      return inventory.get(searchCode(code)).getDescription();
  }
  
  public int getItemQuantity(String code){
      return inventory.get(searchCode(code)).getQuantity();
  }

  public long getItemCost(String code){
      return inventory.get(searchCode(code)).getCost();
  }
  
  public void setAddQuantity(String code, int increment){
      int index = searchCode(code);
      int currQuantity = inventory.get(index).getQuantity();
      inventory.get(index).setQuantity(currQuantity + increment);
  }
  
  public void setDeleteQuantity(String code, int decrement){
      int index = searchCode(code);
      int currQuantity = inventory.get(index).getQuantity();
      inventory.get(index).setQuantity(currQuantity - decrement);
  }
  
  public boolean getAllItemsSorted(){
      boolean done = false;
      insertionSort();
      for(int i = 0; i<inventory.size(); i++){
          nextSortedCode(i);
          nextSortedDescription(i);
          nextSortedCost(i);
          nextSortedQuantity(i);
      }
      done = true;
      return done;
  }
  
  public boolean getAllItemsInCostRange(long minCost, long maxCost){
      boolean done = false;
      
      for (int j = 0; j < this.inventory.size(); j++){
          Item item = this.inventory.get(j);
          if ((item.getCost()) >= minCost && item.getCost() <= maxCost){
              String code = nextSortedCode(j);
              String description = nextSortedDescription(j);
              int quantity = nextSortedQuantity(j);
              
              System.out.println("ID: " + code + ", Description: " + description + ", Quantity: " + quantity);
          }
      }
      done = true;
      return done;
  }
  
  private String nextSortedCode(int i){
      return inventory.get(i).getCode();
  }
  
  private String nextSortedDescription(int i){
      return inventory.get(i).getDescription();
  }
  
  private long nextSortedCost(int i){
      return inventory.get(i).getCost();
  }
  
  private int nextSortedQuantity(int i){
      return inventory.get(i).getQuantity();
  }

  public static void main(String[] args) {
  }
}
