package facturas;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		IntroducirFacturas introducirFacturas=new IntroducirFacturas();
		GuardarFacturas guardarFacturas=new GuardarFacturas();
		CargarFacturas cargarFacturas=new CargarFacturas();
		ListarFacturas listarFacturas=new ListarFacturas();
		ListaFacturas listaFacturas=new ListaFacturas();
		Factura factura=new Factura();
		Scanner entrada=new Scanner(System.in);
		int opcion;
		do {
		System.out.println("Elige entre las siguientes opciones\n0-Salir del programa"
				+ "\n1-Introducir facturas\n2-Listar facturas"
				+ "\n3-Cargar facturas\n4-Guardar facturas");
		opcion=entrada.nextInt();
		
		switch(opcion) {
		case 0:
			System.out.println("Saliendo del programa...");
			break;
		case 1:
			introducirFacturas.introducirFacturas(factura);
			break;
		case 2:
			listaFacturas.imprimir();
			break;
		case 3:
			cargarFacturas.cargarFacturas();
			break;
		case 4:
			guardarFacturas.guardarFacturas();
			break;
		}
		}while(opcion!=0);
		entrada.close();
	}
}
