package ids596.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.MenuItemDAO;
import ids596.app.dao.SalesItemLineDAO;
import ids596.app.dao.SalesOrderDAO;
import ids596.app.entity.MenuItem;
import ids596.app.entity.SalesItemLine;
import ids596.app.entity.SalesItemLineId;
import ids596.app.entity.SalesOrder;

@Service
public class SalesItemLineService implements ISalesItemLineService{

	@Autowired
	private MenuItemDAO menuItemDAO;
	
	@Autowired
	private SalesOrderDAO salesOrderDAO;
	
	@Autowired
	private SalesItemLineDAO itemLineDAO;
	
	@Override
	public SalesItemLine getSalesItemLine(long salesOrderId, int menuItemId) {
/*		MenuItem menuItem = menuItemDAO.getMenuItemById(menuItemId);
		SalesOrder salesOrder = salesOrderDAO.getSalesOrder(salesOrderId);*/
		SalesItemLineId itemLine = new SalesItemLineId(salesOrderId,menuItemId);
		return itemLineDAO.getSalesItemLine(itemLine);
	}

}
