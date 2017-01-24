package inventory;

import java.util.ArrayList;

public final class Inventory {
	
	private ArrayList<Integer>  editedItemIndices = new ArrayList<Integer>();
	private ArrayList<Item>     editedItems       = new ArrayList<Item>();
	private ArrayList<Item>     inventory         = new ArrayList<Item>();
	private ArrayList<ItemStack> inventoryStack   = new ArrayList<ItemStack>();
	private boolean             itemAdded         = false;
	
	public Inventory(){}
	
	
	public Inventory(ArrayList<Item> inventory){
		this.inventory = inventory;
	}
	
	
	/**
	 * TODO OPTIMIZE THIS MOFO LATER
	 * @param itemName
	 * @return
	 */
	public boolean searchByName(String itemName){
		for(Item i : inventory){
			if(itemName.equals(i.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This may eventually be expanded to include optimization
	 * techniques to search by ID number or some other method
	 * depending on what type of item it is or how long the
	 * name is etc. Ideally there would be multiple ways to
	 * search for an item, and this method would choose the
	 * optimal method depending on the circumstance.
	 * Also, there will have to be other methods to search for
	 * ID or date added so that the user is able to organize the
	 * Inventory by different parameters.
	 * @param i
	 * @return 
	 */
	public boolean isItemInInventory(Item i){
		return searchByName(i.getName());
	}
	
	/**
	 * Adds Item to the Inventory only if it does not
	 * already exist. Returns true if the Item was
	 * added successfully and false if an Item of the
	 * same name already existed in the Inventory.
	 * @param i
	 * @return
	 */
	public boolean add(Item i){
		if(isItemInInventory(i))
			return false;
		
		else{
			inventory.add(i);
			editedItemIndices.add(inventory.size()-1);
			itemAdded = true;
			return true;
		}
	}
	
	
	/**
	 * TODO NEW METHOD, KEEP AN EYE ON THIS ONE
	 * @param i
	 * @return
	 */
	public boolean add(ItemStack i){
		if(isItemInInventory(i.getItem()))
			return false;
		else{
			inventoryStack.add(i);
			editedItemIndices.add(inventory.size()-1);
			itemAdded = true;
			return true;
		}
	}
	
	public boolean hasItemBeenAdded(){
		if(itemAdded){
			itemAdded = false;
			return true;
		}
		return false;
	}
	
	/*public void set( , int index){
		
	}*/
	
	public final ArrayList<Item> getItems(){
		return new ArrayList<Item>(inventory);
	}
	
	/*public final ArrayList<Item> getEditedItems(){
		for(int i : editedItemIndices){
			editedItems.add(inventory.get(i));
		}
		return new ArrayList<Item>(editedItems);
	}*/

}
