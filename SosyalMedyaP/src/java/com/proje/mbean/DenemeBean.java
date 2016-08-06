package com.proje.mbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.proje.entity.Kullanici;
import com.proje.entity.Sehir;
import com.proje.entity.Ulkeler;
import com.proje.sevice.KullaniciService;
@ManagedBean(name="denemeBean")
@ViewScoped
public class DenemeBean {

	      private Kullanici kullanici;
	      private KullaniciService kullaniciService;
	      private Ulkeler ulke1; 
	      private Sehir sehir1;
	      @PostConstruct
		 public void init()
		 {
	    	 kullaniciService=new KullaniciService();
	    	 kullanici=new  Kullanici();
		 }
	      public void kaydet() {
	  		try {
	  			this.sehir1.setUlke(ulke1);
	  			this.kullanici.setSehir(sehir1);
	  			kullaniciService.save(kullanici);
	  			
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		
	  		 FacesContext context = FacesContext.getCurrentInstance();
	           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Kayit",  "Kullanici Kaydedildi") );
	  	}
	      public void sil(Long id) {
	  		try {
	  			kullaniciService.deleteById(id);
	  			
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  		FacesContext context = FacesContext.getCurrentInstance();
	          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Kayit",  "Kullanici Silindi") );
	  	}
	    
		public Kullanici getKullanici() {
			return kullanici;
		}
		public void setKullanici(Kullanici kullanici) {
			this.kullanici = kullanici;
		}
		public KullaniciService getKullaniciService() {
			return kullaniciService;
		}
		public void setKullaniciService(KullaniciService kullaniciService) {
			this.kullaniciService = kullaniciService;
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
		
		 
}
