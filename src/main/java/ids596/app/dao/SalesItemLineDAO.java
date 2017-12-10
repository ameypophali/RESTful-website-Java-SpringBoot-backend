package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ids596.app.entity.SalesItemLine;
import ids596.app.entity.SalesItemLineId;

@Transactional
@Repository
public class SalesItemLineDAO implements ISalesItemLineDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public SalesItemLine getSalesItemLine(SalesItemLineId salesItemLineId) {
/*		String hql = "FROM SalesItemLine";
				//+ "and siLine.salesItemId.menuItem.itemId = ?";
		System.out.println("Amey Pophali" + salesItemLineId.getSalesOrder().getSalesOrderId() + " "
				+ salesItemLineId.getMenuItem().getItemId());
		@SuppressWarnings("unchecked")
		List<SalesItemLine> salesItemLine = entityManager.createQuery(hql)
				//.setParameter(1, salesItemLineId.getSalesOrder().getSalesOrderId())
				//.setParameter(2, salesItemLineId.getMenuItem().getItemId())
				.getResultList(); */
		return entityManager.find(SalesItemLine.class, salesItemLineId);
	}

}
