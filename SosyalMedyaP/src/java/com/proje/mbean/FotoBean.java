package com.proje.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import com.proje.base.BaseService;
import com.proje.entity.Fotograf;
import com.proje.entity.Kullanici;
import com.proje.sevice.FotografService;
import com.proje.sevice.KullaniciService;

@ManagedBean(name="fotoBean")
@ViewScoped
public class FotoBean {
 private Fotograf fotograf;
 private Kullanici kullanici;
 private UploadedFile file;
 private List<Fotograf> fotoListe;
 private String url;
 FotografService fotoservice;
	@ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
 
 
 
 
 
 @PostConstruct
 public void init()
 {
	 KullaniciService kullaniciService=new KullaniciService();
	 System.out.println("foto  ye geldý");
	  Long id2=loginBean.getId();
	  kullanici=new Kullanici();
	  setKullanici(kullaniciService.getById(id2));
	  fotograf=new Fotograf();
	  fotograf.setKullaniciId(kullanici);
	  fotoservice=new FotografService();
	  fotolistele();
 }
 @SuppressWarnings("unchecked")
public void fotolistele()
 {
	 Long id2=loginBean.getId();
	 BaseService baseService=new BaseService();
	 System.out.println("fotolisteleye geldi");
	fotoListe= baseService.getAll(Fotograf.class);
	
	
 }

 public List<Fotograf> getFotoListe() {
	return fotoListe;
}


public void setFotoListe(List<Fotograf> fotoListe) {
	this.fotoListe = fotoListe;
}


public void upload() {
     if(file != null) {
         FacesMessage message = new FacesMessage("Profil Fotoðrafý güncellendi.", file.getFileName() + " is uploaded.");
         FacesContext.getCurrentInstance().addMessage(null, message);
         fotograf.setProfilFoto(file.getFileName());
         url=file.getFileName();
         fotoservice.save(fotograf);
     }
 }
 public void upload2() {
     if(file != null) {
         FacesMessage message = new FacesMessage(" ", file.getFileName() + " is uploaded.");
         FacesContext.getCurrentInstance().addMessage(null, message);
         fotograf.setEvFoto(file.getFileName());
         fotoservice.save(fotograf);
     }
 }

 
 
 public UploadedFile getFile() {
	return file;
}


public void setFile(UploadedFile file) {
	this.file = file;
}


public Fotograf getFotograf() {
	return fotograf;
}
 public void setFotograf(Fotograf fotograf) {
	this.fotograf = fotograf;
}


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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
 
}
