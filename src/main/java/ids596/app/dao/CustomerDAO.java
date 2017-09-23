package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ids596.app.entity.Customer;

@Transactional
@Repository
public class CustomerDAO implements iCustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public Customer getCustomer(long customerid) {
		return entityManager.find(Customer.class, customerid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		String hql = "from Customer";
		return (List<Customer>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public boolean isUserExists(Customer customer) {
		String hql = "from Customer where firstName = ? and lastName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, customer.getFirstName())
				.setParameter(2, customer.getLastName()).getResultList().size();
		return count > 0 ? true : false;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Customer currentCustomer = getCustomer(customer.getCustomerId());
		currentCustomer.setLastName(customer.getLastName());
		currentCustomer.setFirstName(customer.getFirstName());
		currentCustomer.setStreetName(customer.getStreetName());
		currentCustomer.setAptNo(customer.getAptNo());
		currentCustomer.setZipCode(customer.getZipCode());
		currentCustomer.setCity(customer.getCity());
	}

}
