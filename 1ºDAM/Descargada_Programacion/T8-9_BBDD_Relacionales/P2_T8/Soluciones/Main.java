package practica03;

import java.awt.*;
import java.sql.*;

public class Main {
	public static void main(String[] args) {
		
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension resolucionPantalla=pantalla.getScreenSize();
		int anchoPantalla=resolucionPantalla.width; 
		int altoPantalla=resolucionPantalla.height; 
		
		VentanaEncurtidos ventana = new VentanaEncurtidos(anchoPantalla,altoPantalla);
		ventana.setVisible(true);
	}
}
