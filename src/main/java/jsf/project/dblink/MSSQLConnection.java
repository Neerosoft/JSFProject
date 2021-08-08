package jsf.project.dblink;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class MSSQLConnection{
	
	  private Connection con = null;
	  private String driver = "";
	  private String puente = "";
	  private String u = "";
	  private String p = "";
	  private String hostname = "";
	  private String db = "";
	  private String port;
	  private String ssl="";
	  private Properties propiedad = null;
	  
	  public void ConexionBD()
	  {
	    LoadDataConfig();
	  }
	  public  void close(Connection con) {
		  try {
				con.close();
	                        System.out.println("__conexión finalizada..:\n\n");
			} 
			catch (Exception ex) {
				System.out.println("__conexión finalizada..:\n\n");
			}
		}
	  
	  public Connection getConnection() {
		    LoadDataConfig();
		    try{
		    System.out.println("__Estableciendo Conexion..:");
		     Class.forName(this.driver).newInstance();
		     this.puente=puente+this.hostname+":"+port+"/"+this.db+this.ssl;
		     System.out.println(puente);
		     this.con = DriverManager.getConnection(this.puente, this.u, this.p);
		     System.out.println("__Conexion establecida..:\n\n");
		     
		     return con;
		    }
		    catch(Exception e){
		    	System.out.print("problema "+e);
		    	return con;
		    }
		    }
	  
	  public void LoadDataConfig()
	  {
	    this.hostname = getpropiedad().getProperty("server");
	    this.db = getpropiedad().getProperty("db");
	    this.u = getpropiedad().getProperty("usuario");
	    this.p = getpropiedad().getProperty("pws");
	    this.driver = getpropiedad().getProperty("driver");
	    this.puente = getpropiedad().getProperty("puente");
	    this.port=getpropiedad().getProperty("port");
	    this.ssl=getpropiedad().getProperty("ssl");
	    
	  }
	
	  private Properties getpropiedad()
	  {
	    if (this.propiedad == null) {
	      this.propiedad = new Properties();
	      try
	      {
	        this.propiedad.load(getClass().getResourceAsStream("/jsf/project/dblink/credenciales.properties"));
	      }
	      catch (Exception e)
	      {
	        System.out.println("Error al leer  las propiedades del archivo init  " + e);
	        e.printStackTrace();
	      }

	      if (!this.propiedad.isEmpty()) return this.propiedad;
	      return null;
	    }

	    return this.propiedad;
	  }
	  public String getdriver()
	  {
	    return this.driver;
	  }
	  public String getpuente() {
	    return this.puente;
	  }
	  public String getusuario() {
	    return this.u;
	  }
	  public String getpassword() {
	    return this.p;
	  }
	  public String getport(){
		  return this.port;
	  }
	public String getSsl() {
		return ssl;
	}
	public void setSsl(String ssl) {
		this.ssl = ssl;
	}
	  

}
