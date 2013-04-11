public class Item {

  private String code;
  private String description;
  private long cost;
  private int quantity;
  
  public Item(String code, String description, long cost, int quantity){
    this.code=code;
    this.description=description;
    this.cost=cost;
    this.quantity = quantity;
  }
  
  //This is not the method required in the MIS. It is simply an access program
  //to return the code of the current object.
  public String getCode(){
	  return code;
  }
  
  public String getDescription(){
	  return description;
  }
  
  public long getCost(){
	  return cost;
  }
  
  public int getQuantity(){
	  return quantity;
  }
  
  //negative increment implies a decrement
  public void setQuantity(int newQuantity){
	  this.quantity = newQuantity;
  }

}
