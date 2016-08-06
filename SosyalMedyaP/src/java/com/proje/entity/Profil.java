package com.proje.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="profil")
public class Profil implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long profilId;
	private Kullanici kullaniciId;
	private String profilFoto;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id" )
	public Long getProfilId() {
		return profilId;
	}
	public void setProfilId(Long profilId) {
		this.profilId = profilId;
	}
	@JoinColumn(name="kullanici_id")
	@OneToOne
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

	
	
	
	

}

