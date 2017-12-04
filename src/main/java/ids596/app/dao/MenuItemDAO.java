package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ids596.app.entity.MenuItem;

@Transactional
@Repository
public class MenuItemDAO implements IMenuItemDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllMenuItems() {
		String menuItemsQuery = "SELECT menuItem.itemId, menuItem.itemName, menuItem.itemPrice, menuItem.decription, "
				+ "menuItem.itemType FROM MenuItem as menuItem ORDER BY menuItem.itemName";
		return (List<Object[]>) entityManager.createQuery(menuItemsQuery).getResultList();
	}

	@Override
	public MenuItem getMenuItemById(int itemId) {
		return entityManager.find(MenuItem.class,itemId);
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		entityManager.merge(menuItem);
	}

	@Override
	public MenuItem updateMenuItem(MenuItem menuItem) {
		/*MenuItem currentItem = getMenuItemById(menuItem.getItemId());
		currentItem.setDecription(menuItem.getDecription());
		currentItem.setItemName(menuItem.getItemName());
		currentItem.setItemPrice(menuItem.getItemPrice());*/
		entityManager.merge(menuItem);
		return menuItem;
	}

/*	@Override
	public MenuItem updateMenuItemPartial(MenuItem menuItem) {
		
	}*/

	@Override
	public boolean menuItemExists(String itemName, int itemPrice) {
		String checkMenuItem = "FROM MenuItem as menuItem where menuItem.itemName = ? "
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
