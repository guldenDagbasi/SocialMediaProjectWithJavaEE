package com.proje.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="evgosterBean")
@RequestScoped
public class EvGoster {
	
	@ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
}
