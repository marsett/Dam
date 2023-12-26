package poo;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Uso_Tienda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tienda almacen = new Tienda(15, 15);
		
		int opcion;
		
		int num;
		
		int retorno = 0;
		
		Scanner entrada = new Scanner (System.in);
		
		do {
			
				System.out.println("Selecciona una de las siguientes opciones");
				
				System.out.println("1) A�adir camisas al almac�n");
				
				System.out.println("2) Vender camisas");
				
				System.out.println("3) A�adir pantalones al almac�n");
				
				System.out.println("4) Vender pantalones");
				
				System.out.println("5) Comprobar stock de camisas");
				
				System.out.println("6) Comprobar stock de pantalones");
				
				System.out.println("7) Salir del programa");
			
				opcion = entrada.nextInt();
			
				try {
			
						switch(opcion) {
							case 1:
								System.out.println("�Cu�ntas camisas deseas a�adir?");
								num = entrada.nextInt();
								almacen.addcamisas(num);
								System.out.println("Has a�adido "+num+" camisas");
								System.out.println("Ahora el almac�n tiene "+almacen.getcamisas()+" camisas");
							break;
							case 2:
								almacen.remcamisas();
								System.out.println("Se ha vendido una camisa");
								System.out.println("Ahora el almac�n tiene "+almacen.getcamisas()+" camisas");
							break;
							case 3:
								System.out.println("�Cu�ntos pantalones deseas a�adir?");
								num = entrada.nextInt();
								almacen.addpantalones(num);
								System.out.println("Has a�adido "+num+" pantalones");
								System.out.println("Ahora el almac�n tiene "+almacen.getpantalones()+" pantalones");
							break;
							case 4:
								System.out.println("�Cu�ntos pantalones deseas quitar?");
								num = entrada.nextInt();
								almacen.rempantalones();
							break;
							case 5:
								System.out.println("El stock de camisas consta de "+almacen.getstockcamisetas()+" camisas");
							break;
							case 6:
								System.out.println("El stock de pantalones consta de "+almacen.getstockpantalones()+" pantalones");
							break;
							case 7:
								opcion = 7;
							break;
							default:
							break;
						}
			
							if (opcion != 7) {	
								System.out.println("�Desea volver al men� de nuevo?");
								System.out.println("Si desea volver, teclea el n�mero 8");
								System.out.println("Si no desea volver, teclee cualquier n�mero");
								retorno = entrada.nextInt();
							}
			
				}catch(InputMismatchException e) {
				
					e.getStackTrace();
				
					System.out.println("El error en cuesti�n es "+e.getMessage());
				
					System.out.println("Has introducido un valor no num�rico");
					
				}catch(Exception e) {
					
					System.out.println("Has hecho algo mal. Revisa el c�digo en busca del error.");
					
				}
		
				finally {
					
					entrada.nextLine();
					
				}
				
		}while(opcion!=7 && retorno==8);
		
			entrada.close();
		
			System.out.println("Has salido del sistema");
			
	}

}
