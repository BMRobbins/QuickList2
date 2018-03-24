package QuickList2;

import java.util.ArrayList;

public class RecipeList {
private ArrayList<Recipe> recipes;
	
	public RecipeList()
	{
		recipes = new ArrayList<Recipe>();
	}
	
	public void addRecipe(Recipe recipe)
	{
		recipes.add(recipe);
	}
	
	public Recipe getRecipe(int index)
	{
		return recipes.get(index);
	}
	
	public void removeRecipe(int index)
	{
		recipes.remove(index);
	}
	
	public void removeRecipe(String StringToRemove)
	{
		int i = 0;
		for(; i < recipes.size(); i++)
		{
			if(StringToRemove.equals(recipes.get(i).getName()))
			{
				removeRecipe(i);
			}
		}
	}
	public int size()
	{
		return recipes.size();
	}
}
