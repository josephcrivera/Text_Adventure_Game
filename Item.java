
/*Class Item
 *This class defines an item that could be a pickup or an environment item.  It can be placed in a room or, if its a pickup,
 *be placed in your inventory.  You can get the item's name, type, and description.
 *
 */
class Item {
	//classification of items
	private String itemName="default";
	private String itemType="pickup";
	private String itemDescription="this is an item";
	
	public Item()
	{
	//nothing to do now
	}
	//set the itemName, itemType, and itemDescription
	//name can be anything
	//itemType can be pickup or environment
	//itemDescription is the description shown when examined
	public Item(String n, String t, String d)
	{
		itemName=n;
		itemType=t;
		itemDescription=d;
	}
	//return the description
	public String getDescription()
	{
	return itemDescription;
	}
	
	//set the description
	public void setDescription(String d)
	{
		itemDescription=d;
	}
	//get the name
	public String getName()
	{
		return itemName;
	}
	//set the name
	public String getType()
	{
		return itemType;
	}
}
