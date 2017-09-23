package ids596.app.service;

import java.util.List;

import ids596.app.dao.IEmployeeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;
import ids596.app.entity.Manager;

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
	
	@Override
	public boolean addManager(Manager manager) {
		if(employeeDAO.employeeExists(manager.getFirstName(), manager.getLastName(), manager.getSsn())) {
			return false;
		}
		else {
			employeeDAO.addManager(manager);
			return true;
		}
	}
	
	@Override
	public Manager getManagerById(long employeeId) {
		return employeeDAO.getManagerById(employeeId);
	}

	@Override
	public void deleteManager(long employeeId) {
		employeeDAO.deleteManager(employeeId);
	}
}
