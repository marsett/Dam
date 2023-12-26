package gestionInventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MostrarFichas {
	Scanner entrada=new Scanner(System.in);
	ListaFichas lista=new ListaFichas();
	public void mostrar() {
		System.out.println("Cual es el codigoArticulo del articulo a revisar el numero de fichas?");
		int codigo=entrada.nextInt();
		System.out.println("Consultando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url,usuario,password;
		url="jdbc:mysql:///bdgestion";	
		usuario="root";
		password="mysql";
		Connection conexion=null;
		Statement statement;
		String sql;
		try {
			conexion=DriverManager.getConnection(url,usuario,password);
			if(conexion!=null) {
				System.out.println("Conexion Establecida!");
				statement=conexion.createStatement();
			
				sql="SELECT * FROM fichasinventario WHERE codigoArticulo="+codigo;
				//System.out.println(sql);
				
				ResultSet rs=statement.executeQuery(sql);
				System.out.println("Las Fichas de este articulo son:");
				while(rs.next()) {
					int codigoArticulo=rs.getInt(1);
					String fechaFichaInventario=rs.getString(2);
					double precioFichaInventario=rs.getDouble(3);
					String ubicacionFichaInventario=rs.getString(4);
					System.out.println(codigoArticulo+" "+fechaFichaInventario+" "+precioFichaInventario+" "+ubicacionFichaInventario);
				}
				
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*for(int i=0;i<lista.getLista().size();i++) {
			if(codigo==lista.getLista().get(i).getCodigoArticulo()) {
				for(FichasInventario fi:lista.getLista()) {
					System.out.println(fi);
				}
			}
		}*/
	}
}
