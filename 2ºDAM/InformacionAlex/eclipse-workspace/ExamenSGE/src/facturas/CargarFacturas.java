package facturas;
import java.sql.*;
import java.util.Scanner;

public class CargarFacturas {
	Scanner entrada=new Scanner(System.in);
	ListaFacturas listaFacturas=new ListaFacturas();
	

	public void cargarFacturas() {
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
					sql="select * from Facturas";
					
					ResultSet rs=statement.executeQuery(sql);
					while(rs.next()) {
						int numFactura=rs.getInt(1);
						String fechaEmision=rs.getString(2);
						String nombreCliente=rs.getString(3);
						String concepto=rs.getString(4);
						double baseImponible=rs.getDouble(5);
						int tipoIva=rs.getInt(6);
						double importeTotal=rs.getDouble(7);
						
						/*System.out.println(numFactura+" "+fechaEmision+" "+nombreCliente+" "+concepto+" "
						+baseImponible+" "+tipoIva+" "+importeTotal);*/
						Factura factura;
						factura=new Factura(numFactura,fechaEmision,nombreCliente,concepto,baseImponible,tipoIva,importeTotal);
						listaFacturas.insertarFactura(factura);
						
						/*for(int i=0;i<listaFacturas.getListaFacturas().size();i++) {
							System.out.println(i);
						}*/
					}
//					for(int i=0;i<.size();i++) {
//						System.out.println(listaFacturas.getListaFacturas().get(i));
//					}
					System.out.println("********facturas introducidas**************");
					for(Factura f: listaFacturas.getListaFacturas() ) {
						System.out.println(f);
					}
					statement.close();
				}
			}catch(SQLException e) {
				
			}
		}else {
			System.out.println("Terminando ejecucion");
		}
	}
}
