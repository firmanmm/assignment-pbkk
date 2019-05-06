package com.kuliah.pbkk.service.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="restaurants", indexes={
		@Index(name="idx_alamat", columnList="alamat", unique = true)})
public class Restaurant extends Data {
	@OneToOne
	@JoinColumn(name="users_id", referencedColumnName="id")
	private User pemilik;
	private String nama;
	private String deskripsi;
	@Column(name="alamat", nullable=false)
	private String alamat;
	private Boolean isPremium;
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getDeskripsi() {
		return deskripsi;
	}
	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public Boolean getIsPremium() {
		return isPremium;
	}
	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}
	public User getPemilik() {
		return pemilik;
	}
	public void setPemilik(User pemilik) {
		this.pemilik = pemilik;
	}
}
