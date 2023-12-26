package recuperacion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;

public class Principal {
	public static void main(String[] args) {
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension resolucionPantalla=pantalla.getScreenSize();
		int anchoPantalla=resolucionPantalla.width; 
		int altoPantalla=resolucionPantalla.height; 
		Ventana ventana=new Ventana(anchoPantalla,altoPantalla);
    }
}

class Ventana extends JFrame{
	public Ventana(int ancho, int alto) {
		int alturaVentana=(int)(alto*0.8);
		int anchoVentana=(int)(ancho*0.5);
		setBounds(100,100,anchoVentana,alturaVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Recuperación 19 Mayo 2022");
		//setLayout(new FlowLayout(FlowLayout.CENTER,200,2));
		  
		Lamina laminaMarco = new Lamina();
		add(laminaMarco);		
		setVisible(true);
	}
}

class Lamina extends JPanel implements ActionListener {
	String fileString ="recuperacion.txt";
	File file = new File (fileString);
	FileWriter fw;
	BufferedWriter bufw;
	FileReader fr;
	BufferedReader bufr;
	
	JTextArea txtArea = new JTextArea(30,45);
	JComboBox jcb_tipo;
    JLabel jl=new JLabel("Elige una opción para escribir en el fichero: ");
    JTextField texto = new JTextField(35);
    JButton botonFin=new JButton("Escribir Fichero");
    String cadenaTexto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, "
    	+ "no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, "
    	+ "adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca "
    	+ "que carnero, salpicón las más noches, duelos y quebrantos los sábados, "
    	+ "lentejas los viernes, algún palomino de añadidura los domingos, consumían "
        + "las tres partes de su hacienda. El resto della concluían sayo de velarte, "
        + "calzas de velludo para las fiestas con sus pantuflos de lo mismo, "
        + "los días de entre semana se honraba con su vellori de lo más fino.";
    
   Lamina(){
    jcb_tipo = new JComboBox();
    jcb_tipo.setEditable(false);
    jcb_tipo.addItem("IGUAL");
    jcb_tipo.addItem("AL REVES");
    jcb_tipo.addItem("MAYUSCULAS");
    jcb_tipo.addItem("MINUSCULAS");
    txtArea.setLineWrap(true);
    txtArea.append(cadenaTexto);
    	
	add(jl);
	add(jcb_tipo);
	add(txtArea);
	add(botonFin); 
	botonFin.addActionListener(this);
  } 
	
 public void actionPerformed (ActionEvent e) {
	 String opcion = (String)jcb_tipo.getSelectedItem();
     System.out.println(opcion);
     String linea = txtArea.getText();
	 if (opcion.equals("IGUAL")) {  
		//Creamos el fichero de escritura y escribimos con un buffer
		//todo el texto
		try {
		  fw = new FileWriter(file);
		  bufw = new BufferedWriter(fw); 
		  bufw.write(linea);
		  bufw.newLine();
		  bufw.flush();
		  bufw.close();
	      fw.close();
		}catch(IOException e1) {
		  e1.printStackTrace();
		}
		this.leerFichero();
	 }
	 if (opcion.equals("AL REVES")) {  	
		//Creamos el fichero de escritura y escribimos carácter 
		//a carácter, al revés
		try {
		 fw = new FileWriter(file);
		 for(int i = linea.length() - 1; i >= 0; i--) {
		   fw.write(linea.charAt(i));
		 }
		 fw.close();
		}catch(IOException ex) {
		  ex.printStackTrace();
		}
		this.leerFichero();
	 }
	 if (opcion.equals("MAYUSCULAS")) {  
		//Creamos el fichero de escritura y con el buffer escribimos
		//la línea convertida a mayúsculas
		try {
		  fw = new FileWriter(file);
		  bufw = new BufferedWriter(fw); 
		  bufw.write(linea.toUpperCase());
		  bufw.newLine();
		  bufw.flush();
		  bufw.close();
		  fw.close();
		}catch(IOException ex) {
			  ex.printStackTrace();
		}
		this.leerFichero();
	 }
	 if (opcion.equals("MINUSCULAS")) {  
		//Creamos el fichero de escritura y con el buffer escribimos
		//la línea convertida a minúsculas
			try {
				  fw = new FileWriter(file);
				  bufw = new BufferedWriter(fw); 
				  bufw.write(linea.toLowerCase());
				  bufw.newLine();
				  bufw.flush();
				  bufw.close();
				  fw.close();
				}catch(IOException ex) {
					  ex.printStackTrace();
				}
				this.leerFichero();
	 }
  }
 
  void leerFichero() {
    	//Leemos el fichero línea a línea 
    	String cadena;
		try {
		  fr = new FileReader(file);
		  bufr = new BufferedReader(fr); 
		  while((cadena = bufr.readLine())!=null) {
		        System.out.println(cadena);
		  } 
	  	  fr.close();
	  	  bufr.close();
		}catch(IOException e) {
			  e.printStackTrace();
	  	}
   }
}