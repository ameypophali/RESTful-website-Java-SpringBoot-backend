package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
{
    "itemId": 1,
    "itemName": "Lamb Curry",
    "itemPrice": 10,
    "decription": "Marinated Chicken fried in spices"
}

{
    "itemId": 2,
    "itemName": "Chicken Fry",
    "itemPrice": 5,
    "decription": "Marinated Chicken fried in spices"
}
*/

enum MenuItemType {
	Entree, Dessert, Appetizer
}

@Entity
@Table(name="Menu_Item")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id", unique=true)
	@NotNull
	private int itemId;
	
	@NotNull
	@Column(name="item_name",unique = true)
	private String itemName;
	
	@NotNull
	@Column(name="item_price")
	private int itemPrice;
	
	@NotNull
	@Column(name="description")
	private String decription;
	
	@NotNull
	@Column(name="item_type")
	@Enumerated(EnumType.STRING)
	private MenuItemType itemType;

	protected MenuItem() {}
	
	protected MenuItem(int itemId, String itemName, int itemPrice, String decription, MenuItemType type) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.decription = decription;
		this.itemType = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public MenuItemType getItemType() {
		return itemType;
	}
	public void setItemType(MenuItemType itemType) {
		this.itemType = itemType;
	}
	
}
