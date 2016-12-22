package id.co.wika.pcd.dashboard.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_progress")
public class ProjectProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Project project;

	private int month;
	private int year;

	private BigDecimal rkapOk;
	private BigDecimal rkapOp;
	private BigDecimal rkapLk;

	private BigDecimal prognosaOk;
	private BigDecimal prognosaOp;
	private BigDecimal prognosaLk;

	private BigDecimal realisasiOk;
	private BigDecimal realisasiOp;
	private BigDecimal realisasiLk;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getRkapOk() {
		return rkapOk;
	}

	public void setRkapOk(BigDecimal rkapOk) {
		this.rkapOk = rkapOk;
	}

	public BigDecimal getRkapOp() {
		return rkapOp;
	}

	public void setRkapOp(BigDecimal rkapOp) {
		this.rkapOp = rkapOp;
	}

	public BigDecimal getRkapLk() {
		return rkapLk;
	}

	public void setRkapLk(BigDecimal rkapLk) {
		this.rkapLk = rkapLk;
	}

	public BigDecimal getPrognosaOk() {
		return prognosaOk;
	}

	public void setPrognosaOk(BigDecimal prognosaOk) {
		this.prognosaOk = prognosaOk;
	}

	public BigDecimal getPrognosaOp() {
		return prognosaOp;
	}

	public void setPrognosaOp(BigDecimal prognosaOp) {
		this.prognosaOp = prognosaOp;
	}

	public BigDecimal getPrognosaLk() {
		return prognosaLk;
	}

	public void setPrognosaLk(BigDecimal prognosaLk) {
		this.prognosaLk = prognosaLk;
	}

	public BigDecimal getRealisasiOk() {
		return realisasiOk;
	}

	public void setRealisasiOk(BigDecimal realisasiOk) {
		this.realisasiOk = realisasiOk;
	}

	public BigDecimal getRealisasiOp() {
		return realisasiOp;
	}

	public void setRealisasiOp(BigDecimal realisasiOp) {
		this.realisasiOp = realisasiOp;
	}

	public BigDecimal getRealisasiLk() {
		return realisasiLk;
	}

	public void setRealisasiLk(BigDecimal realisasiLk) {
		this.realisasiLk = realisasiLk;
	}

}
