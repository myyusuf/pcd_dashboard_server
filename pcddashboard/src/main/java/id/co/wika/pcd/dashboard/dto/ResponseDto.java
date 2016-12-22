package id.co.wika.pcd.dashboard.dto;

import java.util.List;

public class ResponseDto<T> {

	private List<T> data;
	private int totalRecords;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
