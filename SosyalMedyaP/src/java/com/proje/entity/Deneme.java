package com.proje.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.proje.base.Cinsiyet;
@Entity
@Table(name="deneme")
public class Deneme {
	private int kullaniciId;
	 private String adi;
	 private String soyadi;
	 private Cinsiyet cinsiyet;
	 private String mail;
	 private String password;
	 private Sehir sehir;
	 private int yas; 

	 @Id
	 @GeneratedValue(strategy=GenerationType.TABLE)
	 @Column(name="kullanici_id",nullable=true,unique=true)
	public int getKullaniciId() {
		return kullaniciId;
	 }
	public void setKullaniciId(int kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	@Column(name="adi", length=100, nullable=true)
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	@Column(name="soyadi", length=100, nullable=true)
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	@Column(name = "cinsiyet",nullable=true)
	@Enumerated(EnumType.ORDINAL)
	public Cinsiyet getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(Cinsiyet cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	@Column(name="mail",nullable=true)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Column(name="password",nullable=true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "yas")
	public int getYas() {
		return yas;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sehirId")
	public Sehir getSehir() {
		return sehir;
	}
	public void setSehir(Sehir sehir) {
		this.sehir = sehir;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	 
}
