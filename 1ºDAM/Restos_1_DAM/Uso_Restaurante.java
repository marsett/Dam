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
				
				System.out.println("1) Mostrar almac�n de papas");
				
				System.out.println("2) A�adir papas");
				
				System.out.println("3) Eliminar papas");
				
				System.out.println("4) Mostrar almac�n de chocos");
				
				System.out.println("5) A�adir chocos");
				
				System.out.println("6) Eliminar chocos");
				
				System.out.println("7) Mostrar n�mero de comensales m�ximo");
				
				System.out.println("8) Salir");
		
				opcion = sc.nextInt();
		
			try {
		
				switch(opcion) {
					case 1:
						System.out.println("El almac�n contiene "+restaurante.getpapas()+" papas");
					break;
					case 2:
						System.out.println("�Cu�ntos kg de papas quieres a�adir?");
						kg = sc.nextInt();
						restaurante.addpapas(kg);
					break;
					case 3:
						System.out.println("�Cu�ntas kg de papas quieres eliminar?");
						kg = sc.nextInt();
						restaurante.rempapas(kg);
					break;
					case 4:
						System.out.println("El almac�n contiene "+restaurante.getchocos()+" chocos");
					break;
					case 5:
						System.out.println("�Cu�ntos kg de chocos quieres a�adir?");
						kg = sc.nextInt();
						restaurante.addchocos(kg);
					break;
					case 6:
						System.out.println("�Cu�ntos kg de papas quieres eliminar?");
						kg = sc.nextInt();
						restaurante.remchocos(kg);
					break;
					case 7:
						System.out.println("El n�mero de comnesales m�ximo es de "+restaurante.getcomensales()+" comensales");
					break;
					case 8:
					break;
					default:
					break;
				}
		
			}catch(InputMismatchException e) {
				
				e.getStackTrace();
				
				System.out.println("El error en cuesti�n es "+e.getMessage());
				
				System.out.println("Has introducido un valor no num�rico");
				
			}catch(Exception e) {
				
				System.out.println("Has hecho algo mal. Revisa el c�digo en busca del error.");
			
			}
		
			finally {
				
				sc.nextLine();
			}
		
			}while(opcion!=8);
			
				sc.close();
		
				System.out.println("Has salido del sistema");
		
	}

}
