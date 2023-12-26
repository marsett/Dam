package examen;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Examen {
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
		setTitle("Recuperación 19 Mayo 2022");
		
		Lamina laminaMarco = new Lamina();
		add(laminaMarco);		
		setVisible(true);
	}
}

class Lamina extends JPanel implements ActionListener{
	
	String fileString = "recuperacion.txt";
	String quijote = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino.";
	File file = new File (fileString);
	FileWriter fw;
	BufferedWriter bufw;
	
	JLabel etiqueta = new JLabel("Elige una opción para escribir en el fichero: ");
	JComboBox <String> cbox;
	JTextArea texta = new JTextArea(30,45);
	JButton escrfichero = new JButton("Escribir Fichero");
	
	Lamina() {
		
		cbox = new JComboBox <String>();
		cbox.setModel(new DefaultComboBoxModel<>(new String[] {"IGUAL", "AL REVES", "MAYUSCULAS", "MINUSCULAS"}));
		cbox.setSelectedIndex(0);
		
		texta.setLineWrap(true);
		texta.append(quijote);
		texta.append("\n");
		
		try {
		  	  fw = new FileWriter(file);		
		      bufw = new BufferedWriter(fw);
		     }catch(IOException e) {
				 e.printStackTrace();
			 }
		
		add(etiqueta);
		add(cbox);
		add(texta);
		add(escrfichero); escrfichero.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e) {
		
		if(cbox.getSelectedItem() == "IGUAL") {
			
			String linea = texta.getText();
			
			try {
				bufw.write(linea);
				bufw.newLine();
				bufw.flush();
				
				String cadena;
				FileReader fr = new FileReader(file);	
				BufferedReader bufr = new BufferedReader(fr);
				while((cadena = bufr.readLine())!=null) {		
			        System.out.println(cadena);
			      }
				
				//bufw.close();
				//bufr.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		/*else if(cbox.getSelectedItem() == "AL REVES") {
			
			String linea = texta.getText();
			
			FileReader fr = new FileReader(file);	
			BufferedReader bufr = new BufferedReader(fr);
			
			int caracter = 0;
			
			while(caracter!=-1) {
				
				caracter = fr.read();
		
				char letra = (char) caracter;
		
				System.out.print(letra);
			}
			
			
		}*/
		
		else if(cbox.getSelectedItem() == "MAYUSCULAS") {
			
			String linea = texta.getText();
			String linea2 = linea.toUpperCase();
			
			try {
				bufw.write(linea2);
				bufw.newLine();
				bufw.flush();
				
				String cadena;
				FileReader fr = new FileReader(file);	
				BufferedReader bufr = new BufferedReader(fr);
				while((cadena = bufr.readLine())!=null) {		
			        System.out.println(cadena);
			      }
				
				//bufw.close();
				//bufr.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		else if(cbox.getSelectedItem() == "MINUSCULAS") {
			
			String linea = texta.getText();
			String linea2 = linea.toLowerCase();
			
			try {
				bufw.write(linea2);
				bufw.newLine();
				bufw.flush();
				
				String cadena;
				FileReader fr = new FileReader(file);	
				BufferedReader bufr = new BufferedReader(fr);
				while((cadena = bufr.readLine())!=null) {		
			        System.out.println(cadena);
			      }
				
				//bufw.close();
				//bufr.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
		
		/*String cadena;
		FileReader fr;
		try {
			fr = new FileReader(file);
			BufferedReader bufr = new BufferedReader(fr);
		
			while((cadena = bufr.readLine())!=null) {		
			    System.out.println(cadena);
			  }
			
			bufw.close();
			fr.close();
			bufr.close();
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
			
		}
	}