package inventory;

public final class Item {
	
	private final String name;
	
	/**
	 * @param n
	 */
	public Item(String n){
		name = n;
	}
	
	/**
	 * @return
	 */
	public String getName(){
		return name;
	}

}
