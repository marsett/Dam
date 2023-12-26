package poo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParqueMain {

    private static Scanner sc;

    public static void main(String[] args) {
	sc = new Scanner(System.in);
	int opcion = 0;
	int numero;

	Parque parque = new Parque(200, 1000, 10000);

	do {
	    try {
		System.out.println();
		System.out.println("RESUMEN:");
		System.out.println("Hay " + parque.getPersonasParque() + " personas en el parque.");
		System.out.println("Aún quedan " + parque.getChanclasAlmacen() + " pares de chanclas en el almacén.");
		System.out.println("Aún quedan " + parque.getSouvenirsAlmacen() + " souvenirs en el almacén.");

		System.out.println();
		System.out.println("Selecciona una de las siguientes opciones:");
		System.out.println("1) Vender Entradas");
		System.out.println("2) Vender Chanclas");
		System.out.println("3) Vender Souvenir");
		System.out.println("4) Comprobar Aforo");
		System.out.println("5) Salir");
		System.out.println();

		opcion = sc.nextInt();

		switch (opcion) {
		case 1:
		    System.out.println("¿Cuántas entradas quieres vender?");
		    numero = sc.nextInt();
		    parque.vendeEntradas(numero, 1);
		    System.out.println("Se han vendido " + numero + " entradas y regalado " + numero + " pares de chanclas");
		    break;
		case 2:
		    System.out.println("¿Cuántos pares de chanclas quieres vender?");
		    numero = sc.nextInt();
		    parque.vendeChanclas(numero, 2);
		    System.out.println("Se han vendido " + numero + " pares de chanclas y regalado " + numero * 2 + " souvenirs.");
		    break;
		case 3:
		    System.out.println("¿Cuántos souvenirs quieres vender?");
		    numero = sc.nextInt();
		    parque.vendeSouvenirs(numero, 2);
		    System.out.println("Se han vendido " + numero + " souvenirs y " + numero + " más de regalo.");
		    break;
		case 4:
		    System.out.println("En este momento hay " + parque.getPersonasParque() + " personas en el parque.");
		    System.out.println("Se han vendido o regalado " + parque.getChanclasVendidas() + " chanclas.");
		    break;
		case 5:
		    break;

		default:
		    System.out.println("La opción tiene que estar comprendida entre 1 y 5");
		}
	    }
	    // catch (Exception e) {
	    catch (InputMismatchException e) {
		// e.printStackTrace();// muestra qué hay en la pila de errores
		System.out.println("Error al introducir los datos. Inténtelo de nuevo.");
	    } finally {
		sc.nextLine(); // saltamos la línea
	    }
	} while (opcion != 5);
	sc.close();
	System.out.println("Has salido del sistema.");
    }
}
