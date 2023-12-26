
import java.util.Scanner;	/*se importa la clase Scanner, con el fin de que, en este ejercicio, 
							se puedan introducir a través de la consola datos enteros*/
public class EJERCICIO6{
	public static void main (String[] args) {
		Scanner lectura = new Scanner(System.in);						//se introduce Scanner, para poder introducir datos
		int numero1;													//declaración de variables
		int numero2;
		int resultado;
		
		System.out.println("Introduce dos números");					//se imprime por pantalla lo que pide el ejercicio
			numero1 = lectura.nextInt();								//se ponen los dos números declarados anteriormente para poder ser introducidos manualmente a través de la consola
			numero2 = lectura.nextInt();
			resultado = numero1-numero2;								//se restan los dos numeros (lo cual es igual a "resultado"), imprimiéndose por pantalla esta solución
			System.out.println("La solución de la resta es "+resultado);
			
			if(resultado<0){											/*para comprobar si es negativo el resultado, se utiliza un "if", donde la condición
																		introducida es resultado<0 (lo cual significa que, todos los resultados negativos, imprimen
																		la frase siguiente, la cual dice "El resultado es negativo")*/
				System.out.println("El resultado es negativo");
			}else{														/*si el resultado no es negativo, actúa "else"*/
				do{														/*dentro de "else", se introduce un "do while", el cual imprime que el resultado
																		es positivo y, que se prueb un nuevo número, para intentar que el resultado
																		sea negativo. Para ello, se introduce un nuevo número, el cual se resta al
																		resultado anterior hasta que salga un número negativo y el programa finalice 
																		con la última frase. Todo esto sucederá si la condición del "while" es 
																		resultado>=0, ya que el "else" se ejecuta si el primer resultado sale positivo
																		o igual a 0*/ 
				System.out.println("El resultado es positivo");
				System.out.println("Pruebe un nuevo numero");
				numero1 = lectura.nextInt();
				resultado = numero1-resultado;//invertido resultado-numero1;
				System.out.println("La solución de la resta es "+resultado);
			}while(resultado>=0);
		}
	}
}
