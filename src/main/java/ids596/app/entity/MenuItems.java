package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Menu_Item")
public class MenuItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id", unique=true)
	@NotNull
	private int itemId;
	
	@NotNull
	@Column(name="item_name",unique = true)
	private String itemName;
	
	@NotNull
	@Column(name="item_price",unique = true)
	private int itemPrice;
	
	@NotNull
	@Column(name="description",unique = true)
	private String decription;
		
	protected MenuItems(int itemId, String itemName, int itemPrice, String decription) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.decription = decription;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItems other = (MenuItems) obj;
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
	
	
}
