package conexion;

import java.sql.*;

public class MetaInformacionDeLaConsulta {
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
			var conexion=DriverManager.getConnection(url,usuario,pwd);
				var stmt=conexion.createStatement();
			){
				String sql="select nombre,id,color from perroscallejeros";
				System.out.println(sql);
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData rsmd=rs.getMetaData();
				int columnasConsulta=rsmd.getColumnCount();
				System.out.println(">>"+columnasConsulta);
				for(int i=1;i<=columnasConsulta;i++) {
					String nombreColumna=rsmd.getColumnName(i);
					String etiquetaColumna=rsmd.getColumnLabel(i);
					String tipoColumna=rsmd.getColumnTypeName(i);
					String clase=rsmd.getColumnClassName(i);
					int tam=rsmd.getColumnDisplaySize(i);
					System.out.print("Nombre: "+nombreColumna);
					System.out.print(" Etiqueta: "+etiquetaColumna);
					System.out.print(" Tipo: "+tipoColumna);
					System.out.print(" Clase: "+clase);
					System.out.println(" Tamano: "+tam);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
