package examen2;

import java.util.Scanner;

public class Academia {
	public static int usuariosEliminados = 0;
	
	public static void capacidad (Aula aula) {
		if (aula.limiteCapacidad() == true) {
		  aula.avisoExcesoCapacidad();
		  System.out.println("Vamos a eliminar usuarios. Usarios iniciales en Aula: "+aula.getUsuarios());
		  do {
		   aula.setUsuarios(aula.getUsuarios()-1);
		    
		   Academia.usuariosEliminados ++;
		  } while (aula.limiteCapacidad() == true);   
		  System.out.println("Usarios finales en Aula: "+aula.getUsuarios());
		}
        return;
	}

	public static void main(String[] args) {
		
		Scanner datos = new Scanner(System.in);
		int opcion=0, numAlumnos=0, numpcs=0;
		
		do {
			System.out.println("\n**********************************");
			System.out.println("¿Qué tipo de aula quieres crear?");
			System.out.println("1=Docencia");
			System.out.println("2=Informática");	
			opcion = datos.nextInt();
			if (opcion > 0 && opcion < 3) {
			 System.out.println("¿Cuántos alumnos quieres incluir en ese Aula?");
			 numAlumnos = datos.nextInt();
 			 switch (opcion) {
			  case 1:
				Docencia doc = new Docencia(numAlumnos);
				Academia.capacidad(doc);
				break;
			  case 2:
				System.out.println("Introduce el número de PCs para tu Aula de Informática \no bien 0 para mantener la cantidad por defecto.");
			    numpcs = datos.nextInt();
			    Informatica inf;
			    if (numpcs == 0) {
			      inf = new Informatica(numAlumnos);
			    }
			    else {
			      inf = new Informatica(numAlumnos, numpcs);
			    }
				Academia.capacidad(inf);
				break;
			  default:
				System.out.println("Fin programa.");
				break;
			  } //switch
			 } //if
			} while (opcion>0 && opcion<3);	
		 System.out.println("Número de usuarios a realojar en otras aulas: "+Academia.usuariosEliminados);
		 System.out.println("Fin programa.");
	 } //main

}
