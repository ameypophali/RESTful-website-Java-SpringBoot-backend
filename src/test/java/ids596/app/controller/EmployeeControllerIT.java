package ids596.app.controller;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import ids596.app.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

	@LocalServerPort
	private int port;
	
	@Test
	public void testRetrieveEmployeeById() throws JSONException {
		String url = "http://localhost:" 
					+ port + "/employee/1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		String output = restTemplate.getForObject(url, String.class);
		
		
/*		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
		*/
		//String actual = "{employeeID:1,ssn:102-876-0990,firstName:Vishita,lastName:Singh,dateOfBirth:1990-05-30,jobTitle:Halwai,joiningDate:2012-06-07,salary:1,aptNo:701,streetName:\"401 Anderson Street\",city:\"College Statiom\",zipCode:482009}";
		System.out.println("Amey = " + output);
		//JSONAssert.assertEquals(output, actual, false);
	}

}
