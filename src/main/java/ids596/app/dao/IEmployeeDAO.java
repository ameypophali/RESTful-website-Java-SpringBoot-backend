package ids596.app.dao;

import java.util.List;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;
import ids596.app.entity.Manager;;

public interface IEmployeeDAO {
    List<Object[]> getAllEmployeesNames();
    Employee getEmployeeById(long employeeId);
    void addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long employeeId);
    boolean employeeExists(String firstName, String lastName, String ssn);
    List<EmployeeKin> getAllEmployeeKins(long employeeId);
	void addManager(Manager manager);
	Manager getManagerById(long employeeId);
	void deleteManager(long employeeId);
}
