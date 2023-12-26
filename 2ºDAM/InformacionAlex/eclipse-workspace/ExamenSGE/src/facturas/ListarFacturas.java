package facturas;

import java.util.List;

public class ListarFacturas {
	public void listarFacturas(ListaFacturas lf) {
		for(Factura f:lf.getListaFacturas()) {
			System.out.println(f);
		}
	}
}
