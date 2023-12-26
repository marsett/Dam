package practica01;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Principal {
	public static void main(String[] args) {
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension resolucionPantalla=pantalla.getScreenSize();
		int anchoPantalla=resolucionPantalla.width; 
		int altoPantalla=resolucionPantalla.height; 

		Ventana1 ventana1=new Ventana1(anchoPantalla,altoPantalla);
		Ventana2 ventana2=new Ventana2(anchoPantalla,altoPantalla);
		Ventana3 ventana3=new Ventana3(anchoPantalla,altoPantalla);
		Ventana4 ventana4=new Ventana4(anchoPantalla,altoPantalla);		
	}
}

