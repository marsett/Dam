package poo;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Mi_Numero {
	
	public static void main(String[] args) {
			
		double opcion;
	
		double salida = 4;
	
		double numero2;
	
		Scanner entrada = new Scanner (System.in);
	
		do {
		
			try {
	
					numero2 = Double.parseDouble(JOptionPane.showInputDialog("Elige el número"));
	
					Numero objeto2 = new Numero(numero2);
	
					System.out.println("Elige qué acción realizar");
					
					System.out.println("1)doble");
					
					System.out.println("2)triple");
					
					System.out.println("3)cuádruple");
	
					opcion = Double.parseDouble(JOptionPane.showInputDialog("¿Qué acción quieres realizar?"));
	
					if(opcion==1) {
						System.out.println("El doble es igual a "+objeto2.getdoble());
					}else if(opcion==2) {
						System.out.println("El triple es igual a "+objeto2.gettriple());
					}else if(opcion==3) {
						System.out.println("El cuádruple es igual a "+objeto2.getcuadruple());
					}
	
					salida = Double.parseDouble(JOptionPane.showInputDialog("¿Desea volver al menú? Pulse 4"));
	
			}catch (NumberFormatException e) {
		
					e.getMessage();
		
					System.out.println("El error es "+e.getMessage());
		
					System.out.println("Ha introducido un divisor con valor cero");
					
			}catch (NullPointerException e) {
		
					e.printStackTrace();
		
					System.out.println("El error es "+e.getMessage());
		
					System.out.println("Al dejar vacío (null) el campo a rellenar por el <<JOptionPane>>");
					
			}catch (Exception e) {
				
					System.out.println("Has hecho algo mal. Revisa el código, por favor.");
			}
	
			finally {
				
					entrada.nextLine();
			}
	
		}while(salida == 4);
	
	}
	
}
