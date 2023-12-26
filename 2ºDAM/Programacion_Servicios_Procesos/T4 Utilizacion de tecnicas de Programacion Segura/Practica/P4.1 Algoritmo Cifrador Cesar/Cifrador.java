package cifrador;
import java.util.Scanner;

public class Cifrador {
	public static void main(String[] args) {
		//se crea una variable de tipo String donde almacenar las letras del abecedario
		String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		//se crea un objeto de la clase Scanner
		Scanner entrada = new Scanner(System.in);
		//se llama al metodo useDelimiter para hacer salto de linea
		entrada.useDelimiter("\n");
		//se crea una variable donde almacenar la frase que se quiera codificar
		System.out.println("Escribe una frase que quieras codificar");
		String frase = entrada.next();
		//se llama al metodo cifrar para que, a través de un algoritmo se codifique la frase introducida
		String texto = cifrar(abecedario, frase);
		System.out.println("Mensaje codificado: " + texto);
		//se llama al metodo descrifrar para volver a la frase original
		texto = descifrar(abecedario, texto);
		System.out.println("Mensaje descodificado: " + texto);
		entrada.close();
	}
	public static String cifrar(String abecedario, String mensaje) {
		String mensajecifrado = "";
		//la frase introducida a través de Scanner se pasa por parámetro y se pone en mayúscula
		mensaje = mensaje.toUpperCase();
		//se crea un bucle que recorre la longitud del mensaje y se almacena en una variable de tipo char cada caracter
		char caracter;
		for (int i = 0; i < mensaje.length(); i++) {
			caracter = mensaje.charAt(i);
			//se almacena en un entero la posicion del caracter segun donde esté en el abecedario
			int posicion = abecedario.indexOf(caracter);
			//se crea un condicional que hace que cada caracter se almacene en la variable mensajecifrado
			if (posicion == -1) {
				mensajecifrado += caracter;
			} else {
				//la codificacion en este caso consiste en cambiar la letra según las posiciones
				mensajecifrado += abecedario.charAt((posicion + 12) % abecedario.length());
			}
		}
		return mensajecifrado;
	}
	public static String descifrar(String abecedario, String mensaje) {
		String mensajedescifrado = "";
		//la frase introducida a través de Scanner se pasa por parámetro y se pone en mayúscula
		mensaje = mensaje.toUpperCase();
		//se crea un bucle que recorre la longitud del mensaje y se almacena en una variable de tipo char cada caracter
		char caracter;
		for (int i = 0; i < mensaje.length(); i++) {
			caracter = mensaje.charAt(i);
			//se almacena en un entero la posicion del caracter segun donde esté en el abecedario
			int posicion = abecedario.indexOf(caracter);
			//se crea un condicional que hace que cada caracter se almacene en la variable mensajecifrado
			if (posicion == -1) {
				mensajedescifrado += caracter;
			} else {
				//se descifra el mensaje según las posiciones 
				if (posicion - 12 < 0) {
					mensajedescifrado += abecedario.charAt(abecedario.length() + (posicion - 12));
				} else {
					mensajedescifrado += abecedario.charAt((posicion - 12) % abecedario.length());
				}
			}
		}
		return mensajedescifrado;
	}
}
