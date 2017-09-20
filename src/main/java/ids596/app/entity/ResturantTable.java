package ids596.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Table")
public class ResturantTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_id", unique = true)
	@NotNull
	private int tableId;

	@Column(name = "seats")
	@NotNull
	private int seats;

	@Column(name = "isReserved")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@NotNull
	private int isReserved;

	private int invoiceId;

	private int totalTableCount = 0;
	private final int MAX_TABLE_COUNT = 8;

	protected ResturantTable() {
		if (totalTableCount < MAX_TABLE_COUNT) {
			totalTableCount++;
		}
	}

	protected ResturantTable(int tableId, int seats, int isReserved, int invoiceId) throws Exception {
		if (totalTableCount < MAX_TABLE_COUNT) {
			this.tableId = tableId;
			this.seats = seats;
			this.isReserved = isReserved;
			this.invoiceId = invoiceId;
			totalTableCount++;
		}
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(int isReserved) {
		this.isReserved = isReserved;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

}
