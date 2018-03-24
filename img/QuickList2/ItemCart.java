package QuickList2;

import java.util.ArrayList;

public class ItemCart {
private ArrayList<Item> items;
	
	public ItemCart()
	{
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item newItem)
	{
		items.add(newItem);
	}
	
	public void removeItem(int index)
	{
		items.remove(index);
	}
	
	public Item getItem(int index)
	{
		return items.get(index);
	}
	
	public boolean contains(Item x)
	{
		for(int i = 0; i < items.size(); i++)
		{
			if(items.get(i).equals(x))
			{
				items.get(i).increment();
				return true;
			}
		}
		return false;
	}
	
	public int size()
	{
		return items.size();
	}
}
