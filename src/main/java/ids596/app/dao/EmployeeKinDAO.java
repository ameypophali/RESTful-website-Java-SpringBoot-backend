package ids596.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ids596.app.entity.Employee;
import ids596.app.entity.EmployeeKin;

@Transactional
@Repository
public class EmployeeKinDAO implements IEmployeeKinDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
/*	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeKin> getAllEmployeeKins(Employee employeeId) {
		String hql = "FROM EmployeeKin as emplkin ORDER BY emplkin.lastName";
		return (List<EmployeeKin>) entityManager.createQuery(hql).getResultList();
	}*/

/*	@Override
	public List<EmployeeKin> getKinByFirstName(Employee employeeId, String firstName) {
		String hql = "FROM EmployeeKin as emplkin WHERE emplkin.parentEmployee = ?";
		@SuppressWarnings("unchecked")
		List<EmployeeKin> employeeKins = entityManager.createQuery(hql)
											.setParameter(1, employeeId).getResultList();
		
		List<EmployeeKin> result = new ArrayList<>();
		
		for(EmployeeKin kin : employeeKins) {
			if(kin.getFirstName().equals(firstName)) {
				result.add(kin);
			}
		}
		return result;
	}*/

	@Override
	public EmployeeKin getEmployeeKinById(long employeeKinId) {
		return entityManager.find(EmployeeKin.class, employeeKinId);
	}

	@Override
	public void addEmployeeKin(EmployeeKin employeeKin) {
		entityManager.merge(employeeKin);
	}

	@Override
	public EmployeeKin updateEmployeeKin(Employee employeeId, EmployeeKin employeeKin) {
		String hql = "FROM EmployeeKin as emplkin WHERE emplkin.parentEmployee = ?";
		@SuppressWarnings("unchecked")
		List<EmployeeKin> employeeKins = entityManager.createQuery(hql)
											.setParameter(1, employeeId).getResultList();
		EmployeeKin updateEmployeeKin = null;
		for(EmployeeKin kin : employeeKins) {
			if(kin.getEmployeeKinId() == employeeKin.getEmployeeKinId()) {
				updateEmployeeKin = kin;
				break;
			}
		}
		updateEmployeeKin.setCityAddress(employeeKin.getCityAddress());
		updateEmployeeKin.setFirstName(employeeKin.getFirstName());
		updateEmployeeKin.setLastName(employeeKin.getLastName());
		updateEmployeeKin.setStreetAddress(employeeKin.getStreetAddress());
		updateEmployeeKin.setZipCode(employeeKin.getZipCode());
		
		return updateEmployeeKin;
	}

	@Override
	public void deleteEmployeeKin(long employeeKinId) {
		entityManager.remove(getEmployeeKinById(employeeKinId));
		
	}

	@Override
	public boolean employeeKinExistsByName(Employee employeeId, String firstName, String lastName) {
		String hql = "FROM EmployeeKin as emplkin WHERE emplkin.parentEmployee = ? and emplkin.firstName = ?"
				+ " and emplkin.lastName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, employeeId)
				.setParameter(2, firstName).setParameter(3, lastName).getResultList().size();
		
		return count>0 ? true : false;
	}


}
