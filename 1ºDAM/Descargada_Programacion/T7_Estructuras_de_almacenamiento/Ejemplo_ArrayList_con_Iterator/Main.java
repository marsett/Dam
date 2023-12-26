package Pruebas;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Declaramos y construimos el ArrayList
		ArrayList<PruebaArrayList> arrayprueba= new ArrayList<PruebaArrayList>(); 

		//Generamos el ArrayList
		for(int i=0; i< 8; i++) {
			//Construimos cada uno de los objetos que vamos a usar, porque si lo construimos fuera del bucle, 
			//siempre nos guardará el mismo objeto, y no distintos como nosotros necesitamos
			arrayprueba.add(new PruebaArrayList(i));
		}
		
		//Recorremos el ArrayList para confirmar que funciona usando un for normal para que también tengáis el ejemplo
		for(int i=0; i<arrayprueba.size(); i++) {
			System.out.println(arrayprueba.get(i).getPrueba());
		}
	}

}
