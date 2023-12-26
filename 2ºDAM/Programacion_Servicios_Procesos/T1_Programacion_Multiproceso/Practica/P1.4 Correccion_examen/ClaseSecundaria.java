package examenquitado;

import java.io.*;

public class ClaseSecundaria {
	public static void main(String[] args) throws IOException{
		File f = new File("C:\\Users\\jimen\\Downloads\\"+args[0]);
		FileReader fr = new FileReader(f);
		BufferedReader bf = new BufferedReader(fr);
		String linea;
		int suma = 0;
		while((linea = bf.readLine()) != null) {
			int posicionSignoIgual = 0;
			if(linea.contains("Venta")) {
				for(int i=0; i<linea.length(); i++) {
					if(linea.charAt(i) == '=') {
						posicionSignoIgual = i;
					}
				}
				suma += Integer.parseInt(linea.substring(posicionSignoIgual+1, linea.length()));
			}else {
				for(int i=0; i<linea.length(); i++) {
					if(linea.charAt(i) == '=') {
						posicionSignoIgual = i;
					}
				}
				suma -= Integer.parseInt(linea.substring(posicionSignoIgual+1, linea.length()));
			}
		}
		System.out.print(suma);
		bf.close();
	}
}
