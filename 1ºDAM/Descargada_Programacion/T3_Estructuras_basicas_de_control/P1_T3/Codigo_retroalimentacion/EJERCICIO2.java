import java.util.Scanner;	/*se importa la clase Scanner, con el fin de que, en este ejercicio, 
							se pueda introducir a través de la consola un número entero, el cuál se va a declarar como "numero"*/

public class EJERCICIO2{
  public static void main (String[] args) {
    Scanner entrada = new Scanner(System.in);	//se introduce Scanner, para poder introducir datos (en este caso, en la segunda línea de código después de esta, es un número entero)
    System.out.println("Los meses del año");	//se introduce texto por pantalla, para aclarar el ejercicio y se entienda mejor a la hora de trabajarlo por consola 
    int numero = entrada.nextInt();				//declaración de variable
    
    switch(numero){												/*se utiliza la instrucción "switch" para introducir 12 "cases" donde,  
																en cada uno y a través de imprimir pantalla, se pondrán los meses del año, 
																introduciendo cifras del 1 al 12, cada una correspondiente al mes. Si se  
																introduce otra cifra fuera de ese intervalo, saltará la frase "El mes propuesto es inválido"*/
      case 1:
        System.out.println("El mes propuesto es Enero");
      break;
      case 2:
        System.out.println("El mes propuesto es Febrero");
      break;
      case 3:
        System.out.println("El mes propuesto es Marzo");
      break;
      case 4:
        System.out.println("El mes propuesto es Abril");
      break;
      case 5:
        System.out.println("El mes propuesto es Mayo");
      break;
      case 6:
        System.out.println("El mes propuesto es Junio");
      break;
      case 7:
        System.out.println("El mes propuesto es Julio");
      break;
      case 8:
        System.out.println("El mes propuesto es Agosto");
      break;
      case 9:
        System.out.println("El mes propuesto es Septiembre");
      break;
      case 10:
        System.out.println("El mes propuesto es Octubre");
      break;
      case 11:
        System.out.println("El mes propuesto es Noviembre");
      break;
      case 12:
        System.out.println("El mes propuesto es Diciembre");
      break;
      default:
        System.out.println("El mes propuesto es inválido");
      break;
    }
    //Podías haber optado por una única salida para todos
  }
}
