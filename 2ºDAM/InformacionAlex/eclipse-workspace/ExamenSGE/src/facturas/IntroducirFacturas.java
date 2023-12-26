package facturas;
import java.util.*;

public class IntroducirFacturas {
	Scanner entrada=new Scanner(System.in);
	ListaFacturas listaFacturas=new ListaFacturas();
	public void introducirFacturas(Factura factura) {
		System.out.println("Elegiste Introducir Facturas");
		System.out.println("Cual es el numero de factura?");
		int numFactura=entrada.nextInt();
		entrada.nextLine();
		System.out.println("Cual es la fecha de emision?");
		String fechaEmision=entrada.nextLine();
		entrada.nextLine();
		System.out.println("Cual es el nombre del cliente?");
		String nombreCliente=entrada.nextLine();
		entrada.nextLine();
		System.out.println("Cual es el concepto?");
		String concepto=entrada.nextLine();
		entrada.nextLine();
		System.out.println("Cual es la base imponible?");
		double baseImponible=entrada.nextDouble();
		System.out.println("Cual es el procentaje de IVA?");
		int tipoIva=entrada.nextInt();
		double tipoImpositivo=tipoIva*10;
		double importeTotal=baseImponible+tipoImpositivo;
		System.out.println("El tipo impositivo de lo insertado es: "+tipoImpositivo);
		System.out.println("El importe total de la factura es de: "+importeTotal);
		System.out.println("/****************/");
		System.out.println("Creando factura...");
		factura=new Factura(numFactura,fechaEmision,nombreCliente,concepto,baseImponible,tipoIva,importeTotal);
		this.listaFacturas.insertarFactura(factura);
	}
}
