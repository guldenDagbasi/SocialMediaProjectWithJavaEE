package com.proje.mbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.proje.base.BaseService;
import com.proje.base.Cinsiyet;
import com.proje.base.PHibernateUtil;
import com.proje.entity.Kullanici;
import com.proje.sevice.KullaniciService;
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;

   KullaniciService kullaniciService;
   
   private String mail;
   private String pwd;
   private Long id;
 	 HttpSession session;
	
	@PostConstruct
	private void init() {
		kullaniciService=new KullaniciService();
	}

	public void girisYap() {
		System.out.println("1");
		if(mail == null || mail.equals("")){
			return;
		} 
		if(pwd == null || pwd.equals("")){
			return;
		}
		
		Kullanici girisKullanici = kullaniciService.getByMail(mail);
		if(girisKullanici!=null && girisKullanici.getPassword().equals(pwd)){
			//Session UserId Ekle
			
			FacesContext context = FacesContext.getCurrentInstance();
	        session = (HttpSession) context.getExternalContext().getSession(true);
	        session.setAttribute("kullanici_id", girisKullanici.getKullaniciId());
	        session.setAttribute("mail", girisKullanici.getMail());
	        session.setAttribute("id", girisKullanici.getKullaniciId());
	        Long id1=(Long) session.getAttribute("id");
	        String m=(String) session.getAttribute("mail");
	        System.out.println(m);
	        System.out.println("kullanýcý id:" + id1);
	        System.out.println("calsý");
	        try {
				context.getExternalContext().redirect("../secure/anaSayfa.xhtml");
	        	System.out.println("Basarýlýoturum");
	        	System.out.println("kullanýcý mail" + girisKullanici.getMail());
	        
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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

	public Long getId() {
		return (Long) session.getAttribute("id");
	}


	   public void setId(Long id) {
			this.id = id;
		}


	


	
	
	
}
