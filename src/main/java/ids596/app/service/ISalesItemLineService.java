package ids596.app.service;

import ids596.app.entity.SalesItemLine;

public interface ISalesItemLineService {
	SalesItemLine getSalesItemLine(long salesOrderId, int menuItemId);
	void addSalesItemLine(SalesItemLine salesItemLine);
	void deleteSalesItemLine(long salesOrderId, int menuItemId);
}
