package ids596.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ids596.app.entity.EmployeeKin;
import ids596.app.service.EmployeeKinService;

@RestController
public class EmployeeKinController {

	@Autowired
	private EmployeeKinService employeeKinService;
	
	@GetMapping("/employee/kin/{employeekinId}")
	public EmployeeKin retrieveKinsForEmployee(@PathVariable long employeekinId) {
		return employeeKinService.getEmployeeKinById(employeekinId);
	}
	
	@PostMapping("/employeeKin")
	public ResponseEntity<Void> createEmployeeKin(@RequestBody EmployeeKin employeeKin, 
														UriComponentsBuilder builder){
		System.out.println("Amey [employeeKinId=" + employeeKin.getEmployeeKinId() + 
		", parentEmployee=" + employeeKin.getParentEmployee() + ", firstName="
				+ employeeKin.getFirstName() + ", lastName=" + employeeKin.getLastName() + 
				", streetAddress=" + employeeKin.getStreetAddress() + ", cityAddress="
				+ employeeKin.getCityAddress() + ", zipCode=" + employeeKin.getZipCode() + "]");
		
		
		boolean flag = employeeKinService.addEmployeeKin(employeeKin);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/employee/kin/{employeekinId}")
					.buildAndExpand(employeeKin.getEmployeeKinId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
