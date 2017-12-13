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
	public void addSalesItemLine(SalesItemLine salesItemLine) {
		entityManager.merge(salesItemLine);
	}

	@Override
	public SalesItemLine getSalesItemLine(SalesItemLineId salesItemLineId) {
		return entityManager.find(SalesItemLine.class, salesItemLineId);
	}

	@Override
	public void deleteSalesLineItem(SalesItemLineId salesItemLineId) {
		entityManager.remove(getSalesItemLine(salesItemLineId));
	}


}
