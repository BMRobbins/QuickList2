package QuickList2;

import java.util.ArrayList;


public class Recipe {
	private ArrayList<Item> items;
	private String recipeName;
	private String picture;
	
	public Recipe(String recipe, String Picture)
	{
		recipeName = recipe;
		picture = Picture;
		items =  new ArrayList<Item>();
	}
	
	public String getName()
	{
		return recipeName;
	}
	
	public void setName(String name)
	{
		recipeName = name;
	}
	public void addItem(Item Item)
	{
		items.add(Item);
	}
	
	public void removeItem(int index)
	{
		items.remove(index);
	}
	
	public void removeItemByName(String Item)
	{
		int i = 0;
		int index = -1;
		for(;i < items.size(); i++)
		{
			if(items.get(i).getName().equals(Item))
			{
				index = i;
			}
		}
		if(index >= 0)
		{
			items.remove(index);
		}
	}
	
	public Item getItem(int index)
	{
		return items.get(index);
	}
	
	public int size()
	{
		return items.size();
	}
	
	public void setPicture(String Picture)
	{
		picture = Picture;
	}
	
	public String getPicture()
	{
		return picture;
	}
}
