package ids596.app.service;

import java.util.List;

import ids596.app.entity.Customer;

public interface iCustomerService {
	public boolean addCustomer(Customer customer);
	public Customer getCustomer(long customerid);
	public List<Customer> getAllCustomers();
	public void updateCustomer(Customer customer);
}
