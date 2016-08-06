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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.proje.base.Cinsiyet;

@Entity
@Table(name="fotograf")
public class Fotograf implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long fotoId;
	private Kullanici kullaniciId;
	private String profilFoto;
	private String evFoto;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id" )
	public Long getFotoId() {
		return fotoId;
	}
	public void setFotoId(Long fotoId) {
		this.fotoId = fotoId;
	}
	@JoinColumn(name="kullanici_id")
	@ManyToOne()
	public Kullanici getKullaniciId() {
		return kullaniciId;
	}
	
	public void setKullaniciId(Kullanici kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	@Column(name="profilfoto")
	public String getProfilFoto() {
		return profilFoto;
	}
	public void setProfilFoto(String profilFoto) {
		this.profilFoto = profilFoto;
	}
	@Column(name="evfoto")
	public String getEvFoto() {
		return evFoto;
	}
	public void setEvFoto(String evFoto) {
		this.evFoto = evFoto;
	}
	
	
	
	

}
