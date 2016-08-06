package com.proje.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.proje.entity.Sehir;
import com.proje.sevice.SehirService;

@ManagedBean(name="sehirBean")
@ViewScoped
public class SehirBean {
    private List<Sehir> sehirliste;
    private String sehir;
    private SehirService sehirService;
    public SehirBean() {
    	sehirService=new SehirService();
    	sehirliste=sehirService.getAll();
	}
    //sehirlerin hepsi veritabanýndan cekilecek.
    //listeleyip verileri almak.
	public List<Sehir> getSehirliste() {
		return sehirliste;
	}
	public void setSehirliste(List<Sehir> sehirliste) {
		this.sehirliste = sehirliste;
	}
	public SehirService getSehirService() {
		return sehirService;
	}
	public void setSehirService(SehirService sehirService) {
		this.sehirService = sehirService;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
    
}
