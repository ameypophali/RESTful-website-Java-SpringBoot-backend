package ids596.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class SalesItemLineId implements Serializable {

	private long salesOrderId;
	private int menuItemId;

	public SalesItemLineId() {
		super();
	}
	
	public SalesItemLineId(long salesOrderId, int menuItemId) {
		super();
		this.salesOrderId = salesOrderId;
		this.menuItemId = menuItemId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + menuItemId;
		result = prime * result + (int) (salesOrderId ^ (salesOrderId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesItemLineId other = (SalesItemLineId) obj;
		if (menuItemId != other.menuItemId)
			return false;
		if (salesOrderId != other.salesOrderId)
			return false;
		return true;
	}
	public long getSalesOrderId() {
		return salesOrderId;
	}
	public void setSalesOrderId(long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	
	
}
