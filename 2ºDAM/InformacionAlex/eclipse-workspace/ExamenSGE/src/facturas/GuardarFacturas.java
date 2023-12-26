package facturas;
import java.util.*;
import java.sql.*;

public class GuardarFacturas {
	Scanner entrada=new Scanner(System.in);
	ListaFacturas listaFacturas=new ListaFacturas();
	Factura factura=new Factura();
	public void guardarFacturas() {
		System.out.println("Elegiste Guardar Facturas");
		System.out.println("Estas seguro de ello?\n1-Si\n2-No");
		int respuesta=entrada.nextInt();
		if(respuesta==1) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url,usuario,password;
			url="jdbc:mysql:///bd_mario_jimenez";
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
					
					for(int i=0;i<listaFacturas.getListaFacturas().size();i++) {
						sql="INSERT INTO Facturas(numFactura, fechaEmision, nombreCliente, concepto, "
							+ "baseImponible, tipoIva, importeTotal) values("+
								listaFacturas.getListaFacturas().get(i).getNumFactura()+",'"+
								listaFacturas.getListaFacturas().get(i).getFechaEmision()+"','"+
								listaFacturas.getListaFacturas().get(i).getNombreCliente()+"','"+
								listaFacturas.getListaFacturas().get(i).getConcepto()+"',"+
								listaFacturas.getListaFacturas().get(i).getBaseImponible()+","+
								listaFacturas.getListaFacturas().get(i).getTipoIva()+","+
								listaFacturas.getListaFacturas().get(i).getImporteTotal()+
								")";
						
						System.out.println(sql);
						statement.execute(sql);
					}
					
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Terminando ejecucion");
		}
	}
}
