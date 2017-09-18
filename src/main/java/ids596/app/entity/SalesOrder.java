package ids596.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private long salesOrderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	@NotNull
	private Date orderDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name="order_time")
	@NotNull
	private Date orderTime;
	
	private int customerId;
	
	
	private long employeeId;
	
	
}
