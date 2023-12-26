package examen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
		setTitle("Examen 28 Abril 2022");
		
		//setLayout(new FlowLayout(FlowLayout.CENTER,200,2));
		  
		Lamina laminaMarco = new Lamina();
		add(laminaMarco);		
		setVisible(true);
		
	}
}

class Lamina extends JPanel implements ActionListener {
	
	String fileString ="examen.txt";
	File file = new File (fileString);
	FileWriter fw;
	BufferedWriter bufw;
	
	JTextArea txtArea = new JTextArea(30,45);
    JLabel jl=new JLabel("Frase: ");
    JTextField texto = new JTextField(35);
    JButton botonEscribir=new JButton("Escribir");
    JButton botonFin=new JButton("Finalizar");
     
    Lamina(){
	 //txtArea.setLocation(120,100);
	 txtArea.setLineWrap(true);		//para no irse de los límites
	 
	 try {
  	  fw = new FileWriter(file);		//se escribe en el fichero con file writer
      bufw = new BufferedWriter(fw); 	//se añade lo escrito en el fichero con buffer	//la conexion de la cadena con filestring
     }catch(IOException e) {
		 e.printStackTrace();
	 }
	 
	 add(jl);
	 add(texto);
	 add(botonEscribir); botonEscribir.addActionListener(this);
	 add(txtArea);
	 add(botonFin); botonFin.addActionListener(this);
	 
	} 
	

	public void actionPerformed (ActionEvent e) {
		
		  Object botonPulsado = e.getSource();		//objeto (el clic en sí)
		  
			if (botonPulsado == botonEscribir) {
				
				String linea = texto.getText();		//texto es el JTextField (el texto puesto en el textfield se recoge en el get 
													//text y lo metes en el string linea)
				txtArea.append(linea);			//añade lo escrito en linea
				txtArea.append("\n");
				texto.setText("");			//limpia
				
				try {
				 bufw.write(linea);		//se escribe línea a línea
				 bufw.newLine();	//línea a línea
				 bufw.flush();		//limpia objetos y movidas invisibles
				}catch(IOException e1) {
					 e1.printStackTrace();
				}
			}
			if (botonPulsado == botonFin) {
				
				try {
					fw.close();			//se cierra el file writer (o el buffer indistintamente)
					String cadena;
					FileReader fr = new FileReader(file);		//se lee la conexion hecha con file (el segundo)
					BufferedReader bufr = new BufferedReader(fr);	//se lee el filereader	
					while((cadena = bufr.readLine())!=null) {		//se lee línea a línea (si fuera con filereader seria caracter a caracter)
				        System.out.println(cadena);
				      }
				   bufr.close();		//se cierra el buffer reader (indistintamente)
				   System.exit(0);
				}catch(IOException e2) {
					e2.printStackTrace();
				}	
				
			}
	}
}
