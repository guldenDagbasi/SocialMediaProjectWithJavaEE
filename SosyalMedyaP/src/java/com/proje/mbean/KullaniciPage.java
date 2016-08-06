package com.proje.mbean;

import java.util.List;

import com.proje.entity.Kullanici;

public class KullaniciPage {
	public KullaniciPage(List<Kullanici> liste,int kayitSayisi) {
		this.kayitSayisi=kayitSayisi;
		this.liste=liste;
	}
	
	List<Kullanici> liste;
	int kayitSayisi;

	public List<Kullanici> getListe() {
		return liste;
	}

	public void setListe(List<Kullanici> liste) {
		this.liste = liste;
	}

	public int getKayitSayisi() {
		return kayitSayisi;
	}

	public void setKayitSayisi(int kayitSayisi) {
		this.kayitSayisi = kayitSayisi;
	}

}
