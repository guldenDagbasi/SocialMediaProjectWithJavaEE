package com.proje.mbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.proje.base.BaseService;
import com.proje.base.Cinsiyet;
import com.proje.entity.Kullanici;
import com.proje.entity.Sehir;
import com.proje.entity.Ulkeler;
import com.proje.sevice.KullaniciService;
import com.proje.sevice.UlkeServis;

@ManagedBean(name="kullaniciBean")
@RequestScoped
public class KullaniciBean implements Serializable{
	/**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private Kullanici kullanici;
      private KullaniciService kullaniciService;
      private Ulkeler ulke1; 
      private Sehir sehir1;
      private String sehir;
      private List<Sehir> sehirliste;
      private String mail;
      private String pwd;
      private Long kullaniciId;
      private String adi;
      private String soyadi;
      private String cinsiyet;
      private int yas; 
      private List<Kullanici> kullaniciListe;
      @PostConstruct
	 public void init()
	 {  
    	  kullanici=new Kullanici();
    	  ulke1= new UlkeServis().getById();
    	 kullaniciService=new KullaniciService();
    	 sehir1=new Sehir();
    	 sehirliste=sehirlistele();
	 }
      public void kaydet() throws IOException {
  		
    	  try {
    			this.sehir1.setUlke(ulke1);
    			this.kullanici.setSehir(sehir1);
    			kullaniciService.save(kullanici);
    			this.adi=kullanici.getAdi();
    		     System.out.println(kullanici.getAdi());
    		     
    		     
    		     
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		 FacesContext context = FacesContext.getCurrentInstance();
           context.getExternalContext().redirect("../giris/login.xhtml");
       	System.out.println("Basarýlýkullanýcýkaydedildi");
       	
     	
     	
  	}
     
      @SuppressWarnings("unchecked")
	public List<Sehir> sehirlistele (){
    	  BaseService baseService=new BaseService();
		return baseService.getAll(Sehir.class);
      }
    
	public Kullanici getKullanici() {
		
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	public List<Sehir> getSehirliste() {
		return sehirliste;
	}
	public void setSehirliste(List<Sehir> sehirliste) {
		this.sehirliste = sehirliste;
	}
	public Ulkeler getUlke1() {
		return ulke1;
	}
	public void setUlke1(Ulkeler ulke1) {
		this.ulke1 = ulke1;
	}
	public Sehir getSehir1() {
		return sehir1;
	}
	public void setSehir1(Sehir sehir1) {
		this.sehir1 = sehir1;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Long getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(Long kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	public String getAdi() {
		return adi;
	}
	
	public String getSoyadi() {
		return soyadi;
	}
	
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public int getYas() {
		return yas;
	}
	public void setYas(int yas) {
		this.yas = yas;
	}
	public List<Kullanici> getKullaniciListe() {
		return kullaniciListe;
	}
	public void setKullaniciListe(List<Kullanici> kullaniciListe) {
		this.kullaniciListe = kullaniciListe;
	}
	
	 
}
