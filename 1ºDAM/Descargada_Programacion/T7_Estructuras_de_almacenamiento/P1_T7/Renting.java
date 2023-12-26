package arreglo;

import java.util.Scanner;

public class Renting {

	public static void main(String[] args) {
	//Mario Jiménez Marset
		Scanner entrada = new Scanner (System.in);
		double [][] arreglo = new double[6][5];		//array declarado
		int i, j;
		System.out.println("¿Qué valor le das a la matriz");
		double valor_matriz = entrada.nextInt();	double inversion = valor_matriz;	double porcentaje = 0.1;	//variables del programa
			for(i=0;i<arreglo.length;i++) {
				for(j=0;j<arreglo[i].length;j++) {
					arreglo[i][j] = inversion;
					System.out.println("Año "+j+" : "+inversion+" ");
					inversion = (inversion*porcentaje)+inversion;	//operacion que calcula las distintas inversiones
					inversion = Math.round(100*inversion)/100;		//redondeo de la operación
				}
					System.out.println();
					inversion = valor_matriz;
					porcentaje = porcentaje +0.01;		//con esta operación, cada vez que se ejecuten de nuevo los for, el porcentaje va variando hasta finalizar la ejecución
			}
					int porcentaje_2 = 10;
					System.out.println("Elige un año");
					int introduce = entrada.nextInt();		//cálculos para que el programa muestre sólo la inversión realizada en el año que se quiera elegir
			for(i=0;i<arreglo.length;i++) {
				for(j=1;j<2;j++) {
					System.out.println("Porcentaje "+porcentaje_2+" % con una rentabilidad de "+arreglo[i][introduce]+" ");
				}
					porcentaje_2++;
			}
	}
}