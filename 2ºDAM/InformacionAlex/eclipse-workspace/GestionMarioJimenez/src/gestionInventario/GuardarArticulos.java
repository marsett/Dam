package gestionInventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class GuardarArticulos {
	Scanner entrada=new Scanner(System.in);
	ArrayArticulos lista=new ArrayArticulos();
	public void guardarArticulos() {
		System.out.println("Elegiste Guardar Articulos");
		System.out.println("Estas seguro de guardar?\n1-Si\n2-No");
		int respuesta=entrada.nextInt();
		if(respuesta==1) {
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
					for(int i=0;i<lista.getLista().size();i++) {
						sql="INSERT INTO articulos(codigoArticulo, descripcionarticulo, marcaArticulo, modeloArticulo, tipoArticulo, referenciaArticulo) "
								+ "values("+lista.getLista().get(i).getCodigoArticulo()+", '"+lista.getLista().get(i).getDescripcionArticulo()+"', '"
								+ lista.getLista().get(i).getMarcaArticulo()+"', '"+lista.getLista().get(i).getModeloArticulo()+"', '"
								+ lista.getLista().get(i).getTipoArticulo()+"', '"+lista.getLista().get(i).getReferenciaArticulo()
								+")";
						System.out.println(sql);
						statement.execute(sql);
					}
					
					/*sql="select id, nombre, edad from Persona";
					
					ResultSet rs=statement.executeQuery(sql);
					while(rs.next()) {
						int id=rs.getInt(1);
						String nombre=rs.getString(2);
						String edad=rs.getString(3);
						System.out.println(id+" "+nombre+" "+edad);
					}*/
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /*finally {
				try {
					//MUY IMPORTANTE cerrar la conexion (obligatorio)
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}else {
			System.out.println("Terminando Ejecucion");
		}
	}
}
