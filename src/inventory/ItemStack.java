package inventory;

public final class ItemStack {
	
	private final Item item;
	private int quantity;
	
	public ItemStack(Item item){
		this.item = item;
		quantity = 1;
	}
	
	public final int getQuantity(){
		return new Integer(quantity);
	}
	
	public void add(int additionalItems){
		quantity += additionalItems;
	}
	
	public void add(){
		quantity++;
	}
	
	public final Item getItem(){
		return new Item(item.getName());
	}

}
