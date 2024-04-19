package pojo;


public class AddMenu {
	String item_name;
	int price;
	
	public AddMenu(String item_name,int price)
	{
		this.item_name=item_name;
		this.price=price;
	}
	
	public String getItemName()
	{
		return item_name;
	}
	
	public void setItemName(String item_name)
	{
		this.item_name=item_name;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public void setPrice(int price)
	{
		this.price=price;
	}
}