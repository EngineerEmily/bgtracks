package org.csc480.projectsite.web.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.directwebremoting.annotations.DataTransferObject;
import org.directwebremoting.annotations.RemoteProperty;

@DataTransferObject
public class GridDataResponseMessage implements Serializable {

	@RemoteProperty
	private int page;
	@RemoteProperty
	private int total;
	@RemoteProperty
	private int records;
	@RemoteProperty
	private List<?> rows;
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage() {
		return page;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotal() {
		return total;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public int getRecords() {
		return records;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public List<?> getRows() {
		return rows;
	}
	


}
