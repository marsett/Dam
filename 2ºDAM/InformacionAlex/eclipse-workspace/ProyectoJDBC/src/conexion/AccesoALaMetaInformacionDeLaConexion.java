package conexion;
import java.sql.*;

public class AccesoALaMetaInformacionDeLaConexion {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url, usuario, pwd;
		usuario="root";
		pwd="mysql";
		url="Jdbc:mysql:///test";
		try(
			Connection conexion=DriverManager.getConnection(url,usuario,pwd);
			){
				DatabaseMetaData dbmd=conexion.getMetaData();
				String nombreBd=dbmd.getDatabaseProductName();
				String versionDd=dbmd.getDatabaseProductVersion();
				System.out.println("Nombre: "+nombreBd+"\nVersion: "+versionDd);
				String catalogo=null;
				String esquema=null;
				String patronTabla="%";//"f%"
				String[] tipos=null;
				ResultSet rs=dbmd.getTables(catalogo, esquema, patronTabla, tipos);
				String formato="%1$25s %2$25s %3$25s %4$25s %5$25s %n";//%n salto de linea
				while(rs.next()){
					System.out.printf(formato,
					rs.getString(1),//catalogo
					rs.getString(2),//esquema
					rs.getString(3),//tabla
					rs.getString(4),//vista
					rs.getString(5));//descripcion tabla
				}
				String patronColumna="%";//"facturas"
				String formatoCol=null;
				ResultSet rsColumnas=dbmd.getColumns(catalogo, esquema, patronColumna, formatoCol);
				String formato2="%1$25s %2$25s %3$25s %n";
				while(rsColumnas.next()){
					System.out.printf(formato2,
					rsColumnas.getString(4),
					rsColumnas.getString(5),
					rsColumnas.getString(6));
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
