package ejemplos;
import java.io.*;
import java.util.*;

public class Fichero_Configuracion {
	public static void main(String[] args) {
		
		String miUsuario="mario";
		String miContrasena="1234";
		String elServidor="1982";
		String elPuerto="65536";
		
		Properties configuracion = new Properties();
		configuracion.setProperty("user", miUsuario);
		configuracion.setProperty("password", miContrasena);
		configuracion.setProperty("server", elServidor);
		configuracion.setProperty("port", elPuerto);
		
		/*miUsuario="xema";
		configuracion.setProperty("user", miUsuario);*/

		try {
		  configuracion.store(new FileOutputStream("configuracion.props"),"Fichero de configuración");
		} 
		catch (FileNotFoundException fnfe) { 
		  fnfe.printStackTrace(); 
		} 
		catch (IOException ioe) { 
		  ioe.printStackTrace();
		}
		
		try {
			  configuracion.load(new FileInputStream("configuracion.props"));
			  miUsuario = configuracion.getProperty("user");
			  miContrasena = configuracion.getProperty("password");
			  elServidor = configuracion.getProperty("server");
			  Object puerto= Integer.valueOf(configuracion.getProperty("port"));
			  System.out.println("El usuario es: "+miUsuario+"\nLa contrasena es: "+miContrasena
					  +"\nEl servidor es: "+elServidor+"\nEl puerto es: "+puerto);
		} 
		catch (FileNotFoundException fnfe) { 
			  fnfe.printStackTrace();
		} 
		catch (IOException ioe) { 
			  ioe.printStackTrace();
		}
		
	}
}
