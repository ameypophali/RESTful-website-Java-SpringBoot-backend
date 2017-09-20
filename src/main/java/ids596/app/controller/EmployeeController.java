package ids596.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;
import ids596.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Object[]> retrieveEmployeeList(){
		List<Object[]> employees = employeeService.getAllEmployeeNames();
		return employees;
	}
	
	
	@GetMapping("/employee/{employeeId}/kins")
	public List<EmployeeKin> retrieveEmployeeKins(@PathVariable long employeeId){
		List<EmployeeKin> employeekins = employeeService.retreieveAllEmployeeKins(employeeId);
		return employeekins;
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee retrieveEmployeeById(@PathVariable long employeeId){
		Employee employee = employeeService.getEmployeeById(employeeId);
		return employee;
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
		boolean added = employeeService.addEmployee(employee);
		if (!added) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee/{employeeId}").buildAndExpand(employee.getEmployeeID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("employee/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("employeeId") long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
