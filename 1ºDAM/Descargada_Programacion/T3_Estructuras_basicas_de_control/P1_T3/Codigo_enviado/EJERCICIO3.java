import java.util.Scanner;/*se importa la clase Scanner, con el fin de que, en este ejercicio, 
							se pueda introducir a través de la consola un número entero, el cuál se va a declarar como "numero"*/

public class EJERCICIO3{
	public static void main (String[] args) {
		Scanner entrada = new Scanner(System.in);	//se introduce Scanner, para poder introducir datos (en este caso, en la segunda línea de código después de esta, es un número entero)
		System.out.println("¿Número par o impar");	//se introduce texto por pantalla, para aclarar el ejercicio y se entienda mejor a la hora de trabajarlo por consola 
		int numero = entrada.nextInt();				//declaración de variable
      
		if(numero %2 == 0){											//se introduce un "if", donde la condición para que salga un número par es que, el número introducido por consola, su módulo debe ser igual a 0, al haber sido dividido por el número 2 (par).
			System.out.println("El número "+numero+ " es par");
		}else{														//si el módulo no es igual a 0, actúa el else, imprimiendo por pantalla que el número introducido es impar.
			System.out.println("El número "+numero+ " es impar");
		}
	}
}
