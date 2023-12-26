import java.util.Scanner;		/*se importa la clase Scanner, con el fin de que, en este ejercicio, 
							se puedan introducir a través de la consola datos enteros*/
							
//los valores fuera del rango en las opciones 1 y 2 no están contempladas
public class EJERCICIO7{
	public static void main (String[] args) {
		int opciones = 0;												//declaración de variable
		do{																//para que todo el programa funcione, se ejecuta un "do while", donde el "while" dice que todo el programa se ejecutará si no se introduce el número 4, ya que este hace que el programa finalice, imprimiendo por pantalla "Salir"
		System.out.println("MENU");										//se imprime por pantalla el menú, sus opciones, para que quede más visual el programa
		System.out.println("Elige entre estas opciones");
		System.out.println("Opcion 1 = Calculo Hora");
		System.out.println("Opcion 2 = Calculo Mes");
		System.out.println("Opcion 3 = Par o Impar");
		System.out.println("Opcion 4 = Salir");
		Scanner lectura = new Scanner(System.in);						//se introduce Scanner, para poder poner datos en consola
		opciones = lectura.nextInt();									//variable entera que se introduce en la consola
		switch(opciones){												/*se usa la instrucción "switch", siendo cada "case" las opciones antes descritas. Cada case son los programas descritos en los anteriores ejercicios, siendo la única diferencia que están dentro de un "switch"*/
			case 1:
				System.out.println("Calculo Hora");
				int hora = lectura.nextInt();
    
				if(hora>=0 && hora<=12){
					System.out.println("Buenos días");
					}else if(hora>=12 && hora<=21){
					System.out.println("Buenas tardes");
					}else if(hora>=21 && hora<=24){
					System.out.println("Buenas noches");
					}
			break;
			case 2:
				System.out.println("Calculo Mes");
				int mes = lectura.nextInt();
    
				switch(mes){
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
			 }
			break;	
			case 3:
				System.out.println("Par o Impar");
				int numero = lectura.nextInt();
				if(numero %2 == 0){
					System.out.println("El número "+numero+ " es par");
				}else{
					System.out.println("El número "+numero+ " es impar");
				}
			break;
			case 4:
				System.out.println("Salir"); 
			break;
			default:													//si se introduce algún valor fuera del rango entre 1 y 4, el programa imprimirá "error en la selección", y volverá a sacar por pantalla las opciones*/
				System.out.println("Error en la selección");
			break;
		}
	}while(opciones!=4);
  }
}
