package com.proje.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ulkeler")
public class Ulkeler implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String ulkeAdi;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id" )
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUlkeAdi() {
		return ulkeAdi;
	}
	public void setUlkeAdi(String ulkeAdi) {
		this.ulkeAdi = ulkeAdi;
	}
	
	
	

	
	
}
