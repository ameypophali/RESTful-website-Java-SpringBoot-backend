package ids596.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.CustomerDAO;
import ids596.app.entity.Customer;

@Service
public class CustomerService implements iCustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public boolean addCustomer(Customer customer) {
		if (customerDAO.isUserExists(customer)) {
			return false;
		}
		customerDAO.addCustomer(customer);
		return true;
	}

	@Override
	public Customer getCustomer(long customerid) {
		return customerDAO.getCustomer(customerid);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}

}
