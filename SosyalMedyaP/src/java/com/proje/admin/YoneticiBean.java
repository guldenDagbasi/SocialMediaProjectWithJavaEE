package com.proje.admin;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="yoneticiBean")
@ViewScoped
public class YoneticiBean {
	private Yonetici yonetici;
   public void kaydet()
   {
	   
   }
   public void sil()
   {
	   
   }
   public void guncelle()
   {
	   
   }
public Yonetici getYonetici() {
	return yonetici;
}
public void setYonetici(Yonetici yonetici) {
	this.yonetici = yonetici;
}
   
}
