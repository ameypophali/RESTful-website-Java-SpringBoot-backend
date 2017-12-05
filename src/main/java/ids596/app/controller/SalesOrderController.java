package ids596.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ids596.app.entity.SalesOrder;
import ids596.app.service.SalesOrderService;

@RestController
public class SalesOrderController {

	@Autowired
	private SalesOrderService salesOService;
	
	@GetMapping("/salesorder/{salesOrderId}")
	public SalesOrder getCustomer(@PathVariable("salesOrderId") long salesOrderId) {
		return salesOService.getSalesOrder(salesOrderId);
	}
	
	@PostMapping("/salesorder")
	public ResponseEntity<Void> addCustomer(@RequestBody SalesOrder salesOrder, UriComponentsBuilder builder) {
		//Date date = salesOrder.getOrderDate();
		
		System.out.println("Amey Pophali " + salesOrder.getOrderDate() + " " + salesOrder.getOrderTime());
		boolean added = salesOService.addSalesOrder(salesOrder);
		if (!added) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
	}
	
	@GetMapping("/{customerID}/salesorders")
	public List<SalesOrder> getAllCustomers(@PathVariable("customerid") long customerId) {
		return salesOService.getAllCustomerOrders(customerId);
	}
	
	@PutMapping("/updateSalesOrder/{salesOrderId}")
	public ResponseEntity<Void> updateCustomer(@PathVariable("salesOrderId") long salesOrderId,
			@RequestBody SalesOrder salesOrder, UriComponentsBuilder builder)
	{
		salesOService.updateSalesOrder(salesOrderId, salesOrder);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/salesorder/{salesOrderId}")
	public ResponseEntity<Void> deleteMenuItem(@PathVariable int salesOrderId){
		salesOService.deleteSalesOrder(salesOrderId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
