package com.proje.mbean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import com.proje.entity.Kullanici;
import com.proje.entity.Profil;
import com.proje.sevice.FotografService;
import com.proje.sevice.KullaniciService;

@ManagedBean(name="profilBean")
@ViewScoped
public class ProfilBean {
 private Profil profil;
 private Kullanici kullanici;
 private UploadedFile file;
 private FotografService fotoservis;
 @ManagedProperty(value="#{loginBean}")
 private LoginBean loginBean;
 
 @PostConstruct
 public void init()
 {
	 fotoservis=new FotografService();
	 KullaniciService kullaniciService=new KullaniciService();
	 System.out.println("foto  ye geldý");
	  Long id2=loginBean.getId();
	  kullanici=new Kullanici();
	  setKullanici(kullaniciService.getById(id2));
	  profil=new Profil();
	  profil.setKullaniciId(kullanici);
	 

 }


 


public void upload() {
     if(file != null) {
         FacesMessage message = new FacesMessage("Profil Fotoðrafý güncellendi.", file.getFileName() + " is uploaded.");
         FacesContext.getCurrentInstance().addMessage(null, message);
     
        	 profil.setProfilFoto(file.getFileName());
        	 fotoservis.save(profil);
         
        
     }
 }

// public UploadedFile getFile() {
//	return file;
//}
//public void setFile(UploadedFile file) {
//	this.file = file;
//}

public LoginBean getLoginBean() {
	return loginBean;
}


public void setLoginBean(LoginBean loginBean) {
	this.loginBean = loginBean;
}


public Kullanici getKullanici() {
	return kullanici;
}


public void setKullanici(Kullanici kullanici) {
	this.kullanici = kullanici;
}





public Profil getProfil() {
	return profil;
}





public void setProfil(Profil profil) {
	this.profil = profil;
}
 
}
