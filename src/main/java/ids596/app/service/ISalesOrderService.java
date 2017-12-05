package ids596.app.service;

import java.util.List;

import ids596.app.entity.SalesOrder;

public interface ISalesOrderService {
	public boolean addSalesOrder(SalesOrder salesOrder);
	public List<SalesOrder> getAllCustomerOrders(long customerId);
	public SalesOrder getSalesOrder(long salesOrderId);
	public void updateSalesOrder(long salesOrderId, SalesOrder salesOrder);
	public void deleteSalesOrder(long salesOrderId);
}