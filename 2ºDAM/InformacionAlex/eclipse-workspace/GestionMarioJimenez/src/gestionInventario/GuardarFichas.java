package gestionInventario;
import java.util.Scanner;
import java.sql.*;

public class GuardarFichas {
	Scanner entrada=new Scanner(System.in);
	ListaFichas lista=new ListaFichas();
	public void guardarFichas() {
		System.out.println("Elegiste Guardar Fichas");
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
						sql="INSERT INTO fichasinventario(codigoArticulo, fechaFichaInventario, precioFichaInventario, ubicacionFichaInventario, codigoFichaInventario) "
								+ "values("+lista.getLista().get(i).getCodigoArticulo()+", '"+lista.getLista().get(i).getFechaFichaInventario()+"', "
								+ lista.getLista().get(i).getPrecioFichaInventario()+", '"+lista.getLista().get(i).getUbicacionFichaInventario()+"', '"
								+ lista.getLista().get(i).getCodigoFichaInventario()+"'"
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
