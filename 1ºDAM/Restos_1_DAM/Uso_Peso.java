package poo;

import javax.swing.JOptionPane;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Uso_Peso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int eleccion = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
		try {
			
			double peso = Double.parseDouble(JOptionPane.showInputDialog("Introduce el peso que desees"));
		
			System.out.println("1 - libras");
			
			System.out.println("2 - lingotes");
			
			System.out.println("3 - onzas");
		
			System.out.println("4 - peniques");
		
			System.out.println("5 - gramos");
		
			System.out.println("6 - quintales");
		
			System.out.println("7 - salida del menú");
		
			eleccion = sc.nextInt();
		
				Peso valor = new Peso();
		
				valor.setKilos(peso);
		
				valor.setValores(eleccion);
		
			System.out.println("La conversión de kilos a "+valor.getNombre()+" da como resultado "+valor.getPeso());
		
		}catch(InputMismatchException e) {
			
			e.getStackTrace();
			
			System.out.println("El error en cuestión es "+e.getMessage());
			
			System.out.println("Has introducido un valor no numérico");
			
		}catch(NumberFormatException e) {
			
			e.getStackTrace();
			
			System.out.println("El error en cuestión es "+e.getMessage());
			
			System.out.println("Has introducido una cadena de caracteres <<String>> en vez de una variable de tipo double");
			
		}catch (NullPointerException e) {
			
			e.printStackTrace();
			
			System.out.println("El error es "+e.getMessage());
			
			System.out.println("Al dejar vacío (null) el campo a rellenar por el <<JOptionPane>>");
			
		}catch(Exception e) {
			
			System.out.println("Has hecho algo mal. Revisa el código, por favor.");
			
		}
		
		finally {
			sc.nextLine();
		}
		
	}while(eleccion == 7);
		
	}
	
}