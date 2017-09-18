package ids596.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.MenuItemDAO;
import ids596.app.entity.MenuItem;

@Service
public class MenuItemService implements IMenuItemService {

	@Autowired
	private MenuItemDAO menuItemDAO;
	
	@Override
	public List<Object[]> getAllMenuItems(){
		return menuItemDAO.getAllMenuItems();
	}

	@Override
	public MenuItem getItemById(int itemId) {
		return menuItemDAO.getMenuItemById(itemId);
	}

	@Override
	public boolean addMenuItem(MenuItem menuItem) {
		if(menuItemDAO.menuItemExists(menuItem.getItemName(), menuItem.getItemPrice())) {
			return false;
		}
		menuItemDAO.addMenuItem(menuItem);
		return true;
	}

	@Override
	public void updateMenuItem(MenuItem menuItem) {
		menuItemDAO.updateMenuItem(menuItem);
	}

	@Override
	public void deleteMenuItem(int itemId) {
		menuItemDAO.deleteMenuItem(itemId);
	}

}
