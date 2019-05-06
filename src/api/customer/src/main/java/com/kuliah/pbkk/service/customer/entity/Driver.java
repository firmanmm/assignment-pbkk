package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;


@Entity
@Table(name="drivers", indexes={
		@Index(name="idx_no_polisi", columnList="no_polisi", unique = true),
		@Index(name="idx_no_handphone", columnList="no_handphone", unique=true)})
public class Driver extends UserTrait{
	@Column(name="no_polisi", nullable=false)
	private String noPolisi;
	private String jenisKendaraan;
	private Boolean isApproved;
	
	public String getNoPolisi() {
		return noPolisi;
	}
	public void setNoPolisi(String noPolisi) {
		this.noPolisi = noPolisi;
	}
	public String getJenisKendaraan() {
		return jenisKendaraan;
	}
	public void setJenisKendaraan(String jenisKendaraan) {
		this.jenisKendaraan = jenisKendaraan;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
}
