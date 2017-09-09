package ids596.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

@Transactional
@Repository
public class EmployeeDAO implements IEmployeeDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllEmployeesNames() {
		// TODO Auto-generated method stub
		String hql = "SELECT empl.employeeID, empl.firstName, empl.lastName, empl.ssn "
									+ "FROM Employee as empl ORDER BY empl.lastName";
		return (List<Object[]>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee currentEmployee = getEmployeeById(employee.getEmployeeID());
		currentEmployee.setAptNo(employee.getAptNo());
		currentEmployee.setCity(employee.getCity());
		currentEmployee.setDateOfBirth(employee.getDateOfBirth());
		currentEmployee.setFirstName(employee.getFirstName());
		currentEmployee.setJobTitle(employee.getJobTitle());
		currentEmployee.setJoiningDate(employee.getJoiningDate());
		currentEmployee.setLastName(employee.getLastName());
		currentEmployee.setSalary(employee.getSalary());
		currentEmployee.setSsn(employee.getSsn());
		currentEmployee.setStreetName(employee.getStreetName());
		currentEmployee.setZipCode(employee.getZipCode());
		
		return currentEmployee;
	}

	@Override
	public void deleteEmployee(long employeeID) {
		// TODO Auto-generated method stub
		entityManager.remove(getEmployeeById(employeeID));
	}

	@Override
	public boolean employeeExists(String firstName, String lastName, String ssn) {
		// TODO Auto-generated method stub
		String hql = "FROM Employee as empl where empl.firstName = ? and empl.lastName = ? "
				+ "and empl.ssn = ?";
		int count = entityManager.createQuery(hql).setParameter(1, firstName).
				setParameter(2, lastName).setParameter(3, ssn).getResultList().size();
		
		return count>0 ? true : false;
	}

	@Override
	public List<EmployeeKin> getAllEmployeeKins(long employeeId) {
		String hql = "FROM EmployeeKin as emplkin where emplkin.parentEmployee.employeeID = ? ";
		@SuppressWarnings("unchecked")
		List<EmployeeKin> employeeKins = 
				entityManager.createQuery(hql).setParameter(1, employeeId).getResultList();
		
		return employeeKins;
	}

}
