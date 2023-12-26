package examen_2;
import java.sql.*;
import java.util.Arrays;

public class Sorteo {
	
	public int jornada, num1, num2, num3, num4, num5, complementario;
	public String fecha;
	
	Sorteo(int jor, String fec, int n1, int n2, int n3, int n4, int n5, int comp){
		jor = jornada;	//0
		fec = fecha;	//1
		n2 = num2;	//2
		n3 = num3;	//3
		n4 = num4;	//4
		n5 = num5;	//5
		comp = complementario;	//6
		n1 = num1;	//7
	}
	
	/*Constructor sobrecargado creado para el case 5 del switch del metodo comprobarSorteo*/
	
	Sorteo(int numero1, int numero2, int numero3, int numero4, int numero5, int complem){
		numero1 = num1;
		numero2 = num2;
		numero3 = num3;
		numero4 = num4;
		numero5 = num5;
		complem = complementario;
	}
	
	public int comprobarSorteo() {
	
		int[] numeros_ordenados = {num1, num2, num3, num4, num5, complementario};
		
		boolean correcto;
		int a = 0;
		
		switch(a) {
		case 1:
			if(fecha != "") {
				correcto = false;
				System.out.println("La fecha no está vacía. Bien hecho");
			}else {
				System.out.println("La fecha está vacía. Revisa código");
			}
			break;
		case 2:
			if(num1 != 0 && num2 != 0 && num3 != 0 && num4 != 0 && num5 != 0 && complementario != 0) {
				correcto = true;
				System.out.println("Los números son diferentes de 0. Bien hecho");
			}else {
				System.out.println("Algún número es igual a 0. Revisa código");
			}
			break;
		case 3:
			if(num1 < 50 && num2 < 50 && num3 < 50 && num4 < 50 && num5 < 50 && complementario < 50) {
				correcto = true;
				System.out.println("Los números son menores de 50. Bien hecho");
			}else {
				System.out.println("Hay algún número mayor de 50. Revisa código");
			}
			break;
		case 4:
			if(complementario < 10) {
				correcto = true;
				System.out.println("El complementario es menor de 10. Bien hecho");
			}else {
				System.out.println("El complementario es mayor de 10. Revisa código");
			}
			break;
		case 5:
			Arrays.sort(numeros_ordenados);
			System.out.println("Elementos ordenados: "+numeros_ordenados);
			int contador = 0;
			int aux = numeros_ordenados[0];
			for(int i=0;i<numeros_ordenados.length;i++) {
				if(aux == numeros_ordenados[i]) {
					contador++;
				}else {
					System.out.println(contador + ",");
					contador = 1;
					aux = numeros_ordenados[i];
				}
			}
			System.out.println(contador);
			break;
		}
		
		return 0;
		
	}
	
	public void imprimirSorteo() {
		System.out.println("Los boletos del sorteo: "+comprobarSorteo());
	}

	public static void main(String[] args) throws SQLException{
		
		Connection miConexion;
		Statement sentencia = null;
		int fin;
		
		Sorteo boletos[] = new Sorteo[9];
		
		Sorteo boleto1 = new Sorteo(1,"01012022",1,3,5,23,45,5);
		boletos[0] = boleto1;
		
		Sorteo boleto2 = new Sorteo(2,"08012022",2,9,13,23,41,4);
		boletos[1] = boleto2;
		
		Sorteo boleto3 = new Sorteo(1,"15012022",1,19,20,28,34,4);
		boletos[2] = boleto3;
		
		Sorteo boleto4 = new Sorteo(3,"",1,3,5,23,45,5);
		boletos[3] = boleto4;
		
		Sorteo boleto5 = new Sorteo(4,"22012022",4,18,25,29,33,10);
		boletos[4] = boleto5;
		
		Sorteo boleto6 = new Sorteo(5,"29012022",7,13,20,28,34,9);
		boletos[5] = boleto6;
		
		Sorteo boleto7 = new Sorteo(6,"06022022",4,24,29,31,31,7);
		boletos[6] = boleto7;
		
		Sorteo boleto8 = new Sorteo(7,"29012022",1,0,20,28,34,4);
		boletos[7] = boleto8;
		
		Sorteo boleto9 = new Sorteo(8,"19022022",4,24,29,31,48,8);
		boletos[8] = boleto9;
		
		try {
			
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOTERIA","root","");
			sentencia = miConexion.createStatement();
			
			String consulta = "INSERT INTO SORTEOS (JORNADA, FECHA, NUM1, NUM2, NUM3, NUM4, NUM5, COMPLEMENTARIO) VALUES";
			String consulta2 = "";
			
			for(int i=0;i<9;i++) {
				consulta2 = consulta + "(" + boletos[i].jornada + "', '"+ boletos[i].fecha + "', '"+boletos[i].num1 + "', '" + boletos[i].num2 + 
				"', '" + boletos[i].num3 + "', '" + boletos[i].num4 + "', '" + boletos[i].num5 + "', '" + boletos[i].complementario + ")";
				System.out.println("La sentencia es "+ consulta2);
				
				fin = sentencia.executeUpdate(consulta2);
				System.out.println("Inserta en tabla: "+fin);
			}
			
			ResultSet rs;
			
			String select ="SELECT * FROM SORTEOS";
			rs = sentencia.executeQuery(select);
			
			while(rs.next()) {
				System.out.println("Jornada: "+rs.getString(1)+" "+"Fecha: "+rs.getString(2)+" "+"Números: "+rs.getString(3)+", "+rs.getString(4)+", "+rs.getString(5)+", "
			    +rs.getString(6)+", "+rs.getString(7)+" Complementario: "+rs.getString(8));
			}
			
			String borrar = "DELETE * FROM SORTEOS";
			fin = sentencia.executeUpdate(borrar);
			System.out.println("BORRADO DE OBJETOS"+"\n"+"Se han borrado "+fin+" boletos de la tabla SORTEOS");
			
		}catch(SQLException e) {
			System.out.println("Error en main");
			System.out.println("Error de sql: "+e.getMessage()+" "+e.getSQLState()+" "+e.getErrorCode());
			//printSQLException(e);
		}
		
	}
	
	private void printSQLException (SQLException ex) {
		ex.printStackTrace(System.err);
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
