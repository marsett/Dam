package ejemplo01;

import java.sql.*;
import java.util.Scanner;

import javax.sql.*;

public class Ejemplo01BD {
 	
 public static void main (String[] args) {
  Connection miConexion;
  Scanner sc = new Scanner(System.in);
  int idal, edad;
  String nombre, apellido, curso;
  
  try {
	miConexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/COLEGIO","root","Solaris");
    ListarTabla(miConexion);
    System.out.println("Introduce el ID de un alumno: ");
    idal = sc.nextInt();
    sc.nextLine();
    ListarUnAlumno(miConexion, idal);
	System.out.println("Introduce el NOMBRE de un alumno para eliminar: ");
	nombre = sc.nextLine();
	BorrarUnAlumno(miConexion, nombre);
	ListarTabla(miConexion);
	System.out.println("Introduce los datos de un alumno para insertar: ");
	System.out.println("IDALUMNO: ");
	idal = sc.nextInt();
    sc.nextLine();
    System.out.println("NOMBRE: ");
    nombre = sc.nextLine();
    System.out.println("APELLIDO: ");
    apellido = sc.nextLine();
    System.out.println("EDAD: ");
    edad = sc.nextInt();
    sc.nextLine();
    System.out.println("CURSO: ");
    curso = sc.nextLine();
    InsertarUnAlumno(miConexion, idal, nombre, apellido, edad, curso);
	ListarTabla(miConexion);
	
   } catch (SQLException e) {			
    System.out.println("Error en main");
    printSQLException(e);
  } 
 }	
 
 public static void ListarTabla(Connection con) throws SQLException {
   Statement miStatement = null;	 
   try {
	 miStatement = con.createStatement();
     ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM ALUMNOS");	
	 while(miResultSet.next()) {
		  System.out.println(miResultSet.getInt("IDALUMNO") + " " 
			+ miResultSet.getString("NOMBRE") + "-" 
			+ miResultSet.getString("APELLIDO") + "-"
			+ miResultSet.getInt("EDAD") + "-" 
			+ miResultSet.getString("CURSO"));
			}
	  }
	  catch (SQLException e) {
		 System.out.println("No lista tabla");
		 printSQLException(e);	
	  } finally {
		  miStatement.close();
	  }
	  
 }
 
 public static void ListarUnAlumno(Connection con, int id) throws SQLException {
	 Statement miStatement = null; 
	 try {
		miStatement = con.createStatement();
		ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM ALUMNOS " 
			+"WHERE IDALUMNO = "+ String.valueOf(id));
		while(miResultSet.next()) {
		  System.out.println(miResultSet.getInt("IDALUMNO") + " " 
			+ miResultSet.getString("NOMBRE") + "-" 
			+ miResultSet.getString("APELLIDO") + "-"
			+ miResultSet.getInt("EDAD") + "-" 
			+ miResultSet.getString("CURSO"));
		}
	  }
	  catch (SQLException e) {
		 System.out.println("No muestra un alumno");
		 printSQLException(e);	
	  } finally {
		  miStatement.close();
	  }	  
}
 
 public static void BorrarUnAlumno(Connection con, String nom) throws SQLException  {
	 Statement miStatement = null; 
	 try {
		miStatement = con.createStatement();	  
		int resul = miStatement.executeUpdate("DELETE FROM ALUMNOS " 
				    +"WHERE NOMBRE = '" + nom + "'");
		System.out.println("Número de alumnos eliminados: " + resul);
		}
	  catch (SQLException e) {
		 System.out.println("No elimina un alumno");
		 printSQLException(e);	
	  } finally {
		  miStatement.close();
	  }	  
}

 public static void InsertarUnAlumno(Connection con, int id, String nom, String ape, int ed, String cur) throws SQLException  {
	 Statement miStatement = null; 
	 try {
		miStatement = con.createStatement();	  
		int resul = miStatement.executeUpdate("INSERT INTO ALUMNOS (IDALUMNO, NOMBRE, APELLIDO, EDAD, CURSO) VALUES (" 
		 + String.valueOf(id) + ", '" + nom + "', '" + ape + "', " + String.valueOf(ed) 
		 + ", '" + cur + "')");
		System.out.println("Número de alumnos insertados: " + resul);
		}
	  catch (SQLException e) {
		 System.out.println("No inserta un alumno");
		 printSQLException(e);	
	  } finally {
		  miStatement.close();
	  }	  
}
 
 private static void printSQLException(SQLException ex) {
	//ex.printStackTrace(System.err);
	System.err.println("SQLState :" + ex.getSQLState());
	System.err.println("Error Code :" + ex.getErrorCode());
    System.err.println("Message :" + ex.getMessage());
	Throwable t = ex.getCause();
	while (t != null) {
	  System.err.println("Cause :" + t);
	  t = t.getCause();
	}
 }
 
}
