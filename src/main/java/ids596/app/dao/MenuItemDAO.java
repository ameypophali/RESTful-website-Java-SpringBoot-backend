package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ids596.app.entity.MenuItem;

public class MenuItemDAO implements IMenuItemDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllMenuItems() {
		String menuItemsQuery = "SELECT menuItem.ItemID, menuItem.ItemName, menuItem.itemPrice, menuItem.desc "
				+ "FROM MenuItem as menuItem ORDER BY menuItem.ItemName";
		return (List<Object[]>) entityManager.createQuery(menuItemsQuery).getResultList();
	}

	@Override
	public MenuItem getMenuItemById(int itemId) {
		entityManager.find(MenuItem.class,itemId);
		return null;
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		entityManager.persist(menuItem);
	}

	@Override
	public MenuItem updateMenuItem(MenuItem menuItem) {
		MenuItem currentItem = getMenuItemById(menuItem.getItemId());
		currentItem.setDecription(menuItem.getDecription());
		currentItem.setItemName(menuItem.getItemName());
		currentItem.setItemPrice(menuItem.getItemPrice());
		
		return currentItem;
	}

/*	@Override
	public MenuItem updateMenuItemPartial(MenuItem menuItem) {
		
	}*/

	@Override
	public boolean menuItemExists(String itemName, int itemPrice) {
		String checkMenuItem = "FROM MenuItem as menuItem where menuItem.ItemName = ? "
				+ "and menuItem.itemPrice = ? ";
		int count = entityManager.createQuery(checkMenuItem).setParameter(1, itemName).
				setParameter(2,itemPrice).getResultList().size();
				
		return count>0 ? true : false;
	}

	@Override
	public void deleteMenuItem(int itemId) {
		entityManager.remove(getMenuItemById(itemId));		
	}


}
