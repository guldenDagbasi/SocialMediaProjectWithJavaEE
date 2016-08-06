import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="mesajBean")
@ViewScoped
public class MesajBean {
 private String mesaj;
 public MesajBean() {
	// TODO Auto-generated constructor stub
}
 public String getMesaj() {
	return mesaj;
}
 public void setMesaj(String mesaj) {
	this.mesaj = mesaj;
}
 
}
