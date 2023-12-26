package poo;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Uso_Restaurante {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Almacen restaurante = new Almacen(500,500);
		
		int opcion;
		
		int kg;
		
		Scanner sc = new Scanner (System.in);
		
			do {
			
				System.out.println("Elige una de las siguientes opciones:");
				
				System.out.println("1) Mostrar almacén de papas");
				
				System.out.println("2) Añadir papas");
				
				System.out.println("3) Eliminar papas");
				
				System.out.println("4) Mostrar almacén de chocos");
				
				System.out.println("5) Añadir chocos");
				
				System.out.println("6) Eliminar chocos");
				
				System.out.println("7) Mostrar número de comensales máximo");
				
				System.out.println("8) Salir");
		
				opcion = sc.nextInt();
		
			try {
		
				switch(opcion) {
					case 1:
						System.out.println("El almacén contiene "+restaurante.getpapas()+" papas");
					break;
					case 2:
						System.out.println("¿Cuántos kg de papas quieres añadir?");
						kg = sc.nextInt();
						restaurante.addpapas(kg);
					break;
					case 3:
						System.out.println("¿Cuántas kg de papas quieres eliminar?");
						kg = sc.nextInt();
						restaurante.rempapas(kg);
					break;
					case 4:
						System.out.println("El almacén contiene "+restaurante.getchocos()+" chocos");
					break;
					case 5:
						System.out.println("¿Cuántos kg de chocos quieres añadir?");
						kg = sc.nextInt();
						restaurante.addchocos(kg);
					break;
					case 6:
						System.out.println("¿Cuántos kg de papas quieres eliminar?");
						kg = sc.nextInt();
						restaurante.remchocos(kg);
					break;
					case 7:
						System.out.println("El número de comnesales máximo es de "+restaurante.getcomensales()+" comensales");
					break;
					case 8:
					break;
					default:
					break;
				}
		
			}catch(InputMismatchException e) {
				
				e.getStackTrace();
				
				System.out.println("El error en cuestión es "+e.getMessage());
				
				System.out.println("Has introducido un valor no numérico");
				
			}catch(Exception e) {
				
				System.out.println("Has hecho algo mal. Revisa el código en busca del error.");
			
			}
		
			finally {
				
				sc.nextLine();
			}
		
			}while(opcion!=8);
			
				sc.close();
		
				System.out.println("Has salido del sistema");
		
	}

}
