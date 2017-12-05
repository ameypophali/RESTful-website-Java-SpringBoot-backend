package ids596.app.dao;

import java.util.List;

import ids596.app.entity.Customer;
import ids596.app.entity.SalesOrder;

public interface ISalesOrderDAO {
	public void addSalesOrder(SalesOrder salesOrder);
	public SalesOrder getSalesOrder(long salesOrderId);
	public List<SalesOrder> getAllCustomerOrders(long customerId);
	public boolean salesOrderExists(long salesOrderId);
	public void updateSalesOrder(long salesOrderId, SalesOrder salesOrder);
	public void deleteSalesOrder(long salesOrderID);
}
