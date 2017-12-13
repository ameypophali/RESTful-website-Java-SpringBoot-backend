package ids596.app.dao;

import ids596.app.entity.SalesItemLine;
import ids596.app.entity.SalesItemLineId;

public interface ISalesItemLineDAO {
	public void addSalesItemLine(SalesItemLine SalesItemLine);
	public SalesItemLine getSalesItemLine(SalesItemLineId salesItemLineId);
	public void deleteSalesLineItem(SalesItemLineId salesItemLineId);

/*	public List<SalesItemLine> getAllCustomerOrders(long customerId);
	public boolean salesOrderExists(long salesOrderId);
	public void updateSalesOrder(long salesOrderId, SalesItemLine salesOrder);
	public void deleteSalesOrder(long salesOrderID);*/
}
