package com.proje.entity;

import java.io.Serializable;
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
@Table(name="kullanici")
public class Kullanici implements Serializable{

 private static final long serialVersionUID = 1L;
 private Long id;
 private String adi;
 private String soyadi;
 private String cinsiyet;
 private String mail;
 private String password;
 private Sehir sehir;
 private int yas; 
 private String evSahipligiIstegi;
 private String egitim;
 private String diller;
 private String bilgiMyself;
 private String ilgiAlanlari;
 private String ziyaretEdilenUlkeler;
 private String referans;
 private String profilfoto;
 private int misafirSayisi;
 private String gunler;
 private String cinsiyetTercihi;
 private Boolean evcilHayvanIstegi;
 private Boolean sigaraAllow;
 private Boolean cocuk;
 private String paylasilacakBolum;
 private Boolean cocukBulundurma;
 private Boolean evcilHayvanBulundurma;
 private Boolean sigaraIcme;
 private String eklemekIstedigim;
   
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id" )
public Long getKullaniciId() {
	return id;
 }
public void setKullaniciId(Long id) {
	this.id = id;
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
@Column(name = "cinsiyet")

public String getCinsiyet() {
	return cinsiyet;
}
public void setCinsiyet(String cinsiyet) {
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
@Column(name = "yas",nullable=true)
public int getYas() {
	return yas;
}
@JoinColumn(name="sehir_id")
@OneToOne(optional=true)
public Sehir getSehir() {
	return sehir;
}
public void setSehir(Sehir sehir) {
	this.sehir = sehir;
}
public void setYas(int yas) {
	this.yas = yas;
}
@Column(name="ev_sahipligi_istegi",nullable=true)
public String getEvSahipligiIstegi() {
	return evSahipligiIstegi;
}
public void setEvSahipligiIstegi(String evSahipligiIstegi) {
	this.evSahipligiIstegi = evSahipligiIstegi;
}
@Column(name="egitim")
public String getEgitim() {
	return egitim;
}
public void setEgitim(String egitim) {
	this.egitim = egitim;
}
@Column(name="diller")
public String getDiller() {
	return diller;
}
public void setDiller(String diller) {
	this.diller = diller;
}
@Column(name="bilgi_myself")
public String getBilgiMyself() {
	return bilgiMyself;
}
public void setBilgiMyself(String bilgiMyself) {
	this.bilgiMyself = bilgiMyself;
}
@Column(name="ilgi_alanlari")
public String getIlgiAlanlari() {
	return ilgiAlanlari;
}
public void setIlgiAlanlari(String ilgiAlanlari) {
	this.ilgiAlanlari = ilgiAlanlari;
}
@Column(name="ziyaret_edilen_ulkeler")
public String getZiyaretEdilenUlkeler() {
	return ziyaretEdilenUlkeler;
}
public void setZiyaretEdilenUlkeler(String ziyaretEdilenUlkeler) {
	this.ziyaretEdilenUlkeler = ziyaretEdilenUlkeler;
}
@Column(name="referanslar")
public String getReferans() {
	return referans;
}
public void setReferans(String referans) {
	this.referans = referans;
}

@Column(name="profilfoto")
public String getProfilfoto() {
	return profilfoto;
}
public void setProfilfoto(String profilfoto) {
	this.profilfoto = profilfoto;
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

@Column(name="cocuk_bulundurma")
public Boolean getCocukBulundurma() {
	return cocukBulundurma;
}
public void setCocukBulundurma(Boolean cocukBulundurma) {
	this.cocukBulundurma = cocukBulundurma;
}
@Column(name="evcilHayvan_bulundurma")
public Boolean getEvcilHayvanBulundurma() {
	return evcilHayvanBulundurma;
}
public void setEvcilHayvanBulundurma(Boolean evcilHayvanBulundurma) {
	this.evcilHayvanBulundurma = evcilHayvanBulundurma;
}
@Column(name="sigara_içme")
public Boolean getSigaraIcme() {
	return sigaraIcme;
}
public void setSigaraIcme(Boolean sigaraIcme) {
	this.sigaraIcme = sigaraIcme;
}
@Column(name="eklemekistedigim")
public String getEklemekIstedigim() {
	return eklemekIstedigim;
}
public void setEklemekIstedigim(String eklemekIstedigim) {
	this.eklemekIstedigim = eklemekIstedigim;
}








}
