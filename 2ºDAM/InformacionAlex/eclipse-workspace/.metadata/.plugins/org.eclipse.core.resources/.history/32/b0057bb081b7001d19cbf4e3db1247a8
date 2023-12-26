package compilando;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class CompilandoInformes {
	final static String RUTA_DESTINO="";
	public static void main(String[] args) {
		String nombreFichero="basic";
		final String RUTA_PLANTILLA="C:\\Reportes\\Plantillas\\"+nombreFichero+".jrxml";
		final String RUTA_COMPILADO="C:\\Reportes\\Compilados\\"+nombreFichero+".jasper";
		JasperReport jasperReport;//compila
		JasperPrint jasperPrint;
		try {
			jasperReport=JasperCompileManager.compileReport(RUTA_PLANTILLA);
		}catch(Exception e) {
			System.out.println("Error Compilación\n"+e.getMessage());
		}
	}
}
