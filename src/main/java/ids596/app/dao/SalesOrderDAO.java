package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ids596.app.entity.SalesOrder;

@Transactional
@Repository
public class SalesOrderDAO implements ISalesOrderDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addSalesOrder(SalesOrder salesOrder) {
		entityManager.persist(salesOrder);
	}

	@Override
	public SalesOrder getSalesOrder(long salesOrderId) {
		return entityManager.find(SalesOrder.class, salesOrderId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SalesOrder> getAllCustomerOrders(long customerId) {
		String hql = "from SalesOrder as slorder where slorder.customer.customerId = ?";
		List<SalesOrder> allOrdersCustomer = 
				entityManager.createQuery(hql).setParameter(1, customerId).getResultList();
		return allOrdersCustomer;
	}

	@Override
	public boolean salesOrderExists(long salesOrderId) {
		String hql = "FROM SalesOrder as sl where sl.salesOrderId = ? ";
		int count = entityManager.createQuery(hql).
					setParameter(1, salesOrderId).getResultList().size();
		
		return count>0 ? true : false;
	}

	@Override
	public void updateSalesOrder(long salesOrderId, SalesOrder salesOrder) {
		//this.entityManager.merge(salesOrder);
	}

	@Override
	public void deleteSalesOrder(long salesOrderID) {
		entityManager.remove(getSalesOrder(salesOrderID));
	}

}
