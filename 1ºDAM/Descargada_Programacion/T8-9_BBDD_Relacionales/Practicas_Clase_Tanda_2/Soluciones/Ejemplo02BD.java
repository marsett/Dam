package ejemplo02;

import java.sql.*;
import javax.sql.*;

public class Ejemplo01BD {
	
static class Profesor {
	public int idprofesor;
	public String nombre;
	public String apellido;
	public int tutor;
		 
	Profesor(int id, String n, String a, int t) {
			 idprofesor = id;
			 nombre = n;
			 apellido = a;
			 tutor = t;
		 }
 }
 
 public static void main (String[] args) {  
  int result;
  int esTutor;
  Profesor listaProfesores[] = new Profesor[5];
	
  Profesor prof1 = new Profesor(1, "Manolo", "Perez", 1);
  listaProfesores[0] = prof1;
  Profesor prof2 = new Profesor(2, "Ana", "Sanz", 0);
  listaProfesores[1] = prof2;
  Profesor prof3 = new Profesor(3, "Sara", "Alvarez", 1);
  listaProfesores[2] = prof3;
  Profesor prof4 = new Profesor(4, "Pedro", "García", 0);
  listaProfesores[3] = prof4;
  Profesor prof5 = new Profesor(5, "Luis", "González", 1);
  listaProfesores[4] = prof5;
	
  try {
	//Creamos un ÚNICO objeto de tipo Connection para poder crear 
	//la conexión con el servidor
	Connection miConexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/COLEGIO","root","Solaris");
	
	//Creamos un objeto Statement que recogerá esa conexión 
	//y nos permitirá ejecutar TODAS las sentencias SQL
	Statement objetoStatement = miConexion.createStatement();
	
	try {
	 //Borramos la tabla PROFESORES para luego volver a crearla
	 String sentenciaDrop = "DROP TABLE PROFESORES ";	
	 System.out.println("Sentencia Drop: " + sentenciaDrop);
	 result = objetoStatement.executeUpdate(sentenciaDrop);
	 System.out.println("Resultado de borrar tabla: " + result);	 
	} catch (SQLException sqle) {
		//Si la tabla no existía saltará una excepción SQL
		System.out.println("Error SQL: " + sqle.getMessage() + " " 
				+ sqle.getSQLState() + " " + sqle.getErrorCode());
		if (sqle.getErrorCode() == 1051) {
			System.out.println("LA TABLA NO EXISTE.");
		}
	}
	// Creamos la tabla PROFESORES
	String sentenciaCreate = "CREATE TABLE PROFESORES "
	+ "( IDPROFESOR INT, NOMBRE VARCHAR(20), "
	+ "APELLIDO VARCHAR(20), TUTOR VARCHAR(1))";
	System.out.println("Sentencia Create Table: " + sentenciaCreate);
	result = objetoStatement.executeUpdate(sentenciaCreate);
	System.out.println("Resultado de crear tabla: " + result);	 
	
	//Para ejecutar sentencias Insert
	String inicioInsert = "INSERT INTO PROFESORES (IDPROFESOR, NOMBRE, APELLIDO, TUTOR) VALUES";
	String sentenciaInsert = "";
	for (int i=0; i < 5; i++) {
		sentenciaInsert = inicioInsert + "(" + listaProfesores[i].idprofesor + ", '"
			+ listaProfesores[i].nombre + "', '" + listaProfesores[i].apellido 
			+ "', " + listaProfesores[i].tutor + ")";
		System.out.println("Sentencia a ejecutar: " + sentenciaInsert);
		//Para ejecutar el Insert
		result = objetoStatement.executeUpdate(sentenciaInsert);
		System.out.println("Resultado de insertar: " + result);	
	}
	
	//Para ejecutar el Update
	String sentenciaUpdate = "UPDATE PROFESORES SET TUTOR=1 WHERE IDPROFESOR = 3";	
	result = objetoStatement.executeUpdate(sentenciaUpdate);
	System.out.println("Resultado de modificar: " + result);	

	//Para ejecutar el Delete
	String sentenciaDelete = "DELETE FROM PROFESORES WHERE IDPROFESOR = 6";
	result = objetoStatement.executeUpdate(sentenciaDelete);
	System.out.println("Resultado de borrar: " + result);	
	
	//Para ejecutar diferentes consultas podemos usar el mismo ResultSet
	ResultSet resultadoSet;
	
	String sentenciaConsulta1 = "SELECT * FROM PROFESORES";
	resultadoSet = objetoStatement.executeQuery(sentenciaConsulta1);
	//Recorremos nuestro ResultSet para recuperar todo lo devuelto por nuestra sentencia
	while (resultadoSet.next()) {
	  System.out.print(resultadoSet.getString("IDPROFESOR") + " "
		 + resultadoSet.getString("NOMBRE") + " "
		 + resultadoSet.getString("APELLIDO") + " ");
	  esTutor = resultadoSet.getInt("TUTOR");
	   if (esTutor == 0)
		 System.out.println("No es tutor.");
	  else if (esTutor == 1) 
		 System.out.println("Sí es tutor.");
	  else
	     System.out.println("No sabemos si es tutor.");
	}		 	  
		// liberar el ResultSet si lo hemos usado
	if (resultadoSet != null) resultadoSet.close();
	
	String sentenciaConsulta2 = "SELECT * FROM PROFESORES WHERE TUTOR = 1";
	resultadoSet = objetoStatement.executeQuery(sentenciaConsulta2);
	System.out.println("PROFESORES QUE SON TUTORES:");
	while (resultadoSet.next()) {
	 System.out.println(resultadoSet.getString(1) + " "
			 + resultadoSet.getString(2) + " "
			 + resultadoSet.getString(3) + " "
			 + resultadoSet.getString(4));	
	}		 	  	
	// liberar el ResultSet si lo hemos usado
	if (resultadoSet != null) resultadoSet.close();
		

	// liberar los Statement
	if (objetoStatement != null) objetoStatement.close();
	// liberar la conexión a la BD
	if (miConexion != null) miConexion.close();
	
  } catch (SQLException sqle) {
	//Si ha habido algún problema de SQL
	System.out.println("Error SQL: " + sqle.getMessage() + " " 
			+ sqle.getSQLState() + " " + sqle.getErrorCode());
  } catch (Exception e) {
	//Si ha fallado cualquier otra cosa dentro de nuestro Try
	System.out.println("Error general: " + e);
  } 
 }
}

