public class EJERCICIO4{
	public static void main (String[] args) {
		int limite = 50;												//declaración de la variable "limite"	
		for(int numero = 0; numero<=limite; numero++){					/*el primer tipo de bucle utilizado es "for". En la condición de este, 
																		se declara la variable entera "numero" igual a 0 (primer número par);
																		entonces, para que saque los números pares hasta el 50 (límite), se dice
																		que "numero<=limite"; "numero", se va sumando hasta llegar al 50. Para que 
																		sean los pares y no todos los números hasta el 50, se introduce "if", 
																		donde la condición introducida es que, para imprimir por pantalla la frase,
																		el numero debe tener módulo igual a 0 (al dividirse entre 2)*/
			if(numero %2 == 0){
				System.out.println("El número "+numero+" es par");
			}
		}
		
		System.out.println(""); // espacio imprimido por pantalla para que, en consola, se aprecie mejor los diferentes ejercicios
		
		int limite2 = 50;		//declaración de variable
		int numero2 = 0; 		//declaración de variable
		while(numero2<=limite2){										/*el segundo tipo de bucle es "while". La condición introducida dice que,
																		mientras que numero2<=limite2 (0<=50) si el módulo de numero2 es igual a 0, el
																		número será par (esto último introducido como condición en un "if" dentro del "while")
																		Para que sean todos los números entre 0 y 50, a la variable numero2 se la va sumando*/
			if(numero2 %2 == 0){
				System.out.println("El número "+numero2+" es par");
			}
			numero2++;
		}
		
		System.out.println("");	// espacio imprimido por pantalla para que, en consola, se aprecie mejor los diferentes ejercicios
		
		int limite3 = 50;		//declaración de variable
		int numero3 = 0;		//declaración de variable
		do{																/*el tercer tipo de bucle es "do while". Dentro de este, se ha introducido un "if", donde
																		la condición introducida dice que, si el módulo de numero3 es igual a 0 (al ser dividible
																		entre 2), el número es par. Para que sean todos los números entre 0 y 50, a la variable
																		numero3 se la va sumando. Cuando el "do" termina, se introduce el "while", el cual
																		dice que numero3<=limite3 (0<=50), para que se cumpla lo introducido dentro del "do".*/
			if(numero3 %2 == 0){
				System.out.println("El número "+numero3+" es par");
			}numero3++;
		}while(numero3<=limite3);	
	}
	//podías haber reutilizado las variables de contador y límite
	//el programa no pedía que dijera si era para o impar, pero ok
}
