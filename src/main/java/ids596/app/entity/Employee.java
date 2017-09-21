/*
**  MODULE DESCRIPTION:
**
**  Base class for restaurant employees
**	Properties for employees are 
**	Id, 
**	SSN, 
**	first name, 
**	last name, 
**  DOB,
**  JobTitle,
**  Joining Date,
**  Salary,
**  apartment no, 
**	street, 
**	city  
**	zipcode
**
**  AUTHORS and CONTRIBUTORS
**      - Amey Pophali
**
**  CREATION DATE:   September 15, 2017
*/


package ids596.app.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*
{
"employeeId":5,
"ssn":"102-876-0990",
"firstName":"Vishita",
"lastName":"Singh",
"dateOfBirth":"1990-05-31",
"jobTitle":"Chef",
"joiningDate":"2012-06-08",
"salary":"1",
"aptNo":"701",
"streetName":"401 Anderson Street",
"city":"College Statiom",
"zipCode":"482009"
}

{
"employeeId":5,
"ssn":"234-085-9090",
"firstName":"Amey",
"lastName":"Pophali",
"dateOfBirth":"1989-05-31",
"jobTitle":"Intern",
"joiningDate":"2011-06-08",
"salary":"1",
"aptNo":"2A",
"streetName":"1444 Taylor Street",
"city":"Chicago",
"zipCode":"60607"
}

*/

enum JobTitle {
	Chef, Manager, Waitress, Accountant, Cashier, Intern
}

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_Id", unique=true)
	@NotNull
	private long employeeID;
	
	@NotNull
	@Column(name="SSN",unique = true)
	private String ssn;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Column(name="DOB")
	@Type(type="date")
	private Date dateOfBirth;
	
	@NotNull
	@Column(name="job_title")
	@Enumerated(EnumType.STRING)
	private JobTitle jobTitle;
	
	@NotNull
	@Column(name="Joining_date")
	private Date joiningDate;
	
	@NotNull
	@Column(name="salary")
	private int salary;
	
	@Column(name="apt_no")
	private String aptNo;
	
	@NotNull
	@Column(name="street_name")
	private String streetName;
	
	@NotNull
	@Column(name="city")
	private String city;

	@NotNull
	@Column(name="zipcode")
	private String zipCode;
	
	@JsonIgnore
	@OneToMany(cascade={CascadeType.ALL})
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="employee_Id", referencedColumnName="employee_Id")
	private Set<EmployeeKin> employeesKins;

	public Employee () {}
	
	public Employee(String ssn, String firstName, String lastName, Date dateOfBirth,
			JobTitle jobTitle, Date joiningDate, int salary, String aptNo, String aptName, String streetName,
			String city, String zipCode) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.jobTitle = jobTitle;
		this.joiningDate = joiningDate;
		this.salary = salary;
		this.aptNo = aptNo;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}
	
	public Set<EmployeeKin> getEmployeesKins() {
		return employeesKins;
	}

	public void setEmployeesKins(Set<EmployeeKin> employeesKins) {
		this.employeesKins = employeesKins;
	}

	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public JobTitle getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAptNo() {
		return aptNo;
	}
	public void setAptNo(String aptNo) {
		this.aptNo = aptNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", jobTitle=" + jobTitle + ", joiningDate=" + joiningDate
				+ ", salary=" + salary + ", aptNo=" + aptNo + ", streetName=" + streetName
				+ ", city=" + city + ", zipCode=" + zipCode + "]";
	}

}
