package ids596.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ids596.app.entity.Customer;
import ids596.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/{customerid}")
	public Customer getCustomer(@PathVariable("customerid") long customerid) {
		return customerService.getCustomer(customerid);
	}

	@PostMapping("/customer")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
		boolean added = customerService.addCustomer(customer);
		if (!added) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer, UriComponentsBuilder builder)
	{
		customerService.updateCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
