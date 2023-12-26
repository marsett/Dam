package conexion;

import java.sql.*;

import perros.PerrosCallejeros;

public class UsandoSentenciasPreparadas {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
			String url, usuario, pwd;
			usuario="root";
			pwd="mysql";
			url="Jdbc:mysql:///test";	//con 3 barras das por hecho que es localhost y el puerto estandar de mysql 3306
										// 3º / --> localhost:3306; localhost --> 192.168.1.1  
			PerrosCallejeros perro=new PerrosCallejeros(4,"Rufino","morado");
			String sql="insert into perroscallejeros(id, nombre, color) values(0,"+",'"+perro.getId()+"'"+
																				",'"+perro.getNombre()+"'"
																				+",'"+perro.getColor()+")";
			try(Connection conexion=DriverManager.getConnection(url,usuario,pwd);
				PreparedStatement pstm=conexion.prepareStatement(sql);){
			}
			catch(SQLException e) {
				System.out.println("error en la consulta");
			}
	}
}
//.trim() espacios en blanco
