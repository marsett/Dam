package practica01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
public class Ventana3 extends JFrame{
		
		public Ventana3(int ancho, int alto) {
		  int alturaVentana = (int)((alto/2)*0.93);
		  int anchoVentana=(int)ancho/3;
		  setBounds(2*ancho/3,0,anchoVentana, alturaVentana);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		  setTitle("Tercera ventana");	
		  Lamina3 laminaMarco = new Lamina3(anchoVentana,alturaVentana);
		  add(laminaMarco);
		  setVisible(true);	
		}
	}

	//Todo lo que extiende de JPanel es una lámina
	class Lamina3 extends JPanel {
		private int altoVentana;
		private int anchoVentana;
		JLabel jl=new JLabel("Ejemplo de ComboBox:");
		JComboBox jcb=new JComboBox();
		String Amigos[]= {"Ana", "Pepe", "Juan", "Carmen"};
		
		Lamina3(int ancho, int alto){
			this.altoVentana = alto;
			this.anchoVentana = ancho;
			for (int i=0; i<Amigos.length; i++)
				jcb.addItem(Amigos[i]);
			add(jl);
			add(jcb);			
		}
		
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			g.drawString("ESTAMOS EN LA TERCERA VENTANA", (int)(this.anchoVentana*0.20), (int)(this.altoVentana*0.80));

		}

}
