package ids596.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ids596.app.entity.SalesItemLine;
import ids596.app.service.SalesItemLineService;

@RestController
public class SalesItemLineController {

	@Autowired
	private SalesItemLineService itemLineService;
	
	@GetMapping("/itemline/{salesOrderId}/{menuItemId}")
	public SalesItemLine retrieveMenuItemByID(@PathVariable long salesOrderId, @PathVariable int menuItemId) {
		return itemLineService.getSalesItemLine(salesOrderId, menuItemId);
	}




}
