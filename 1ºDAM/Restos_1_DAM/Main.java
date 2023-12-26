package practica_bbdd;

import javax.swing.*;
import java.awt.*;

public class Main{

	public static void main(String[] args) {
		
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanopantalla = mipantalla.getScreenSize();
		
		int anch = tamanopantalla.width;
		int alt = tamanopantalla.height;
		
		Ventana vent = new Ventana(anch,alt);
		vent.setVisible(true);
		vent.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	
	}



}
