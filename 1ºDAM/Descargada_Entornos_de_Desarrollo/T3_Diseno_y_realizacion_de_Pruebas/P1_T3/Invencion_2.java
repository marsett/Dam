package p1t3;

import java.util.Scanner;

public class Invencion_2 {
	
	public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	
	int numero = 0, aleatorio = 0;
	
	boolean ejercicio = true;
	
		do {
	
			System.out.println("Elige el número de elementos entre 1 y 10");
	
			aleatorio = entrada.nextInt();
	
				if(aleatorio >=1 && aleatorio <=10) {
		
					for(int i = 0; i<aleatorio; i++) {
			
						numero = (int) (Math.random()*(10-1+1+1));
			
						System.out.println("Este es el número aleatorio "+numero);
					}
		
				}else{
					
					System.out.println("Número fuera del rango, prueba de nuevo");
				}
	
		}while(ejercicio == true);
	
	}
}
