package ids596.app.service;

import java.util.List;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

public interface IEmployeeKinService {
    //List<EmployeeKin> getAllKins(Employee employeeId);
    EmployeeKin getEmployeeKinById(long employeeKinId);
    boolean addEmployeeKin(EmployeeKin employeeKin);
    EmployeeKin updateEmployeeKin(Employee employeeId, EmployeeKin employeeKin);
    void deleteEmployeeKin(long employeeKinId);
    boolean employeeKinExistsByName(Employee employeeId, String firstName, String lastName);
	//List<EmployeeKin> getKinByFirstName(Employee employeeId, String firstName);
}
