package ids596.app.service;

import java.util.List;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;
import ids596.app.entity.Manager;

public interface IEmployeeService {
    List<Object[]> getAllEmployeeNames();
    Employee getEmployeeById(long employeeId);
    boolean addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(long employeeId);
    List<EmployeeKin> retreieveAllEmployeeKins(long employeeId);
	boolean addManager(Manager manager);
	Manager getManagerById(long employeeId);
	void deleteManager(long employeeId);
}
