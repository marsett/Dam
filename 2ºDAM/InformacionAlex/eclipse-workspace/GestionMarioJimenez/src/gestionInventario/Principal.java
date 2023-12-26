package gestionInventario;
import java.util.*;

public class Principal {
	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		CrearFichas crearFichas=new CrearFichas();
		GuardarFichas guardarFichas=new GuardarFichas();
		ArrayArticulos array=new ArrayArticulos();
		GuardarArticulos guardarArticulos=new GuardarArticulos();
		NumeroFichasInventario numeros=new NumeroFichasInventario();
		ValorInventario valor=new ValorInventario();
		MostrarFichas mostrar=new MostrarFichas();
		int opcion;
		do {
			System.out.println("Menu de Consola Inventario\nElige entre las siguientes opciones"
					+ "\n1-Crear fichas de Inventario"
					+ "\n2-Guardar fichas de Inventario"
					+ "\n3-Guardar Articulos"
					+ "\n4-Numero de fichas de Inventario"
					+ "\n5-Valor de Inventario"
					+ "\n6-Mostrar Fichas Inventario");
			opcion=entrada.nextInt();
			switch(opcion) {
			case 0:
				System.out.println("Saliendo del Menu...");
				break;
			case 1:
				crearFichas.crearFichas();
				break;
			case 2:
				guardarFichas.guardarFichas();
				break;
			case 3:
				array.inserta();
				guardarArticulos.guardarArticulos();
				break;
			case 4:
				numeros.numero();
				break;
			case 5:
				valor.valor();
				break;
			case 6:
				mostrar.mostrar();
				break;
			}
		}while(opcion!=0);
		entrada.close();
	}
}
