package examen26Mayo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class AplicacionLoteria {
	
static class Sorteo {
	public int jornada;
	public String fecha;
	public int numero1 = 0;
	public int numero2 = 0;
	public int numero3 = 0;
	public int numero4 = 0;
	public int numero5 = 0;
	public int complementario = 0;
		 
	Sorteo(int j, String f, int num1, int num2, int num3, int num4, int num5, int c) {
			 jornada = j;
			 fecha = f;
			 numero1 = num1;
			 numero2 = num2;
			 numero3 = num3;
			 numero4 = num4;
			 numero5 = num5;
			 complementario = c;
	}
	
	public int comprobarSorteo() {
		if (fecha.length() != 8) 
			return 1; // Fecha incorrecta
		if (numero1 == 0 || numero2 == 0 || numero3 == 0 || numero4 == 0 || numero5 == 0 || complementario == 0) 
			return 2; // Algun número o el complementario es cero o vacío
		if ( numero1 > 49 || numero2 > 49 || numero3 > 49 || numero4 > 49 || numero5 > 49)
			return 3; // Algún número es mayor de 49
		if ( complementario > 9 )
			return 4; // El complementario es mayor de 9
		// Para comprobar si los elementos están repetidos
		// Metemos todos los números en un array, lo ordenamos y luego sólo comprobamos 
		// cada elemento con el siguiente
		int[] arr = { numero1, numero2, numero3, numero4, numero5};
        Arrays.sort(arr);
        for (int i=0; i<4; i++)
        	if (arr[i] == arr[i+1])
        		return 5; 
		return 0; // Si se devuelve un 0, los números son correctos		
	}
	public void imprimirSorteo() {
		System.out.println("Boleto Jornada: " + jornada + " de fecha: " + fecha + " de números: " 
				+ numero1 + ", " + numero2 + ", " + numero3 + ", " + numero4 + ", " + numero5
				+ " y complementario: " + complementario);
		return;		
	}
 }
 
 public static void main (String[] args) {  
  int result;
  Scanner sc = new Scanner(System.in);
  int NUM_BOLETOS = 9;

  Sorteo jornadas[] = new Sorteo[NUM_BOLETOS];
	
  Sorteo jornada1 = new Sorteo(1, "01012022", 1, 3, 5, 23, 45, 5);
  jornadas[0] = jornada1;
  Sorteo jornada2 = new Sorteo(2, "08012022", 2, 9, 13, 23, 41, 4);
  jornadas[1] = jornada2;
  Sorteo jornada3 = new Sorteo(1, "15012022", 1, 19, 20, 28, 34, 4);
  jornadas[2] = jornada3;
  Sorteo jornada4 = new Sorteo(3, "", 1, 3, 5, 23, 45, 5);
  jornadas[3] = jornada4;
  Sorteo jornada5 = new Sorteo(4, "22012022", 4, 18, 25, 29, 33, 10);
  jornadas[4] = jornada5;
  Sorteo jornada6 = new Sorteo(5, "29012022", 7, 13, 20, 28, 34, 9);
  jornadas[5] = jornada6;
  Sorteo jornada7 = new Sorteo(6, "06022022", 4, 24, 29, 31, 31, 7);
  jornadas[6] = jornada7;
  Sorteo jornada8 = new Sorteo(7, "29012022", 1, 0, 20, 28, 34, 4);
  jornadas[7] = jornada8;
  Sorteo jornada9 = new Sorteo(8, "19022022", 4, 24, 29, 31, 48, 8);
  jornadas[8] = jornada9;

  
  try {
	Connection miConexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/LOTERIA","root","Solaris");
	
	//Creamos un objeto Statement que recogerá esa conexión 
	//y nos permitirá ejecutar TODAS las sentencias SQL
	Statement objetoStatement = miConexion.createStatement(); 
	
	System.out.println("\nPASO 1: INSERCIÓN DE BOLETOS");
	System.out.println("-----------------------------");
	
	//Para ejecutar sentencias Insert
	String inicioInsert = "INSERT INTO SORTEOS (JORNADA, FECHA, NUMERO1, NUMERO2, NUMERO3, NUMERO4, NUMERO5, COMPLEMENTARIO) VALUES";
	String sentenciaInsert = "";
	for (int i=0; i < NUM_BOLETOS; i++) {
		int comprobacion = jornadas[i].comprobarSorteo();
		switch (comprobacion) {
		 case 1:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR: El boleto tiene la fecha incorrecta;"); 
			 break;
		 case 2:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR: El boleto tiene algún número o el complementario vacío o es cero;"); 
			 break;
		 case 3:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR: El boleto tiene algún número mayor de 49;"); 
			 break;
		 case 4:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR: El boleto tiene el complementario con un número mayor de 9;"); 
			 break;
		 case 5:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR: El boleto tiene números repetidos;"); 
			 break;	 
		 case 0:					
			//Antes de ejecutar el Insert comprobamos si existe la jornada
			String sentencia = "SELECT * FROM sorteos WHERE jornada=" + jornadas[i].jornada;
			ResultSet resultado;
			resultado = objetoStatement.executeQuery(sentencia);
			if (resultado.next()) {
			  jornadas[i].imprimirSorteo(); 
			  System.out.println("  --!> ERROR: El boleto con la jornada " + jornadas[i].jornada + " ya existe en la tabla SORTEOS;"); 
			}
		   	else {
		   	 sentenciaInsert = inicioInsert + "(" + jornadas[i].jornada + ", '"
						+ jornadas[i].fecha + "', " + jornadas[i].numero1 + ", " +  jornadas[i].numero2 + ", " 
						+ jornadas[i].numero3 + ", " + jornadas[i].numero4 + ", " + jornadas[i].numero5 
						+ ", " + jornadas[i].complementario + ")";
			jornadas[i].imprimirSorteo(); 
			System.out.println("  --> Boleto CORRECTO. Se procede a insertar");
			//Para ejecutar el Insert
			result = objetoStatement.executeUpdate(sentenciaInsert);
			if (result == 1)
				System.out.println("  --> Se inserta correctamente el boleto.");
			else
			System.out.println("   --!> ERROR: No se ha podido insertar el boleto."); 
		   	
		   	}
            break;
		   default:
			 jornadas[i].imprimirSorteo(); 
			 System.out.println("  --!> ERROR desconocido en el boleto."); 
			 break;
		}	
	 }
	// Mostramos las jornadas y fechas de todos los boletos 
	System.out.println("\nPASO 2: CONSULTA DE BOLETOS");
	System.out.println("-----------------------------");
    ResultSet rs = objetoStatement.executeQuery("SELECT * FROM SORTEOS");
	while (rs.next()) {
		System.out.println("Jornada: " + rs.getInt(1) + " Fecha: " + rs.getString(2) + " Números: " 
				+ rs.getInt(3) + ", " + rs.getInt(4) + ", " + rs.getInt(5) + ", " + rs.getInt(6) + ", " + rs.getInt(7)
				+ " Complementario: " + rs.getInt(8));
	}
	
	
	// Pedimos al usuario el valor de una jornada para mostrar los números de ese boleto
	
	// Borramos todos los boletos y mostramos el número de boletos borrados.
	System.out.println("\nPASO 3: BORRADO DE BOLETOS");
	System.out.println("-----------------------------");
	

	String delete = "DELETE FROM SORTEOS";
	//System.out.println("Sentencia a ejecutar: " + delete);
	//Para ejecutar el Delete
	result = objetoStatement.executeUpdate(delete);
	System.out.println("Se han borrado " + result + " boletos de la tabla SORTEOS");
	
	} catch (SQLException e) {			
	    System.out.println("Error en Insertar");
	    printSQLException(e);
    }
 }

	
static void printSQLException(SQLException ex) {
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

