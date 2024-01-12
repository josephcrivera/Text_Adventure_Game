
/*Class Inventory
 *This class maintains an inventory of items you have picked up using an ArrayList.
 *
 */

import java.util.ArrayList;
class Inventory {
	//keep an inventory of all items that were picked up
	ArrayList  <Item> inv=new ArrayList();
	public Inventory()
	{
		Item shield = new Item("shield", "pickup", "A sturdy metal shield.");
		inv.add(shield);
		Item sword = new Item("sword", "pickup", "A sturdy metal sword.");
		inv.add(sword);
		Item starKey = new Item("starKey", "pickup", "A sturdy metal key.");
		inv.add(starKey);
		//nothing to do here unless you want to give the player an
		//item in their inventory before they start the game
		//Item apple=new Item("apple","pickup","A shinny red apple.  Looks delicious!");
		//inv.add(apple);
	}
	
	//add an item to the arraylist
	public void addItem(Item i)
	{
		inv.add(i);
	}
	
	//list the items in your inventory by looping through the array list
	public void listItems() 
	{
		
		String output="";
		for(int x=0; x<inv.size(); x++)
		{
		output=output+inv.get(x).getName()+"\n";
		}
		System.out.println("Inventory:\n"+output);	
	}
	
    //check if the string is in your inventory
    //return null if its not found
	public Item checkInventory(String s)
	{
		for(int x=0; x<inv.size(); x++)
		{
			if (inv.get(x).getName().equals(s))
				return inv.get(x);
		}
		return null;
	}
	
	//remove an item from the inventory
	// first use an if statement to 
	//checkInventory() and see if its not null
	//meaning that you have the item.  If that's ok,
	//do a loop through inv and if the .getName() of
	//the item equals s, then remove it from the
	//inventory
	public void removeItem(String s)
	{
		if (checkInventory(s)!=null)
		{
			for(int x=0; x<inv.size(); x++)
			{
				if (inv.get(x).getName().equals(s))
				{
				
					inv.remove(x);
				}
			}
		}
	}
}
