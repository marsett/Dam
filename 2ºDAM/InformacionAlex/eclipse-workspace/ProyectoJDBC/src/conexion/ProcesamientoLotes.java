package conexion;
import java.sql.*;

public class ProcesamientoLotes {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url,usuario,password;
		url="jdbc:mysql:///test";
		usuario="root";
		password="mysql";
			try (
				Connection conexion=DriverManager.getConnection(url,usuario,password);
				Statement loteSentencias=conexion.createStatement();
				){
					String sql1="insert into perroscallejeros values ('Torete')";
					loteSentencias.addBatch(sql1);
					String sql2="insert into gatoscallejeros values ('Salomon')";
					loteSentencias.addBatch(sql2);
					String sql3="insert into pajaroscallejeros values ('Reinildo')";
					loteSentencias.addBatch(sql3);
					String sql4="insert into perroscallejeros values ('El Butano')";
					loteSentencias.addBatch(sql4);
					//loteSentencias.executeBatch();
					int[] modificados=loteSentencias.executeBatch();
					for(int i=0;i<modificados.length;i++) {
						System.out.println(modificados[i]);
					}
					//truncate table nombretabla;
					//drop table nombretabla
					//delete from (where)
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
