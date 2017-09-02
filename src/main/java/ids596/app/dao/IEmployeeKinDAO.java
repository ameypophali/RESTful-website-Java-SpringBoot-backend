package ids596.app.dao;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

public interface IEmployeeKinDAO {
    //List<EmployeeKin> getAllEmployeeKins(Employee employeeId);
    EmployeeKin getEmployeeKinById(long employeeKinId);
    void addEmployeeKin(EmployeeKin employeeKin);
    EmployeeKin updateEmployeeKin(Employee employeeId, EmployeeKin employeeKin);
    void deleteEmployeeKin(long employeeKinId);
    boolean employeeKinExistsByName(Employee employeeId, String firstName, String lastName);
	//List<EmployeeKin> getKinByFirstName(Employee employeeId, String firstName);
}
