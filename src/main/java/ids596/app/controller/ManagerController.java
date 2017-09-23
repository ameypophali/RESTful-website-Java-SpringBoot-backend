package ids596.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ids596.app.entity.Manager;
import ids596.app.service.EmployeeService;

@RestController
public class ManagerController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("manager/{employeeId}")
	public Manager retrieveManagerById(@PathVariable long employeeId){
		Manager manager = employeeService.getManagerById(employeeId);
		return manager;
	}
	
	@PostMapping("/manager")
	public ResponseEntity<Void> addManager(@RequestBody Manager manager, UriComponentsBuilder builder) {
		boolean added = employeeService.addManager(manager);
		if (!added) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/manager/{employeeId}").buildAndExpand(manager.getEmployeeID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("manager/{employeeId}")
	public ResponseEntity<Void> deleteManager(@PathVariable("employeeId") long employeeId) {
		employeeService.deleteManager(employeeId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
