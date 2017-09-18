package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Customer")
public class Customer{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_Id", unique=true)
	@NotNull
	private int cutomerId;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
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
	
	protected Customer() {}

	protected Customer(int cutomerId, String firstName, String lastName, String aptNo, String streetName, String city,
			String zipCode) {
		super();
		this.cutomerId = cutomerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aptNo = aptNo;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}

	public int getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
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
	
}
