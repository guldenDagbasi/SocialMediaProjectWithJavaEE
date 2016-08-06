package com.proje.entity;

public enum Gunler {
	Pazartesi("Pazartesi"),
	Salý("Salý"),
	Çarþamba("Çarþamba"),
	Perþembe("Perþembe"),
	Cuma("Cuma"),
	Cumartesi("Cumartesi"),
	Pazar("Pazar");
private final String label;
private Gunler(String label) {
	this.label=label;
}
public String getLabel() {
	return this.label;
}
	
}
