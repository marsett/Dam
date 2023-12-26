package facturas;

import java.util.ArrayList;

public class ListaFacturas {
	private static ArrayList<Factura> listaFacturas=new ArrayList<>();
		public void insertarFactura(Factura factura) {
			listaFacturas.add(factura);
		}
		public ArrayList<Factura> getListaFacturas(){
			return listaFacturas;
		}
		public void setLista(ArrayList<Factura> listaFacturas) {
			this.listaFacturas=listaFacturas;
		}
		
		public static void imprimir() {
			for(Factura f: listaFacturas) 
				System.out.println(f);
			
		}
}
