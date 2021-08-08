package jsf.project.org;

import java.sql.Connection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import jsf.project.dblink.MSSQLConnection;

@SessionScoped
@ManagedBean(name="index")
public class Index {
	private MSSQLConnection mysql;
	public Connection con;
	private String saludo="Prueba JSF";

	public Index() {
		this.mysql=new MSSQLConnection();
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
	public void buttonActionNoXML(ActionEvent actionEvent) {
		 this.con=this.mysql.getConnection();
		 this.mysql.close(con);
		
		 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"No XMl",  null);
	     FacesContext.getCurrentInstance().addMessage(null, message);
   
    }
	

}
