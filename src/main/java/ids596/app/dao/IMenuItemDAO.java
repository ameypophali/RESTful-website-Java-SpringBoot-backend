package ids596.app.dao;

import java.util.List;
import ids596.app.entity.MenuItem;

public interface IMenuItemDAO {
	List<Object[]> getAllMenuItems();
	MenuItem getMenuItemById(int itemId);
	void addMenuItem(MenuItem menuItem);
	//MenuItem updateMenuItemPartial(MenuItem menuItem);
	MenuItem updateMenuItem(MenuItem menuItem);
	boolean menuItemExists(String itemName, int itemPrice);
	void deleteMenuItem(int itemId);
}
