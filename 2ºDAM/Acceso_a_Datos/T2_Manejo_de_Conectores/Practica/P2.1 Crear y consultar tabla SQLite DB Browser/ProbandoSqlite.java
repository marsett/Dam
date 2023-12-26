package sqlitepack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProbandoSqlite {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		  try {
			  // ESTABLECER LA CONEXIÓN
			  Connection conexion;
			  conexion = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jimen\\OneDrive\\Documentos\\BasesDatosSQLite\\xemaSQLIte01.db");
			  // CREAR ENUNCIADO
			  Statement enunciado;
			  enunciado = conexion.createStatement();
			  // CREAR UNA TABLA NUEVA, LA BORRA SI EXISTE
			  enunciado.execute("DROP TABLE IF EXISTS TABLAPRUEBA;");
			  enunciado.execute("CREATE TABLE TABLAPRUEBA2 (id int primary key, aleatorio int);");
			  // INSERTAR DATOS
			  for (int i = 1; i <= 100; i++) {
				  enunciado.execute("INSERT INTO TABLAPRUEBA2 (id, aleatorio) values ("+ i+ ", "+ Math.floor(Math.random() * 100 + 1) + ");");
			  }
			  // CONSULTA DATOS
			  ResultSet resultados;
			  resultados = enunciado.executeQuery("SELECT * FROM TABLAPRUEBA2;");
			  // PROCESAR EL RESULTADO
			  while (resultados.next()) {
				  System.out.println("id " + resultados.getString(1)+ ": aleatorio " + resultados.getString(2));
			  }
			  // CERRAR
			  resultados.close();
			  enunciado.close();
			  conexion.close();
		  }
		  catch (Exception e) {
			  System.out.println("ERROR: " + e.getMessage());
		  }
	 }
}