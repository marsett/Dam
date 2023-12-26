package conexion;

import java.sql.*;
//import java.util.*;

public class MiPrimeraConexionJDBC {
	public static void main(String[] args) {
		//registrar el driver (ojo versiones nuevas de api jdbc no es necesario)
		try {
			Class.forName("com.mysql.jdbc.Driver");//busca en el classpath una clase correspondiente al driver con el que se va a trabajar
			//Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ArrayList <String>i=new ArrayList<>();//<>tipar el array
		Enumeration <Driver> en=DriverManager.getDrivers();//para ver los drivers que hay
		while(en.hasMoreElements()) {
			Driver tmp=en.nextElement();
			System.out.println(tmp);
		}*/
		String url,usuario,password;
		url="jdbc:mysql:///test";	//solo se pueden poner 3 barras si estan los valores por defecto (la tercera barra igual a --> localhost:3306)
		usuario="root";
		password="mysql";
		//crear conexion con base de datos
		Connection conexion=null;
		Statement statement;
		try {
			conexion=DriverManager.getConnection(url,usuario,password);
			if(conexion!=null) {
				System.out.println("Conexion Establecida!");
				//crear el objeto statement
				statement=conexion.createStatement();
				String sql="insert into Persona(id, nombre, edad) values(50, 'Pepe', 69)";
				sql="update Persona set nombre='Vicenta' where id>1";
				System.out.println(sql);
				sql="select id, nombre, edad from Persona";
				ResultSet rs=statement.executeQuery(sql);
				//en el resultset se guardan las filas que cumplan lo que dice la query
				while(rs.next()) {
					int id=rs.getInt(1);//rs.getInt("id")
					String nombre=rs.getString(2);	//mejor ponerlo con nombre porque si hay fallo es de sintaxis, no de logica
					String color=rs.getString(3);
					System.out.println(id+" "+nombre+" "+color);
				}
				//ejecutar la sentencia
				//boolean seEjecuto=statement.execute(sql);
				//statement.execute(sql);//es una funcion que hacemos que se comporte como un procedimiento
				//int filasAfectadas=statement.executeUpdate(sql);
				//System.out.println("Se ejecuto? "+seEjecuto);
				//System.out.println(filasAfectadas);
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//MUY IMPORTANTE cerrar la conexion (obligatorio)
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//opcion tratar los resultados
		//cerrar recursos abiertos (opcional) --> esto mejora el rendimiento de la aplicacion
	}
}
