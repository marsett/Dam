import java.util.Scanner; /*se importa la clase Scanner, con el fin de que, en este ejercicio, 
							se pueda introducir a través de la consola un número entero, el cuál se va a declarar como "hora"*/

public class EJERCICIO1{
  public static void main (String[] args) {
    Scanner entrada = new Scanner(System.in); //se introduce Scanner, para poder introducir datos (en este caso, en la siguiente línea de código, es un número entero)
    int hora = entrada.nextInt(); //declaración de variable
    
    if(hora>=0 && hora<=12){				//para que el programa devuelva por consola "Buenos días", se introduce un "if" cuya condición es: entre las 0 (12 de la noche) y las 12 (12 de la mañana), la consola mostrará "Buenos días".
      System.out.println("Buenos días");	
    }else if(hora>12 && hora<21){			//para los dos "else if" siguientes, se sigue la misma lógica, introduciéndose "else if" puesto que, si no se introduce una hora entre las 0 y las 12, se va a introducir otra diferente en dos intervalos diferentes, lo cual va a mostrar por consola una de dos frases diferentes ("Buenas tardes" o "Buenas noches").
      System.out.println("Buenas tardes");
    }else if(hora>=21 && hora<=24){
      System.out.println("Buenas noches");
    }else{									//finalmente, si se introduce una hora fuera del intervalo entre 0 y 24, el programa lo interpretará como "Hora inválida", a través de un "else".
      System.out.println("Hora inválida");
    }
  }
  //por un tema de usabilidad, el programa debería preguntar por la hora a introducir
}
    
