package ids596.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.dao.EmployeeKinDAO;
import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

@Service
public class EmployeeKinService implements IEmployeeKinService{

	@Autowired
	private EmployeeKinDAO employeeKinDAO;
	
/*	@Override
	public List<EmployeeKin> getAllKins(Employee employeeId) {
		return employeeKinDAO.getAllEmployeeKins(employeeId);
	}*/

	@Override
	public EmployeeKin getEmployeeKinById(long employeeKinId) {
		return employeeKinDAO.getEmployeeKinById(employeeKinId);
	}

	@Override
	public boolean addEmployeeKin(EmployeeKin employeeKin) {
		if(employeeKinDAO.employeeKinExistsByName(employeeKin.getParentEmployee(), 
									employeeKin.getFirstName(), employeeKin.getLastName())) {
			return false;
		}
		else {
			employeeKinDAO.addEmployeeKin(employeeKin);
			return true;
		}
		
	}

	@Override
	public EmployeeKin updateEmployeeKin(Employee employeeId, EmployeeKin employeeKin) {
		return employeeKinDAO.updateEmployeeKin(employeeId, employeeKin);
	}

	@Override
	public void deleteEmployeeKin(long employeeKinId) {
		employeeKinDAO.deleteEmployeeKin(employeeKinId);
	}

	@Override
	public boolean employeeKinExistsByName(Employee employeeId, String firstName, String lastName) {
		return employeeKinDAO.employeeKinExistsByName(employeeId, firstName, lastName);
	}

/*	@Override
	public List<EmployeeKin> getKinByFirstName(Employee employeeId, String firstName) {
		return employeeKinDAO.getKinByFirstName(employeeId, firstName);
	}*/

}
