package practica01;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
	
public class Ventana1 extends JFrame{
	
	public Ventana1(int ancho, int alto) {
		int alturaVentana=(int)(alto*0.93);
		int anchoVentana=(int)ancho/3;
		setBounds(0,0,anchoVentana,alturaVentana);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Primera ventana");
		
		//Creamos la lámina donde vamos a pintar objetos y la añadimos
		Lamina1 laminaMarco = new Lamina1(anchoVentana,alturaVentana);
		add(laminaMarco);
		
		//Hace visible la primera ventana
		//Lo ponemos lo último, porque sino a veces no veremos en pantalla lo que se haya definido después de hacerla visible
		setVisible(true);
		
	}
}

class Lamina1 extends JPanel {
	private int altoVentana;
	private int anchoVentana;
    JTextArea txtArea = new JTextArea(30,30);
    String fileString ="ficheros/Lorem.txt";
	File fr = new File (fileString);
	JLabel jl=new JLabel("Texto leído del fichero " + fileString);
	String cadena="";
	
	Lamina1(int ancho, int alto){
	 this.altoVentana = alto;
	 this.anchoVentana = ancho;txtArea.setLocation(120,100);
	 txtArea.setLineWrap(true);
	 txtArea.append("\n"); 
	 try {
  	  FileReader f = new FileReader(fr);
      BufferedReader b = new BufferedReader(f);
      while((cadena = b.readLine())!=null) {
        txtArea.append(cadena);
        txtArea.append("\n");
      }
      b.close();
	 }catch(IOException e) {
		 txtArea.setText("Error no se ha encontrada el archivo\n");
		 txtArea.append(e.getMessage()+"\n");
	 }
	 add(jl);
	 add(txtArea);	
	} 
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.drawString("TEXTAREA CON TEXTO DE FICHERO", (int)(this.anchoVentana*0.20), (int)(this.altoVentana*0.80));
	}
}


