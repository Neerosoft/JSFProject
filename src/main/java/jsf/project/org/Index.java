package jsf.project.org;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="index")
@SessionScoped
public class Index {
	private String saludo="Prueba JSF";

	public Index() {
		// TODO Auto-generated constructor stub
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	

}
