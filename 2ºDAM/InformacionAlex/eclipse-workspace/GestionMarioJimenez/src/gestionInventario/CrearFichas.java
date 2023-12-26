package gestionInventario;
import java.util.Scanner;

public class CrearFichas {
	Scanner entrada=new Scanner(System.in);
	ListaFichas lista=new ListaFichas();
	
	public void crearFichas() {
		System.out.println("Elegiste Crear Fichas");
		System.out.println("Cual es el codigo del articulo?");
		int codigoArticulo=entrada.nextInt();
		entrada.nextLine();
		System.out.println("Cual es la fecha de entrada de la unidad?");
		String fechaFichaInventario=entrada.nextLine();
		System.out.println("Cual es el precio de entrada de la unidad?");
		double precioFichaInventario=entrada.nextDouble();
		entrada.nextLine();
		System.out.println("Cual es la ubicacion de la unidad?");
		String ubicacionFichaInventario=entrada.nextLine();
		System.out.println("Creando Ficha de Inventario...");
		
		FichasInventario fichaInventario=new FichasInventario(codigoArticulo,fechaFichaInventario,
				precioFichaInventario,ubicacionFichaInventario);
		System.out.println("Ficha de Inventario creada");
		this.lista.insertarFicha(fichaInventario);
	}
}
