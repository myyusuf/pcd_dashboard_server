package id.co.wika.pcd.dashboard.dto;

import java.math.BigDecimal;

public class ChartDataDto {

	private String month;
	private BigDecimal plan;
	private BigDecimal actual;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public BigDecimal getPlan() {
		return plan;
	}

	public void setPlan(BigDecimal plan) {
		this.plan = plan;
	}

	public BigDecimal getActual() {
		return actual;
	}

	public void setActual(BigDecimal actual) {
		this.actual = actual;
	}

}
