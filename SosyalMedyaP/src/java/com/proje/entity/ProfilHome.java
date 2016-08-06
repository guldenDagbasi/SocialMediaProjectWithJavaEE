package com.proje.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.proje.base.Cinsiyet;
@Entity
@Table(name="profil_home")
public class ProfilHome implements Serializable{
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 private Long id;
 private Kullanici kullanici;
 private int misafirSayisi;
 private String gunler;
 private String cinsiyetTercihi;
 private Boolean evcilHayvanIstegi;
 private Boolean sigaraAllow;
 private Boolean cocuk;
 private String paylasilacakBolum;
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name="id")
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@JoinColumn(name="kullaniciId")
@OneToOne
public Kullanici getKullanici() {
	return kullanici;
}
public void setKullanici(Kullanici kullanici) {
	this.kullanici = kullanici;
}
@Column(name="misafir_sayisi")
public int getMisafirSayisi() {
	return misafirSayisi;
}
public void setMisafirSayisi(int misafirSayisi) {
	this.misafirSayisi = misafirSayisi;
}
@Column(name="gunler")
public String getGunler() {
	return gunler;
}
public void setGunler(String gunler) {
	this.gunler = gunler;
}
@Column(name="cinsiyet_tercihi")
public String getCinsiyetTercihi() {
	return cinsiyetTercihi;
}
public void setCinsiyetTercihi(String cinsiyetTercihi) {
	this.cinsiyetTercihi = cinsiyetTercihi;
}
@Column(name="evcil_hayvan_istegi")
public Boolean getEvcilHayvanIstegi() {
	return evcilHayvanIstegi;
}
public void setEvcilHayvanIstegi(Boolean evcilHayvanIstegi) {
	this.evcilHayvanIstegi = evcilHayvanIstegi;
}
@Column(name="sigara")
public Boolean getSigaraAllow() {
	return sigaraAllow;
}
public void setSigaraAllow(Boolean sigaraAllow) {
	this.sigaraAllow = sigaraAllow;
}
@Column(name="cocuk_izni")
public Boolean getCocuk() {
	return cocuk;
}
public void setCocuk(Boolean cocuk) {
	this.cocuk = cocuk;
}
@Column(name="paylasilacak_bolum")
public String getPaylasilacakBolum() {
	return paylasilacakBolum;
}
public void setPaylasilacakBolum(String paylasilacakBolum) {
	this.paylasilacakBolum = paylasilacakBolum;
}

 
}
