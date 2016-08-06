package com.proje.entity;

public enum PaylasýlacakBolum 
{
	Oda("Oda"),
	Yatak("Yatak"),
	Koltuk("Koltuk");
	private final String label;
	private PaylasýlacakBolum(String label) {
		this.label=label;
	}
	public String getLabel() {
		return this.label;
	}
	
	

}
