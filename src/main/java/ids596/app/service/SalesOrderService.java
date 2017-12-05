package ids596.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.SalesOrderDAO;
import ids596.app.entity.SalesOrder;

@Service
public class SalesOrderService implements ISalesOrderService {

	@Autowired
	private SalesOrderDAO salesOrderDAO;

	@Override
	public boolean addSalesOrder(SalesOrder salesOrder) {
		if(salesOrderDAO.salesOrderExists(salesOrder.getSalesOrderId())) {
			return false;
		}
		salesOrderDAO.addSalesOrder(salesOrder);
		return false;
	}

	@Override
	public List<SalesOrder> getAllCustomerOrders(long customerId) {
		return salesOrderDAO.getAllCustomerOrders(customerId);
	}

	@Override
	public void updateSalesOrder(long salesOrderId, SalesOrder salesOrder) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteSalesOrder(long salesOrderId) {
		salesOrderDAO.deleteSalesOrder(salesOrderId);
		
	}

	@Override
	public SalesOrder getSalesOrder(long salesOrderId) {
		return salesOrderDAO.getSalesOrder(salesOrderId);
	}

}
