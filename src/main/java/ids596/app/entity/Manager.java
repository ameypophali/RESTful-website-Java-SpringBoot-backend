package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*{
    "employeeID": 11,
    "ssn": "102-876-0990",
    "firstName": "Vishita",
    "lastName": "Singh",
    "dateOfBirth": "1990-05-30",
    "jobTitle": "manager",
    "joiningDate": "2012-06-07",
    "salary": 10000,
    "aptNo": "701",
    "streetName": "401 Anderson Street",
    "city": "College Statiom",
    "zipCode": "482009",
    "carAllowance": 200,
    "bonusAllowance": 100
}*/

@Entity
@Table(name="Manager")
@PrimaryKeyJoinColumn(name="employee_Id",referencedColumnName="employee_Id")
public class Manager extends Employee {

	@Column(name="car_allowance")    
	private int carAllowance;
	
	@Column(name="bonus_allowance")  
	private int bonusAllowance;
	
	protected Manager() {}
	
	protected Manager(int carAllowance, int bonusAllowance) {
		super();
		this.carAllowance = carAllowance;
		this.bonusAllowance = bonusAllowance;
	}
	
	public int getCarAllowance() {
		return carAllowance;
	}
	public void setCarAllowance(int carAllowance) {
		this.carAllowance = carAllowance;
	}
	public int getBonusAllowance() {
		return bonusAllowance;
	}
	public void setBonusAllowance(int bonusAllowance) {
		this.bonusAllowance = bonusAllowance;
	}

	@Override
	public String toString() {
		return "Manager [carAllowance=" + carAllowance + ", bonusAllowance=" + bonusAllowance + "]";
	}
	
}
