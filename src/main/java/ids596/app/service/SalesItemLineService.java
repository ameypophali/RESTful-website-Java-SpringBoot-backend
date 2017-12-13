package ids596.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.SalesItemLineDAO;
import ids596.app.entity.SalesItemLine;
import ids596.app.entity.SalesItemLineId;

@Service
public class SalesItemLineService implements ISalesItemLineService{

	@Autowired
	private SalesItemLineDAO itemLineDAO;
	
	@Override
	public SalesItemLine getSalesItemLine(long salesOrderId, int menuItemId) {
		SalesItemLineId itemLine = new SalesItemLineId(salesOrderId,menuItemId);
		return itemLineDAO.getSalesItemLine(itemLine);
	}

	@Override
	public void addSalesItemLine(SalesItemLine salesItemLine) {
		itemLineDAO.addSalesItemLine(salesItemLine);
	}

	@Override
	public void deleteSalesItemLine(long salesOrderId, int menuItemId) {
		SalesItemLineId itemLine = new SalesItemLineId(salesOrderId,menuItemId);
		itemLineDAO.deleteSalesLineItem(itemLine);
	}

}
