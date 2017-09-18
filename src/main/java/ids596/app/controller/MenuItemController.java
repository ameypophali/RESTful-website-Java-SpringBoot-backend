package ids596.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ids596.app.entity.MenuItem;
import ids596.app.service.MenuItemService;

@RestController
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping("/menuitems")
	public List<Object[]> retrieveAllMenuItems(){
		List<Object[]> allItems = menuItemService.getAllMenuItems();
		return allItems;
	}
	
	@GetMapping("/menuitem/{itemId}")
	public MenuItem retrieveMenuItemByID(@PathVariable int itemId) {
		return menuItemService.getItemById(itemId);
	}
	
	@PostMapping("/menuitem")
	public ResponseEntity<Void> addMenuItem(@RequestBody MenuItem menuItem, UriComponentsBuilder builder){
		boolean added = menuItemService.addMenuItem(menuItem);
		if(!added) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/menuitem/{menuItem}").buildAndExpand(menuItem.getItemId())
				.toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/menuitem")
	public ResponseEntity<MenuItem> updateMenuItem(MenuItem menuItem) {
		menuItemService.updateMenuItem(menuItem);
		return new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
	}
	
	@DeleteMapping("/menuitem/{itemId}")
	public ResponseEntity<Void> deleteMenuItem(@PathVariable int itemId){
		menuItemService.deleteMenuItem(itemId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
