package practica01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
public class Ventana4 extends JFrame{
		
		public Ventana4(int ancho, int alto) {
		  int alturaVentana = (int)((alto/2)*0.93);
		  int anchoVentana=2*ancho/3;	
		  setBounds(ancho/3,(int)((alto/2)*0.99),anchoVentana, alturaVentana);			  
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		  setTitle("Cuarta ventana");	
		  	
		  Lamina4 laminaMarco = new Lamina4(anchoVentana,alturaVentana);
		  add(laminaMarco);
				
		  //Hace visible la segunda ventana
		  //Lo ponemos lo último, porque sino a veces no veremos en pantalla lo que se haya definido después de hacerla visible
		  setVisible(true);	
		}
	}

	//Todo lo que extiende de JPanel es una lámina
	class Lamina4 extends JPanel {
		private int altoVentana;
		private int anchoVentana;
		JLabel jl=new JLabel("Ejemplo de campo: ");
		JTextField txtTexto = new JTextField(20);
		JButton BotonTexto=new JButton("Pulsa");
		
		Lamina4(int ancho, int alto){
			this.altoVentana = alto;
			this.anchoVentana = ancho;
			txtTexto.setText("Escribe tu nombre ...");
			add(jl);
			add(txtTexto);	
			add(BotonTexto);
		}
		
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			g.drawString("¡¡SI CIERRAS ESTA VENTANA, FINALIZA EL PROGRAMA!!", (int)(this.anchoVentana*0.20), (int)(this.altoVentana*0.80));
		}

}
