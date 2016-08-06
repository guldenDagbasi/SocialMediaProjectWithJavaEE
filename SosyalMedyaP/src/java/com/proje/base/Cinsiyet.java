package com.proje.base;

public enum Cinsiyet {
   ERKEK("ERKEK"),
   KADIN("KADIN");
	private final String label;
	private Cinsiyet(String label) {
		this.label=label;
	}
	public String getLabel() {
		return this.label;
	}
   
}
