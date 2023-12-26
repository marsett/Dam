package conexion;
import java.sql.*;
public class InvocandoProcedimientosAlmacenados {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url, usuario, pwd;
		usuario="root";
		pwd="mysql";
		url="Jdbc:mysql:///test";
		try(
			var conexion=DriverManager.getConnection(url,usuario,pwd);
			){
				String sql="call MI_PROCEDIMIENTO(?)";
				CallableStatement stmt=conexion.prepareCall(sql);
				stmt.setInt(1, 0);	//inserta el 0 en la invocacion del procedimeinto almacenado
				int filasAfectadasPorLaConsulta=stmt.executeUpdate();
				System.out.println(filasAfectadasPorLaConsulta);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
	}
}
