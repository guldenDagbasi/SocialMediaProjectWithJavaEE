package com.proje.mbean;

import javax.faces.bean.ManagedBean;

import com.proje.entity.Kullanici;

@ManagedBean(name="kisiBean")
public class KisiBean {
   private Kullanici kullanici;

public Kullanici getKullanici() {
	return kullanici;
}

public void setKullanici(Kullanici kullanici) {
	this.kullanici = kullanici;
}
   
}
