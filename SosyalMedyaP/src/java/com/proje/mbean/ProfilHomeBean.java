package com.proje.mbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.LazyDataModel;
import com.proje.base.PHibernateUtil;
import com.proje.entity.Kullanici;
import com.proje.entity.Sehir;
import com.proje.entity.Ulkeler;
import com.proje.sevice.KullaniciService;

@ManagedBean(name="profilHomeBean")
@RequestScoped
public class ProfilHomeBean implements Serializable
{
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
      private Long kullaniciId;
      private LazyDataModel<Kullanici> lazy;
      private List<Kullanici> kullaniciListesi;
      @ManagedProperty(value="#{loginBean}")
      private LoginBean loginBean;
     
       @PostConstruct
      public void init() {

    	  System.out.println("detail  ye geldý");
    	  Long id2=loginBean.getId();
		  System.out.println(kullaniciId);
		  kullaniciService=new KullaniciService();
		  kullanici=new Kullanici();
		  setKullanici(kullaniciService.getById(id2));
		  kullaniciListesi=kullaniciService.getAll();
		  
			
	}
    
   				
   		
      public void guncelle ()
      {
    	  try {
    		 
    		Kullanici guncellenecekKullanici= this.kullanici;
    		System.out.println(this.kullanici.getBilgiMyself());
    		System.out.println("guncellenecek kullanýcý adi:"+guncellenecekKullanici.getKullaniciId());
    		System.out.println("GUN1" + guncellenecekKullanici.getAdi() + "1knew");
    		  Session session1 = PHibernateUtil.getcreateSessionFactory().openSession();
    		    Transaction transaction =  session1.beginTransaction();
    		    session1.update(guncellenecekKullanici);
    		    transaction.commit();
    		    System.out.println(guncellenecekKullanici.getEvSahipligiIstegi().toString());
    		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
      }
      public void sil()
      {
    	  Kullanici silinecekKullanici= this.kullanici;
  		System.out.println("guncellenecek kullanýcý adi:"+silinecekKullanici.getKullaniciId());
  		System.out.println("GUN1" + silinecekKullanici.getAdi() + "1knew");
  		  Session session1 = PHibernateUtil.getcreateSessionFactory().openSession();
  		    Transaction transaction =  session1.beginTransaction();
  		    session1.delete(silinecekKullanici);
  		    System.out.println("silindi");
  		    transaction.commit();
  		  FacesContext context = FacesContext.getCurrentInstance();
  		  try {
			context.getExternalContext().redirect("../giris/login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Kayýt",  "Kullanýcý Silindi") );
  		   
      }
      public LazyDataModel<Kullanici> getLazy() {
  		return lazy;
  	}
	public Kullanici getKullanici() {
		return kullanici;
	}
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
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
	public List<Sehir> getSehirliste() {
		return sehirliste;
	}
	public void setSehirliste(List<Sehir> sehirliste) {
		this.sehirliste = sehirliste;
	}
	public Long getKullaniciId() {
		return kullaniciId;
	}
	public void setKullaniciId(Long kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Kullanici> getKullaniciListesi() {
		return kullaniciListesi;
	}

	public void setKullaniciListesi(List<Kullanici> kullaniciListesi) {
		this.kullaniciListesi = kullaniciListesi;
	}

 
      
      
}
