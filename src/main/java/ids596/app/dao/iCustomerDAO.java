package ids596.app.dao;

import java.util.List;

import ids596.app.entity.Customer;

public interface iCustomerDAO {
	
	public void addCustomer(Customer customer);
	public Customer getCustomer(long customerid);
	public List<Customer> getAllCustomers();
	public boolean isUserExists(Customer customer);
	public void updateCustomer(Customer customer);

}
