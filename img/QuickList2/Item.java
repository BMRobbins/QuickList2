package QuickList2;

public class Item {
		private String name;
		private String store;
		private int quantity;
		private double price;
		
		public Item(String itemName, String Store, int numOfItem)
		{
			name = itemName;
			store = Store;
			price = 0.0;
			quantity = numOfItem;
		}	
		
		public Item(String itemName, String Store, double Price)
		{
			name = itemName;
			store = Store;
			price = Price;
		}
		
		public void setQuantity(int value)
		{
			quantity = value;
		}
		
		public void increment()
		{
			quantity++;
		}
		public int getQuanity()
		{
			return quantity;
		}
		public void setName(String Name)
		{
			name = Name;
		}
		
		public String getName()
		{
			return name;
		}
		
		public void setStore(String Store)
		{
			store = Store;
		}
		
		public String getStore()
		{
			return store;
		}
		
		public void setPrice(double Price)
		{
			price = Price;
		}
		
		public double getPrice()
		{
			return price;
		}
		public boolean equals(Object obj)
		{
			Item  other = (Item) obj;
			return this.name.equals(other.getName());
			
		}
		
		public boolean sameStore(String other)
		{
			return this.store.equals(other);
		}

}


