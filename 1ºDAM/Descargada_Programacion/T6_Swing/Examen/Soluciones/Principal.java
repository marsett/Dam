package examen;

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
		setTitle("Examen 28 Abril 2022");
		//setLayout(new FlowLayout(FlowLayout.CENTER,200,2));
		  
		Lamina laminaMarco = new Lamina();
		add(laminaMarco);		
		setVisible(true);
		//Método si no se implementa la funcionalidad de
		//ficheros con eventos en botones
		//laminaMarco.ficheros();
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
	 txtArea.setLineWrap(true);
	 try {
  	  fw = new FileWriter(file);
      bufw = new BufferedWriter(fw); 
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
		  Object botonPulsado = e.getSource();
			if (botonPulsado == botonEscribir) {
				String linea = texto.getText();
				txtArea.append(linea);
				txtArea.append("\n");
				texto.setText("");	
				try {
				 bufw.write(linea);
				 bufw.newLine();
				 bufw.flush();
				}catch(IOException e1) {
					 e1.printStackTrace();
				}
			}
			if (botonPulsado == botonFin) {
				try {
					fw.close();
					String cadena;
					FileReader fr = new FileReader(file);
					BufferedReader bufr = new BufferedReader(fr);
					while((cadena = bufr.readLine())!=null) {
				        System.out.println(cadena);
				      }
				   bufr.close();
				   System.exit(0);
				}catch(IOException e2) {
					e2.printStackTrace();
				}	
			}
		}
	
	void ficheros () {
		Scanner sc = new Scanner(System.in);
		String cad;
	    System.out.println("Introduce una palabra o frase: ");
	    cad = sc.nextLine(); //leemos la cadena
	    try {
		  while(!cad.equals("fin")) {
			 bufw.write(cad);
			 bufw.newLine();
			 bufw.flush();
			 System.out.println("Introduce otra palabra o frase: ");
			 cad = sc.nextLine(); //leemos la cadena
		  }
		  fw.close();
		}catch(IOException e1) {
				 e1.printStackTrace();
		}
		try {
		  String cadena;
		  FileReader fr = new FileReader(file);
		  BufferedReader bufr = new BufferedReader(fr);
		  while((cadena = bufr.readLine())!=null) {
		      System.out.println(cadena);
		  }
		  bufr.close();
		  System.exit(0);
		}catch(IOException e2) {
			e2.printStackTrace();
		}		
	}
}