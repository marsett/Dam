package ficheros;
import java.io.*;
public class OPeracionesFicheros{

	String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que viv�a un hidalgo de los de lanza en astillero,"
			+ " adarga antigua, roc�n flaco y galgo corredor. Una olla de algo m�s vaca que carnero, salpic�n las m�s noches, duelos y quebrantos los s�bados,"
			+ " lentejas los viernes, alg�n palomino de a�adidura los domingos, consum�an las tres partes de su hacienda. El resto della conclu�an sayo de velarte,"
			+ " calzas de velludo para las fiestas con sus pantuflos de lo mismo, los d�as de entre semana se honraba con su vellori de lo m�s fino."
			+ " Ten�a en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza,"
			+ " que as� ensillaba el roc�n como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta a�os, era de complexi�n recia,"
			+ " seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza."
			+ " Quieren decir que ten�a el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben),"
			+ " aunque por conjeturas veros�miles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento;"
			+ " basta que en la narraci�n d�l no se salga un punto de la verdad.";
	File fichero1 = new File("Quijote.txt");
	File fichero2 = new File("Quijote_lineas.txt");


	public void writer()  throws IOException{
		File fichero1 = new File("Quijote.txt");
		try {
			FileWriter wr1 = new FileWriter(fichero1);
			for(int i = 0; i < frase.length(); i++) {
				char letra = frase.charAt(i);
				wr1.write(letra);
			}

			wr1.close();
		}catch(NullPointerException e) {
			System.out.println("Algo ha fallado");
		}
	}
	
	public void lectura_escritura() throws IOException{
		File fichero1 = new File("Quijote.txt");
		File fichero2 = new File("Quijote_lineas.txt");
		FileWriter wr1 = new FileWriter(fichero2);
		BufferedWriter bw1 = new BufferedWriter(wr1);
		if(fichero1.exists()) {
		try {
			FileReader rd1 = new FileReader(fichero1);
			String frase2 = "";
			int caracter = rd1.read();
			while(caracter != -1) {
				System.out.print((char)caracter);
				caracter = rd1.read();
				frase2 = frase2+(char)caracter;
			}
			System.out.println("");
			rd1.close();
		
			
			for(int i = 0; i < frase2.length(); i++) {
				char caracter2  = frase2.charAt(i);
				if((char)caracter2 == ',') {
					bw1.write(caracter2);
					bw1.newLine();
				}else if((char)caracter2 == '.') {
					bw1.write(caracter2);
					bw1.newLine();
				}else if((char)caracter2 == ';') {
					bw1.write(caracter2);
					bw1.newLine();
				}else {
					bw1.write(caracter2);
				}
			}
			
			bw1.flush();
			
		}catch(NullPointerException e) {
			System.out.println("Algo ha fallado");
		}
		}
	}
	
	public void bfReader() throws IOException{
		File fichero2 = new File("Quijote_lineas.txt");
		try {
			FileReader rd1 = new FileReader(fichero2);
			BufferedReader br1 = new BufferedReader(rd1);
			String linea;
			while((linea = br1.readLine()) != null) {
				System.out.println(linea);
			}
			rd1.close();
			
		}catch(NullPointerException e) {
			System.out.println("Algo ha fallado");
		}
	}
}
