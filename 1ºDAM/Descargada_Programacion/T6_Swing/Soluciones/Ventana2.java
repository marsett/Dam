package practica01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
public class Ventana2 extends JFrame{
		
		public Ventana2(int ancho, int alto) {
		  int alturaVentana = (int)((alto/2)*0.93);
		  int anchoVentana=(int)ancho/3;	
		  setBounds(ancho/3,0,anchoVentana, alturaVentana);		 
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		  setTitle("Segunda ventana");		
		  Lamina2 laminaMarco = new Lamina2(anchoVentana,alturaVentana);
		  add(laminaMarco);
				
		  //Hace visible la segunda ventana
		  //Lo ponemos lo último, porque sino a veces no veremos en pantalla lo que se haya definido después de hacerla visible
		  setVisible(true);	
		}
	}

	//Todo lo que extiende de JPanel es una lámina
	class Lamina2 extends JPanel {
		private int altoVentana;
		private int anchoVentana;
		JLabel jl=new JLabel("Ejemplo de Botones:");
		JButton bt=new JButton("Texto1");
		JCheckBox jcb=new JCheckBox("Texto2");	
		JRadioButton jrb=new JRadioButton("Texto3");
			
		Lamina2(int ancho, int alto){
			this.altoVentana = alto;
			this.anchoVentana = ancho;
			jl.setLocation(10, 10);
			add(jl);
			add(bt);
			add(jcb);
			add(jrb);
		}
		
		public void paintComponent (Graphics g){
			super.paintComponent(g);
			g.drawString("ESTAMOS EN LA SEGUNDA VENTANA", (int)(this.anchoVentana*0.20), (int)(this.altoVentana*0.80));

		}

}
