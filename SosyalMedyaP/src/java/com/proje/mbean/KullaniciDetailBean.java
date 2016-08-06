package com.proje.mbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.proje.base.Cinsiyet;
import com.proje.base.PHibernateUtil;
import com.proje.base.Sort;
import com.proje.entity.Kullanici;
import com.proje.entity.Sehir;
import com.proje.entity.Ulkeler;
import com.proje.sevice.KullaniciService;

@ManagedBean(name="detailBean")
@RequestScoped
public class KullaniciDetailBean implements Serializable
{
	  /**
	 * 
	 */
	  private static final long serialVersionUID = 1L;
	  private Kullanici selectedKullanici;
	

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
      private LazyDataModel<Kullanici> lazy;
      private List<Kullanici> kullaniciListesi;
      @ManagedProperty(value="#{loginBean}")
      private LoginBean loginBean;
      @ManagedProperty(value="#{fotoBean}")
      private FotoBean fotoBean;
      
      @PostConstruct
      public void init() {
          selectedKullanici=new Kullanici();
    	  System.out.println("detail  ye geldý");
    	  Long id2=loginBean.getId();
		  System.out.println(kullaniciId);
		  kullaniciService=new KullaniciService();
		  kullanici=new Kullanici();
		  setKullanici(kullaniciService.getById(id2));
		  kullaniciListesi=kullaniciService.getAll();
		  listele();
			
	}
       public FotoBean getFotoBean() {
		return fotoBean;
	}
	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}
	@SuppressWarnings("serial")
   	public void listele() {
   		
   		lazy=new LazyDataModel<Kullanici>() {
   			
   			@SuppressWarnings("incomplete-switch")
   			@Override
   			public List<Kullanici> load(int first, int pageSize,String sortField, SortOrder sortOrder,Map<String, Object> filters) {
   				Sort mySorting=Sort.ASC;
   				if(sortField!=null && !sortField.equals("")){
   					switch (sortOrder) {
   					case ASCENDING:
   						mySorting=Sort.ASC;
   						break;
   					case DESCENDING:
   						mySorting=Sort.DESC;
   						break;		
   					}
   				}
   				
   				KullaniciPage kullaniciPage = kullaniciService.getByPaging(first,pageSize,filters,sortField,mySorting);
   				lazy.setRowCount(kullaniciPage.kayitSayisi);
   				return kullaniciPage.liste;
   			}	
   			
   			
   			
   		};

   	}
      public void guncelle ()
      {
    	  try {
    		  String url=fotoBean.getUrl();
    		 this.kullanici.setProfilfoto(url);
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
      public void showSelectedKullanici()
      {
    	  FacesContext context = FacesContext.getCurrentInstance();
    	  try {
			context.getExternalContext().redirect("../giris/login.xhtml");
			System.out.println("show a geldi");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		}
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
	  public Kullanici getSelectedKullanici() {
			return selectedKullanici;
		}
		public void setSelectedKullanici(Kullanici selectedKullanici) {
			this.selectedKullanici = selectedKullanici;
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
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
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
