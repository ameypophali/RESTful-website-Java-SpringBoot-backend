package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="sales_item_line")
public class SalesItemLine {
	
	@EmbeddedId
	private SalesItemLineId salesItemId;
	
	@ManyToOne
	@MapsId("salesOrderId")
	@JoinColumn(name = "sales_order_id")
	private SalesOrder salesOrder;
	
	@ManyToOne
	@MapsId("menuItemId")
	@JoinColumn(name = "item_id")
	private MenuItem menuItem;
	
	@NotNull
	@Column(name="quantity_ordered")
	private int quantity;

	public SalesItemLine() {
	}

	public SalesItemLine(SalesItemLineId salesItemId, int quantity) {
		super();
		this.salesItemId = salesItemId;
		this.quantity = quantity;
	}

	public SalesItemLineId getSalesItemId() {
		return salesItemId;
	}

	public void setSalesItemId(SalesItemLineId salesItemId) {
		this.salesItemId = salesItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
