package ids596.app.service;

import java.util.List;

import ids596.app.entity.MenuItem;

public interface IMenuItemService {
    List<Object[]> getAllMenuItems();
    MenuItem getItemById(int itemId);
    boolean addMenuItem(MenuItem menuItem);
    void updateMenuItem(MenuItem menuItem);
    void deleteMenuItem(int itemId);
}
