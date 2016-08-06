package com.proje.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sehir")
public class Sehir implements Serializable {
 
 
  private static final long serialVersionUID = 1L;
  private Long id;
  private String sehirAdi;
  private Ulkeler ulke;
  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id" )
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
@Column(name="sehir_adi")
public String getSehirAdi() {
	return sehirAdi;
}
public void setSehirAdi(String sehirAdi) {
	this.sehirAdi = sehirAdi;
}
@JoinColumn(name="ulke_id")
@ManyToOne(optional=false)
public Ulkeler getUlke() {
	return ulke;
}
public void setUlke(Ulkeler ulke) {
	this.ulke = ulke;
}

  
  
}
