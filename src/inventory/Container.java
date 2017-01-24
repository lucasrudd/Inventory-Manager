package inventory;

import java.util.ArrayList;

public class Container {
	
	ArrayList<Item> items = new ArrayList<Item>();
	
	Container(Item... item){
		for(Item i : item){
			items.add(i);
		}
	}
	
	Container(){
		
	}
	
	Container(Item item, int numberOfItems)
	{
		for(int i = 0; i < numberOfItems; i++){
			items.add(item);
		}
	}
	
	public void addItem(Item i)
	{
		items.add(i);
	}
	
	public void addItems(ArrayList<Item> items)
	{
		for(Item i : items){
			this.items.add(i);
		}
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	public Item getItemAt(int i)
	{
		return items.get(i);
	}
	
}
