package ficheros;
import java.io.*;
public class OPeracionesFicheros{

	String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero,"
			+ " adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados,"
			+ " lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte,"
			+ " calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino."
			+ " Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza,"
			+ " que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años, era de complexión recia,"
			+ " seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza."
			+ " Quieren decir que tenía el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben),"
			+ " aunque por conjeturas verosímiles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento;"
			+ " basta que en la narración dél no se salga un punto de la verdad.";
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
