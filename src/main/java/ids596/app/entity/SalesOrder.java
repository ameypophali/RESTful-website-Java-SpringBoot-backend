package ids596.app.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Sales_Order")
public class SalesOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sales_order_id", unique=true)
	@NotNull
	private int salesOrderId;
	
	/*
	 * The date on which the order was placed
	 */
	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	@NotNull
	private Date orderDate;
	
	/*
	 * Time at which the order was recorded
	 */
	@Temporal(TemporalType.TIME)
	@Column(name="order_time")
	@NotNull
	private Date orderTime;
	
	//Total cost of the sales order
	private int totalCost;
	
	/*
	 * This field maps customer to its sales order
	 * A sales order will have one customer, but a customer can have
	 * multiple sales order
	*/
	/*@ManyToOne
	@JoinColumn(name = "customer_Id")
	private Customer customer;*/
	
	/*
	 * This field maps an employee that has assisted 
	 * in placing the sales order to the sales order. It is a
	 * many to one mapping
	 */
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	/*
	 * This is a ManytoMany mapping for 
	 * Sales orders and menu items. A sales order can contain many menu items.
	 * A menu item can be present in many sales orders.
	 * The HashSet contains unique values for the menu items in this sales order
	 */
	//private Set<MenuItem> menuitems;

	protected SalesOrder() {}
	
	protected SalesOrder(int salesOrderId, Date orderDate, Date orderTime, int totalCost, Customer customer,
			Employee employee) {
		super();
		this.salesOrderId = salesOrderId;
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.totalCost = totalCost;
		//this.customer = customer;
		this.employee = employee;
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
/*	public Set<MenuItem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(Set<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}*/
	
}
