package id.co.wika.pcd.dashboard.dto;

import java.math.BigDecimal;

public class DashboardItemDto {

	private String title;
	private BigDecimal ok;
	private BigDecimal op;
	private BigDecimal lsp;
	private BigDecimal lk;
	
	public BigDecimal getOk() {
		return ok;
	}

	public void setOk(BigDecimal ok) {
		this.ok = ok;
	}

	public BigDecimal getOp() {
		return op;
	}

	public void setOp(BigDecimal op) {
		this.op = op;
	}

	public BigDecimal getLsp() {
		return lsp;
	}

	public void setLsp(BigDecimal lsp) {
		this.lsp = lsp;
	}

	public BigDecimal getLk() {
		return lk;
	}

	public void setLk(BigDecimal lk) {
		this.lk = lk;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
