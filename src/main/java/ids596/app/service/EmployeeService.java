package ids596.app.service;

import java.util.List;

import ids596.app.dao.IEmployeeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	private IEmployeeDAO employeeDAO; 

	@Override
	public List<Object[]> getAllEmployeeNames() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployeesNames();
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeDAO.employeeExists(employee.getFirstName(), employee.getLastName(), employee.getSsn())) {
			return false;
		}
		else {
			employeeDAO.addEmployee(employee);
			return true;
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public List<EmployeeKin> retreieveAllEmployeeKins(long employeeId) {
		return employeeDAO.getAllEmployeeKins(employeeId);
	}

}
