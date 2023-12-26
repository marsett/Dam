package practica_bbdd;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private int anchoventana, alturaventana;
	
	public Ventana(int ancho, int alto){
		
		setTitle("Aplicación de Consulta");
		setResizable(true);
		
		anchoventana = 400;
		alturaventana = 400;
		
		setBounds(50,50,anchoventana, alturaventana);
		
		Lamina lam_ej1 = new Lamina();
		add(lam_ej1);
		setVisible(true);
		
	}

}

class Lamina extends JPanel {
		
		private static final long serialVersionUID = 1L;
		
		
		public Lamina() {
			
			
		}
		
		public void ActionPerformed(ActionEvent e) {
			
		}
		
}


